package br.unicamp.bookstore.calculafrete;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.assertj.core.api.Assertions;

import com.github.tomakehurst.wiremock.WireMockServer;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Produto;
import br.unicamp.bookstore.model.TipoEntregaEnum;
import br.unicamp.bookstore.service.BuscaEnderecoService;
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
	
    private Throwable throwable;
    
    @Before
    public void setUp() {
    
    	throwable = null;
    }

	@Given("^Que eu possuo o uma calculadora de valor de frete e tempo$")
	public void que_eu_possuo_o_uma_calculadora_de_valor_de_frete_e_tempo() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^Eu informo Peso {(\\d+)}, Largura {(\\d+)}, Altura {(\\d+)}, Comprimento {(\\d+)}, Cep {(\\d+)} e TipoEntrega {(\\d+)}$")
	public void eu_informo_Peso_Largura_Altura_Comprimento_Cep_e_TipoEntrega(Integer peso, Integer largura, Integer altura, 
			Integer comprimento, Integer cep, Integer tipoEntrega) throws Throwable {
	    
		Produto produto = new Produto(peso.doubleValue(), largura.doubleValue(), altura.doubleValue(), comprimento.doubleValue());
		
		//cep, TipoEntregaEnum.getTipoEntregaEnum(tipoEntrega);
		
		
		//TODO
		
		
		
//		Código Serviço
//		40010 SEDEX Varejo
//		40215 SEDEX 10 Varejo
//		41106 PAC Varejo
		
	}
	
	@Then("^eu recebo um Objeto contendo valor do Frete e o Tempo$")
	public void eu_recebo_um_Objeto_contendo_valor_do_Frete_e_o_Tempo() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}