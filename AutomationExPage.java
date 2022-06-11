package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExPage {

    public AutomationExPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Main page
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement mainPageloginSingupButonu;
    @FindBy(xpath = "//a[@href='/contact_us']")
    public WebElement mainPageContactUsButonu;
    @FindBy(xpath = "//a[@href='/products']")
    public WebElement mainPageProductsButonu;
    @FindBy(css = "div[class='single-widget'] h2")
    public WebElement mainPageSubscriptionText;
    @FindBy(xpath = "//input[@id='susbscribe_email']")
    public WebElement mainPageSubscriptionInput;
    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    public WebElement mainPageSubscriptionArrowButton;
    @FindBy(xpath = "//div[@class='alert-success alert']")
    public WebElement mainPageSubscriptionSuccessAlert;
    @FindBy(xpath = "(//a[@href='/view_cart'])[1]")
    public WebElement mainPageCartButton;
    @FindBy(xpath = "//i[@class='fa fa-angle-up']")
    public WebElement mainPageArrowUptoAngleUp;
 
    //Recommended items
    @FindBy(xpath = "//h2[text()='recommended items']")
    public WebElement mainPageRecommendedItemsList;

    //Main page Category and Brands bar
    //Categories
    @FindBy(css = ".left-sidebar")
    public WebElement mainPageCategoryBrandBar;
    //Women
    @FindBy(css = "a[href='#Women']")
    public WebElement mainPageCategoryWomen;
    //Subcategories
    @FindBy(css = "a[href='/category_products/1']")
    public WebElement mainPageWomenSubcategoryDress;
    @FindBy(css = "a[href='/category_products/2']")
    public WebElement mainPageWomenSubcategoryTops;
    @FindBy(css = "a[href='/category_products/7']")
    public WebElement mainPageWomenSubcategorySaree;
    //Men
    @FindBy(css = "a[href='#Men']")
    public WebElement mainPageCategoryMen;
    //Subcategories
    @FindBy(css = "a[href='/category_products/3']")
    public WebElement mainPageMenSubcategoryTshirts;
    @FindBy(css = "a[href='/category_products/6']")
    public WebElement mainPageMenSubcategoryJeans;
    //Kids
    @FindBy(css = "a[href='#Kids']")
    public WebElement mainPageCategoryKids;
    //Subcategories
    @FindBy(css = "a[href='/category_products/4']")
    public WebElement mainPageKidsSubcategoryDress;
    @FindBy(css = "a[href='/category_products/5']")
    public WebElement mainPageKidsSubcategoryTopsShirts;

    //Brands
    @FindBy(css = "a[href='/brand_products/Polo']")
    public WebElement mainPageBrandsPolo;
    @FindBy(css = "a[href='/brand_products/H&M']")
    public WebElement mainPageBrandsHm;
    @FindBy(css = "a[href='/brand_products/Madame']")
    public WebElement mainPageBrandsMadame;
    @FindBy(css = "a[href='/brand_products/Mast & Harbour']")
    public WebElement mainPageBrandsHarbour;
    @FindBy(css = "a[href='/brand_products/Babyhug']")
    public WebElement mainPageBrandsBabyhug;
    @FindBy(css = "a[href='/brand_products/Allen Solly Junior']")
    public WebElement mainPageBrandsAllenSollyJunior;
    @FindBy(css = "a[href='/brand_products/Kookie Kids']")
    public WebElement mainPageBrandsKookieKids;
    @FindBy(css = "a[href='/brand_products/Biba']")
    public WebElement mainPageBrandsBiba;


    //Login/singup form menu
    @FindBy(xpath = "//div[@class='signup-form']")
    public WebElement newUserSingupMenuForm;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement newUserSingupMenuName;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement newUserSingupMenuEmail;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement newUserSingupButton;
    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    public WebElement newUserMenuError;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginUserEmail;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginUserPassword;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginUserButton;
    @FindBy(xpath = "//div[@class='login-form']")
    public WebElement loginUserMenuForm;
    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement loginUserMenuError;

    //LoginFormTable
    @FindBy(xpath = "//div[@class='login-form']")
    public WebElement loginForm;
    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement loginFormtitleRadioButtonGenderMr;
    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement loginFormtitleRadioButtonGenderMrs;
    @FindBy(css = "#name")
    public WebElement loginFormName;
    @FindBy(css = "#password")
    public WebElement loginFormPassword;
    @FindBy(css = "#days")
    public WebElement loginFormDropdownDay;
    @FindBy(css = "#months")
    public WebElement loginFormDropdownMonth;
    @FindBy(css = "#years")
    public WebElement loginFormDropdownYear;
    @FindBy(xpath = "//input[@name='newsletter']")
    public WebElement loginFormCheckboxNewslatter;
    @FindBy(xpath = "//input[@name='optin']")
    public WebElement loginFormCheckboxSpecialOffer;
    @FindBy(css = "#first_name")
    public WebElement loginFormAdressInfoFirstName;
    @FindBy(css = "#last_name")
    public WebElement loginFormAdressInfoLastName;
    @FindBy(css = "#company")
    public WebElement loginFormAdressInfoCompany;
    @FindBy(css = "#address1")
    public WebElement loginFormAdressInfoAdress1;
    @FindBy(css = "#address2")
    public WebElement loginFormAdressInfoAdress2;
    @FindBy(css = "#state")
    public WebElement loginFormAdressInfoState;
    @FindBy(css = "#city")
    public WebElement loginFormAdressInfoCity;
    @FindBy(css = "#zipcode")
    public WebElement loginFormAdressInfoZipcode;
    @FindBy(css = "#mobile_number")
    public WebElement loginFormAdressInfoMobileNumber;
    @FindBy(css = "#country")
    public WebElement loginFormAdressInfoDropdownCountry;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement loginFormAdressInfoCreateAccountButton;

    //Account created page
    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement verifyAccountCreated;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement accountCreateContinueButton;

    //Main page After logged in
    @FindBy(css = "div ul li a b")
    public WebElement loggedUserName;
    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement loggedUserLogoutButton;

    //Contact US Page
    @FindBy(xpath = "//h2[text()='Get In Touch']")
    public WebElement contactUsFormGetInTouch;
    @FindBy(xpath = "//input[@data-qa='name']")
    public WebElement contactUsFormName;
    @FindBy(xpath = "//input[@data-qa='email']")
    public WebElement contactUsFormEmail;
    @FindBy(xpath = "//input[@data-qa='subject']")
    public WebElement contactUsFormSubject;
    @FindBy(css = "#message")
    public WebElement contactUsFormMessage;
    @FindBy(xpath = "//input[@name='upload_file']")
    public WebElement contactUsFormUploadFile;
    @FindBy(xpath = "//input[@data-qa='submit-button']")
    public WebElement contactUsSubmitButton;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement contactUsAlertSuccessMessage;
    @FindBy(xpath = "//a[@class='btn btn-success']")
    public WebElement contactUsHomeButton;

    //Products Page
    @FindBy(xpath = "//input[@id='search_product']")
    public WebElement productPageSearchPanel;
    @FindBy(xpath = "(//a[@data-product-id='1'])[1]")
    public WebElement productPageAddtoCartFirstItem;
    @FindBy(xpath = "(//a[@data-product-id='2'])[1]")
    public WebElement productPageAddtoCartSecondItem;
    @FindBy(css = "h2[class]")
    public WebElement productPageTopTitleText;

    //Product detail page
    @FindBy(css = ".product-information")
    public WebElement oneProductPageProductInformationPanel;
    @FindBy(css = "div[class='product-information'] h2")
    public WebElement oneProductPageProductName;
    @FindBy(css = "div[class='product-information'] p:nth-of-type(1)")
    public WebElement oneProductPageProductCategory;
    @FindBy(css = "div[class='product-information'] span span")
    public WebElement oneProductPageProductPrice;
    @FindBy(css = "div[class='product-information'] p:nth-of-type(2)")
    public WebElement oneProductPageProductAvalibility;
    @FindBy(css = "div[class='product-information'] p:nth-of-type(3)")
    public WebElement oneProductPageProductCondition;
    @FindBy(css = "div[class='product-information'] p:nth-of-type(4)")
    public WebElement oneProductPageProductBrand;
    @FindBy(css = "#quantity")
    public WebElement oneProductPageProductQuantity;
    @FindBy(xpath = "//button[@type='button']")
    public WebElement oneProductPageAddToCardButton;
    @FindBy(css = "a[href='#reviews']")
    public WebElement oneProductPageWriteYourReviewForm;
    @FindBy(css = "#name")
    public WebElement oneProductPageWriteYourReviewNameInput;
    @FindBy(css = "#email")
    public WebElement oneProductPageWriteYourReviewEmailInput;
    @FindBy(css = "#review")
    public WebElement oneProductPageWriteYourReviewMessageInput;
    @FindBy(css = "#button-review")
    public WebElement oneProductPageWriteYourReviewSubmitButton;
    @FindBy(css = "div[class='alert-success alert'] span")
    public WebElement oneProductPageWriteYourReviewSuccessAlert;

    //Pop-up menu
    @FindBy(xpath = "//u[text()='View Cart']")
    public WebElement popUpViewCartButton;
    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    public WebElement popUpContinueShoppingButton;
    @FindBy(xpath = "//u[text()='Register / Login']")
    public WebElement popUpRegisterLoginButton;
    @FindBy(xpath = "//button[@class='btn btn-success close-checkout-modal btn-block']")
    public WebElement popUpContinueOnCartButton;

    //Searched items
    @FindBy(css = "div[class='productinfo text-center'] p")
    public WebElement searchPanelSearchedItem;

    //Cart Page
    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement cartPageSubscriptionText;
    @FindBy(xpath = "//input[@id='susbscribe_email']")
    public WebElement cartPageSubscriptionInput;
    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    public WebElement cartPageSubscriptionArrowButton;
    @FindBy(xpath = "//div[@class='alert-success alert']")
    public WebElement cartPageSubscriptionSuccessAlert;
    @FindBy(xpath = "//button[@class='disabled']")
    public WebElement cartPageQuantity;
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement cartPageProceedToCheckOutButton;
    @FindBy(xpath = "(//a[@class='cart_quantity_delete'])[1]")
    public WebElement cartPageDeleteButton1;
    @FindBy(xpath = "(//a[@class='cart_quantity_delete'])[2]")
    public WebElement cartPageDeleteButton2;
    @FindBy(xpath = "(//a[@class='cart_quantity_delete'])[3]")
    public WebElement cartPageDeleteButton3;
    @FindBy(xpath = "(//a[@class='cart_quantity_delete'])[4]")
    public WebElement cartPageDeleteButton4;
    @FindBy(xpath = "(//a[@class='cart_quantity_delete'])[5]")
    public WebElement cartPageDeleteButton5;
    @FindBy(css = "a[href='/product_details/1']")
    public WebElement cartPageProduct1;
    @FindBy(css = "a[href='/product_details/2']")
    public WebElement cartPageProduct2;
    @FindBy(css = "a[href='/product_details/3']")
    public WebElement cartPageProduct3;
    @FindBy(css = "a[href='/product_details/4']")
    public WebElement cartPageProduct4;
    @FindBy(css = "a[href='/product_details/5']")
    public WebElement cartPageProduct5;


    //Checkout Page
    @FindBy(xpath = "//textarea[@class='form-control']")
    public WebElement checkoutPageCommentTextArea;
    @FindBy(xpath = "//a[@href='/payment']")
    public WebElement checkoutPagePlaceOrder;

    //Payment Page
    @FindBy(xpath = "//button[@class='disabled']")
    public WebElement paymentPagePaymentFormVerification;
    @FindBy(xpath = "//input[@name='name_on_card']")
    public WebElement paymentPageNameOnCardInput;
    @FindBy(xpath = "//input[@name='card_number']")
    public WebElement paymentPageCardNumberInput;
    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement paymentPageCvcNumberInput;
    @FindBy(xpath = "//input[@name='expiry_month']")
    public WebElement paymentPageExpirationMonthInput;
    @FindBy(xpath = "//input[@name='expiry_year']")
    public WebElement paymentPageExpirationYearInput;
    @FindBy(xpath = "//button[@id='submit']")
    public WebElement paymentPagePayAndConfirmOrderButton;

    //Payment Done page
    @FindBy(xpath = "//p[@style='font-size: 20px; font-family: garamond;']")
    public WebElement paymentDonePageSuccessMessageText;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement paymentDonePageContinueButton;
}
