package br.unicamp.bookstore.model;

public class ProdutoFrete {
	private double Peso;
	
	private double Largura;
	
	private double Altura;
	
	private double Comprimento;
	
	private int Cep;
	
	private TipoEntregaEnum TipoEntrega;
	
	public ProdutoFrete(double peso, double largura, double altura, double comprimento, int cep,
			TipoEntregaEnum tipoEntrega) {
		Peso = peso;
		Largura = largura;
		Altura = altura;
		Comprimento = comprimento;
		Cep = cep;
		TipoEntrega = tipoEntrega;
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

	public int getCep() {
		return Cep;
	}

	public void setCep(int cep) {
		Cep = cep;
	}

	public TipoEntregaEnum getTipoEntrega() {
		return TipoEntrega;
	}

	public void setTipoEntrega(Integer tipoEntrega) {		
		TipoEntrega = TipoEntregaEnum.getTipoEntregaEnum(tipoEntrega);
		
	}
}
