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

import java.util.List;

public class AutomationEx_22 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test22_Add_to_cart_from_Recommended_items() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test22_Add_to_cart_from_Recommended_items", "automationexercise.com UI testcase 22");
        extentTest.info("1. Launch browser and Navigate to url 'http://automationexercise.com , 2. Verify that home page is visible successfully");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        ReusableMethods.waitForPageToLoad(2500);
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/"));
        List<WebElement> mainPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : mainPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("3. Scroll to bottom of page");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.mainPageRecommendedItemsList);
        extentTest.info("4. Verify 'RECOMMENDED ITEMS' are visible");
        automationExPage.mainPageRecommendedItemsList.isDisplayed();
        extentTest.info("5. Click on 'Add To Cart' on Recommended product");
        String arrProductNames[] = new String[6];
        if (Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='1']")).isDisplayed()) {
            Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='1']")).click();
            Thread.sleep(100);
            automationExPage.popUpContinueShoppingButton.click();
        }
        if (Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='2']")).isDisplayed()) {
            Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='2']")).click();
            Thread.sleep(100);
            automationExPage.popUpContinueShoppingButton.click();
        }
        if (Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='3']")).isDisplayed()) {
            Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='3']")).click();
            Thread.sleep(100);
            automationExPage.popUpContinueShoppingButton.click();
        }
        if (Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='4']")).isDisplayed()) {
            Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='4']")).click();
            Thread.sleep(100);
            automationExPage.popUpContinueShoppingButton.click();
        }
        if (Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='5']")).isDisplayed()) {
            Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='5']")).click();
            Thread.sleep(100);
            automationExPage.popUpContinueShoppingButton.click();
        }
        if (Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='6']")).isDisplayed()) {
            Driver.getDriver().findElement(By.cssSelector("div.carousel-inner a[data-product-id='6']")).click();
            Thread.sleep(100);
            automationExPage.popUpContinueShoppingButton.click();
        }
        List<WebElement> recommendedProductnames = Driver.getDriver().findElements(By.cssSelector("div.carousel.slide div.single-products p"));
        for (WebElement element : recommendedProductnames) {
            try {
                int counter = 0;
                arrProductNames[counter] = element.getText();
            } catch (Exception e) {
                System.out.println("Can't find product!");
            }
        }
        extentTest.info("6. Click on 'View Cart' button");
        automationExPage.mainPageCartButton.click();
        extentTest.info("7. Verify that products are displayed in cart page");
        List<WebElement> cartListElements = Driver.getDriver().findElements(By.cssSelector("tbody tr h4 a"));
        Assert.assertTrue(ReusableMethods.cartProductVerification(arrProductNames, cartListElements));
        extentTest.pass("Add to cart recommended items and verify are they visible in cart functions are works as expectedly!");
    }
}
