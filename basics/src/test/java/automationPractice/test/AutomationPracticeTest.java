package automationPractice.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import framework.ChromeDriverManager;
import framework.TestBase;
import framework.WebDriverFactory;
import automationPractice.foundation.DriverDocPage;
import automationPractice.page.CartSummaryPage;
import automationPractice.page.CheckOutPage;
import automationPractice.page.ContactUsPage;
import automationPractice.page.DriverHomePageBen;
import automationPractice.page.ProductDetailPage;

public class AutomationPracticeTest extends TestBase{
	
	private final String emailBen = "yxu117@mail.ccsf.edu";
	private final String emailBenPW = "drse9520";
	/*
	 * 
	 Nanda
FR001.B1 P2 User will be able to login into the website using the email and password.
FR001.B2 P3 Reset password option for the users to reset the password in case of forgot password.
FR002.B1 P2 Buyers will be able to get registered on website with simple registration form with details
FR004.B2 P1 By clicking on product title and image, user will be able to navigate on product detail page to view more details of the product.
FR005.B4 P1 User will be able to add the product to his shopping cart. User will also be able to add the product to wishlist.

Savon
FR003.B1 P1 Buyers  will  be  able  to  search  the  products  by  keyword,  by  browsing  through category/sub-category, using filters and sorting options.
FR004.B1 P1 Buyers will be able to view the listing of the product with following details:
FR007.B4 P1 User will be able to proceed for checkout of any items/ all items available in shopping cart.

Ben
FR005.B6 P3 User will not be able to add the product to wishlist without login.
FR007.B1 P1 The products can be added into shopping cart from the product detail page.
FR008.B2 P1 Buyer is required to login into website for checkout and payment.
FR008.B3 P2 Buyer  will  required  to  enter  billing  and  shipping  address  before  checkout  and payment.
FR013.B1 P4 Buyers  will  be  able  to  contact  support  team  via  email  regarding  any  queries/
	 */
	
	@Test
	/*
	 * FR001.B1 P2 User will be able to login into the website using the email and password.
	 */
	public void TestExample() {
		String HomePageURL = "http://automationpractice.com/";
		String somethingXpath = "";
		//new the driver page
		//DriverDocPage = new DriverDocPage(driver);
		//set default email address + set password
		//DriverHomePage HomePage = DriverDocPage.NavigateToPage(HomePageURL);
		//String currentURL = driver.getCurrentUrl();
		//String HomeUrl = HomePage.getHomeUrl();
		//assertEquals("cant not go to url: " + HomeUrl, currentURL, HomeUrl);
	}
	
	@Test
	/*
	 * FR005.B6 P3 User will not be able to add the product to wishlist without login.
	 */
	public void FR005B6P3Test() {
		String HomePageURL = "http://automationpractice.com/index.php";
		String ProductXpath = "//div[@id = 'center_column']//div[@class = 'tab-content']//ul[@id = 'homefeatured']//"
				+ "li[@class = 'ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line "
				+ "first-item-of-mobile-line']/div/div[@class = 'left-block']//div[@class = 'product-image-container']//a[@class = 'product_img_link']";
		String ProductDetailUrl = "http://automationpractice.com/index.php?id_product=1&controller=product";
		String AddtoWishXpath = "//a[@id = 'wishlist_button']";
		String Temp = "//div[@class = 'fancybox-inner']";
		DriverDocPage = new DriverDocPage(driver);
		
		ProductDetailPage productDetailPage = ((DriverHomePageBen) DriverDocPage.NavigateToPage(HomePageURL))
				.ClickToProductDetail(ProductXpath, ProductDetailUrl);
		productDetailPage.Click(AddtoWishXpath);
		
		String errorReport = productDetailPage.GetText(Temp);
		assertTrue(errorReport.equals("You must be logged in to manage your wishlist."));
	}
	
