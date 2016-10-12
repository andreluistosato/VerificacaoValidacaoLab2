package br.unicamp.bookstore.model;

import javax.xml.bind.annotation.XmlElement;

public class Produto {
	@XmlElement(name = "peso")
	private double Peso;
	
	@XmlElement(name = "largura")
	private double Largura;
	
	@XmlElement(name = "altura")
	private double Altura;
	
	@XmlElement(name = "comprimento")
	private double Comprimento;
	
	//@XmlElement(name = "cep")
	//private int Cep;
	
	//@XmlElement(name = "tipoentrega")
	//private TipoEntregaEnum TipoEntrega;
	
	public Produto(double peso, double largura, double altura, double comprimento) {
		Peso = peso;
		Largura = largura;
		Altura = altura;
		Comprimento = comprimento;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		Peso = peso;
	}

	public double getLargura() {
		return Largura;
	}

	public void setLargura(double largura) {
		Largura = largura;
	}

	public double getAltura() {
		return Altura;
	}

	public void setAltura(double altura) {
		Altura = altura;
	}

	public double getComprimento() {
		return Comprimento;
	}

	public void setComprimento(double comprimento) {
		Comprimento = comprimento;
	}

}
