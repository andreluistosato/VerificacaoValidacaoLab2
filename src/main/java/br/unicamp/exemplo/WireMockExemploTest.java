package br.unicamp.exemplo;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.any;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.notMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import br.unicamp.bookstore.Configuration;
import br.unicamp.bookstore.service.ConsultaStatusService;

@RunWith(MockitoJUnitRunner.class)
public class WireMockExemploTest {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule();
	
	@InjectMocks
	private ConsultaStatusService consultaStatusService;
	
	@Mock
	private Configuration configuration;

	@Before
	public void setup() {
		Mockito.when(configuration.getUrlEndpoint()).thenReturn("http://localhost:8080");
	}
	
	
	@Test
	public void exampleTest() {
	    stubFor(post(urlEqualTo("/sro_bin/sroii_xml.eventos"))
	            //.withHeader("Accept", equalTo("text/xml"))
	            .willReturn(aResponse()
	                .withStatus(200)
	                .withHeader("Content-Type", "text/xml")
	                .withBodyFile("resultado-pesquisa-status.xml")));

	    String status = consultaStatusService.consultStatus("123");

	    assertNotNull(status);

//	    verify(postRequestedFor(urlMatching("/my/resource/[a-z0-9]+"))
//	            .withRequestBody(matching(".*<message>1234</message>.*"))
//	            .withHeader("Content-Type", notMatching("application/json")));
	}
	
}
