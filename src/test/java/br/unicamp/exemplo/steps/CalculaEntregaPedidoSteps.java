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
    
    @Given("^Eu possuo um Peso de (\\d+) quilos preenchido e valido$")
    public void eu_possuo_um_Peso_de_quilos_preenchido_e_valido(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Eu possuo uma Largura de (\\d+) metro preenchido e valido$")
    public void eu_possuo_uma_Largura_de_metro_preenchido_e_valido(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Eu informo o Peso {(\\d+)}$")
    public void eu_informo_o_Peso(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Eu informo a Largura {(\\d+)}$")
    public void eu_informo_a_Largura(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^O resultado deve ser TRUE$")
    public void o_resultado_deve_ser_TRUE() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}