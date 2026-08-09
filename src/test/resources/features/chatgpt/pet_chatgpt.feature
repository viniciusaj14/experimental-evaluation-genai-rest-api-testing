@chatgpt
Feature: Gerenciamento de pets na Petstore API com abordagem ChatGPT

  @C01
  Scenario: Criar um pet válido
    Given que a abordagem ChatGPT possui os dados de um pet válido para C01
    When a abordagem ChatGPT enviar POST para criar o pet de C01
    Then a resposta de C01 deve possuir status 200
    And o nome retornado em C01 deve corresponder ao nome enviado

  @C02
  Scenario: Consultar pet pelo identificador
    Given que a abordagem ChatGPT criou um pet determinístico para C02
    When a abordagem ChatGPT consultar o pet de C02 pelo identificador
    Then a resposta de C02 deve possuir status 200
    And o identificador retornado em C02 deve corresponder ao informado

  @C03
  Scenario: Atualizar pet existente
    Given que a abordagem ChatGPT criou um pet determinístico para C03
    When a abordagem ChatGPT atualizar o nome e o status do pet de C03
    Then a resposta de C03 deve possuir status 200
    And os dados retornados em C03 devem refletir a atualização

  @C04
  Scenario: Excluir pet existente
    Given que a abordagem ChatGPT criou um pet determinístico para C04
    When a abordagem ChatGPT excluir o pet de C04
    Then a resposta de C04 deve possuir status 200
    And uma consulta posterior em C04 deve retornar 404

  @C05
  Scenario: Consultar um pet inexistente
    Given que não existe um pet com o identificador informado na abordagem ChatGPT
    When a abordagem ChatGPT consultar o pet inexistente pelo identificador
    Then a resposta negativa de C05 deve possuir status 404
    And a resposta de C05 deve informar que o pet não foi encontrado
