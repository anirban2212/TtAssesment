package com.ttassesment.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ttassesment.base.BaseClass;
import com.ttassesment.pageobjects.FlipcartAddToCartPage;
import com.ttassesment.pageobjects.AmazoneAddToCartPage;
import com.ttassesment.pageobjects.AmazoneCartPage;
import com.ttassesment.pageobjects.AmazoneHomePage;
import com.ttassesment.pageobjects.AmazoneSearchResultPage;
import com.ttassesment.pageobjects.FlipcartCartPage;
import com.ttassesment.pageobjects.FlipcartHomePage;
import com.ttassesment.pageobjects.FlipcartSearchResultPage;

public class CompareProductPrice extends BaseClass {
	FlipcartHomePage flipcartHomepage;
	FlipcartSearchResultPage flipcartSearchResultPage;
	FlipcartCartPage flipcartCartPage;
	FlipcartAddToCartPage flipcartAddToCartPage;
	AmazoneHomePage amazoneHomepage;
	AmazoneSearchResultPage amazonesearchResultPage;
	AmazoneAddToCartPage amazoneAddToCartPage;
	AmazoneCartPage amazoneCartPage;

	@BeforeMethod
	public void setup() throws Exception {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	@Test
	public void getPriceOnBothWebsite() throws Exception {
		flipcartHomepage = new FlipcartHomePage();
		flipcartSearchResultPage = flipcartHomepage.flipcartSearchProduct("macbook pro");//iphone 12 mini
		flipcartAddToCartPage = flipcartSearchResultPage.flipcartClickFirstproduct();
		Thread.sleep(2000);
		flipcartAddToCartPage.flipcartProductPrice();
		flipcartCartPage = flipcartAddToCartPage.flipcartAddToCart();
		Thread.sleep(5000);
		int flipcartPrice = flipcartCartPage.flipcartCheckoutPrice(); 
		
		  amazoneHomepage=flipcartCartPage.launchAmazone(); 
		  Thread.sleep(3000);
		  amazonesearchResultPage=amazoneHomepage.amazoneSearchProduct("macbook pro");
		  
		  Thread.sleep(3000);
		  amazoneAddToCartPage=amazonesearchResultPage.amazoneClickFirstProduct();
		 amazoneAddToCartPage.amazoneProductPriceFromAddToCartPage();
		  amazoneCartPage=amazoneAddToCartPage.amazoneAddToCart();
		  Thread.sleep(5000);
		  int amazonePrice=amazoneCartPage.amazoneProductPriceFromCartPage();
		  
		if(flipcartPrice>amazonePrice) {
			System.out.println("Amazone is giving much better deal");
			
		} 
		else if(flipcartPrice==amazonePrice){
			System.out.println("Both sites have same price");

			
		}
		else {
			System.out.println("Flipcart is giving much better deal");
		}
		
		  
		  
		 
		  
		  
		  
		  
		 
		

	}

}
