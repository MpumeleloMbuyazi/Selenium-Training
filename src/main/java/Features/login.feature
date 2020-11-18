Feature: Login

  Scenario: Login facebook scenario

    Given User is on Facebook login page
    When Application page tittle is Facebook
    Then User enters UserName and Password
    And User clicks on Login button
    Then User should access their account
