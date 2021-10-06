package automationPractice.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.Test;

import framework.ChromeDriverManager;
import framework.TestBase;
import framework.WebDriverFactory;
import automationPractice.foundation.DriverDocPage;
import automationPractice.page.DriverHomePageBen;
import automationPractice.page.ProductDetailPage;

public class AutomationPracticeTest extends TestBase{
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
		String NotloginReportXpath = "//p[@class = 'fancybox-error']//text()[0]";
		String Temp = "//div[@class = 'fancybox-inner']";
		//String TempCSS = "p[class=\"fancybox-error\"]";
		DriverDocPage = new DriverDocPage(driver);
		
		DriverHomePageBen HomePage = (DriverHomePageBen) DriverDocPage.NavigateToPage(HomePageURL);
		String currentURL = driver.getCurrentUrl();
		String HomeUrl = HomePage.getHomeUrl();
		assertTrue(currentURL.equals(HomeUrl), "cant not go to url: " + HomeUrl + ".But went to:" + currentURL);
		
		ProductDetailPage productDetailPage = HomePage.ClickToProductDetail(ProductXpath, ProductDetailUrl);
		
		productDetailPage.Click(AddtoWishXpath);
		
		String errorReport = productDetailPage.GetText(Temp);
		System.out.println(errorReport);
		//for(int i = 0; i < errorReport.length; i++) {
		//	System.out.println(errorReport[i]);
		//}
		
		//assertTrue(errorReport.equals("You must be logged in to manage your wishlist."));
	}
	
	@Test
	/*
	 * FR007.B1 P1 The products can be added into shopping cart from the product detail page.
	 */
	public void FR007B1P1Test() {
		String HomePageURL = "http://automationpractice.com/index.php";
		String ProductXpath = "//div[@id = 'center_column']//div[@class = 'tab-content']//ul[@id = 'homefeatured']//"
				+ "li[@class = 'ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line "
				+ "first-item-of-mobile-line']/div/div[@class = 'left-block']//div[@class = 'product-image-container']//a[@class = 'product_img_link']";
		String ProductDetailUrl = "http://automationpractice.com/index.php?id_product=1&controller=product";
		String AddtoCartXpath = "//p[@id = 'add_to_cart']/button";
		String ReplyXpath = "//div[@class = 'layer_cart_product col-xs-12 col-md-6']//h2";
		DriverDocPage = new DriverDocPage(driver);
		
		DriverHomePageBen HomePage = (DriverHomePageBen) DriverDocPage.NavigateToPage(HomePageURL);
		String currentURL = driver.getCurrentUrl();
		String HomeUrl = HomePage.getHomeUrl();
		assertTrue(currentURL.equals(HomeUrl), "cant not go to url: " + HomeUrl + ".But went to:" + currentURL);
		
		ProductDetailPage productDetailPage = HomePage.ClickToProductDetail(ProductXpath, ProductDetailUrl);
		
		productDetailPage.Click(AddtoCartXpath);
		
		String x = productDetailPage.GetText(ReplyXpath);
		System.out.println("output" + x);
	}
}
