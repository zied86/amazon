package com.e2eTests.automatedTests.searcharticle;

import com.e2eTests.automatedTests.utilis.AmountException;
import com.e2eTests.automatedTests.utilis.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class SearcheArticlePageObject extends BasePage {

    private Object e;

    public SearcheArticlePageObject() throws IOException {
        PageFactory.initElements(driver, this);

    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                                                    Locators
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    final static String SEARCHARTICLE = "#searchDropdownBox";
    final static String PRDUCTLIST = "#searchDropdownBox > option:nth-child(36)";
    final static String AMOUNTS = "//*[@class='a-price-whole']";
    final static String AMOUNTS10£ = "nav-search-label-id";
    final static String CLICKSEARCH = "//input[@id='nav-search-submit-button']";
    final static String ALLRESULTS = ".a-size-medium.a-color-link.a-text-bold";
    final static String ARTICLE = "//*[@class='a-size-base-plus a-color-base a-text-normal']";

    @FindBy(how = How.CSS, using = SEARCHARTICLE)
    public static WebElement searcharticle;
    @FindBy(how = How.CSS, using = PRDUCTLIST)
    public static WebElement productlist;
    @FindBy(how = How.XPATH, using = AMOUNTS)
    public static List<WebElement> amounts;

    @FindBy(how = How.XPATH, using = CLICKSEARCH)
    public static WebElement clicksearch;
    @FindBy(how = How.CSS, using = ALLRESULTS)
    public static WebElement allresults;
    @FindBy(how = How.XPATH, using = ARTICLE)
    public static List<WebElement> article;

    public void SearchArticle() throws InterruptedException {
        searcharticle.click();
    }

    public void selectDropDownListByValue(WebElement product, String value) throws InterruptedException {

        Select dropDownList = new Select(searcharticle);
        System.out.println(productlist.getText());
        dropDownList.selectByValue(value);
        clicksearch.click();
        Thread.sleep(3000);
    }

    public void verifyAmountsDisplayed(String arg1) throws AmountException {

        WebElement q;
        WebElement p;
       // allresults.click();
          System.out.println(amounts.size());
        System.out.println(article.size());
         int j =0;
            for (int i = 0; i < article.size(); i++) {
                    q = article.get(i);
                    if(j< amounts.size()) {
                        p = amounts.get(j);
                        double xValue = 10.00;
                        double pValue = Double.parseDouble(p.getText().replace(",", "."));
                        if (pValue > xValue) {
                            System.out.println(q.getText());
                            System.out.println(p.getText());
                            throw new AmountException("Amount grate then 10.00");


                        }
                    }
                    j++;
                }


            }
        }










