package tests.automationExCases;

import org.openqa.selenium.By;
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

public class AutomationEx_09 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test09_Search_Product() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test09_Search_Product", "automationexercise.com UI testcase 9");
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
        extentTest.info("5. Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/products"));
        extentTest.info("6. Enter product name in search input and click search button");
        String productName = "Blue Top";
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(automationExPage.productPageSearchPanel).click().perform();
        actions.sendKeys(productName).moveToElement(Driver.getDriver().findElement(By.cssSelector(".fa.fa-search"))).click().perform();
        extentTest.info("7. Verify 'SEARCHED PRODUCTS' is visible");
        Assert.assertTrue(ReusableMethods.verifyURLorText(automationExPage.productPageTopTitleText.getText(),"SEARCHED PRODUCTS"));
        extentTest.info("8. Verify all the products related to search are visible");
        List<WebElement> allSearchResults = Driver.getDriver().findElements(By.cssSelector(".product-overlay"));
        for (WebElement items : allSearchResults
        ) {
            items.isDisplayed();
        }
        extentTest.pass("For search product all fonctions are working as expectedly!");
    }
}
