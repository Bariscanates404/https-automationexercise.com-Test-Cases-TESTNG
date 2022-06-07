package tests.automationExCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.List;

public class AutomationEx_10 extends TestBaseRapor {

    AutomationExPage automationExPage;
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test10_Verify_Subscription_in_home_page() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test10_Verify_Subscription_in_home_page", "automationexercise.com UI testcase 10");
        extentTest.info("1. Launch browser, 2. Navigate to url 'http://automationexercise.com");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extentTest.info("3. Verify that home page is visible successfully");
        Assert.assertTrue(ReusableMethods.verifyURL(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/"));
        List<WebElement> mainPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : mainPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("4. Scroll down to footer");
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.mainPageSubscriptionText);
        extentTest.info("5. Verify text 'SUBSCRIPTION'");
        Assert.assertTrue(ReusableMethods.verifyURL(automationExPage.mainPageSubscriptionText.getText(),"SUBSCRIPTION"));
        extentTest.info("6. Enter email address in input and click arrow button");
        automationExPage.mainPageSubscriptionInput.sendKeys(ConfigReader.getProperty("autExEmail"));
        automationExPage.mainPageSubscriptionArrowButton.click();
        extentTest.info("7. Verify success message 'You have been successfully subscribed!' is visible");
        automationExPage.mainPageSubscriptionSuccessAlert.isDisplayed();
        extentTest.pass("Subscription panel works as expected!");
    }
}
