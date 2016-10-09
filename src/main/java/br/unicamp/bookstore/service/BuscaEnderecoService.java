package br.unicamp.bookstore.service;

import org.w3c.dom.Document;

import br.unicamp.bookstore.Configuracao;

public class BuscaEnderecoService {

	private Configuracao configuracao;
	
	public String buscar(String cep) {
		String url = String.format("%s/%s/xml", 
				configuracao.getBuscarEnderecoUrl(),
				cep);
		
		Document document = new RemoteService().getAndParseXml(url);
		return null;
	}
	
	
}
