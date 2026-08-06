package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnvironmentSteps {

    @Given("que o ambiente de testes está configurado")
    public void ambienteConfigurado() {
        assertTrue(true);
    }

    @When("o executor iniciar a validação")
    public void executorIniciarValidacao() {
        assertTrue(true);
    }

    @Then("o framework deve reconhecer o cenário")
    public void frameworkReconhecerCenario() {
        assertTrue(true);
    }
}
