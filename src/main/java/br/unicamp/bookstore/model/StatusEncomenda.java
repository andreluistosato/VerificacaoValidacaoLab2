package br.unicamp.bookstore.model;

import javax.ws.rs.GET;
import javax.xml.bind.annotation.XmlElement;

public class StatusEncomenda {

	    @XmlElement(name = "Tipo")
	    private String tipo;
	    
	    @XmlElement(name = "Status")
	    private String status;
	    
	    @XmlElement(name = "Descricao")
	    private String descricao;

	    public String getTipo() {
			return tipo;
		}

		public void setTipo(String Tipo) {
			tipo = Tipo;
		}
	    
		public String getstatus() {
			return status;
		}

		public void setStatus(String Status) {
			status = Status;
		}
		
		public String getdescricao() {
			return descricao;
		}

		public void setdescricao(String Descricao) {
			descricao = Descricao;
		}
	 }


	 