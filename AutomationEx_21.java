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

public class AutomationEx_21 extends TestBaseRapor {
    AutomationExPage automationExPage;
    Faker faker=new Faker();

    @Test
    public void test21_Add_review_on_product() throws InterruptedException {
        automationExPage = new AutomationExPage();
        String fakeMessage = faker.hitchhikersGuideToTheGalaxy().marvinQuote();
        String fakeFirstName = faker.name().nameWithMiddle();
        String fakeEmail = faker.internet().emailAddress();

        extentTest = extentReports.createTest("test21_Add_review_on_product", "automationexercise.com UI testcase 21");
        extentTest.info("1. Launch browser and Navigate to url 'http://automationexercise.com , 2. Verify that home page is visible successfully");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/"));
        List<WebElement> mainPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : mainPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("3. Click on 'Products' button");
        automationExPage.mainPageProductsButonu.click();
        extentTest.info("4. Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/products"));
        extentTest.info("5. Click on 'View Product' button");
        Driver.getDriver().findElement(By.xpath("//a[@href='/product_details/1']")).click();
        extentTest.info("6. Verify 'Write Your Review' is visible");
        automationExPage.oneProductPageWriteYourReviewForm.isDisplayed();
        extentTest.info("7. Enter name, email and review");
        automationExPage.oneProductPageWriteYourReviewNameInput.sendKeys(fakeFirstName);
        automationExPage.oneProductPageWriteYourReviewEmailInput.sendKeys(fakeEmail);
        automationExPage.oneProductPageWriteYourReviewMessageInput.sendKeys(fakeMessage);
        extentTest.info("8. Click 'Submit' button");
        automationExPage.oneProductPageWriteYourReviewSubmitButton.click();
        extentTest.info("9. Verify success message 'Thank you for your review.'");
        automationExPage.oneProductPageWriteYourReviewSuccessAlert.isDisplayed();
        extentTest.pass("All of add review on product functions are works expectedly!");
    }
}
