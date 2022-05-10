package com.e2eTests.automatedTests.orderonamazon;

import com.e2eTests.automatedTests.utilis.BasePage;
import com.e2eTests.automatedTests.utilis.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class OrderOnAmazonPageObject extends BasePage {

    public OrderOnAmazonPageObject() throws IOException {
        PageFactory.initElements(driver, this);
    }


    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                                                       Locators
       -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    final static String SEARCHARTICLE = "#twotabsearchtextbox";
    final static String CLICKARTICLE = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'WD_BLACK SN850 1 To - SSD NVMe Gaming avec dissipa')]";
    final static String ClLICKOFFRES = "a[title='Voir toutes les offres']";
    final static String ADDTOCART = "span[id='a-autoid-2-offer-1'] input[name='submit.addToCart']";
    final static String CLICKCLOSE = "body > span:nth-child(2) > div:nth-child(1)";
    final static String CLICKCART = "#nav-cart-count";
    final static String VERIFYARTICLE = "//span[@class='a-truncate-cut']";
    final static String PLACEORDER = "input[value='Proceed to checkout']";
    final static String FULLNAME = "#address-ui-widgets-enterAddressFullName";
    final static String PHONENUMBER = "#address-ui-widgets-enterAddressPhoneNumber";
    final static String ENTERADDRESS = "#address-ui-widgets-enterAddressLine1";
    final static String ENTERPOSTALCODE = "#address-ui-widgets-enterAddressPostalCode";
    final static String ENTERADDRESSCITY = " #address-ui-widgets-enterAddressCity";
    final static String SUBMIT = " input[type='submit']";
    final static String CLICKSEARCH= "#nav-search-submit-button";
    final static String CONFIRMEARTICLE= "div#search>div>div>div>span:nth-of-type(3)>div:nth-of-type(2)>div:nth-of-type(3)>div>div>div>div>div>span>a>div";
    final static String VALIDETEARTICLE= "a[title='Voir toutes les offres']";


    @FindBy(how = How.CSS, using = SEARCHARTICLE)
    public static WebElement serachitem;
    @FindBy(how = How.CSS, using = CLICKSEARCH)
    public static WebElement clickserach;
    @FindBy(how = How.CSS, using = CLICKARTICLE)
    public static WebElement clickarticle;
    @FindBy(how = How.CSS, using = ClLICKOFFRES)
    public static WebElement clickoffres;
    @FindBy(how = How.CSS, using = ADDTOCART)
    public static WebElement addtocart;
    @FindBy(how = How.CSS, using = CLICKCLOSE)
    public static WebElement clickclose;
    @FindBy(how = How.CSS, using = CLICKCART)
    public static WebElement clickcart;
    @FindBy(how = How.XPATH, using = VERIFYARTICLE)
    public static WebElement verifyarticle;
    @FindBy(how = How.CSS, using = PLACEORDER)
    public static WebElement placeorder;
    @FindBy(how = How.CSS, using = FULLNAME)
    public static WebElement fullname;
    @FindBy(how = How.CSS, using = PHONENUMBER)
    public static WebElement phonenumber;
    @FindBy(how = How.CSS, using = ENTERADDRESS)
    public static WebElement enteradress;
    @FindBy(how = How.CSS, using = ENTERPOSTALCODE)
    public static WebElement entrepostalcode;
    @FindBy(how = How.CSS, using = ENTERADDRESSCITY)
    public static WebElement entreadresscity;
    @FindBy(how = How.CSS, using = SUBMIT)
    public static WebElement submit;
    @FindBy(how = How.CSS, using = CONFIRMEARTICLE)
    public static WebElement confirmearticle;
    @FindBy(how = How.CSS, using = VALIDETEARTICLE)
    public static WebElement validtearticle;


    public void serchArticle(String arg) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        serachitem.sendKeys(arg);
        clickserach.click();
        confirmearticle = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CONFIRMEARTICLE)));
        confirmearticle.click();
    }

    public void choseQuantity () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        validtearticle = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(VALIDETEARTICLE)));
        validtearticle.click();


    }
    public void waitForPageToLoad() {
        String pageLoadStatus;
        JavascriptExecutor js;

        do {
            js = (JavascriptExecutor) driver;
            pageLoadStatus = (String) js.executeScript("return document.readyState");
            Log.info(".");
        } while (!pageLoadStatus.equals("complete"));
       // Log.info(PageName + " page loaded successfully");
    }

    public void addToCart () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        addtocart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ADDTOCART)));
        addtocart.click();
        clickclose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CLICKCLOSE)));
        clickclose.click();
        clickcart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CLICKCART)));
        clickcart.click();

    }

    public void verifyarticule (WebElement verifyarticle, String text ) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        verifyarticle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VERIFYARTICLE)));
        String messageDeSuccès = OrderOnAmazonPageObject.verifyarticle.getText();
        Assert.assertTrue(messageDeSuccès.contains(text));

    }


    public void placeOrder (){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        placeorder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PLACEORDER)));
        placeorder.click();
    }

   public void addNewAddess (String arg, String arg2, String arg3, String arg5, String s) throws InterruptedException {
       WebDriverWait wait = new WebDriverWait(driver, 10);
       fullname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FULLNAME)));
       fullname.sendKeys(arg);
       phonenumber.sendKeys(arg2);
       enteradress.sendKeys(arg3);
       entrepostalcode.sendKeys(arg3);
       entreadresscity.sendKeys(arg5);

   }
   public void submitorder(){

        submit.click();
   }


}












