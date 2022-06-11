package tests.automationExCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class AutomationEx_13 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test13_Verify_Product_quantity_in_Cart() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test13_Verify_Product_quantity_in_Cart", "automationexercise.com UI testcase 13");
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
        extentTest.info("4. Click 'View Product' for any product on home page");
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        String firstItemName = Driver.getDriver().findElement(By.xpath("(//p[text()='Blue Top'])[1]")).getText();
        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", Driver.getDriver().findElement(By.xpath("//a[@href='/product_details/1']")));
        Driver.getDriver().findElement(By.xpath("//a[@href='/product_details/1']")).click();
        extentTest.info("5. Verify product detail is opened");
        automationExPage.oneProductPageProductInformationPanel.isDisplayed();
        extentTest.info("6. Increase quantity to 4");
        automationExPage.oneProductPageProductQuantity.sendKeys(Keys.DELETE);
        automationExPage.oneProductPageProductQuantity.sendKeys("4");
        extentTest.info("7. Click 'Add to cart' button");
        automationExPage.oneProductPageAddToCardButton.click();
        extentTest.info("8. Click 'View Cart' button");
        automationExPage.popUpViewCartButton.click();
        extentTest.info("9. Verify that product is displayed in cart page with exact quantity");
        Assert.assertEquals(firstItemName, Driver.getDriver().findElement(By.xpath("//a[text()='Blue Top']")).getText());
        Assert.assertEquals(automationExPage.cartPageQuantity.getText(),"4");
        extentTest.pass("Quantity funtion is works as expected!");
    }
}
