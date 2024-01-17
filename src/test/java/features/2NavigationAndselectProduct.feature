Feature: Navigate to hot seller

  Scenario: To navigate to hot seller products
    Given User write in search bar hot seller
    When hot seller items appears
    Then select products to compare
