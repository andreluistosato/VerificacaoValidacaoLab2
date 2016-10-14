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
import org.w3c.dom.Node;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.PrecoPrazo;
import br.unicamp.bookstore.model.StatusEncomenda;

public class ConsultaStatusService {

	private Configuracao configuracao;

	public StatusEncomenda consultStatus(String codigo) {
		String body = "usuario=ECT&senha=SRO&tipo=L&resultado=T&objetos=" + codigo;
		String endpointUrl = configuracao.getStatusEntregaUrl();

		try {
			Document document = new RemoteService().postAndParseXml(endpointUrl, body);
			return parseDocument(document);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private StatusEncomenda parseDocument(Document document) {
		try {
			XPath xpath = XPathFactory.newInstance().newXPath();
			XPathExpression expr = xpath.compile("/sroxml/objeto/evento[1]");
			return parseItem((Node) expr.evaluate(document, XPathConstants.NODE));
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
