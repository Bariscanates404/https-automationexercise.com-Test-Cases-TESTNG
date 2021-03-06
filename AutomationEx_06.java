package tests.automationExCases;

import com.github.javafaker.Faker;
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

public class AutomationEx_06 extends TestBaseRapor {
    AutomationExPage automationExPage;

    @Test
    public void test06_Contact_Us_Form() throws InterruptedException {
        automationExPage = new AutomationExPage();
        Faker faker = new Faker();
        String filePath = "C:\\Users\\tunab\\Desktop\\TestNg Reports\\1.jpg";
        String fakeName = faker.name().fullName();
        String fakeEmail = faker.internet().emailAddress();
        String fakeSubject = faker.pokemon().name();
        String fakeMessage = faker.hitchhikersGuideToTheGalaxy().marvinQuote();
        extentTest = extentReports.createTest("test06_Contact_Us_Form", "automationexercise.com UI testcase 6");
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
        extentTest.info("4. Click on 'Contact Us' button");
        automationExPage.mainPageContactUsButonu.click();
        extentTest.info("5. Verify 'GET IN TOUCH' is visible");
        automationExPage.contactUsFormGetInTouch.isDisplayed();
        extentTest.info("6. Enter name, email, subject and message");
        automationExPage.contactUsFormName.sendKeys(fakeName);
        automationExPage.contactUsFormEmail.sendKeys(fakeEmail);
        automationExPage.contactUsFormSubject.sendKeys(fakeSubject);
        automationExPage.contactUsFormMessage.sendKeys(fakeMessage);
        extentTest.info("7. Upload file");
        automationExPage.contactUsFormUploadFile.sendKeys(filePath);
        extentTest.info("8. Click 'Submit' button");
        automationExPage.contactUsSubmitButton.click();
        extentTest.info("9. Click OK button");
        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("10. Verify success message 'Success! Your details have been submitted successfully.' is visible");
        String actualAlertMessage = automationExPage.contactUsAlertSuccessMessage.getText();
        String expectedAlertMessage = "Success! Your details have been submitted successfully.";
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        extentTest.info("11. Click 'Home' button and verify that landed to home page successfully");
        automationExPage.contactUsHomeButton.click();
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/"));
        extentTest.pass("Contact us form is works as expected!");
    }
}
