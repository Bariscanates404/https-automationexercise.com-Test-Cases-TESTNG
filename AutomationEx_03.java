package tests.automationExCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class AutomationEx_03 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test03_Login_User_With_Incorrect_Info() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test03Login_User_With_Incorrect_Info", "automationexercise.com UI testcase 3");
        extentTest.info("1. Launch browser, 2. Navigate to url 'http://automationexercise.com");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extentTest.info("3. Verify that home page is visible successfully");
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://automationexercise.com/";
        Assert.assertEquals(actualURL, expectedURL);
        for (WebElement element : automationExPage.sayfadakiTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("4. Click on 'Signup / Login' button");
        automationExPage.loginSingupButonu.click();
        extentTest.info("5. Verify 'Login to your account' is visible");
        automationExPage.loginUserMenuForm.isDisplayed();
        extentTest.info("6. Enter incorrect email address and password");
        automationExPage.loginUserEmail.sendKeys(ConfigReader.getProperty("autExIncorrectEmail"));
        automationExPage.loginUserPassword.sendKeys(ConfigReader.getProperty("autExIncorrectPassword"));
        extentTest.info("7. Click 'login' button");
        automationExPage.loginUserButton.click();
        extentTest.info("8. Verify error 'Your email or password is incorrect!' is visible");
        String actualPasswordCheck=automationExPage.loginUserMenuPasswordIncorrectError.getText();
        String expectedPasswordCheck="Your email or password is incorrect!";
        Assert.assertEquals(actualPasswordCheck, expectedPasswordCheck);
        extentTest.pass("Login menu acted as expected against invalid informations!");
    }
}
