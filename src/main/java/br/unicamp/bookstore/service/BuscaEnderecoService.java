package br.unicamp.bookstore.service;

import java.io.IOException;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;

public class BuscaEnderecoService {

	private Configuracao configuracao;

	public Endereco buscar(String cep) {
		String url = String.format("%s/%s/xml",
				configuracao.getBuscarEnderecoUrl(),
				cep);

		try {
			return new RemoteService().getAndParseXml(url, Endereco.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
