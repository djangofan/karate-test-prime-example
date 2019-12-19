Feature: sample karate test script to reproduce https://github.com/intuit/karate/issues/552

  Scenario: Match to headers

    Given url demoBaseUrl + '/asjson'
    When method get
    Then status 200
    * match responseHeaders.Content-Type == [application/json]
    * match response.color == '#present'
    * match response.type == '#present'

