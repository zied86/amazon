@addaccountamazon
Feature: Add an account on AMAZON
  As a user I would like to test adding an account to the AMAZON site

  Background:
    Given I connect to the AMAZON app


  @Ajout
  Scenario:Test adding an AMAZON account
    When I click on the button indetifiez-vous
    And I type the e-mail address "raissi.zied0108@gmail.com" and password "raissizied"  then click on the start button.
    Then  I click on the button identify
