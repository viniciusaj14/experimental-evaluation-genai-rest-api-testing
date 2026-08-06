Feature: Gerenciamento de pets na Petstore API

  Scenario: Criar um pet válido
    Given que eu tenho os dados de um novo pet válido
    When eu enviar uma requisição POST para criar o pet
    Then a API deve retornar status code 200
    And o pet deve ser criado corretamente
