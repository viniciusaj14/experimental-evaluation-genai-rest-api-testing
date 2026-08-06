package steps;

import config.ApiConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetSteps {

    private Response response;

    private String petName = "pet-manual-vinicius";


    @Given("que eu tenho os dados de um novo pet válido")
    public void queEuTenhoOsDadosDeUmNovoPetValido() {

    }

    @When("eu enviar uma requisição POST para criar o pet")
    public void euEnviarUmaRequisicaoPOSTparaCriarOPet() {

        String body = """
                {
                "id": 912071300006,
                "name": "pet-manual-vinicius",
                "photoUrls": [
                    "https://example.com/pet.jpg"
                    ],
                    "status": "available"
                }
                """;

        response =
                given()
                        .contentType(ContentType.JSON)
                        .body(body)
                        .when()
                        .post(ApiConfig.BASE_URL + "/pet");
    }

    @Then("a API deve retornar status code 200")
    public void aAPIDeveRetornarStatusCode200() {

        assertEquals(response.getStatusCode(), 200);
    }

    @Then("o pet deve ser criado corretamente")
    public void oPetDeveSerCriadoCorretamente() {

        assertEquals(
                petName,
                response.jsonPath().getString("name")
        );

    }
}