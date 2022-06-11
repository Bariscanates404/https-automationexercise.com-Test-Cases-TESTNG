package tests.automationExCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.List;

public class AutomationEx_01 extends TestBaseRapor {
    AutomationExPage automationExPage;
    Select select;

    @Test
    public void test01_Register_User() throws InterruptedException {
        automationExPage = new AutomationExPage();
        Faker faker = new Faker();
        String fakeFirstName = faker.name().nameWithMiddle();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();
        String fakeAddress = faker.address().streetAddressNumber();
        String fakeAddress2 = faker.address().fullAddress();
        String fakeMobilePhone = faker.phoneNumber().cellPhone();

        extentTest = extentReports.createTest("test01_Register_User", "automationexercise.com UI testcase 1");
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
        extentTest.info("6. Enter name and email address");
        automationExPage.newUserSingupMenuName.sendKeys(fakeFirstName);
        automationExPage.newUserSingupMenuEmail.sendKeys(fakeEmail);
        extentTest.info("7. Click 'Signup' button ");
        automationExPage.newUserSingupButton.click();
        extentTest.info("8. Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        automationExPage.loginForm.isDisplayed();
        extentTest.info("9. Fill details: Title, Name, Email, Password, Date of birth");
        if (!automationExPage.loginFormtitleRadioButtonGenderMr.isSelected()) {
            automationExPage.loginFormtitleRadioButtonGenderMr.click();
        }
        automationExPage.loginFormPassword.sendKeys(fakePassword);
        select = new Select(automationExPage.loginFormDropdownDay);
        select.selectByVisibleText("1");
        select = new Select(automationExPage.loginFormDropdownMonth);
        select.selectByVisibleText("July");
        select = new Select(automationExPage.loginFormDropdownYear);
        select.selectByVisibleText("1989");
        extentTest.info("10-11. Click to checkboxes");
        automationExPage.loginFormCheckboxNewslatter.click();
        automationExPage.loginFormCheckboxSpecialOffer.click();
        extentTest.info("12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        automationExPage.loginFormAdressInfoFirstName.sendKeys(ConfigReader.getProperty("autExValidName"));
        automationExPage.loginFormAdressInfoLastName.sendKeys(ConfigReader.getProperty("autExValidSurname"));
        automationExPage.loginFormAdressInfoCompany.sendKeys("Art Chess Club");
        automationExPage.loginFormAdressInfoAdress1.sendKeys(fakeAddress);
        automationExPage.loginFormAdressInfoAdress2.sendKeys(fakeAddress2);
        select = new Select(automationExPage.loginFormAdressInfoDropdownCountry);
        select.selectByVisibleText("United States");
        automationExPage.loginFormAdressInfoState.sendKeys("Massachusetts");
        automationExPage.loginFormAdressInfoCity.sendKeys("Boston");
        automationExPage.loginFormAdressInfoZipcode.sendKeys("02108");
        automationExPage.loginFormAdressInfoMobileNumber.sendKeys(fakeMobilePhone);
        extentTest.info("13. Click 'Create Account button' ");
        automationExPage.loginFormAdressInfoCreateAccountButton.click();
        extentTest.info("14. Verify that 'ACCOUNT CREATED!' is visible ");
        String actualText = automationExPage.verifyAccountCreated.getText();
        String expectedText = "ACCOUNT CREATED!";
        Assert.assertEquals(actualText, expectedText);
        extentTest.info("15. Click 'Continue' button ");
        automationExPage.accountCreateContinueButton.click();
        extentTest.info("16. Verify that 'Logged in as username' is visible ");
        String actualId = automationExPage.loggedUserName.getText();
        String expectedId = fakeFirstName;
        Assert.assertEquals(actualId, expectedId);
        extentTest.pass("User logged in succesfully!");
    }
}
