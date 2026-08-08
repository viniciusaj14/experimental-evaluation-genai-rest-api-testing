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
    private long petIdAtualizacao = 3003L;
    private long petIdExclusao = 4004L;
    private long petIdInexistente = 999999L;

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

    //Métodos do C03 aqui

    @Given("que existe um pet cadastrado para atualização")
    public void queExisteUmPetCadastradoParaAtualizacao() {

        String body = """
                {
                "id":3003,
                "name":"pet-c03-original",
                "photoUrls":[
                "https://example.com/pet.jpg"
                ],
                "status":"available"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(ApiConfig.BASE_URL + "/pet")
                .then()
                .statusCode(200);
    }

    @When("eu enviar uma requisição PUT para atualizar o pet")
    public void euEnviarUmaRequisicaoPUTparaAtualizarOPet() {

        String body = """
                {
                "id":3003,
                "name":"pet-c03-atualizado",
                "photoUrls":[
                "https://example.com/pet.jpg"
                ],
                "status":"sold"
                }
                """;

        response =
                given()
                        .contentType(ContentType.JSON)
                        .body(body)
                        .when()
                        .put(ApiConfig.BASE_URL + "/pet");

        System.out.println("STATUS UPDATE C03: " + response.statusCode());
        System.out.println("BODY UPDATE C03: " + response.body().asString());
    }

    @Then("a API deve retornar status code 200 na atualização")
    public void aAPIDeveRetornarStatusCode200NaAtualizacao() {

        assertEquals(200, response.statusCode());
    }

    @Then("os dados do pet devem estar atualizados")
    public void osDadosDoPetDevEstarAtualizados() {

        assertEquals(
                "pet-c03-atualizado",
                response.jsonPath().getString("name")
        );

        assertEquals(
                "sold",
                response.jsonPath().getString("status")
        );

        given()
                .when()
                .delete(ApiConfig.BASE_URL + "/pet/" + petIdAtualizacao)
                .then()
                .statusCode(200);
    }

    //Métodos do C04 aqui

    @Given("que existe um pet cadastrado para exclusão")
    public void queExisteUmPetCadastradoParaExclusao() {

        String body = """
                        {
                        "id":4004,
                        "name":"pet-c04-exclusao",
                        "photoUrls":[
                        "https://example.com/pet.jpg"
                        ],
                        "status":"available"
                        }
                """;

        response =
                given()
                        .contentType(ContentType.JSON)
                        .body(body)
                        .when()
                        .post(ApiConfig.BASE_URL + "/pet");

        System.out.println("STATUS CREATE C04: " + response.statusCode());
        System.out.println("BODY CREATE C04: " + response.body().asString());

        assertEquals(200, response.statusCode());
    }

    @When("eu enviar uma requisição DELETE para excluir o pet")
    public void euEnviarUmaRequisicaoDELETEparaExcluirOPet() {

        response =
                given()
                        .when()
                        .delete(ApiConfig.BASE_URL + "/pet/" + petIdExclusao);

        System.out.println("STATUS DELETE C04: " + response.statusCode());
        System.out.println("BODY DELETE C04: " + response.body().asString());
    }

    @Then("a API deve retornar status code 200 na exclusão")
    public void aAPIDeveRetornarStatusCode200NaExclusao(){

        assertEquals(200, response.statusCode());
    }

    @Then("o pet não deve mais existir")
    public void oPetNaoDeveMaisExistir(){

        Response consulta =
                given()
                        .when()
                .get(ApiConfig.BASE_URL + "/pet/" + petIdExclusao);

        assertEquals(404, consulta.statusCode());
    }

    //Métodos do C05 aqui

    @Given("que não existe um pet com o identificador informado")
    public void queExisteUmPetComOIdentificadorInformado(){

        Response consulta =
                given()
                        .when()
                        .get(ApiConfig.BASE_URL + "/pet/" + petIdInexistente);

        System.out.println("STATUS CONSULTA C05: " + consulta.statusCode());
        System.out.println("BODY CONSULTA C05: " + consulta.body().asString());

        assertEquals(404, consulta.statusCode());
    }

    @When("eu consultar o pet inexistente pelo identificador")
    public void euConsultarOPetInexistentePeloIdentificador(){

        response =
                given()
                        .when()
                        .get(ApiConfig.BASE_URL + "/pet/" + petIdInexistente);

        System.out.println("STATUS GET C05: " + response.statusCode());
        System.out.println("BODY GET C05: " + response.body().asString());
    }

    @Then("a API deve retornar status code 404")
    public void aAPIDeveRetornarStatus404(){

        assertEquals(404, response.statusCode());
    }
}