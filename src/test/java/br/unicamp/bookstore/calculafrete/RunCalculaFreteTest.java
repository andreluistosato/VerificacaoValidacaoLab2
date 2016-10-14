package br.unicamp.bookstore.calculafrete;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber" },
        glue = "br.unicamp.bookstore.calculafrete",
        features = "classpath:features/CalculaFrete.feature"
)
public class RunCalculaFreteTest {
}

