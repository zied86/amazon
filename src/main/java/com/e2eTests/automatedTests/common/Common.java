package com.e2eTests.automatedTests.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Common {

	public WebDriver driver;

	public void selectDropDownListByVisibleText(WebElement element, String text) {
		Select dropDownList = new Select(element);
		dropDownList.selectByVisibleText(text);
	}

	public void selectDropDownListByIndex(WebElement element, int index) {
		Select dropDownList = new Select(element);
		dropDownList.selectByIndex(index);
	}

	public void selectDropDownListByValue(WebElement element, String value) {
		Select dropDownList = new Select(element);
		dropDownList.selectByValue(value);
	}

	public Boolean isElementDisplayed(WebElement element) {
		Boolean isElementDisplayed = element.isDisplayed();
		return isElementDisplayed;
	}
	
	public boolean isElementPresent(String elementxpath) {
		
		int count = driver.findElements(By.xpath(elementxpath)).size();
		if(count == 0)
			return false;
		else
			return true;
	}

}