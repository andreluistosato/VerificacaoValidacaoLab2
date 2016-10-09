package br.unicamp.bookstore.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class RemoteService {

	public Document getAndParseXml(String endpointUrl) {
		try {
			URL url = new URL(endpointUrl);
			URLConnection connection = url.openConnection();
			connection.setUseCaches(false);
			connection.setAllowUserInteraction(false);

			return parseResponse(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Document postAndParseXml(String endpointUrl, String body) {
		try {
			URLConnection connection = openConnection(endpointUrl, body);
			return parseResponse(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String postAndReturnBody(String endpointUrl, String body) {
		try {
			URLConnection connection = openConnection(endpointUrl, body);
			return readResponse(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Document parseResponse(URLConnection connection) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(connection.getInputStream());
	}

	private String readResponse(URLConnection connection) throws Exception {
		Scanner scanner = new Scanner(connection.getInputStream());
		try {
			StringBuilder builder = new StringBuilder();
			while (scanner.hasNext()) {
				builder.append(scanner.nextLine());
				builder.append("\n");
			}
			return builder.toString();
		} finally {
			scanner.close();
		}
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
