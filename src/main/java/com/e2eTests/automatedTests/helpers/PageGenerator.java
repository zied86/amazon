package com.e2eTests.automatedTests.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {

    public WebDriver driver;

    public PageGenerator(WebDriver driver){
        this.driver = driver;
    }

    public  <TPage extends BasePageHelper> TPage getPage (Class<TPage> pageClass) {
        try {
        	
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw e;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }
}
