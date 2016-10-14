package br.unicamp.bookstore.endereco;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.tomakehurst.wiremock.WireMockServer;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.service.BuscaEnderecoService;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuscaEnderecoSteps {

	public WireMockServer wireMockServer = new WireMockServer();

	@Mock
	private Configuracao configuration;

	@InjectMocks
	private BuscaEnderecoService buscaEndereco;

	private String endereco;
	
	private Throwable throwable;

	@Before
	public void setUp() {
		if (!wireMockServer.isRunning()) {
			wireMockServer.start();
		}
		MockitoAnnotations.initMocks(this);
		Mockito.when(configuration.getBuscarEnderecoUrl())
				.thenReturn("http://localhost:8080/ws");
		throwable = null;
		endereco = null;
	}

	@After
	public void teardown() {
		wireMockServer.stop();
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
		try {
			endereco = buscaEndereco.buscar(cep);
		} catch (Exception e) {
			throwable = e;
		}
	}

	@Then("^O resultado deve ser o endereco \"([^\"]*)\"$")
	public void o_resultado_deve_ser_o_endereco(String enderecoEsperado) throws Throwable {
		assertEquals(enderecoEsperado, endereco);
		assertNull(throwable);
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
		assertNull(throwable);
	}

	@Given("^Eu possuo um CEP incorreto com mais de (\\d+) digitos$")
	public void eu_possuo_um_CEP_incorreto_com_mais_de_digitos(int cepIncorreto) throws Throwable {
		wireMockServer.stubFor(get(urlEqualTo("/ws/" + cepIncorreto + "/xml/"))
				.willReturn(aResponse().withStatus(400)));

	}

	@Then("^O retorno da consulta sera um (\\d+) \\(Bad Request\\)\\.$")
	public void o_retorno_da_consulta_sera_um_Bad_Request(String retorno) throws Throwable {
		assertNotNull(throwable);
		assertNull(endereco);
	}

}