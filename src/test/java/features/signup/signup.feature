#Feature: Talentek Sign up feature test suite
#
#  @signup @regression @smoke @prod
#  Scenario: User should be able to sign up with valid email address
#    Given I am at talenttek Home Page
#    And I click on  Create New Account button
#    And I enter student first name, last name, valid email address, password and confirm password
#    And I enter student birth month, date and year
#    And I enter student gender as female
#    And I agree with the terms and data use policy
#    When I click on the Create my account
#    Then I should be able to get the student id
#
#  @signup @regression
#  Scenario: User should not be able to sign up with invalid email address
#    Given I am at talenttek Home Page
#    And I click on  Create New Account button
#    And I enter student information with invalid email address
#    And I enter student birth month, date and year
#    And I enter student gender as male
#    And I agree with the terms and data use policy
#    When I click on the Create my account
#    Then I should get an invalid email address error message
#
#  @signuptest
#  Scenario: User should be able to sign up with valid email address and sign in using the newly created studentID
#    Given I am at talenttek Home Page
#    And I click on  Create New Account button
#    And I enter student first name, last name, valid email address, password and confirm password
#    And I enter student birth month, date and year
#    And I enter student gender as female
#    And I agree with the terms and data use policy
#    And I click on the Create my account
#    And I should be able to get the student id
#    And I click on the Login link from taltek website
#    When I enter studentID and password
#    Then I should be able successfully to sign in
