package br.unicamp.bookstore.service;

import java.io.IOException;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;

public class BuscaEnderecoService {

	private Configuracao configuracao;

	public String buscar(String cep) {
		String url = String.format("%s/%s/xml",
				configuracao.getBuscarEnderecoUrl(),
				cep);

		try {
			Endereco endereco = new RemoteService().getAndParseXml(url, Endereco.class);
			String hasError = endereco.getErro();
			if ((hasError != null) && (hasError.equals("true"))) {
				return "erro=true";
			}
			return String.format("%s, %s", endereco.getLogradouro(), endereco.getLocalidade());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
