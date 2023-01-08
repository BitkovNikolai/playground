Feature: Default feature

  @nasa
  Scenario Outline: Check date on apod request
    Given I request apod from <date> date
    Then I see that date is <date>
    Examples:
      | date       |
      | 2020-06-25 |
      | 2021-03-12 |