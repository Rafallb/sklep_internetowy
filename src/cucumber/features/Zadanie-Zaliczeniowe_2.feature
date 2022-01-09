Feature: buy product
  Scenario: buy stuff on https://mystore-testlab.coderslab.pl
    Given Landing page3 https://mystore-testlab.coderslab.pl opened in browser
    When Sign in button pressed3
    And Log in to your account3
    And select to purchase Hummingbird Printed Sweater
    And chose size and take 5 thinks
    And add to cart
    And confirm address
    And select a pickup method pick up in store
    And select payment options Pay by Check
    And click order with an obligation to pay
    And Take screenshot
    And check money status
    And check payment status