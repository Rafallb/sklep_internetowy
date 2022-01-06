Feature: Create new address
  Scenario Outline: adding an address in the user form on https://mystore-testlab.coderslab.pl
    Given Landing page2 https://mystore-testlab.coderslab.pl opened in browser
    When Sign in button pressed2
    And Log in to your account2
    And clicks on the option Addresses
    And clicks on the option Create new address
    And  New address form filled out and save <alias>, <company>, <vatNumber>, <address>, <addressComplement>, <zipCode>, <city>, <country>, <phone>
    And save address data
    Then New account registered on https://mystore-testlab.coderslab.pl/index.php?controller=addresses website
    Examples:
      |alias|company              |vatNumber |address               |addressComplement      |zipCode|city   |country       |phone     |
      |alias| Phalange Corporation|257392877 |Central Perk Coffee   | Central Perk Coffee   | 07-481|New York|United Kingdom|879432760|