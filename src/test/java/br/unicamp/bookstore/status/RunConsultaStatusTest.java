package br.unicamp.bookstore.status;

import org.junit.Rule;
import org.junit.runner.RunWith;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber" },
        glue = "br.unicamp.bookstore",
        features = "classpath:features/ConsultarStatus.feature"
)
public class RunConsultaStatusTest {
	
}

