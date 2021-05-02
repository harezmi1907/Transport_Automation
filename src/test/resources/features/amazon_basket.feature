Feature: This feature is to validate buyer interaction

  @registration
  Scenario: Verify student registration
    When I fill out the form for <free> or <paid> student
    # count can be max 5 students
      |free | 5 |
      |paid | 0 |
    Then I enter first name
#    Then I enter the middle initial
    Then I enter last name
    Then I enter date of birth
    Then I pick a school
    Then I pick a grade
    Then I enter address
    Then I enter parent name
    Then I enter parent email
    Then I enter parent phone
#    Then I click on add sibling
    Then I input the sibling information
    Then I click on contunue button
    Then I click on submit buuton



