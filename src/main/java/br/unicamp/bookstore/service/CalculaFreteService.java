package br.unicamp.bookstore.service;

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
import br.unicamp.bookstore.model.PrecoPrazo;
import br.unicamp.bookstore.model.Produto;

public class CalculaFreteService {

	private Configuracao configuracao;

	public PrecoPrazo consultaPrecoPrazo(Produto produto, String cep, String codigo) {
		//Passar parametros na consulta
		//http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?
		//nCdEmpresa=09146920&sDsSenha=123456&sCepOrigem=70002900&sCepDestino=71939360&nVlPeso=1&nCdFormato=1&nVlComprimento=30&nVlAltura=30&nVlLargura=30&sCdMaoPropria=n&nVlValorDeclarado=0&sCdAvisoRecebimento=n&nCdServico=40010&nVlDiametro=0&StrRetorno=xml&nIndicaCalculo=3
		String url = configuracao.getConsultaPrecoPrazoUrl();
		url += "nCdEmpresa=bla";
		
		
		//url += produto.toQueryString();
		//url += cep;
		//url += codigo;
		//todo: fazer o querystring general.(empresa, senha); 
				
		RemoteService remoteService = new RemoteService();
		Document document = remoteService.getAndParseXml(url);

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
