Feature: Validating SauceDemo website

  Scenario: Validating Login, Add to cart functionality before and after adding product, logout
     Given User launches website
     When User login and validates login
     And User adds products to cart and validate the cart
     And User removes two items and re-validates the cart
     When User Checks out and validate the checkout
     Then user logout and validate logout
     