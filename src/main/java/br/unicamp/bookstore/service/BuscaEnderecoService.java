package br.unicamp.bookstore.service;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;

public class BuscaEnderecoService {

	private Configuracao configuracao;
	
	public String buscar(String cep) {
		String url = String.format("%s/%s/xml", 
				configuracao.getBuscarEnderecoUrl(),
				cep);
		
		Endereco endereco = new RemoteService().getAndParseXml(url, Endereco.class);
		
		return String.format("%s, %s", endereco.getBairro(), endereco.getLogradouro());
	}
	
	
}
