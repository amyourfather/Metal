package automationPractice.test;

import static org.testng.Assert.assertEquals;
import org.junit.Test;

import framework.TestBase;
import automationPractice.page.AuthenticationPage;
import automationPractice.page.HomePage;
import automationPractice.page.ProductDetailsPage;
import automationPractice.foundation.DriverDocPage;

public class AutomationPracticeTest extends TestBase {

//Nanda	
//FR001.B1 P2 User will be able to login into the website using the email and password.
	@Test
	public void testLoginWithEmailAndPassword() {
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";

		new AuthenticationPage(this.getDriver()).fillLoginCredentials();

		String actualUrl = this.getDriver().getCurrentUrl();

		assertEquals(actualUrl, expectedUrl, "Did not navigate to the My Account page.");
	}

//FR001.B2 P3 Reset password option for the users to reset the password in case of forgot password.
	@Test
	public void testResetPassword() {
		String expectedMessage = "A confirmation email has been sent to your address: gracy21@gmail.com";

		String actualMessage = new AuthenticationPage(this.getDriver()).clickForgotPassword().resetPassword();

		assertEquals(actualMessage, expectedMessage, "Did not get confirmation message.");
	}

//FR002.B1 P2 Buyers will be able to get registered on website with simple registration form with details
	@Test
	public void testResgistrationForm() {
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";

		new AuthenticationPage(this.getDriver()).clickCreateAccountButton().fillPersonalInformation();

		String actualUrl = this.getDriver().getCurrentUrl();

		assertEquals(actualUrl, expectedUrl, "Did not navigate to the My Account page after registration.");
	}

	// FR004.B2 P1 By clicking on product title and image, user will be able to
	// navigate on product detail page to view more details of the product.
	@Test
	public void testProductTitleNavigateToProductDetailsPage() {
		String expectedUrl = "http://automationpractice.com/index.php?id_product=4&controller=product";

		new HomePage(this.getDriver()).clickOnProductTitle();

		String actualUrl = this.getDriver().getCurrentUrl();

		assertEquals(actualUrl, expectedUrl, "Did not navigate to the Product Details page.");
	}

	@Test
	public void testProductImageNavigateToProductDetailsPage() {
		String expectedUrl = "http://automationpractice.com/index.php?id_product=4&controller=product";

		new HomePage(this.getDriver()).clickOnProductImage();

		String actualUrl = this.getDriver().getCurrentUrl();

		assertEquals(actualUrl, expectedUrl, "Did not navigate to the Product Details page.");
	}

	// FR005.B4 P1 User will be able to add the product to his shopping cart. User
	// will also be able to add the product to wishlist.
	@Test
	public void testAddToCart() {
		String id = new ProductDetailsPage(this.getDriver()).getProductDemoId();
		String expectedProductDemo = "SKU : " + id;

		String actualProductDemo = new HomePage(this.getDriver()).clickSignInButton().fillLoginCredentials()
				.clickOnYourLogo().clickOnProductTitle().clickAddToCart().productDescription();

		assertEquals(actualProductDemo, expectedProductDemo, "Product demo did not match.");
	}

	@Test
	public void testAddToWishList() {
		String expectedUrl = "http://automationpractice.com/index.php?id_product=4&controller=product";

		new HomePage(this.getDriver()).clickSignInButton().fillLoginCredentials().clickOnYourLogo()
				.clickOnProductTitle().clickAddToWishListThenUserName().clickOnWishList().clickOnProductThumnail();

		String actualUrl = this.getDriver().getCurrentUrl();
		assertEquals(actualUrl, expectedUrl, "Did not navigate to the Product Details page.");
	}
}
// Nanda Ends


//	Savon 
//	FR003.B1 P1 Buyers will be able to search the products by keyword, by browsing through category/sub-category, using filters and sorting options.
//	FR004.B1 P1 Buyers will be able to view the listing of the product with following details. 
//	FR007.B4 P1 User will be able to proceed for checkout of any items/ all items available in shopping cart.

//	Ben 
//	FR005.B6 P3 User will not be able to add the product to wishlist without login. 
//	FR007.B1 P1 The products can be added into shopping cart from the product detail page. 
//	FR008.B2 P1 Buyer is required to login into website for checkout and payment. 
//	FR008.B3 P2 Buyer will required to enter billing and shipping address before checkout and payment. 
//	FR013.B1 P4 Buyers will be able to contact support team via email regarding any queries.

