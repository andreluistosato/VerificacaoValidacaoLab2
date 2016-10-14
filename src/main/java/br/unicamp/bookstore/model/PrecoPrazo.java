package br.unicamp.bookstore.model;

import java.text.DecimalFormat;
import java.text.ParseException;

import javax.xml.bind.annotation.XmlElement;

public class PrecoPrazo {
	@XmlElement(name = "Codigo")
	private Integer Codigo;

	@XmlElement(name = "Valor")
	private String Valor;

	@XmlElement(name = "PrazoEntrega")
	private Integer PrazoEntrega;

	@XmlElement(name = "ValorMaoPropria")
	private String ValorMaoPropria;

	@XmlElement(name = "ValorAvisoRecebimento")
	private String ValorAvisoRecebimento;

	@XmlElement(name = "ValorValorDeclarado")
	private String ValorValorDeclarado;

	@XmlElement(name = "EntregaDomiciliar")
	private String EntregaDomiciliar;

	@XmlElement(name = "EntregaSabado")
	private String EntregaSabado;

	@XmlElement(name = "Erro")
	private String Erro;

	@XmlElement(name = "MsgErro")
	private String MsgErro;

	public String getMsgErro() {
		return MsgErro;
	}

	public Integer getCodigo() {
		return Codigo;
	}

	public void setCodigo(Integer codigo) {
		Codigo = codigo;
	}

	public Double getValorFrete() {
		try {
			return new DecimalFormat("##,##").parse(Valor).doubleValue();
		} catch (ParseException e) {
			return null;
		}
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public Integer getPrazoEntrega() {
		return PrazoEntrega;
	}

	public void setPrazoEntrega(Integer prazoEntrega) {
		PrazoEntrega = prazoEntrega;
	}

	public String getValorMaoPropria() {
		return ValorMaoPropria;
	}

	public void setValorMaoPropria(String valorMaoPropria) {
		ValorMaoPropria = valorMaoPropria;
	}

	public String getValorAvisoRecebimento() {
		return ValorAvisoRecebimento;
	}

	public void setValorAvisoRecebimento(String valorAvisoRecebimento) {
		ValorAvisoRecebimento = valorAvisoRecebimento;
	}

	public String getValorValorDeclarado() {
		return ValorValorDeclarado;
	}

	public void setValorValorDeclarado(String valorValorDeclarado) {
		ValorValorDeclarado = valorValorDeclarado;
	}

	public String getEntregaDomiciliar() {
		return EntregaDomiciliar;
	}

	public void setEntregaDomiciliar(String entregaDomiciliar) {
		EntregaDomiciliar = entregaDomiciliar;
	}

	public String getEntregaSabado() {
		return EntregaSabado;
	}

	public void setEntregaSabado(String entregaSabado) {
		EntregaSabado = entregaSabado;
	}

	public String getErro() {
		return Erro;
	}

	public void setErro(String erro) {
		Erro = erro;
	}
}
