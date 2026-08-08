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
    private long petIdConsulta = 2002L;

    //Métodos do C01 aqui

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
                response.jsonPath().getString("name"));
        ;
    }

    //Métodos do C02 aqui

    @Given("que existe um pet válido cadastrado para consulta")
    public void queExisteUmPetVidaloCadastradoParaConsulta() {

        String body = "{\"id\":2002,\"name\":\"pet-manual-c02\",\"photoUrls\":[\"https://example.com/pet.jpg\"],\"status\":\"available\"}";

        Response createResponse =
                given()
                        .contentType(ContentType.JSON)
                        .body(body)
                        .when()
                        .post(ApiConfig.BASE_URL + "/pet");

        System.out.println("STATUS CREATE C02: " + createResponse.getStatusCode());
        System.out.println("BODY CREATE C02: " + createResponse.body().asString());

        assertEquals(200, createResponse.getStatusCode());
    }

    @When("eu consultar o pet pelo seu identificador")
    public void euConsultarOPetPeloSeuIdentificador() {

        response =
                given()
                        .when()
                        .get(ApiConfig.BASE_URL + "/pet/" + petIdConsulta);

        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
    }

    @Then("a API deve retornar status code 200 para a consulta")
    public void aAPIDeveRetornarStatusCode200ParaAConsulta() {
        assertEquals(200, response.getStatusCode());
    }

    @Then("o identificador do pet consultado deve estar correto")
    public void oIdentificadorDoPetConsultadoDeEstarCorreto() {

        assertEquals(petIdConsulta, response.jsonPath().getInt("id"));
        given()
                .when()
                .delete(ApiConfig.BASE_URL + "/pet/" + petIdConsulta)
                .then()
                .statusCode(200);
    }
}