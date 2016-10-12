package br.unicamp.bookstore.service;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;
import br.unicamp.bookstore.model.ProdutoFrete;

public class CalculaFreteService {
	private Configuracao configuracao;
	
	public String buscar(ProdutoFrete produtoFrete) {
		String url = String.format("%s/%s/xml", 
				configuracao.getConsultaPrecoPrazoUrl(),
				produtoFrete);
		
		Endereco endereco = new RemoteService().getAndParseXml(url, Endereco.class);
		
		String hasError = "";
		hasError = endereco.getErro();
		
		if ( (hasError != null) && (hasError.equals("true"))){
				return "erro=true";
			}
		
		return String.format("%s, %s", endereco.getBairro(), endereco.getLogradouro());
		
	}
}
