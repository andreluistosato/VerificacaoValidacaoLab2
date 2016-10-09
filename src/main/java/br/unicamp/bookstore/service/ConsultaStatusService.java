package br.unicamp.bookstore.service;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.unicamp.bookstore.Configuration;

public class ConsultaStatusService {

	private Configuration configuration;

	public String consultStatus(String codigo) {
		try {
			URLConnection connection = openConnection(codigo);
			String status = getStatusFromResponse(connection);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getStatusFromResponse(URLConnection connection) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(connection.getInputStream());
		
		XPath xpath = XPathFactory.newInstance().newXPath();
	    XPathExpression expr = xpath.compile("/sroxml/objeto/evento[1]/status");
	    
	    return (String) expr.evaluate(document, XPathConstants.STRING);
	}

	private URLConnection openConnection(String codigo) throws MalformedURLException, IOException {
		URL url = new URL(configuration.getUrlEndpoint() + "/sro_bin/sroii_xml.eventos");
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setAllowUserInteraction(false);

		PrintStream outStream = new PrintStream(connection.getOutputStream());
		outStream.println("usuario=ECT&senha=SRO&tipo=L&resultado=T&objetos=" + codigo);
		outStream.close();
		return connection;
	}

}
