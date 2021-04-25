Feature: Calculations

  @firstTest
  Scenario: Borrowing estimation check
    Given I launch chrome browser
    When I open ANZ calculation page
    Then I verify borrowing estimate
    And close browser


  @secondTest
  Scenario: Clicking 'Start over' button clears the form
    Given I launch chrome browser
    When I open ANZ calculation page
    Then I enter calculation data
    And I clear the form
    And close browser

  @thirdTest
  Scenario: Living expenses to one dollar
    Given I launch chrome browser
    When I open ANZ calculation page
    Then I enter living expenses to one dollar
    And I verify the message
    And close browser