package br.unicamp.bookstore.calculafrete;

import static org.junit.Assert.*;
import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.dao.DadosDeEntregaDAO;
import br.unicamp.bookstore.model.PrecoPrazo;
import br.unicamp.bookstore.model.Produto;
import br.unicamp.bookstore.model.TipoEntregaEnum;
import br.unicamp.bookstore.service.CalculaFreteService;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculaFreteSteps {

	public WireMockServer wireMockServer = new WireMockServer();

	@Mock
	private Configuracao configuration;

	@Mock
	private DadosDeEntregaDAO dadosDeEntregaDao;

	@InjectMocks
	private CalculaFreteService calculaFrete;
	private PrecoPrazo precoPrazo;

	private TipoEntregaEnum tipoEntregaEnum;

	private Produto produto;

	@Before
	public void setUp() {
		wireMockServer.start();
		MockitoAnnotations.initMocks(this);
		Mockito.when(configuration.getConsultaPrecoPrazoUrl())
				.thenReturn("http://localhost:8080/calculador/CalcPrecoPrazo.aspx");
	}

	@After
	public void teardown() {
		wireMockServer.stop();
	}

	@Given("^Que eu possuo uma calculadora de valor de frete e tempo$")
	public void que_eu_possuo_uma_calculadora_de_valor_de_frete_e_tempo() throws Throwable {
		assertNotNull(calculaFrete);

		// Sedex Varejo
		wireMockServer.stubFor(get(urlMatching(".*"))
				.withQueryParam("nCdServico", equalTo("40010"))
				.willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "text/xml")
						.withBodyFile("resultado-consulta-prazo-entrega-sedex-varejo.xml")));

		// Pac Varejo
		wireMockServer.stubFor(get(urlMatching(".*"))
				.withQueryParam("nCdServico", equalTo("41106"))
				.willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "text/xml")
						.withBodyFile("resultado-consulta-prazo-entrega-pac-varejo.xml")));

		// Sedex 10 Varejo
		wireMockServer.stubFor(get(urlMatching(".*"))
				.withQueryParam("nCdServico", equalTo("40215"))
				.willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "text/xml")
						.withBodyFile("resultado-consulta-prazo-entrega-sedex-10-varejo.xml")));

		// Cep invalido
		wireMockServer.stubFor(get(urlMatching(".*"))
				.withQueryParam("sCepDestino", equalTo("123"))
				.willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "text/xml")
						.withBodyFile("resultado-consulta-prazo-entrega-ERR.xml")));
		
		// Cep invalido
		wireMockServer.stubFor(get(urlMatching(".*"))
				.withQueryParam("sCepDestino", equalTo("123"))
				.willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "text/xml")
						.withBodyFile("resultado-consulta-prazo-entrega-ERR.xml")));
	}

	@When("^Eu informo Peso (\\d+), Largura (\\d+), Altura (\\d+), Comprimento (\\d+), Cep \"([^\"]*)\" e tipoEntrega \"([^\"]*)\"$")
	public void eu_informo_Peso_Largura_Altura_Comprimento_Cep_e_TipoEntrega(Integer peso, Integer largura,
			Integer altura, Integer comprimento, String cep, String tipoEntrega) throws Throwable {

		TipoEntregaEnum tipoEntregaEnum = TipoEntregaEnum.valueOf(tipoEntrega.trim().replace(" ", "").toUpperCase());

		Produto produto = new Produto(peso.doubleValue(), largura.doubleValue(), altura.doubleValue(),
				comprimento.doubleValue());

		precoPrazo = calculaFrete.consultaPrecoPrazo(produto, cep, tipoEntregaEnum.getCodigo());

	}

	@Then("^Eu recebo um preco \"([^\"]*)\" e o prazo (\\d+)$")
	public void eu_recebo_um_preco_e_o_prazo(String preco, int prazo) throws Throwable {
		assertEquals(preco, precoPrazo.getValor());
		assertEquals(prazo, precoPrazo.getPrazoEntrega().intValue());
	}

	@When("^Eu informo Peso (\\d+), Largura (\\d+), Altura (\\d+), Comprimento (\\d+), e o tipoEntrega \"([^\"]*)\"$")
	public void eu_informo_Peso_Largura_Altura_Comprimento_e_o_tipoEntrega(Integer peso, Integer altura,
			Integer largura, Integer comprimento, String tipoEntrega) throws Throwable {
		tipoEntregaEnum = TipoEntregaEnum.valueOf(tipoEntrega.trim().replace(" ", "").toUpperCase());

		produto = new Produto(peso.doubleValue(), largura.doubleValue(), altura.doubleValue(),
				comprimento.doubleValue());
	}

	@When("^Eu informo um cep \"([^\"]*)\" invalido$")
	public void eu_informo_um_cep_invalido(String cep) throws Throwable {
		precoPrazo = calculaFrete.consultaPrecoPrazo(produto, cep, tipoEntregaEnum.getCodigo());
	}

	@Then("^Eu recebo uma mensagem \"([^\"]*)\"$")
	public void eu_recebo_uma_mensagem(String erro) throws Throwable {
		assertEquals(precoPrazo.getMsgErro(), erro);

	}

}