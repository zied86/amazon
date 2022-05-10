package com.e2eTests.automatedTests.addaccount;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

public class AddAcountStepDefinition {


    private AddAccountPageObject amazon;

    public AddAcountStepDefinition() throws IOException {
        this.amazon = new AddAccountPageObject();
    }


    @When("^I click on the button indetifiez-vous$")
    public void iClickOnTheButtonIndetifiezVous() throws Throwable {
        amazon.identifierUser();
    }

    @When("^I type the e-mail address \"([^\"]*)\" and password \"([^\"]*)\"  then click on the start button\\.$")
    public void iTypeTheEMailAddressAndPasswordThenClickOnTheStartButton(String arg1, String arg2) throws Throwable {
        amazon.addUserEmail(arg1,arg2);
    }

    @Then("^I click on the button identify$")
    public void iClickOnTheButtonIdentify() throws Throwable {

    }


}
