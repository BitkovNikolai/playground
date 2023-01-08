Feature: Default feature

  @pokemon
  Scenario: Default scenario
    Given I request info about ditto pokemon
    When I get weight from the response
    Then I see that weight is 40