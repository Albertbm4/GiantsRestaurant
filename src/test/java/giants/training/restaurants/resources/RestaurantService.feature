Feature: Testing GET and POST. Users should be able to submit GET and POST requests to a web service,represented by WireMock

  Scenario: Data Upload to a web service
    Given Create new restaurant service
    When Users upload data on a project
    Then The server should handle it and return a success status