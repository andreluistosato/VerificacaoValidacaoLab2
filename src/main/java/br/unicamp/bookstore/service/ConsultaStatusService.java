package br.unicamp.bookstore.service;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import br.unicamp.bookstore.Configuracao;

public class ConsultaStatusService {

	private Configuracao configuracao;

	public String consultStatus(String codigo) {
		String body = "usuario=ECT&senha=SRO&tipo=L&resultado=T&objetos=" + codigo;
		String endpointUrl = configuracao.getStatusEntregaUrl();
		Document document = new RemoteService().postAndParseXml(endpointUrl, body);

		try {
			XPath xpath = XPathFactory.newInstance().newXPath();
			XPathExpression expr = xpath.compile("/sroxml/objeto/evento[1]/status");

			return (String) expr.evaluate(document, XPathConstants.STRING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
