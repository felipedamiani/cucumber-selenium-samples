Feature: Loggin

  @runIt
  Scenario: Logging in the app
    Given I navigate to the login page http://localhost/myApp/login
    When I try to login with 'valid' credentials
    Then I should see the menu button

  @runIt
  Scenario: Logging in the app with the invalid user
    Given I navigate to the login page http://localhost/myApp/login
    When I try to login with 'invalid' credentials
    Then I should see a error message
