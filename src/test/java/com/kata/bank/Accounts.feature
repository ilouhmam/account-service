Feature: Testing Create Account
  Background:
    * url baseUrl
    * path 'accounts'
    #* configure logPrettyRequest = true
    #* configure logPrettyResponse = true

  Scenario: Testing valid account creation
    * json reqBody = read('classpath:resources/data/create_account.json')
    And path 'create'
    And request reqBody
    When method POST
    Then status 200
    And match response == { "id": 1, "date": "2020-02-22", "rib": "234567876", "iban": "34587777", "balance": 4000.0 }

  Scenario: Testing valid deposit
    * json reqBody = read('classpath:resources/data/deposit.json')
    And path 'deposit'
    And request reqBody
    When method POST
    Then status 200
    And match response contains "OK"

  Scenario: Testing valid withdrawal
    * json reqBody = read('classpath:resources/data/withdrawal.json')
    And path 'withdrawal'
    And request reqBody
    When method POST
    Then status 200
    And match response contains "OK"

  Scenario: Testing valid operations
    * json reqBody = read('classpath:resources/data/operations.json')
    And path 'operations'
    And request reqBody
    When method POST
    Then status 200
    And print response
    And match response ==  [{"date": "2022-01-17",  "accountId": 1, "amount": 4000.0,  "balance": 4000.0, "type": "DEPOSIT" }, { "date": "2022-01-17", "accountId": 1, "amount": 2000.0, "balance": 4000.0,"type": "WITHDRAWAL"}]