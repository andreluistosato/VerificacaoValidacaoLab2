package br.unicamp.bookstore.service;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.dao.DadosDeEntregaDAO;
import br.unicamp.bookstore.model.PrecoPrazo;
import br.unicamp.bookstore.model.Produto;

public class CalculaFreteService {

	private Configuracao configuracao;
	
	private DadosDeEntregaDAO dadosDeEntregaDao;

	public PrecoPrazo consultaPrecoPrazo(Produto produto, String cep, String codigo) {
		
		// http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?
		String url = configuracao.getConsultaPrecoPrazoUrl();
		url += String.format("?nCdEmpresa=09146920"
				+ "&sDsSenha=123456"
				+ "&sCepOrigem=70002900"
				+ "&sCepDestino=%s"
				+ "%s" // atributos do Produto
				+ "&nCdFormato=1"
				+ "&sCdMaoPropria=n"
				+ "&nVlValorDeclarado=0"
				+ "&sCdAvisoRecebimento=n"
				+ "&nCdServico=%s"
				+ "&nVlDiametro=0"
				+ "&StrRetorno=xml"
				+ "&nIndicaCalculo=3",
				cep,
				produto.toQueryString(),
				codigo);
		
		PrecoPrazo frete = parseDocument(url);
		dadosDeEntregaDao.saveDadosDeEntrega(frete.getValorFrete(), frete.getPrazoEntrega());
		return frete;
	}

	private PrecoPrazo parseDocument(String url) {
		RemoteService remoteService = new RemoteService();
		try {
			Document document = remoteService.getAndParseXml(url);
			return parseDocument(document);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private PrecoPrazo parseDocument(Document document) {
		try {
			XPath xpath = XPathFactory.newInstance().newXPath();
			XPathExpression expr = xpath.compile("//Servicos/cServico");

			return parseItem((Node) expr.evaluate(document, XPathConstants.NODE));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private PrecoPrazo parseItem(Node item) {
		try {
			JAXBContext context = JAXBContext.newInstance(PrecoPrazo.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			JAXBElement<PrecoPrazo> loader = unmarshaller.unmarshal(item, PrecoPrazo.class);
			return loader.getValue();
		} catch (JAXBException e) {
			 return null;
		}
	}

}
