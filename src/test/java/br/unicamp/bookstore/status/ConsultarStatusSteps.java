package br.unicamp.bookstore.status;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.assertj.core.api.Assertions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.tomakehurst.wiremock.WireMockServer;

import br.unicamp.bookstore.Configuration;
import br.unicamp.bookstore.service.ConsultaStatusService;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultarStatusSteps {

	public WireMockServer wireMockServer = new WireMockServer();

	@Mock
	private Configuration configuration;

	@InjectMocks
	private ConsultaStatusService consultaStatusService;

	private String status;

	@BeforeClass
	public void setupTest() {
		wireMockServer.start();
	}
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(configuration.getUrlEndpoint()).thenReturn("http://localhost:8080");
	}

	@AfterClass
	public void tearDownTest() {
		wireMockServer.stop();
	}
	
	@Given("^Eu possuo um codigo de rastreamento de uma compra efetuado no BookStore$")
	public void eu_possuo_um_codigo_de_rastreamento_de_uma_compra_efetuado_no_BookStore() throws Throwable {
		wireMockServer.stubFor(post(urlEqualTo("/sro_bin/sroii_xml.eventos"))
				.willReturn(aResponse().withStatus(200)
				.withHeader("Content-Type", "text/xml")
				.withBodyFile("resultado-pesquisa-status.xml")));
	}

	@When("^O cliente informar o <codigo> de rastreamento$")
	public void o_cliente_informar_o_codigo_de_rastreamento(String codigo) throws Throwable {
		status = consultaStatusService.consultStatus(codigo);
		
		wireMockServer.verify(postRequestedFor(urlMatching("/sro_bin/sroii_xml.eventos"))
				.withRequestBody(containing("objetos=" + codigo)));
	}

	@Then("^O cliente recebera o <status> da entrega$")
	public void o_cliente_recebera_o_status_da_entrega(String status) throws Throwable {
		assertEquals(this.status, status);
	}
}