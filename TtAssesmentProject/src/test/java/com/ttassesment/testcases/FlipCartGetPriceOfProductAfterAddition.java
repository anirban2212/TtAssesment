package com.ttassesment.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ttassesment.base.BaseClass;
import com.ttassesment.pageobjects.FlipcartAddToCartPage;
import com.ttassesment.pageobjects.FlipcartCartPage;
import com.ttassesment.pageobjects.FlipcartHomePage;
import com.ttassesment.pageobjects.FlipcartSearchResultPage;

public class FlipCartGetPriceOfProductAfterAddition extends BaseClass{
	FlipcartHomePage flipcartHomepage;
	FlipcartSearchResultPage flipcartSearchResultPage;
	FlipcartCartPage flipcartCartPage;
	FlipcartAddToCartPage flipcartAddToCartPage;
	
	@BeforeMethod
	public void setup() throws Exception {
		launchApp();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void getTotalAmount() throws Exception {
		 flipcartHomepage=new FlipcartHomePage();
		 flipcartSearchResultPage=flipcartHomepage.flipcartSearchProduct("ipad");
		 flipcartAddToCartPage=flipcartSearchResultPage.flipcartClickFirstproduct();
		Thread.sleep(2000);
		flipcartCartPage=flipcartAddToCartPage.flipcartAddToCart();
		Thread.sleep(5000);
		flipcartCartPage.flipcartIncreaseQuantity();
		flipcartCartPage.flipcartProductPrice();
		//System.out.println(a);
		Thread.sleep(2000);
		
		
		
		
		
		
		
	}
	
	
	

}
