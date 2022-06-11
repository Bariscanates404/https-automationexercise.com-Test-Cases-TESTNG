package tests.automationExCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.List;

public class AutomationEx_07 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test02_Verify_Testcases_Page() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test07_Verify_Testcases_Page", "automationexercise.com UI testcase 7");
        extentTest.info("1. Launch browser, 2. Navigate to url 'http://automationexercise.com");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        ReusableMethods.waitForPageToLoad(10);
        extentTest.info("3. Verify that home page is visible successfully");
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/"));
        List<WebElement> mainPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : mainPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("4. Click on 'Test Cases' button");
        List<WebElement> mainPageTestCasesButtons = Driver.getDriver().findElements(By.xpath("//button[text()='Test Cases']"));
        for (WebElement button : mainPageTestCasesButtons) {
            try
            {
                if(button.isDisplayed())
                {
                    button.click();
                }
            }
            catch(Exception e){}
        }
        extentTest.info("5. Verify user is navigated to test cases page successfully");
        String actualTestCasesURL = Driver.getDriver().getCurrentUrl();
        String expectedTestCasesURL = "https://automationexercise.com/test_cases";
        Assert.assertEquals(actualTestCasesURL, expectedTestCasesURL);
        extentTest.pass("Test cases button working expectedly!");
    }
}
