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

public class AutomationEx_12 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test12_Add_Products_In_Cart() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test12_Add_Products_In_Cart", "automationexercise.com UI testcase 12");
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
        extentTest.info("4. Click on 'Products' button");
        automationExPage.mainPageProductsButonu.click();
        extentTest.info("5. Hover over first product and click 'Add to cart'");
        String firstItemName = Driver.getDriver().findElement(By.xpath("(//p[text()='Blue Top'])[1]")).getText();
        String secondItemName = Driver.getDriver().findElement(By.xpath("(//p[text()='Men Tshirt'])[1]")).getText();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.productPageAddtoCartFirstItem);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[1]"))).perform();
        actions.moveToElement(automationExPage.productPageAddtoCartFirstItem).click().perform();
        extentTest.info("6. Click 'Continue Shopping' button");
        automationExPage.productPageContinueShoppingButton.click();
        extentTest.info("7. Hover over second product and click 'Add to cart'");
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.productPageAddtoCartFirstItem);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[2]"))).perform();
        actions.moveToElement(automationExPage.productPageAddtoCartSecondItem).click().perform();
        extentTest.info("8. Click 'View Cart' button");
        automationExPage.productPageViewCartButton.click();
        extentTest.info("9. Verify both products are added to Cart");
        Assert.assertEquals(firstItemName, Driver.getDriver().findElement(By.xpath("//a[text()='Blue Top']")).getText());
        Assert.assertEquals(secondItemName, Driver.getDriver().findElement(By.xpath("//a[text()='Men Tshirt']")).getText());
        extentTest.info("10. Verify their prices, quantity and total price");
        String firstItemPrice = Driver.getDriver().findElement(By.cssSelector("tr[id='product-1'] td[class='cart_price'] p")).getText();
        String firstItemquantity = Driver.getDriver().findElement(By.cssSelector("tr[id='product-1'] button[class='disabled']")).getText();
        String firstItemtotal = Driver.getDriver().findElement(By.cssSelector("tr[id='product-1'] p[class='cart_total_price']")).getText();
        String secondItemPrice = Driver.getDriver().findElement(By.cssSelector("tr[id='product-2'] td[class='cart_price'] p")).getText();
        String secondItemquantity = Driver.getDriver().findElement(By.cssSelector("tr[id='product-2'] button[class='disabled']")).getText();
        String secondItemtotal = Driver.getDriver().findElement(By.cssSelector("tr[id='product-2'] p[class='cart_total_price']")).getText();

        Assert.assertEquals(firstItemPrice, "Rs. 500");
        Assert.assertEquals(firstItemquantity, "1");
        Assert.assertEquals(firstItemtotal, "Rs. 500");

        Assert.assertEquals(secondItemPrice, "Rs. 400");
        Assert.assertEquals(secondItemquantity, "1");
        Assert.assertEquals(secondItemtotal, "Rs. 400");

        extentTest.pass("Add products in cart works as expectedly!");

    }
}
