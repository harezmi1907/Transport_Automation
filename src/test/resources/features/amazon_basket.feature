Feature: This feature is to validate buyer interaction

  @amazon
  Scenario: Verify student registration
    Given I enter the first name
    Then I enter the middle initial
    Then I enter last name
    Then I enter date of birth
    Then I pick a school
    Then I pick a grade
    Then I enter address



