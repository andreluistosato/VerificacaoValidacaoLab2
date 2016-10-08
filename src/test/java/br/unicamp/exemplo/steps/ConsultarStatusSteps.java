package br.unicamp.exemplo.steps;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.assertj.core.api.Assertions;
import br.unicamp.exemplo.BuscaEndereco;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultarStatusSteps{
	
	@Given("^Eu possuo um codigo de rastreamento de uma compra efetuado no BookStore$")
	public void eu_possuo_um_codigo_de_rastreamento_de_uma_compra_efetuado_no_BookStore() throws Throwable {

		}

	@When("^O cliente informar o <codigo> de rastreamento$")
	public void o_cliente_informar_o_codigo_de_rastreamento() throws Throwable {
	}

	@Then("^O cliente recebera o <status> da entrega$")
	public void o_cliente_recebera_o_status_da_entrega() throws Throwable {

	}
}