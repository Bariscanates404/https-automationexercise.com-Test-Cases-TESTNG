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

public class AutomationEx_19 extends TestBaseRapor {
    JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
    AutomationExPage automationExPage;

    @Test
    public void test19_View_Cart_Brand_Products() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test19_View_Cart_Brand_Products", "automationexercise.com UI testcase 19");
        extentTest.info("1. Launch browser and Navigate to url 'http://automationexercise.com , 2. Verify that home page is visible successfully");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/"));
        List<WebElement> mainPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : mainPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("4. Verify that Brands are visible on left side bar");
        automationExPage.mainPageCategoryBrandBar.isDisplayed();
        extentTest.info("5. Click on any brand name");
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.mainPageBrandsPolo);
        automationExPage.mainPageBrandsPolo.click();
        Thread.sleep(500);
        extentTest.info("6. Verify that user is navigated to brand page and brand products are displayed");
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/brand_products/Polo"));
        List<WebElement> poloBrandPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : poloBrandPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("7. On left side bar, click on any other brand link");
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.mainPageBrandsHarbour);
        automationExPage.mainPageBrandsHarbour.click();
        extentTest.info("8. Verify that user is navigated to that brand page and can see products");
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/brand_products/Mast%20&%20Harbour"));
        List<WebElement> harbourBrandPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : harbourBrandPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.pass("View cart and different brand products functions are works as expectedly!");
    }
}
