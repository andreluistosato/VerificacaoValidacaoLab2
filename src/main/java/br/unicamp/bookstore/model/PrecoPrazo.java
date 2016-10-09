package br.unicamp.bookstore.model;

import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlElement;

public class PrecoPrazo {

	@XmlElement(name = "Valor")
	private String valor;
	
	@XmlElement(name = "PrazoEntrega")
	private Integer prazoEntrega;

	public Integer getPrazoEntrega() {
		return prazoEntrega;
	}
	
	public Double getValor() {
		try {
			return new DecimalFormat("##,##").parse(valor).doubleValue();
		} catch (Exception e) {
			return null;
		}
	}
	
}
