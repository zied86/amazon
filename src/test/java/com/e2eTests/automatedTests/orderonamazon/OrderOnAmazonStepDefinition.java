package com.e2eTests.automatedTests.orderonamazon;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;


public class OrderOnAmazonStepDefinition {


    private OrderOnAmazonPageObject amazon;

    public OrderOnAmazonStepDefinition() throws IOException {
        this.amazon = new OrderOnAmazonPageObject();
    }


    @When("^Search for an item\"([^\"]*)\"$")
    public void searchForAnItem(String arg1) throws Throwable {
        amazon.serchArticle(arg1);
    }

    @When("^choose the quantity of the item$")
    public void chooseTheQuantityOfTheItem() throws Throwable {
        amazon.choseQuantity();
    }

    @When("^Add item to cart$")
    public void addItemToCart() throws Throwable {
        amazon.addToCart();
    }

    @When("^Check Cart \"([^\"]*)\"$")
    public void checkCart(String arg1) throws Throwable {
        amazon.verifyarticule(OrderOnAmazonPageObject.verifyarticle, arg1);

    }

    @When("^Place the order on site$")
    public void placeTheOrderOnSite() throws Throwable {
        amazon.placeOrder();
    }

    @When("^Add full name \"([^\"]*)\"Add phone number\"([^\"]*)\"add address\"([^\"]*)\" and Postal code\"([^\"]*)\" and city\"([^\"]*)\"\"$")
    public void addFullNameAddPhoneNumberAddAddressAndPostalCodeAndCity(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        amazon.addNewAddess(arg1, arg2, arg3, arg4, arg5);

    }

    @Then("^use this address$")
    public void useThisAddress() throws Throwable {
        amazon.submitorder();
    }


}
