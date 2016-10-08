import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.Result;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class BuscaEnderecoWire {

	private Object testClient;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089); // No-args constructor defaults to port 8080

	
	@Test
	public void exampleTest() {
	    stubFor(get(urlEqualTo("/my/resource"))
	            .withHeader("Accept", equalTo("text/xml"))
	            .willReturn(aResponse()
	                .withStatus(200)
	                .withHeader("Content-Type", "text/xml")
	                .withBody("<response>Some content</response>")));

	    //Result result = myHttpServiceCallingObject.doSomething();
	    Result result = null;

	    assertTrue(result.wasSuccessful());

	    verify(postRequestedFor(urlMatching("/my/resource/[a-z0-9]+"))
	            .withRequestBody(matching(".*<message>1234</message>.*"))
	            .withHeader("Content-Type", notMatching("application/json")));
	}
	
	/*@Test
	public void exactUrlOnly() {
	    stubFor(get(urlEqualTo("/some/thing"))
	            .willReturn(aResponse()
	                .withHeader("Content-Type", "text/plain")
	                .withBody("Hello world!")));

	    assertThat(testClient.get("/some/thing").statusCode(), is(200));
	    assertThat(testClient.get("/some/thing/else").statusCode(), is(404));
	}*/

}
