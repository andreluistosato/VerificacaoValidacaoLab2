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
import org.assertj.core.api.Assertions;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.PrecoPrazo;
import br.unicamp.bookstore.model.Produto;
import br.unicamp.bookstore.model.TipoEntregaEnum;
import br.unicamp.bookstore.service.CalculaFreteService;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculaFreteSteps{
	
	public static WireMockServer wireMockServer = new WireMockServer();
	
	@Mock
	private Configuracao configuration;

	@InjectMocks
	private CalculaFreteService calculaFrete;
	private PrecoPrazo precoPrazo;
	
    private Throwable throwable;
    
    @Before
    public void setUp() {
    	if (!wireMockServer.isRunning()) {
			wireMockServer.start();
			wireMockServer.resetToDefaultMappings();
		}
		MockitoAnnotations.initMocks(this);
		Mockito.when(configuration.getConsultaPrecoPrazoUrl())
				.thenReturn("http://localhost:8080/calculador/CalcPrecoPrazo.aspx");
    }

	@Given("^Que eu possuo o uma calculadora de valor de frete e tempo$")
	public void que_eu_possuo_o_uma_calculadora_de_valor_de_frete_e_tempo() throws Throwable {
	    assertNotNull(calculaFrete);
	}
	
	@When("^Eu informo Peso (\\d+), Largura (\\d+), Altura (\\d+), Comprimento (\\d+), Cep \"([^\"]*)\" e tipoEntrega \"([^\"]*)\"$")
	public void eu_informo_Peso_Largura_Altura_Comprimento_Cep_e_TipoEntrega(Integer peso, Integer largura, Integer altura, Integer comprimento, String cep, String tipoEntrega) throws Throwable {
		
		TipoEntregaEnum tipoEntregaEnum = TipoEntregaEnum.valueOf(tipoEntrega.trim().replace(" ", "").toUpperCase());
	
		
		Produto produto = new Produto(peso.doubleValue(), largura.doubleValue(), altura.doubleValue(), comprimento.doubleValue());
		
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

		precoPrazo = calculaFrete.consultaPrecoPrazo(produto, cep, tipoEntregaEnum.getCodigo());
		
	}


	@Then("^Eu recebo um preco \"([^\"]*)\" e o prazo (\\d+)$")
	public void eu_recebo_um_preco_e_o_prazo(String preco, int prazo) throws Throwable {
		assertEquals(preco, precoPrazo.getValor());
		assertEquals(prazo, precoPrazo.getPrazoEntrega().intValue());
	}

}