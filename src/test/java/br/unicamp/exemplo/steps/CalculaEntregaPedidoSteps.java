package br.unicamp.exemplo.steps;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.assertj.core.api.Assertions;
import br.unicamp.exemplo.CalculaEntregaPedido;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculaEntregaPedidoSteps{
	
    private CalculaEntregaPedido calculaEntregaPedido;
    private Throwable throwable;
    
    @Before
    public void setUp() {
    	calculaEntregaPedido = new CalculaEntregaPedido();
    	throwable = null;
    }
    
    @Given("^Que eu possuo o uma calculadora de valor de frete e tempo$")
    public void que_eu_possuo_o_uma_calculadora_de_valor_de_frete_e_tempo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Eu informo Peso {(\\d+)}, Largura {(\\d+)}, Altura {(\\d+)} e Comprimento {(\\d+)}$")
    public void eu_informo_Peso_Largura_Altura_e_Comprimento(int arg1, int arg2, int arg3, int arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^eu recebo um Objeto contendo valor do Frete e o Tempo$")
    public void eu_recebo_um_Objeto_contendo_valor_do_Frete_e_o_Tempo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}