
Feature: sample karate test script

  Background:
    * configure report = { showRequest: true, showResponse: false, showLog: true, showAllSteps: true}

  Scenario: Match to json response

    Given url demoBaseUrl + '/asjson'
    When method get
    Then status 200
    * match responseHeaders.Content-Type == [application/json]
    * match response.color == '#present'
    * match response.type == '#present'

