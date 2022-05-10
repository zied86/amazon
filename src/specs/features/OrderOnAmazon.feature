@orderonAmazon
Feature:place an order on Amazon
  As a user I want to place an order on Amazon

  Background:
    Given I connect to the AMAZON app
    When I click on the button indetifiez-vous
    And I type the e-mail address "raissi.zied0108@gmail.com" and password "raissizied"  then click on the start button.
    Then  I click on the button identify

  @OrderAmazon
  Scenario:test adding an order on Amazon
    When Search for an item"WD_BLACK SN850 1 To - SSD NVMe Gaming avec dissipateur thermique "
    And choose the quantity of the item
    And Add item to cart
    And  Check Cart "WD_BLACK SN850 1 To - SSD NVMe Gaming avec dissipateur thermique – Fonctionne avec PS5; M.2 2280; "
    And Place the order on site
    And  Add full name "Zied RAISSI"Add phone number"+33623454560"add address"16rue de larbre sec" and Postal code"91250" and city"paris""
    Then use this address

