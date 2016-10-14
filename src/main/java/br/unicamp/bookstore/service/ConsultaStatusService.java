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
import org.w3c.dom.Node;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.PrecoPrazo;

public class ConsultaStatusService {

	private Configuracao configuracao;

	public String consultStatus(String codigo) {
		String body = "usuario=ECT&senha=SRO&tipo=L&resultado=T&objetos=" + codigo;
		String endpointUrl = configuracao.getStatusEntregaUrl();
		Document document = new RemoteService().postAndParseXml(endpointUrl, body);

		try {
			XPath xpath = XPathFactory.newInstance().newXPath();
  			XPathExpression expr = xpath.compile("/sroxml/objeto/evento[1]");

			return (String) expr.evaluate(document, XPathConstants.STRING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private StatusEncomenda parseItem(Node item) {
		try {
			JAXBContext context = JAXBContext.newInstance(StatusEncomenda.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			JAXBElement<StatusEncomenda> loader = unmarshaller.unmarshal(item, StatusEncomenda.class);
			return loader.getValue();
		} catch (JAXBException e) {
			 return null;
		}
	}

}
