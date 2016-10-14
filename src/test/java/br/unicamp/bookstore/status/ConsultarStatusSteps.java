package br.unicamp.bookstore.status;

import static org.junit.Assert.*;

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
import cucumber.api.PendingException;
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

	private Exception throwable;

	@Before
	public void setUp() {
		wireMockServer.start();
		MockitoAnnotations.initMocks(this);
		Mockito.when(configuration.getStatusEntregaUrl())
				.thenReturn("http://localhost:8080/sro_bin/sroii_xml.eventos");
		status = null;
		throwable = null;
	}

	@After
	public void teardown() {
		wireMockServer.stop();
	}

	@Given("^Eu possuo um codigo de rastreamento de uma compra efetuado no BookStore$")
	public void eu_possuo_um_codigo_de_rastreamento_de_uma_compra_efetuado_no_BookStore() throws Throwable {
		wireMockServer.stubFor(post(urlEqualTo("/sro_bin/sroii_xml.eventos"))
				.withRequestBody(containing("SQ458226057BR"))
				.willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "text/xml")
						.withBodyFile("resultado-pesquisa-status-entregue.xml")));

		wireMockServer.stubFor(post(urlEqualTo("/sro_bin/sroii_xml.eventos"))
				.withRequestBody(containing("SQ458226058BR"))
				.willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "text/xml")
						.withBodyFile("resultado-pesquisa-status-carteiro-nao-atendido.xml")));

		wireMockServer.stubFor(post(urlEqualTo("/sro_bin/sroii_xml.eventos"))
				.withRequestBody(containing("SQ458226059BR"))
				.willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "text/xml")
						.withBodyFile("resultado-pesquisa-status-cliente-mudou-se.xml")));
	}

	@Given("^Eu possuo um codigo invalido de rastreamento de uma compra efetuado no BookStore$")
	public void eu_possuo_um_codigo_invalido_de_rastreamento_de_uma_compra_efetuado_no_BookStore() throws Throwable {
		wireMockServer.stubFor(post(urlEqualTo("/sro_bin/sroii_xml.eventos"))
				.willReturn(aResponse().withStatus(400)));
	}

	@Given("^Eu possuo um codigo de rastreamento de uma compra efetuado no BookStore , porem o servico esta fora$")
	public void eu_possuo_um_codigo_de_rastreamento_de_uma_compra_efetuado_no_BookStore_porem_o_servico_esta_fora()
			throws Throwable {
		// Sem mapeamento
	}

	@When("^O cliente informar o codigo \"([^\"]*)\" de rastreamento$")
	public void o_cliente_informar_o_codigo_de_rastreamento(String codigo) throws Throwable {
		try {
			status = consultaStatusService.consultStatus(codigo);

			wireMockServer.verify(postRequestedFor(urlMatching("/sro_bin/sroii_xml.eventos"))
					.withRequestBody(containing("objetos=" + codigo)));
		} catch (Exception e) {
			throwable = e;
		}
	}

	@Then("^O cliente recebera o status: \"([^\"]*)\"$")
	public void o_cliente_recebera_o_status(String status) throws Throwable {
		assertEquals(this.status.getDescricao(), status);
		assertNull(throwable);
	}

	@Then("^O cliente recebera o codigo de erro$")
	public void o_cliente_recebera_o_codigo_de_erro() throws Throwable {
		assertNull(status);
		assertNotNull(throwable);
	}

}