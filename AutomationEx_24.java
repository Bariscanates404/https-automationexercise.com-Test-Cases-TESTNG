package tests.automationExCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

public class AutomationEx_24 extends TestBaseRapor {
    AutomationExPage automationExPage;
    Select select;

    @Test
    public void test24_Download_Invoice_after_purchase_order() throws InterruptedException {
        Faker faker = new Faker();
        automationExPage = new AutomationExPage();
        String fakeFirstName = faker.name().nameWithMiddle();
        String fakeLastName = faker.name().lastName();
        String fakeCompany = faker.company().name();
        String fakeAddress = faker.address().streetAddressNumber();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();
        String fakeMobilePhone = faker.phoneNumber().cellPhone();
        String fakeMessage = faker.hitchhikersGuideToTheGalaxy().marvinQuote();
        
        extentTest = extentReports.createTest("test24_Download_Invoice_after_purchase_order", "automationexercise.com UI testcase 24");
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
        extentTest.info("4. Add products to cart");
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.productPageAddtoCartFirstItem);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[1]"))).perform();
        actions.moveToElement(automationExPage.productPageAddtoCartFirstItem).click().perform();
        automationExPage.popUpContinueShoppingButton.click();
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[2]"))).perform();
        actions.moveToElement(automationExPage.productPageAddtoCartSecondItem).click().perform();
        automationExPage.popUpContinueShoppingButton.click();
        extentTest.info("5. Click 'Cart' button");
        automationExPage.mainPageCartButton.click();
        extentTest.info("6. Verify that cart page is displayed");
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/view_cart"));
        extentTest.info("7. Click Proceed To Checkout");
        Thread.sleep(500);
        automationExPage.cartPageProceedToCheckOutButton.click();
        extentTest.info("8. Click 'Register / Login' button");
        automationExPage.popUpRegisterLoginButton.click();
        extentTest.info("9. Fill all details in Signup and create account");
        automationExPage.newUserSingupMenuName.sendKeys(fakeFirstName);
        automationExPage.newUserSingupMenuEmail.sendKeys(fakeEmail);
        automationExPage.newUserSingupButton.click();
        if (!automationExPage.loginFormtitleRadioButtonGenderMr.isSelected()) {
            automationExPage.loginFormtitleRadioButtonGenderMr.click();
        }
        automationExPage.loginFormPassword.sendKeys(fakePassword);
        select = new Select(automationExPage.loginFormDropdownYear);
        select.selectByVisibleText("1989");
        select = new Select(automationExPage.loginFormDropdownMonth);
        select.selectByVisibleText("July");
        select = new Select(automationExPage.loginFormDropdownDay);
        select.selectByVisibleText("2");
        automationExPage.loginFormCheckboxNewslatter.click();
        automationExPage.loginFormCheckboxSpecialOffer.click();
        automationExPage.loginFormAdressInfoFirstName.sendKeys(fakeFirstName);
        automationExPage.loginFormAdressInfoLastName.sendKeys(fakeLastName);
        automationExPage.loginFormAdressInfoCompany.sendKeys(fakeCompany);
        automationExPage.loginFormAdressInfoAdress1.sendKeys(fakeAddress);
        automationExPage.loginFormAdressInfoAdress2.sendKeys(fakeAddress);
        select = new Select(automationExPage.loginFormAdressInfoDropdownCountry);
        select.selectByVisibleText("United States");
        automationExPage.loginFormAdressInfoState.sendKeys("Massachusetts");
        automationExPage.loginFormAdressInfoCity.sendKeys("Boston");
        automationExPage.loginFormAdressInfoZipcode.sendKeys("02108");
        automationExPage.loginFormAdressInfoMobileNumber.sendKeys(fakeMobilePhone);
        automationExPage.loginFormAdressInfoCreateAccountButton.click();
        extentTest.info("10. Verify 'ACCOUNT CREATED!' and click 'Continue' button");
        Assert.assertTrue(ReusableMethods.verifyURLorText(automationExPage.verifyAccountCreated.getText(), "ACCOUNT CREATED!"));
        automationExPage.accountCreateContinueButton.click();
        extentTest.info("11. Verify ' Logged in as username' at top");
        Assert.assertTrue(ReusableMethods.verifyURLorText(automationExPage.loggedUserName.getText(), fakeFirstName));
        extentTest.info("12.Click 'Cart' button");
        automationExPage.mainPageCartButton.click();
        extentTest.info("13. Click 'Proceed To Checkout' button");
        Thread.sleep(500);
        automationExPage.cartPageProceedToCheckOutButton.click();
        extentTest.info("14. Verify Address Details and Review Your Order");
        Assert.assertTrue(ReusableMethods.verifyAdressInformations("Mr.", fakeFirstName, fakeLastName, fakeCompany
                , fakeAddress, fakeAddress, "Massachusetts", "Boston", "02108", "United States", fakeMobilePhone));
        extentTest.info("15. Enter description in comment text area and click 'Place Order'");
        automationExPage.checkoutPageCommentTextArea.sendKeys(fakeMessage);
        automationExPage.checkoutPagePlaceOrder.click();
        extentTest.info("16. Enter payment details: Name on Card, Card Number, CVC, Expiration date");
        automationExPage.paymentPageNameOnCardInput.sendKeys(fakeFirstName);
        automationExPage.paymentPageCardNumberInput.sendKeys("1234567891234567");
        automationExPage.paymentPageCvcNumberInput.sendKeys("567");
        automationExPage.paymentPageExpirationMonthInput.sendKeys("11");
        automationExPage.paymentPageExpirationYearInput.sendKeys("2023");
        extentTest.info("17. Click 'Pay and Confirm Order' button");
        automationExPage.paymentPagePayAndConfirmOrderButton.click();
        extentTest.info("18. Verify success message 'Your order has been placed successfully!'");
        Assert.assertTrue(ReusableMethods.verifyURLorText(automationExPage.paymentDonePageSuccessMessageText.getText(), "Congratulations! Your order has been confirmed!"));
        extentTest.info("19. Click 'Download Invoice' button and verify invoice is downloaded successfully.");
        Driver.getDriver().findElement(By.cssSelector("div a[class='btn btn-default check_out']")).click();
        Thread.sleep(2500);
        Assert.assertTrue(ReusableMethods.fileDownloadVerification("invoice.txt"));
        extentTest.pass("Download invoice after purchase functions are works as expectedly!");
    }
}
