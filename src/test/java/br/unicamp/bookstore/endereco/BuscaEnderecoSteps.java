package br.unicamp.bookstore.endereco;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.http.Fault;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;
import br.unicamp.bookstore.service.BuscaEnderecoService;
import br.unicamp.bookstore.service.ConsultaStatusService;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuscaEnderecoSteps {

	public static WireMockServer wireMockServer = new WireMockServer();

	@Mock
	private Configuracao configuration;

	@InjectMocks
	private BuscaEnderecoService buscaEndereco;

	private String endereco;

	@Before
	public void setup() {
		if (!wireMockServer.isRunning()) {
			wireMockServer.start();
		}
		MockitoAnnotations.initMocks(this);
		Mockito.when(configuration.getBuscarEnderecoUrl())
				.thenReturn("http://localhost:8080/ws");
	}

	
	@Given("^Eu possuo um CEP correto com (\\d+) digitos$")
	public void eu_possuo_um_CEP_correto_com_digitos(int arg1) throws Throwable {
		wireMockServer.stubFor(get(urlMatching("/ws/.*"))
				.willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "text/xml")
						.withBodyFile("resultado-pesquisa-BuscaEndereco.xml")));
	}

	@When("^Eu informo o CEP (\\d+)$")
	public void eu_informo_o_CEP(String cep) throws Throwable {
		endereco = buscaEndereco.buscar(cep);
	}

	@Then("^O resultado deve ser o endereco \"([^\"]*)\"$")
	public void o_resultado_deve_ser_o_endereco(String enderecoEsperado) throws Throwable {
		enderecoEsperado = "Rua Carlos Gomes, Campinas";
		assertEquals(enderecoEsperado, endereco);
	}
	
	@Given("^Eu possuo um CEP incorreto com (\\d+) digitos$")
	public void eu_possuo_um_CEP_incorreto_com_digitos(int arg1) throws Throwable {
		wireMockServer.stubFor(get(urlMatching("/ws/.*"))
				.willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "text/xml")
						.withBodyFile("resultado-pesquisa-BuscaEndereco_ERR.xml")));
	
	}

	@Then("^O retorno contera um valor de \"([^\"]*)\"\\.$")
	public void o_retorno_contera_um_valor_de(String retorno) throws Throwable {
		assertEquals(retorno, endereco);
	}

	@Given("^Eu possuo um CEP incorreto com mais de (\\d+) digitos$")
	public void eu_possuo_um_CEP_incorreto_com_mais_de_digitos(int arg1) throws Throwable {
		wireMockServer.stubFor(get(urlEqualTo("/ws/123456789/xml/"))
				.willReturn(aResponse().withFault(Fault.EMPTY_RESPONSE)));
		
	}

	@Then("^O retorno da consulta sera um (\\d+) \\(Bad Request\\)\\.$")
	public void o_retorno_da_consulta_sera_um_Bad_Request(String retorno) throws Throwable {
		assertEquals(retorno, "400");
	}

	

}