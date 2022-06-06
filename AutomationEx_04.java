package tests.automationExCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class AutomationEx_04 extends TestBaseRapor {

    AutomationExPage automationExPage;

    @Test
    public void test04_Logout_User() throws InterruptedException {
        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test04_Logout_User", "automationexercise.com UI testcase 4");
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
        extentTest.info("6. Enter correct email address and password");
        automationExPage.loginUserEmail.sendKeys(ConfigReader.getProperty("autExEmail"));
        automationExPage.loginUserPassword.sendKeys(ConfigReader.getProperty("autExValidPassword"));
        extentTest.info("7. Click 'login' button");
        automationExPage.loginUserButton.click();
        extentTest.info("8. Verify that 'Logged in as username' is visible");
        String actualsername = automationExPage.loggedUserName.getText();
        String expectedUsername = ConfigReader.getProperty("autExValidName");
        Assert.assertEquals(actualsername, expectedUsername);
        extentTest.info("9. Click 'Logout' button");
        automationExPage.loggedUserLogoutButton.click();
        extentTest.info("10. Verify that user is navigated to login page");
        String actualLoginPageUrl = Driver.getDriver().getCurrentUrl();
        String expectedLoginPageUrl = "https://automationexercise.com/login";
        extentTest.pass("User logout operation works as expected!");
    }
}
