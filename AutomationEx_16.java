package tests.automationExCases;

import com.github.javafaker.Faker;
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

public class AutomationEx_16 extends TestBaseRapor {

    AutomationExPage automationExPage;
    Faker faker=new Faker();

    @Test
    public void test16_Place_Order_Login_before_Checkout() throws InterruptedException {
        String fakeMessage = faker.hitchhikersGuideToTheGalaxy().marvinQuote();

        automationExPage = new AutomationExPage();
        extentTest = extentReports.createTest("test16_Place_Order_Login_before_Checkout", "automationexercise.com UI testcase 16");
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
        extentTest.info("5. Fill email, password and click 'Login' button");
        automationExPage.loginUserEmail.sendKeys(ConfigReader.getProperty("autExEmail"));
        automationExPage.loginUserPassword.sendKeys(ConfigReader.getProperty("autExValidPassword"));
        automationExPage.loginUserButton.click();
        extentTest.info("6. Verify 'Logged in as username' at top");
        String actualsername = automationExPage.loggedUserName.getText();
        String expectedUsername = ConfigReader.getProperty("autExValidName");
        Assert.assertEquals(actualsername, expectedUsername);
        extentTest.info("7. Add products to cart");
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", automationExPage.productPageAddtoCartFirstItem);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[1]"))).perform();
        actions.moveToElement(automationExPage.productPageAddtoCartFirstItem).click().perform();
        automationExPage.popUpContinueShoppingButton.click();
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[2]"))).perform();
        actions.moveToElement(automationExPage.productPageAddtoCartSecondItem).click().perform();
        automationExPage.popUpContinueShoppingButton.click();
        extentTest.info("8. Click 'Cart' button");
        automationExPage.mainPageCartButton.click();
        extentTest.info("9. Verify that cart page is displayed");
        ReusableMethods.verifyURLorText(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/view_cart");
        extentTest.info("10. Click Proceed To Checkout");
        Thread.sleep(500);
        automationExPage.cartPageProceedToCheckOutButton.click();
        extentTest.info("11. Verify Address Details and Review Your Order");
        Assert.assertTrue(ReusableMethods.verifyAdressInformations("Mr.", "bariscan", "ates", "Art Chess Club"
                , "661", "Suite 895 38602 Eric Park, Rodriguezbury, GA 30326", "Massachusetts", "Boston", "02108", "United States", "207-024-5440"));
        extentTest.info("12. Enter description in comment text area and click 'Place Order'");
        automationExPage.checkoutPageCommentTextArea.sendKeys(fakeMessage);
        automationExPage.checkoutPagePlaceOrder.click();
        extentTest.info("13. Enter payment details: Name on Card, Card Number, CVC, Expiration date");
        automationExPage.paymentPageNameOnCardInput.sendKeys(ConfigReader.getProperty("autExValidName"));
        automationExPage.paymentPageCardNumberInput.sendKeys("1234567891234567");
        automationExPage.paymentPageCvcNumberInput.sendKeys("567");
        automationExPage.paymentPageExpirationMonthInput.sendKeys("11");
        automationExPage.paymentPageExpirationYearInput.sendKeys("2023");
        extentTest.info("14. Click 'Pay and Confirm Order' button");
        automationExPage.paymentPagePayAndConfirmOrderButton.click();
        extentTest.info("15. Verify success message 'Your order has been placed successfully!'");
        ReusableMethods.verifyURLorText(automationExPage.paymentDonePageSuccessMessageText.getText(), "Your order has been placed successfully!");
        extentTest.info("17. Click payment continue button");
        automationExPage.paymentDonePageContinueButton.click();
        extentTest.pass("User logged in with valid account informations successfully!");
    }
}
