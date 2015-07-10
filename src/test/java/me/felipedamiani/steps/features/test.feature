Feature: Test

  @runIt
  Scenario: Test type a value in a element by selector
    Given I navigate to the login page http://localhost/myApp/login
    When I type in input#key the value 669

  @runIt
  Scenario: Test a click on a element
    Given I navigate to the login page http://localhost/myApp/login
    When I click on login
    
  @runIt
  Scenario: Test log in using datatables
    Given I navigate to the login page http://localhost/myApp/login
    When I set the following values in the form
        | #key  | 1 |
        | #user | 1 |
        | #pwd | 1 |
    And I click on login
    Then I should see the menu button