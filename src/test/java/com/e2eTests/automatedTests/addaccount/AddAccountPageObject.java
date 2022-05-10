package com.e2eTests.automatedTests.addaccount;

import com.e2eTests.automatedTests.utilis.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AddAccountPageObject extends BasePage {

    public AddAccountPageObject() throws IOException {
        PageFactory.initElements(driver, this);

    }


    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                                                       Locators
       -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    final static String LOGIN = "//div[@id='nav-signin-tooltip']//span[@class='nav-action-inner'][normalize-space()='Identifiez-vous']";
    final static String PASSWORD = "ap_password";
    final static String COOKIES = "//input[@id='sp-cc-accept']";
    final static String ADRESSE_MAIL = "#ap_email";
    final static String CONTINUIER = "input#continue";
    final static String SIGNINSUBMIT = "#signInSubmit";
    final static String SEARCH = "#searchDropdownBox";



    @FindBy(how = How.XPATH, using = LOGIN)
    public static WebElement login;
    @FindBy(how = How.ID, using = PASSWORD)
    public static WebElement password;
    @FindBy(how = How.XPATH, using = COOKIES)
    public static WebElement clickcookies;
    @FindBy(how = How.CSS, using = ADRESSE_MAIL)
    public static WebElement adressemail;
    @FindBy(how = How.CSS, using = CONTINUIER)
    public static WebElement continuer;
    @FindBy(how = How.CSS, using = SIGNINSUBMIT)
    public static WebElement signinsubmit;
    @FindBy(how = How.CSS, using = SEARCH)
    public static WebElement search;


    public void identifierUser() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        clickcookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(COOKIES)));
        login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGIN)));
        clickcookies.click();
        login.click();

    }

    public void selectDropDownListByValue(WebElement item, String value) throws InterruptedException {
        Select dropDownList = new Select(item);
        dropDownList.selectByValue(value);
    }

    public void addUserEmail(String mail , String arg2) throws InterruptedException {
        adressemail.sendKeys(mail);
        continuer.click();
        password.sendKeys(arg2);
        signinsubmit.click();
        search.click();



    }

}






