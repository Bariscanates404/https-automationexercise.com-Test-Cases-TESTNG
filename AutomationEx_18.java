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

public class AutomationEx_18 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test18_View_Category_Products() throws InterruptedException {
        automationExPage = new AutomationExPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        extentTest = extentReports.createTest("test18_View_Category_Products", "automationexercise.com UI testcase 18");
        extentTest.info("1. Launch browser and Navigate to url 'http://automationexercise.com , 2. Verify that home page is visible successfully");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        ReusableMethods.waitForPageToLoad(10);
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/"));
        List<WebElement> mainPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : mainPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("3. Verify that categories are visible on left side bar");
        automationExPage.mainPageCategoryBrandBar.isDisplayed();
        extentTest.info("4. Click on 'Women' category");
        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.mainPageCategoryWomen);
        automationExPage.mainPageCategoryWomen.click();
        extentTest.info("5. Click on any category link under 'Women' category, for example: Dress");
        Thread.sleep(500);
        automationExPage.mainPageWomenSubcategoryDress.click();
        extentTest.info("6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'");
        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.productPageTopTitleText);
        Assert.assertTrue(ReusableMethods.verifyURLorText(automationExPage.productPageTopTitleText.getText(), "WOMEN - DRESS PRODUCTS"));
        extentTest.info("7. On left side bar, click on any sub-category link of 'Men' category");
        automationExPage.mainPageCategoryMen.click();
        Thread.sleep(500);
        automationExPage.mainPageMenSubcategoryTshirts.click();
        extentTest.info("8. Verify that user is navigated to that category page");
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.productPageTopTitleText);
        Assert.assertTrue(ReusableMethods.verifyURLorText(automationExPage.productPageTopTitleText.getText(), "MEN - TSHIRTS PRODUCTS"));
        extentTest.pass("View category and different category functions are works expectedly!");
    }
}
