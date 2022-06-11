package tests.automationExCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class AutomationEx_25 extends TestBaseRapor {
    AutomationExPage automationExPage;
    @Test
    public void test25_Verify_Scroll_Up_using_Arrow_button_and_Scroll_Down_functionality() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test25_Verify_Scroll_Up_using_Arrow_button_and_Scroll_Down_functionality", "automationexercise.com UI testcase 25");
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
        extentTest.info("4. Scroll to bottom of page");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.mainPageRecommendedItemsList);
        extentTest.info("5. Verify 'SUBSCRIPTION' is visible");
        automationExPage.cartPageSubscriptionText.isDisplayed();
        extentTest.info("6. Click on arrow at bottom right side to move upward");
        automationExPage.mainPageArrowUptoAngleUp.click();
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
        System.out.println(counter);
        Assert.assertTrue(counter>=1);
        extentTest.pass("Scroll down, scroll up, angle up arrow funtions are works as expectedly!");
    }
}
