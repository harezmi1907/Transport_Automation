Feature: This feature is to validate buyer interaction

  @registration
  Scenario: Verify student registration
    When I fill out the form for <free> or <paid> student
      |free | 1 |
      |paid | 2 |
    Then I enter the middle initial
    Then I enter last name
#    Then I enter date of birth
#    Then I pick a school
#    Then I pick a grade
#    Then I enter address



