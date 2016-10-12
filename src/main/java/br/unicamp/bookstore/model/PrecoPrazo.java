package br.unicamp.bookstore.model;

import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlElement;

public class PrecoPrazo {
	// TODO: Adicionar mais atributos e get and Set.
	@XmlElement(name = "Valor")
	private String Valor;
	
	@XmlElement(name = "PrazoEntrega")
	private Integer PrazoEntrega;
	
	public PrecoPrazo(String valor, Integer prazoEntrega) {
		this.Valor = valor;
		this.PrazoEntrega = prazoEntrega;

	}

	public Integer getPrazoEntrega() {
		return PrazoEntrega;
	}
	
	public Double getValor() {
		try {
			return new DecimalFormat("##,##").parse(Valor).doubleValue();
		} catch (Exception e) {
			return null;
		}
	}
	
}
