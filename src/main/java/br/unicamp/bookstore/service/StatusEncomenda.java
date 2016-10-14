package br.unicamp.bookstore.service;

import javax.xml.bind.annotation.XmlElement;

public class StatusEncomenda {

	    @XmlElement(name = "tipo")
	    private String tipo;
	    
	    @XmlElement(name = "status")
	    private String status1;
	    
	    @XmlElement(name = "descricao")
	    private String descricao;

	    StatusEncomenda status = parseItem(blahblah);
	    
	    if ((status.getTipo().equals("BDE") || status.getTipo().equals("BDI") || status.getTipo().equals("BDR")) && status.getStatus().equals("0))) { 
	    return descrição;
	    }else {
	    //regra pra produto nao entrege
	    return descrição;
	    }
}

