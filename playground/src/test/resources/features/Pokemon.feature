Feature: Pokemon feature

  @pokemon
  Scenario: Check that the weight of ditto is 40
    Given I request info about ditto pokemon
    When I get weight from the response
    Then I see that weight is 40