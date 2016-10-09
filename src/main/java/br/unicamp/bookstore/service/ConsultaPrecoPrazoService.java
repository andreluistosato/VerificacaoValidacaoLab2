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

public class ConsultaPrecoPrazoService {

	private Configuracao configuracao;

	public Double consultPreco(String codigo) {
		PrecoPrazo precoPrazo = consultaPrecoPrazo();
		return precoPrazo.getValor();
	}

	private PrecoPrazo consultaPrecoPrazo() {
		//Passar parametros na consulta
		String url = configuracao.getConsultaPrecoPrazoUrl();
		
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
