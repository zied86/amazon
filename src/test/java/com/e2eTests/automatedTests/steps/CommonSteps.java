package com.e2eTests.automatedTests.steps;

import cucumber.api.java.en.Given;

import java.io.FileInputStream;
import java.util.Properties;

import static com.e2eTests.automatedTests.utilis.Setup.driver;

public class CommonSteps {
	
	private static final String HOME_PAGE_URL = "";
	public static Properties prop;

	@Given("^I connect to the AMAZON app$")
	public void IConnectToTheAMAZONApp() throws Throwable {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/profiles/recette/profile.properties");
		prop.load(fis);
		System.out.print(prop);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}
	}

