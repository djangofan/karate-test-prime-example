Feature: sample karate test script to reproduce https://github.com/intuit/karate/issues/552

  Scenario: Match to headers

    Given url demoBaseUrl + '/headers'
    When method get
    Then status 200
    * match responseCookies.testCookie == '#present'
    * match responseCookies.guid == '#present'

