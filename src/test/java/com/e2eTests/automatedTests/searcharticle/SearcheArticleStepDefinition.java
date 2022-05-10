package com.e2eTests.automatedTests.searcharticle;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class SearcheArticleStepDefinition {

    private SearcheArticlePageObject amazon;

    public SearcheArticleStepDefinition() throws IOException {
        this.amazon = new SearcheArticlePageObject();
    }






    @When("^I click on the search field all our categories$")
    public void iClickOnTheSearchFieldAllOurCategories() throws Throwable {
      amazon.SearchArticle();
    }

    @When("^click on the less than (\\d+) euros \"([^\"]*)\"$")
    public void clickOnTheLessThanEuros(int arg1, String arg2) throws Throwable {
     amazon.selectDropDownListByValue(SearcheArticlePageObject.productlist,arg2);

    }

    @Then("^check that the price of the items is less than$")
    public void checkThatThePriceOfTheItemsIsLessThan£() throws Throwable {
          amazon.verifyAmountsDisplayed(String.valueOf(SearcheArticlePageObject.amounts));
    }





}
