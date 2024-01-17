Feature: Create New Account

  Scenario: Create new user with valid data
    Given User open website and goto create new account page
    When User insert all correct data in fields
    Then New account created successfully
