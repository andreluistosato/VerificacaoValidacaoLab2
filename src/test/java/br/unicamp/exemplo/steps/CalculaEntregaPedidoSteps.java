package br.unicamp.exemplo.steps;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.assertj.core.api.Assertions;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculaEntregaPedidoSteps{
	
    private Object buscaEndereco;
    private Throwable throwable;
    
    @Before
    public void setUp() {
    	buscaEndereco = new Object();
    	throwable = null;
    }
    
    @Given("^Eu possuo um CEP correto com (\\d+) digitos$")
    public void possuoCEPCorreto(String cep){
    }
    


}