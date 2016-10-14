package br.unicamp.bookstore.model;

public class Produto {
	private double Peso;	
	private double Largura;	
	private double Altura;
	private double Comprimento;
	
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

	//todo: fazer uma funcao toQueryString() que retorna um sprintf() para retornar o querystring.
	@Override //Apagar essa porra
	public String toQueryString() {
		return String.format("&nVlPeso=%s&nVlComprimento=%s&nVlAltura=%s&nVlLargura=%s", args);
	}
	
	

}
