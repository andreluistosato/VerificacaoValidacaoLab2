package br.unicamp.bookstore.service;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;
import br.unicamp.bookstore.model.Produto;
import br.unicamp.bookstore.model.TipoEntregaEnum;

public class CalculaFreteService {
	private Configuracao configuracao;
	
	public String calculaFrete(Produto produto, String cep, TipoEntregaEnum tipoEntrega) {
		String url = String.format("%s/%s/xml", 
				configuracao.getConsultaPrecoPrazoUrl(),
				produto,
				cep,
				tipoEntrega);
		
		
		// Objeto valor, PrazoEntrega
		
		Endereco endereco = new RemoteService().getAndParseXml(url, Endereco.class);
		
		String hasError = "";
		hasError = endereco.getErro();
		
		if ( (hasError != null) && (hasError.equals("true"))){
				return "erro=true";
			}
		
		return String.format("%s, %s", endereco.getBairro(), endereco.getLogradouro());
		
	}
}
