Feature: compare products

  Scenario: To select product from comparison
    Given From two products select second one
    When add second one to the cart
    Then Product added to cart successfully