package br.unicamp.bookstore.service;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import br.unicamp.bookstore.Configuration;

public class ConsultaStatusService {

	private Configuration configuration;

	public String consultStatus(String codigo) {
		try {
			URLConnection connection = openConnection(codigo);
			String status = getStatusFromResponse(connection);
			return status;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getStatusFromResponse(URLConnection connection) throws IOException {
		StringBuilder builder = new StringBuilder();
		DataInputStream inStream = new DataInputStream(connection.getInputStream());
		String inputLine;
		while ((inputLine = inStream.readLine()) != null) {
			builder.append(inputLine);
		}
		inStream.close();
		return builder.toString();
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
