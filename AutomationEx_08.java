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

public class AutomationEx_08 extends TestBaseRapor {

    AutomationExPage automationExPage;

    @Test
    public void test08_Verify_All_Products_product_detail_page() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test08_Verify_All_Products_product_detail_page", "automationexercise.com UI testcase 8");
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
        extentTest.info("4. Click on 'Products' button");
        automationExPage.mainPageProductsButonu.click();
        extentTest.info("5. Verify user is navigated to ALL PRODUCTS page successfully");
        String actualProductPageUrl = Driver.getDriver().getCurrentUrl();
        String expeptedProductPageUrl = "https://automationexercise.com/products";
        Assert.assertEquals(actualProductPageUrl, expeptedProductPageUrl);
        extentTest.info("6. The products list is visible");
        List<WebElement> Products = Driver.getDriver().findElements(By.xpath("//div[@class='product-overlay']"));
        for (WebElement element : Products) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("7. Click on 'View Product' of first product");
        Driver.getDriver().findElement(By.xpath("//a[@href='/product_details/1']")).click();
        extentTest.info("8. User is landed to product detail page");
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/product_details/1"));
        extentTest.info("9. Verify that detail detail is visible: product name, category, price, availability, condition, brand");
        automationExPage.oneProductPageProductName.isDisplayed();
        automationExPage.oneProductPageProductCategory.isDisplayed();
        automationExPage.oneProductPageProductPrice.isDisplayed();
        automationExPage.oneProductPageProductPrice.isDisplayed();
        automationExPage.oneProductPageProductAvalibility.isDisplayed();
        automationExPage.oneProductPageProductCondition.isDisplayed();
        automationExPage.oneProductPageProductBrand.isDisplayed();

        extentTest.pass("All products page and product details page works as expectedly!");
    }
}
