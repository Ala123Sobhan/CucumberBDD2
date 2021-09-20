Feature: Captcha Automation

  @captcha
  Scenario: User should be able to input captcha text
    Given I am at "https://sso.us.lg.com/oauth/page/login?authorizeKey=74d577bc-8924-4856-a41d-14283c61d1c0"
    And I understand the captcha text
    When I input the the captcha in the captcha input box
#    Then I should be able to get done with captcha verification