package copilot.steps;

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

public class CopilotPetSteps {

    private static final long C01_PET_ID = 912071300006L;
    private static final long C02_PET_ID = 2002L;
    private static final long C03_PET_ID = 3003L;
    private static final long C04_PET_ID = 4004L;
    private static final long C05_MISSING_PET_ID = 999999L;
    private static final String PHOTO_URL = "https://example.com/copilot-pet.jpg";

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
    public void cleanScenarioPet() {
        if (cleanupRequired) {
            deleteIgnoringResponse(petId, "CLEANUP");
        }
    }

    @Given("que a abordagem Copilot possui os dados de um pet válido para C01")
    public void prepareC01Data() {
        petId = C01_PET_ID;
        expectedName = "pet-copilot-c01";
        expectedStatus = "available";
        deleteIgnoringResponse(petId, "PREPARE C01");
    }

    @When("a abordagem Copilot criar o pet de C01")
    public void createC01Pet() {
        response = createPet(petId, expectedName, expectedStatus);
        logResponse("CREATE C01", response);
        cleanupRequired = response.statusCode() == 200;
    }

    @Then("a resposta de C01 da abordagem Copilot deve possuir status 200")
    public void validateC01Status() {
        assertEquals(200, response.statusCode());
    }

    @Then("o nome retornado em C01 da abordagem Copilot deve corresponder ao enviado")
    public void validateC01Name() {
        assertEquals(expectedName, response.jsonPath().getString("name"));
    }

    @Given("que a abordagem Copilot criou um pet independente para C02")
    public void createC02Precondition() {
        petId = C02_PET_ID;
        expectedName = "pet-copilot-c02";
        expectedStatus = "available";
        prepareExistingPet("C02");
    }

    @When("a abordagem Copilot consultar o pet de C02 pelo identificador")
    public void getC02Pet() {
        response = given().when().get(ApiConfig.BASE_URL + "/pet/" + petId);
        logResponse("GET C02", response);
    }

    @Then("a resposta de C02 da abordagem Copilot deve possuir status 200")
    public void validateC02Status() {
        assertEquals(200, response.statusCode());
    }

    @Then("o identificador retornado em C02 da abordagem Copilot deve corresponder ao informado")
    public void validateC02Id() {
        assertEquals(petId, response.jsonPath().getLong("id"));
    }

    @Given("que a abordagem Copilot criou um pet independente para C03")
    public void createC03Precondition() {
        petId = C03_PET_ID;
        expectedName = "pet-copilot-c03-original";
        expectedStatus = "available";
        prepareExistingPet("C03");
    }

    @When("a abordagem Copilot atualizar nome e status do pet de C03")
    public void updateC03Pet() {
        expectedName = "pet-copilot-c03-atualizado";
        expectedStatus = "sold";
        response = given()
                .contentType(ContentType.JSON)
                .body(petBody(petId, expectedName, expectedStatus))
                .when()
                .put(ApiConfig.BASE_URL + "/pet");
        logResponse("UPDATE C03", response);
    }

    @Then("a resposta de C03 da abordagem Copilot deve possuir status 200")
    public void validateC03Status() {
        assertEquals(200, response.statusCode());
    }

    @Then("os dados retornados em C03 da abordagem Copilot devem refletir a atualização")
    public void validateC03Data() {
        assertAll(
                () -> assertEquals(petId, response.jsonPath().getLong("id")),
                () -> assertEquals(expectedName, response.jsonPath().getString("name")),
                () -> assertEquals(expectedStatus, response.jsonPath().getString("status"))
        );
    }

    @Given("que a abordagem Copilot criou um pet independente para C04")
    public void createC04Precondition() {
        petId = C04_PET_ID;
        expectedName = "pet-copilot-c04";
        expectedStatus = "available";
        prepareExistingPet("C04");
    }

    @When("a abordagem Copilot excluir o pet de C04")
    public void deleteC04Pet() {
        response = given().when().delete(ApiConfig.BASE_URL + "/pet/" + petId);
        logResponse("DELETE C04", response);
    }

    @Then("a resposta de C04 da abordagem Copilot deve possuir status 200")
    public void validateC04Status() {
        assertEquals(200, response.statusCode());
    }

    @Then("uma consulta posterior em C04 da abordagem Copilot deve retornar 404")
    public void validateC04Removal() {
        Response getResponse = given().when().get(ApiConfig.BASE_URL + "/pet/" + petId);
        logResponse("GET AFTER DELETE C04", getResponse);
        assertEquals(404, getResponse.statusCode());
        cleanupRequired = false;
    }

    @Given("que não existe um pet com o identificador informado na abordagem Copilot")
    public void ensureC05PetDoesNotExist() {
        petId = C05_MISSING_PET_ID;
        deleteIgnoringResponse(petId, "PREPARE C05");
    }

    @When("a abordagem Copilot consultar o pet inexistente pelo identificador")
    public void getMissingC05Pet() {
        response = given().when().get(ApiConfig.BASE_URL + "/pet/" + petId);
        logResponse("GET C05", response);
    }

    @Then("a resposta de C05 da abordagem Copilot deve possuir status 404")
    public void validateC05Status() {
        assertEquals(404, response.statusCode());
    }

    @Then("a resposta de C05 da abordagem Copilot deve informar que o pet não foi encontrado")
    public void validateC05NotFoundMessage() {
        assertEquals("Pet not found", response.body().asString().trim());
    }

    private void prepareExistingPet(String scenarioId) {
        deleteIgnoringResponse(petId, "PREPARE " + scenarioId);
        Response createResponse = createPet(petId, expectedName, expectedStatus);
        logResponse("CREATE " + scenarioId, createResponse);
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

    private void deleteIgnoringResponse(long id, String label) {
        try {
            Response deleteResponse = given().when().delete(ApiConfig.BASE_URL + "/pet/" + id);
            logResponse(label, deleteResponse);
        } catch (RuntimeException exception) {
            System.out.println(label + " STATUS: unavailable");
            System.out.println(label + " BODY: " + exception.getMessage());
        }
    }

    private void logResponse(String label, Response loggedResponse) {
        System.out.println(label + " STATUS: " + loggedResponse.statusCode());
        System.out.println(label + " BODY: " + loggedResponse.body().asString());
    }
}
