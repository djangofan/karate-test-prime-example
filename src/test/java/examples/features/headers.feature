Feature: sample karate test script

  Scenario: Match to json response

    Given url demoBaseUrl + '/asjson'
    When method get
    Then status 200
    * match responseHeaders.Content-Type == [application/json]
    * match response.color == '#present'
    * match response.type == '#present'

