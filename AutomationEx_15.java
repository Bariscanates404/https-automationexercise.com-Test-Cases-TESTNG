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

import java.time.Duration;
import java.util.List;

public class AutomationEx_15 extends TestBaseRapor {
    AutomationExPage automationExPage;
    Faker faker = new Faker();
    Select select;

    @Test
    public void test15_Place_Order_Register_before_Checkout() throws InterruptedException {
        String fakeFirstName = faker.name().nameWithMiddle();
        String fakeLastName = faker.name().lastName();
        String fakeCompany = faker.company().name();
        String fakeAddress = faker.address().streetAddressNumber();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();
        String fakeMobilePhone = faker.phoneNumber().cellPhone();
        String fakeMessage = faker.hitchhikersGuideToTheGalaxy().marvinQuote();

        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test15_Place_Order_Register_before_Checkout", "automationexercise.com UI testcase 15");
        extentTest.info("1. Launch browser, 2. Navigate to url 'http://automationexercise.com");
        Driver.getDriver().get(ConfigReader.getProperty("autExUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extentTest.info("3. Verify that home page is visible successfully");
        Assert.assertTrue(ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/"));
        List<WebElement> mainPageTumResimler = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));
        for (WebElement element : mainPageTumResimler) {
            element.isDisplayed();
            element.isEnabled();
        }
        extentTest.info("4. Click on 'Signup / Login' button");
        automationExPage.mainPageloginSingupButonu.click();
        extentTest.info("5. Fill all details in Signup and create account");
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
        extentTest.info("6. Verify 'ACCOUNT CREATED!' and click 'Continue' button");
        ReusableMethods.verifyURLorText(automationExPage.verifyAccountCreated.getText(), "ACCOUNT CREATED!");
        automationExPage.accountCreateContinueButton.click();
        extentTest.info("7. Verify ' Logged in as username' at top");
        ReusableMethods.verifyURLorText(automationExPage.loggedUserName.getText(), fakeFirstName);
        extentTest.info("8. Add products to cart");
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.productPageAddtoCartFirstItem);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[1]"))).perform();
        actions.moveToElement(automationExPage.productPageAddtoCartFirstItem).click().perform();
        automationExPage.popUpContinueShoppingButton.click();
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[2]"))).perform();
        actions.moveToElement(automationExPage.productPageAddtoCartSecondItem).click().perform();
        automationExPage.popUpContinueShoppingButton.click();
        extentTest.info("9. Click 'Cart' button");
        automationExPage.mainPageCartButton.click();
        extentTest.info("10. Verify that cart page is displayed");
        ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/view_cart");
        extentTest.info("11. Click Proceed To Checkout");
        Thread.sleep(500);
        automationExPage.cartPageProceedToCheckOutButton.click();
        extentTest.info("12. Verify Address Details and Review Your Order");
        Assert.assertTrue(ReusableMethods.verifyAdressInformations("Mr.", fakeFirstName, fakeLastName, fakeCompany
                , fakeAddress, fakeAddress, "Massachusetts", "Boston", "02108", "United States", fakeMobilePhone));
        extentTest.info("13. Enter description in comment text area and click 'Place Order'");
        automationExPage.checkoutPageCommentTextArea.sendKeys(fakeMessage);
        automationExPage.checkoutPagePlaceOrder.click();
        extentTest.info("14. Enter payment details: Name on Card, Card Number, CVC, Expiration date");
        automationExPage.paymentPageNameOnCardInput.sendKeys(fakeFirstName);
        automationExPage.paymentPageCardNumberInput.sendKeys("1234567891234567");
        automationExPage.paymentPageCvcNumberInput.sendKeys("567");
        automationExPage.paymentPageExpirationMonthInput.sendKeys("11");
        automationExPage.paymentPageExpirationYearInput.sendKeys("2023");
        extentTest.info("15. Click 'Pay and Confirm Order' button");
        automationExPage.paymentPagePayAndConfirmOrderButton.click();
        extentTest.info("16. Verify success message 'Your order has been placed successfully!'");
        ReusableMethods.verifyURLorText(automationExPage.paymentDonePageSuccessMessageText.getText(), "Your order has been placed successfully!");
        extentTest.info("17. Click payment continue button");
        automationExPage.paymentDonePageContinueButton.click();
        extentTest.pass("Register account, place order and credit card functions works as expected! ");
    }
}
