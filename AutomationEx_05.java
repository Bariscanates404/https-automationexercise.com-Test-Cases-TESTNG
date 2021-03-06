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

public class AutomationEx_05 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test04_Register_user_with_existing_Email() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test05_Register_user_with_existing_Email", "automationexercise.com UI testcase 5");
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
        extentTest.info("4. Click on 'Signup / Login' button");
        automationExPage.mainPageloginSingupButonu.click();
        extentTest.info("5. Verify 'New User Signup!' is visible");
        automationExPage.newUserSingupMenuForm.isDisplayed();
        extentTest.info("6. Enter name and already registered email address");
        automationExPage.newUserSingupMenuName.sendKeys(ConfigReader.getProperty("autExUnusedName"));
        automationExPage.newUserSingupMenuEmail.sendKeys(ConfigReader.getProperty("autExEmail"));
        extentTest.info("7. Click 'Signup' button ");
        automationExPage.newUserSingupButton.click();
        extentTest.info("8. Verify error 'Email Address already exist!' is visible");
        String actualError= automationExPage.newUserMenuError.getText();
        String expectedError="Email Address already exist!";
        Assert.assertEquals(actualError,expectedError);
        extentTest.pass("Signup menu acted as expected against register new user with existing email operation!");
    }
}