	@Test
	/*
	 * FR007.B1 P1 The products can be added into shopping cart from the product detail page.
	 */
	public void FR007B1P1Test() {
		String ProductName = "Faded Short Sleeve T-shirts";
		String ProductID = "demo_1";
		String HomePageURL = "http://automationpractice.com/index.php";
		String ProductXpath = "//div[@id = 'center_column']//div[@class = 'tab-content']//ul[@id = 'homefeatured']//"
				+ "li[@class = 'ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line "
				+ "first-item-of-mobile-line']/div/div[@class = 'left-block']//div[@class = 'product-image-container']//a[@class = 'product_img_link']";
		String ProductDetailUrl = "http://automationpractice.com/index.php?id_product=1&controller=product";
		DriverDocPage = new DriverDocPage(driver);
		
		DriverHomePageBen HomePage = (DriverHomePageBen) DriverDocPage.NavigateToPage(HomePageURL);
		String currentURL = driver.getCurrentUrl();
		String HomeUrl = HomePage.getHomeUrl();
		assertTrue(currentURL.equals(HomeUrl), "cant not go to url: " + HomeUrl + ".But went to:" + currentURL);
		
		ProductDetailPage productDetailPage = HomePage.ClickToProductDetail(ProductXpath, ProductDetailUrl);
		productDetailPage.addToCartAndClosePopUp();
		
		CartSummaryPage cartSummaryPage = productDetailPage.NavigateToCart();
		HashMap<String, String> productHashMap = cartSummaryPage
				.getProductMap();
		Set<?> productKeys = cartSummaryPage
				.getProductMapAndReturnKeySet();
		
		assertTrue(productKeys.contains(ProductName), "Should contain " + ProductName + " but it doesn't");
		assertTrue(productHashMap.get(ProductName).equals(ProductID), "The product ID for " + ProductName + " should be " + ProductID);
	}
	
	@Test
	/*
	 * FR008.B2 P1 Buyer is required to login into website for checkout and payment.
	 */
	public void FB008B2P1Test() {
		String expectedCreateAccountTitle = "CREATE AN ACCOUNT";
		String HomePageURL = "http://automationpractice.com/index.php";
		String ProductXpath = "//div[@id = 'center_column']//div[@class = 'tab-content']//ul[@id = 'homefeatured']//"
				+ "li[@class = 'ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line "
				+ "first-item-of-mobile-line']/div/div[@class = 'left-block']//div[@class = 'product-image-container']//a[@class = 'product_img_link']";
		String ProductDetailUrl = "http://automationpractice.com/index.php?id_product=1&controller=product";
		DriverDocPage = new DriverDocPage(driver);
		
		DriverHomePageBen HomePage = (DriverHomePageBen) DriverDocPage.NavigateToPage(HomePageURL);
		String currentURL = driver.getCurrentUrl();
		String HomeUrl = HomePage.getHomeUrl();
		assertTrue(currentURL.equals(HomeUrl), "cant not go to url: " + HomeUrl + ".But went to:" + currentURL);
		
		ProductDetailPage productDetailPage = HomePage.ClickToProductDetail(ProductXpath, ProductDetailUrl);
		
		productDetailPage.addToCartAndClosePopUp();
		
		CartSummaryPage cartSummaryPage = productDetailPage.NavigateToCart();
		CheckOutPage checkoutPage = cartSummaryPage.NavigateToCheckOut();
		String createAccountMessage = checkoutPage.getCreateAccountTextIfExist();
		
		assertTrue(createAccountMessage.equals(expectedCreateAccountTitle));
	}
	
	@Test
	/*
	 * FR008.B3 P2 Buyer  will  required  to  enter  billing  and  shipping  address  before  checkout  and payment.
	 */
	public void FB008B3P2Test() {
		String HomePageURL = "http://automationpractice.com/index.php";
		String ProductXpath = "//div[@id = 'center_column']//div[@class = 'tab-content']//ul[@id = 'homefeatured']//"
				+ "li[@class = 'ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line "
				+ "first-item-of-mobile-line']/div/div[@class = 'left-block']//div[@class = 'product-image-container']//a[@class = 'product_img_link']";
		String ProductDetailUrl = "http://automationpractice.com/index.php?id_product=1&controller=product";
		DriverDocPage = new DriverDocPage(driver);
		
		String[] deliveryAddressBoxTexts = ((DriverHomePageBen) DriverDocPage.NavigateToPage(HomePageURL))
				.ClickToProductDetail(ProductXpath, ProductDetailUrl)
				.addToCartAndClosePopUp()
				.NavigateToCart()
				.NavigateToCheckOut()
				.inputEmailPasswdAndLogin(this.emailBen, this.emailBenPW)
				.getDeliveryAddressBoxTexts();
		
		assertTrue(deliveryAddressBoxTexts[0].equals("YOUR DELIVERY ADDRESS"));
	}
	
	@Test
	/*
	 * FR013.B1 P4 Buyers  will  be  able  to  contact  support  team  via  email  regarding  any  queries/
	 */
	public void FB013B1P4Test() {
		String HomePageURL = "http://automationpractice.com/index.php";
		String subjectHeading = "Customer service";
		String emailAddress = this.emailBen;
		String message = "aaa";
		
		DriverDocPage = new DriverDocPage(driver);
		ContactUsPage contactUsPage = ((DriverHomePageBen) DriverDocPage
				.NavigateToPage(HomePageURL))
				.NavigateToContacUs();
		
		contactUsPage.submitForm(subjectHeading, emailAddress, message);
	}
}
