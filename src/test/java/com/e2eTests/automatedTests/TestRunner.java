package com.e2eTests.automatedTests;

import com.cucumber.listener.Reporter;
import com.e2eTests.automatedTests.utilis.Log;
import com.e2eTests.automatedTests.utilis.Setup;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.e2eTests.automatedTests.utilis.Setup.driver;



@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/specs/features"},
        strict = false,
        plugin = {"pretty", "json:target/cucumber_json_reports/cucumber.json", "html:target/cucumber-report", "com.cucumber.listener.ExtentCucumberFormatter:target/extent-reports/ExtentReport.html"},
        snippets = SnippetType.CAMELCASE,
        tags = ("@addaccountamazon,@addaccountamazon,@orderonAmazon"))

public class TestRunner {

    private Log log;

    @AfterClass
    public static void writeExtentReport() {

        Reporter.loadXMLConfig(new File("src/test/resources/configs/extent-config.xml"));

    }
    public void tearDown(Scenario scenario) throws IOException {
        File file;
        if (scenario.isFailed()) {
            String screenshotPath = System.getProperty("user.dir") + "\\target\\screenshots\\"+scenario.getName()+"\\";
            file = new File(screenshotPath);
            file.mkdir();
            try {
                final File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(screenshotPath+"screenshot.png"));

            } catch (final Exception e) {
                e.printStackTrace();
            }
            String failedScreenShot = screenshotPath+"screenshot.png";
            String url = "<img src="+failedScreenShot+" alt='failed screenshot'>";
            scenario.embed(url.getBytes(),failedScreenShot);
        }
    }
    /*  public class TearDown {

          /* Constant : log. /
          public static final Logger log = LogManager.getLogger();

          /**
           * This method is used to close browser.
           * This method is called after the invocation of each test method in given class.
           * @After Methods annotated with @After execute after every scenario.
           */
   /* public void quitDriver(Scenario scenario) {

        {

            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) Setup.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            }

            log.info("Goodbye!");
            Setup.driver.quit();
        }
    }*/
}