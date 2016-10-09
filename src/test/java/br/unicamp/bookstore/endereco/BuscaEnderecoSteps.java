package br.unicamp.bookstore.endereco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.assertj.core.api.Assertions;

import br.unicamp.bookstore.service.BuscaEnderecoService;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuscaEnderecoSteps{
	
    private BuscaEnderecoService buscaEndereco;
    private Throwable throwable;
    
    @Before
    public void setUp() {
    	buscaEndereco = new BuscaEnderecoService();
    	throwable = null;
    }
    
    @Given("^Eu possuo um CEP correto com (\\d+) digitos$")
    public void possuoCEPCorreto(String cep){
    	buscaEndereco.buscar(cep);
    }
    
    @When("^Eu informo o CEP {(\\d+)}$")
    public void eu_informo_o_CEP(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^O resultado deve ser o endereço \"([^\"]*)\"$")
    public void o_resultado_deve_ser_o_endereço(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Eu possuo um CEP incorreto com (\\d+) digitos$")
    public void eu_possuo_um_CEP_incorreto_com_digitos(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^O retorno contera um valor de \"([^\"]*)\" igual a \"([^\"]*)\"\\.$")
    public void o_retorno_contera_um_valor_de_igual_a(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Eu possuo um CEP incorreto com mais de (\\d+) digitos$")
    public void eu_possuo_um_CEP_incorreto_com_mais_de_digitos(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^O retorno da consulta será um (\\d+) \\(Bad Request\\)\\.$")
    public void o_retorno_da_consulta_será_um_Bad_Request(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Eu possuo um CEP incorreto com caracteres invalidos\\.$")
    public void eu_possuo_um_CEP_incorreto_com_caracteres_invalidos() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Eu informo o CEP {(\\d+) A\\*n(\\d+)}$")
    public void eu_informo_o_CEP_A_n(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}