@copilot
Feature: Gerenciamento de pets na Petstore API com abordagem GitHub Copilot

  @C01
  Scenario: Criar um pet válido
    Given que a abordagem Copilot possui os dados de um pet válido para C01
    When a abordagem Copilot criar o pet de C01
    Then a resposta de C01 da abordagem Copilot deve possuir status 200
    And o nome retornado em C01 da abordagem Copilot deve corresponder ao enviado

  @C02
  Scenario: Consultar um pet existente
    Given que a abordagem Copilot criou um pet independente para C02
    When a abordagem Copilot consultar o pet de C02 pelo identificador
    Then a resposta de C02 da abordagem Copilot deve possuir status 200
    And o identificador retornado em C02 da abordagem Copilot deve corresponder ao informado

  @C03
  Scenario: Atualizar um pet existente
    Given que a abordagem Copilot criou um pet independente para C03
    When a abordagem Copilot atualizar nome e status do pet de C03
    Then a resposta de C03 da abordagem Copilot deve possuir status 200
    And os dados retornados em C03 da abordagem Copilot devem refletir a atualização

  @C04
  Scenario: Excluir um pet existente
    Given que a abordagem Copilot criou um pet independente para C04
    When a abordagem Copilot excluir o pet de C04
    Then a resposta de C04 da abordagem Copilot deve possuir status 200
    And uma consulta posterior em C04 da abordagem Copilot deve retornar 404

  @C05
  Scenario: Consultar um pet inexistente
    Given que não existe um pet com o identificador informado na abordagem Copilot
    When a abordagem Copilot consultar o pet inexistente pelo identificador
    Then a resposta de C05 da abordagem Copilot deve possuir status 404
    And a resposta de C05 da abordagem Copilot deve informar que o pet não foi encontrado
