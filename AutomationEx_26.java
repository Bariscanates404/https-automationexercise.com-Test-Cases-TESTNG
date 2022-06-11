package tests.automationExCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.List;

public class AutomationEx_26 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test26_Verify_Scroll_Up_without_Arrow_button_and_Scroll_Down_functionality() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test26_Verify_Scroll_Up_without_Arrow_button_and_Scroll_Down_functionality", "automationexercise.com UI testcase 26");
        extentTest.info("1. Launch browser, 2. Navigate to url 'http://automationexercise.com");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extentTest.info("3. Verify that home page is visible successfully");
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://automationexercise.com/";
        Assert.assertEquals(actualURL, expectedURL);
        List<WebElement> mainPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : mainPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("4. Scroll to bottom of page");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.mainPageRecommendedItemsList);
        extentTest.info("5. Verify 'SUBSCRIPTION' is visible");
        automationExPage.cartPageSubscriptionText.isDisplayed();
        extentTest.info("6. Scroll up page to top");
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.mainPageCartButton);
        extentTest.info("7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        List<WebElement> fullFledged=Driver.getDriver().findElements(By.cssSelector(" div.col-sm-6 h2"));
        int counter=0;
        for (WebElement element : fullFledged) {
            try {
                if (element.isDisplayed()){
                    counter++;
                }
            } catch (Exception e) {
                System.out.println("Can't find product!");
            }
        }
        Assert.assertTrue(counter>=1);
        extentTest.pass("Scroll down, scroll up, angle up arrow funtions are works as expectedly!");
    }
}
