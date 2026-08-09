package chatgpt.steps;

import config.ApiConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatGPTPetSteps {

    private static final long C01_PET_ID = 920260809001L;
    private static final long C02_PET_ID = 920260809002L;
    private static final long C03_PET_ID = 920260809003L;
    private static final long C04_PET_ID = 920260809004L;
    private static final long C05_MISSING_PET_ID = 920260809005L;
    private static final String PHOTO_URL = "https://example.com/chatgpt-pet.jpg";

    private Response response;
    private long petId;
    private String expectedName;
    private String expectedStatus;
    private boolean cleanupRequired;

    @Before
    public void resetScenarioState() {
        response = null;
        petId = 0L;
        expectedName = null;
        expectedStatus = null;
        cleanupRequired = false;
    }

    @After
    public void cleanCreatedPet() {
        if (cleanupRequired) {
            deleteIgnoringResponse(petId);
        }
    }

    @Given("que a abordagem ChatGPT possui os dados de um pet válido para C01")
    public void prepareC01Data() {
        petId = C01_PET_ID;
        expectedName = "pet-chatgpt-c01";
        expectedStatus = "available";
        deleteIgnoringResponse(petId);
    }

    @When("a abordagem ChatGPT enviar POST para criar o pet de C01")
    public void createC01Pet() {
        response = createPet(petId, expectedName, expectedStatus);
        cleanupRequired = response.statusCode() == 200;
    }

    @Then("a resposta de C01 deve possuir status 200")
    public void validateC01Status() {
        assertEquals(200, response.statusCode());
    }

    @Then("o nome retornado em C01 deve corresponder ao nome enviado")
    public void validateC01Name() {
        assertEquals(expectedName, response.jsonPath().getString("name"));
    }

    @Given("que a abordagem ChatGPT criou um pet determinístico para C02")
    public void createC02Precondition() {
        petId = C02_PET_ID;
        expectedName = "pet-chatgpt-c02";
        expectedStatus = "available";
        prepareExistingPet();
    }

    @When("a abordagem ChatGPT consultar o pet de C02 pelo identificador")
    public void getC02Pet() {
        response = given().when().get(ApiConfig.BASE_URL + "/pet/" + petId);
    }

    @Then("a resposta de C02 deve possuir status 200")
    public void validateC02Status() {
        assertEquals(200, response.statusCode());
    }

    @Then("o identificador retornado em C02 deve corresponder ao informado")
    public void validateC02Id() {
        assertEquals(petId, response.jsonPath().getLong("id"));
    }

    @Given("que a abordagem ChatGPT criou um pet determinístico para C03")
    public void createC03Precondition() {
        petId = C03_PET_ID;
        expectedName = "pet-chatgpt-c03-original";
        expectedStatus = "available";
        prepareExistingPet();
    }

    @When("a abordagem ChatGPT atualizar o nome e o status do pet de C03")
    public void updateC03Pet() {
        expectedName = "pet-chatgpt-c03-atualizado";
        expectedStatus = "sold";
        response = given()
                .contentType(ContentType.JSON)
                .body(petBody(petId, expectedName, expectedStatus))
                .when()
                .put(ApiConfig.BASE_URL + "/pet");
    }

    @Then("a resposta de C03 deve possuir status 200")
    public void validateC03Status() {
        assertEquals(200, response.statusCode());
    }

    @Then("os dados retornados em C03 devem refletir a atualização")
    public void validateC03Data() {
        assertAll(
                () -> assertEquals(petId, response.jsonPath().getLong("id")),
                () -> assertEquals(expectedName, response.jsonPath().getString("name")),
                () -> assertEquals(expectedStatus, response.jsonPath().getString("status"))
        );
    }

    @Given("que a abordagem ChatGPT criou um pet determinístico para C04")
    public void createC04Precondition() {
        petId = C04_PET_ID;
        expectedName = "pet-chatgpt-c04";
        expectedStatus = "available";
        prepareExistingPet();
    }

    @When("a abordagem ChatGPT excluir o pet de C04")
    public void deleteC04Pet() {
        response = given().when().delete(ApiConfig.BASE_URL + "/pet/" + petId);
    }

    @Then("a resposta de C04 deve possuir status 200")
    public void validateC04DeleteStatus() {
        assertEquals(200, response.statusCode());
    }

    @Then("uma consulta posterior em C04 deve retornar 404")
    public void validateC04Removal() {
        Response getResponse = given().when().get(ApiConfig.BASE_URL + "/pet/" + petId);
        assertEquals(404, getResponse.statusCode());
        cleanupRequired = false;
    }

    @Given("que não existe um pet com o identificador informado na abordagem ChatGPT")
    public void ensureC05PetDoesNotExist() {
        petId = C05_MISSING_PET_ID;
        deleteIgnoringResponse(petId);
    }

    @When("a abordagem ChatGPT consultar o pet inexistente pelo identificador")
    public void getMissingC05Pet() {
        response = given().when().get(ApiConfig.BASE_URL + "/pet/" + petId);
    }

    @Then("a resposta negativa de C05 deve possuir status 404")
    public void validateC05Status() {
        assertEquals(404, response.statusCode());
    }

    @Then("a resposta de C05 deve informar que o pet não foi encontrado")
    public void validateC05NotFoundMessage() {
        assertEquals("Pet not found", response.body().asString().trim());
    }

    private void prepareExistingPet() {
        deleteIgnoringResponse(petId);
        Response createResponse = createPet(petId, expectedName, expectedStatus);
        assertEquals(200, createResponse.statusCode(), "A precondição de criação do pet falhou");
        cleanupRequired = true;
    }

    private Response createPet(long id, String name, String status) {
        return given()
                .contentType(ContentType.JSON)
                .body(petBody(id, name, status))
                .when()
                .post(ApiConfig.BASE_URL + "/pet");
    }

    private String petBody(long id, String name, String status) {
        return """
                {
                  "id": %d,
                  "name": "%s",
                  "photoUrls": ["%s"],
                  "status": "%s"
                }
                """.formatted(id, name, PHOTO_URL, status);
    }

    private void deleteIgnoringResponse(long id) {
        try {
            given().when().delete(ApiConfig.BASE_URL + "/pet/" + id);
        } catch (RuntimeException ignored) {
            // Limpeza best-effort; as assertions do cenário preservam a falha funcional.
        }
    }
}
