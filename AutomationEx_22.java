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

public class AutomationEx_22 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test22_Add_to_cart_from_Recommended_items() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test22_Add_to_cart_from_Recommended_items", "automationexercise.com UI testcase 22");
        extentTest.info("1. Launch browser and Navigate to url 'http://automationexercise.com , 2. Verify that home page is visible successfully");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/"));
        List<WebElement> mainPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : mainPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("3. Scroll to bottom of page");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.mainPageRecommendedItemsList);
        extentTest.info("4. Verify 'RECOMMENDED ITEMS' are visible");
        automationExPage.mainPageRecommendedItemsList.isDisplayed();
        extentTest.info("5. Click on 'Add To Cart' on Recommended product");
        List<WebElement> mainPageRecommendedItem = Driver.getDriver().findElements(By.cssSelector("div.carousel.slide div.single-products a"));
        String arrProductNames[] = new String[6];
        for (WebElement element : mainPageRecommendedItem) {
            try {
                element.isDisplayed();
                element.isEnabled();
                element.click();
                automationExPage.popUpContinueShoppingButton.click();
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Can't find product!");
            }
        }
        List<WebElement> recommendedProductnames = Driver.getDriver().findElements(By.cssSelector("div.carousel.slide div.single-products p"));
        for (WebElement element : recommendedProductnames) {
            try {
                int counter = 0;
                arrProductNames[counter] = element.getText();
                Thread.sleep(100);
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
