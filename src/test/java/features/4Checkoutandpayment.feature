Feature: Go to cart and proceed to check out and made Payment

  Scenario: To Test Checkout scenario
    Given Go to cart
    When Proceed with payment
    And Fill data in two steps
    Then Assert
