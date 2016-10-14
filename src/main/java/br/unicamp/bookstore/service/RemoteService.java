package br.unicamp.bookstore.service;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class RemoteService {

	public <T> T getAndParseXml(String endpointUrl, Class<T> xmlClass) throws IOException {
		Document document = getAndParseXml(endpointUrl);
		try {
			Element root = document.getDocumentElement();

			JAXBContext context = JAXBContext.newInstance(xmlClass);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			JAXBElement<T> loader = unmarshaller.unmarshal(root, xmlClass);
			return loader.getValue();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Document getAndParseXml(String endpointUrl) throws IOException {
		URLConnection connection = openConnection(endpointUrl);
		return parseResponse(connection);
	}

	public Document postAndParseXml(String endpointUrl, String body) throws IOException {
		URLConnection connection = openConnection(endpointUrl, body);
		return parseResponse(connection);
	}

	private Document parseResponse(URLConnection connection) throws IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(connection.getInputStream());
		} catch (ParserConfigurationException | SAXException e) {
			throw new RuntimeException(e);
		}
	}

	private URLConnection openConnection(String endpointUrl) throws MalformedURLException, IOException {
		URL url = new URL(endpointUrl);
		URLConnection connection = url.openConnection();
		connection.setUseCaches(false);
		connection.setAllowUserInteraction(false);

		return connection;
	}

	private URLConnection openConnection(String endpointUrl, String body) throws MalformedURLException, IOException {
		URL url = new URL(endpointUrl);
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setAllowUserInteraction(false);

		PrintStream outStream = new PrintStream(connection.getOutputStream());
		outStream.println(body);
		outStream.close();
		return connection;
	}

}
