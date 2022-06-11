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

public class AutomationEx_17 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test17_Remove_Products_From_Cart() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test17_Remove_Products_From_Cart", "automationexercise.com UI testcase 17");
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
        extentTest.info("4. Add products to cart");
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.productPageAddtoCartFirstItem);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[1]"))).perform();
        actions.moveToElement(automationExPage.productPageAddtoCartFirstItem).click().perform();
        automationExPage.popUpContinueShoppingButton.click();
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[2]"))).perform();
        actions.moveToElement(automationExPage.productPageAddtoCartSecondItem).click().perform();
        automationExPage.popUpContinueShoppingButton.click();
        extentTest.info("5. Click 'Cart' button");
        automationExPage.mainPageCartButton.click();
        extentTest.info("6. Verify that cart page is displayed");
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/view_cart"));
        extentTest.info("7. Click 'X' button corresponding to particular product");
        String firstProduct = automationExPage.cartPageProduct1.getText();
        automationExPage.cartPageDeleteButton1.click();
        extentTest.info("8. Verify that product is removed from the cart");
        Assert.assertTrue(ReusableMethods.verifyURLorText(firstProduct, automationExPage.cartPageProduct1.getText()));
        extentTest.pass("Remove products on cart function is works as espectedly!");
    }
}
