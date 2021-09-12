Feature: Talentek Sign up feature test suite

  @signup @regression @smoke @prod
  Scenario: User should be able to sign up with valid email address
    Given I am at talenttek Home Page
    And I click on  Create New Account button
    And I enter student first name, last name, valid email address, password and confirm password
    And I enter student birth month, date and year
#    And I enter student gender as female
#    And I agree with the terms and data use policy
#    When I click on the Create my account
#    Then I should be able to get the student id

#    @signup @regression
#  Scenario: User should not be able to sign up with invalid email address
#    Given I am at talentTEK Home Page
#    And I click on Create New Account button
#    And I enter student information with invalid email address
#    And I enter student dob
#    And I enter student gender as male
#    And I agree with from
#    When I click Create My Account button
#    Then I should not be able to get an student Id