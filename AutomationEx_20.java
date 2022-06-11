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

public class AutomationEx_20 extends TestBaseRapor {
    AutomationExPage automationExPage;
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test20_Search_Products_and_Verify_Cart_After_Login() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test20_Search_Products_and_Verify_Cart_After_Login", "automationexercise.com UI testcase 20");
        extentTest.info("1. Launch browser and Navigate to url 'http://automationexercise.com , 2. Verify that home page is visible successfully");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/"));
        List<WebElement> mainPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : mainPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("3. Click on 'Products' button");
        automationExPage.mainPageProductsButonu.click();
        extentTest.info("4. Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/products"));
        extentTest.info("5. Enter product name in search input and click search button");
        String productName = "saree";
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(automationExPage.productPageSearchPanel).click().perform();
        actions.sendKeys(productName).moveToElement(Driver.getDriver().findElement(By.cssSelector(".fa.fa-search"))).click().perform();
        extentTest.info("6. Verify 'SEARCHED PRODUCTS' is visible");
        Assert.assertTrue(ReusableMethods.verifyURLorText(automationExPage.productPageTopTitleText.getText(), "SEARCHED PRODUCTS"));
        extentTest.info("7. Verify all the products related to search are visible");
        List<WebElement> allSearchResults = Driver.getDriver().findElements(By.cssSelector(".product-overlay"));
        for (WebElement items : allSearchResults
        ) {
            items.isDisplayed();
        }
        extentTest.info("8. Add those products to cart");
        js.executeScript("arguments[0].scrollIntoView();", Driver.getDriver().findElement(By.xpath("(//a[@data-product-id='39'])[1]")));
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[1]"))).perform();
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@data-product-id='39'])[1]"))).click().perform();
        automationExPage.popUpContinueShoppingButton.click();
        Thread.sleep(500);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[2]"))).perform();
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@data-product-id='40'])[1]"))).click().perform();
        automationExPage.popUpContinueShoppingButton.click();
        Thread.sleep(500);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[3]"))).perform();
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@data-product-id='41'])[1]"))).click().perform();
        automationExPage.popUpContinueShoppingButton.click();
        extentTest.info("9. Click 'Cart' button and verify that products are visible in cart");
        automationExPage.mainPageCartButton.click();
        Driver.getDriver().findElement(By.cssSelector("tr[id='product-39']")).isDisplayed();
        Driver.getDriver().findElement(By.cssSelector("tr[id='product-40']")).isDisplayed();
        Driver.getDriver().findElement(By.cssSelector("tr[id='product-41']")).isDisplayed();
        extentTest.info("10. Click 'Signup / Login' button and submit login details");
        automationExPage.mainPageloginSingupButonu.click();
        automationExPage.loginUserEmail.sendKeys(ConfigReader.getProperty("autExEmail"));
        automationExPage.loginUserPassword.sendKeys(ConfigReader.getProperty("autExValidPassword"));
        automationExPage.loginUserButton.click();
        extentTest.info("11. Again, go to Cart page");
        automationExPage.mainPageCartButton.click();
        extentTest.info("12. Verify that those products are visible in cart after login as well");
        Driver.getDriver().findElement(By.cssSelector("tr[id='product-39']")).isDisplayed();
        Driver.getDriver().findElement(By.cssSelector("tr[id='product-40']")).isDisplayed();
        Driver.getDriver().findElement(By.cssSelector("tr[id='product-41']")).isDisplayed();
        extentTest.pass("Search product add to cart and verify cart after login functions are working as expectedly!");
    }
}
