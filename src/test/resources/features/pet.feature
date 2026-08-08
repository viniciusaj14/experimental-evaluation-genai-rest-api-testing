Feature: Gerenciamento de pets na Petstore API

  Scenario: Criar um pet válido
    Given que eu tenho os dados de um novo pet válido
    When eu enviar uma requisição POST para criar o pet
    Then a API deve retornar status code 200
    And o pet deve ser criado corretamente

  Scenario: Consultar um pet existente
    Given que existe um pet válido cadastrado para consulta
    When eu consultar o pet pelo seu identificador
    Then a API deve retornar status code 200 para a consulta
    And o identificador do pet consultado deve estar correto

  Scenario: Atualizar um pet existente
    Given que existe um pet cadastrado para atualização
    When eu enviar uma requisição PUT para atualizar o pet
    Then a API deve retornar status code 200 na atualização
    And os dados do pet devem estar atualizados