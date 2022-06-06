package tests.automationExCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class AutomationEx_01 extends TestBaseRapor {
    AutomationExPage automationExPage;
    Select select;

    @Test
    public void test01_Register_User() throws InterruptedException {
        automationExPage = new AutomationExPage();
        Faker faker = new Faker();
        String fakeAddress = faker.address().streetAddressNumber();
        String fakeAddress2 = faker.address().fullAddress();
        String fakeMobilePhone = faker.phoneNumber().cellPhone();

        extentTest = extentReports.createTest("test01_Register_User", "automationexercise.com UI testcase 1");
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
        automationExPage.loginButonu.click();
        extentTest.info("5. Verify 'New User Signup!' is visible");
        automationExPage.newUserSingupMenu.isDisplayed();
        extentTest.info("6. Enter name and email address");
        automationExPage.newUserSingupMenuName.sendKeys(ConfigReader.getProperty("autExValidName"));
        automationExPage.newUserSingupMenuEmail.sendKeys(ConfigReader.getProperty("autExEmail"));
        extentTest.info("//7. Click 'Signup' button ");
        automationExPage.newUserSingupButton.click();
        extentTest.info("//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        automationExPage.loginForm.isDisplayed();
        extentTest.info("//9. Fill details: Title, Name, Email, Password, Date of birth");
        if (!automationExPage.titleRadioButtonGenderMr.isSelected()) {
            automationExPage.titleRadioButtonGenderMr.click();
        }
        automationExPage.loginFormPassword.sendKeys(ConfigReader.getProperty("autExValidPassword"));
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
        automationExPage.loginFormAdressInfoCreateAccount.click();
        extentTest.info("14. Verify that 'ACCOUNT CREATED!' is visible ");
        String actualText = automationExPage.verifyAccountCreated.getText();
        String expectedText = "ACCOUNT CREATED!";
        Assert.assertEquals(actualText, expectedText);
        extentTest.info("15. Click 'Continue' button ");
        automationExPage.accountCreateContinueButton.click();
        extentTest.info("16. Verify that 'Logged in as username' is visible ");
        String actualId = automationExPage.loggedUserName.getText();
        String expectedId = ConfigReader.getProperty("autExValidName");
        Assert.assertEquals(actualId, expectedId);
        extentTest.pass("User logged in succesfully!");
    } 
}
