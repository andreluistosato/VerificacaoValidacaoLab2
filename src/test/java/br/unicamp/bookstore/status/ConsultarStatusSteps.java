package br.unicamp.bookstore.status;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.junit.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.tomakehurst.wiremock.WireMockServer;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.StatusEncomenda;
import br.unicamp.bookstore.service.ConsultaStatusService;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultarStatusSteps {

	public WireMockServer wireMockServer = new WireMockServer();

	@Mock
	private Configuracao configuration;

	@InjectMocks
	private ConsultaStatusService consultaStatusService;

	private StatusEncomenda status;

	@Before
	public void setUp() {
		if (!wireMockServer.isRunning()) {
			wireMockServer.start();
		}
		MockitoAnnotations.initMocks(this);
		Mockito.when(configuration.getStatusEntregaUrl())
				.thenReturn("http://localhost:8080/sro_bin/sroii_xml.eventos");
	}

	@After
	public void teardown() {
		wireMockServer.stop();
	}

	@Given("^Eu possuo um codigo de rastreamento de uma compra efetuado no BookStore$")
	public void eu_possuo_um_codigo_de_rastreamento_de_uma_compra_efetuado_no_BookStore() throws Throwable {
		wireMockServer.stubFor(post(urlEqualTo("/sro_bin/sroii_xml.eventos"))
				.willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "text/xml")
						.withBodyFile("resultado-pesquisa-status.xml")));
	}

	@When("^O cliente informar o (\\d+) de rastreamento$")
	public void o_cliente_informar_o_codigo_de_rastreamento(String codigo) throws Throwable {
		status = consultaStatusService.consultStatus(codigo);

		wireMockServer.verify(postRequestedFor(urlMatching("/sro_bin/sroii_xml.eventos"))
				.withRequestBody(containing("objetos=" + codigo)));
	}

	@Then("^O cliente recebera o status:\"([^\"]*)\"$")
	public void o_cliente_recebera_o_status(String status) throws Throwable {
		assertEquals(this.status.getDescricao(), status);
	}

	@When("^O cliente informar o <codigo> de rastreamento$")
	public void o_cliente_informar_o_codigo_de_rastreamento() throws Throwable {
	}

	@Then("^O cliente recebera o <status> da entrega$")
	public void o_cliente_recebera_o_status_da_entrega() throws Throwable {
	}

	@Then("^O cliente recebera o codigo xx de erro$")
	public void o_cliente_recebera_o_codigo_xx_de_erro() throws Throwable {
	}

	@Then("^O cliente recebera o codigo de erro$")
	public void o_cliente_recebera_o_codigo_de_erro() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

}