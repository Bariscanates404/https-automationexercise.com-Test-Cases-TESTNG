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

public class AutomationEx_11 extends TestBaseRapor {

    AutomationExPage automationExPage;

    @Test
    public void test11_Verify_Subscription_in_chart_page() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test11_Verify_Subscription_in_chart_page", "automationexercise.com UI testcase 11");
        extentTest.info("1. Launch browser, 2. Navigate to url 'http://automationexercise.com");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extentTest.info("3. Verify that home page is visible successfully");
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/"));
        List<WebElement> mainPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : mainPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("4. Click 'Cart' button");
        automationExPage.mainPageCartButton.click();
        extentTest.info("5. Scroll down to footer");
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.cartPageSubscriptionText);
        extentTest.info("6. Verify text 'SUBSCRIPTION'");
        ReusableMethods.verifyURLorText(automationExPage.cartPageSubscriptionText.getText(),"SUBSCRIPTION");
        extentTest.info("7. Enter email address in input and click arrow button");
        automationExPage.cartPageSubscriptionInput.sendKeys(ConfigReader.getProperty("autExEmail"));
        automationExPage.cartPageSubscriptionArrowButton.click();
        extentTest.info("8. Verify success message 'You have been successfully subscribed!' is visible");
        ReusableMethods.verifyURLorText(automationExPage.cartPageSubscriptionSuccessAlert.getText(),"You have been successfully subscribed!");
        extentTest.pass("Cart page subscription panel works as expectedly!");

    }
}
