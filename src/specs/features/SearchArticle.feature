@searcharticles
Feature:Choose an item less than 10 euro
  As a user I want to search for articles

  Background:
    Given I connect to the AMAZON app
    When I click on the button indetifiez-vous
    And I type the e-mail address "raissi.zied0108@gmail.com" and password "raissizied"  then click on the start button.
    Then  I click on the button identify

  @search
  Scenario:Choose an item less than 10 euro
    When I click on the search field all our categories
    And click on the less than 10 euros "search-alias=under-ten-dollars"
    Then  check that the price of the items is less than
