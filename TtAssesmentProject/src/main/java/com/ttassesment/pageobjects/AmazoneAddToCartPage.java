package com.ttassesment.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.actiondriver.Action;
import com.ttassesment.base.BaseClass;

public class AmazoneAddToCartPage extends BaseClass{
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement amazoneAddToCartBtn;
	@FindBy(xpath = "(//span[@class='a-price a-text-price a-size-medium apexPriceToPay']/span)[2]")
	WebElement amazonePriceEle;
	@FindBy(xpath = "//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")
	WebElement CartBtn;
	
	
	
	public AmazoneAddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	public AmazoneCartPage amazoneAddToCart() throws Exception {
		
		Action.click(driver, amazoneAddToCartBtn);
		Thread.sleep(3000);
		Action.click(driver, CartBtn);
		String oldTab = driver.getWindowHandle();
	    
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(1));
		Thread.sleep(5000);
		

		
		return new AmazoneCartPage();
		
	}
	public int amazoneProductPriceFromAddToCartPage() {
		
		String price= amazonePriceEle.getText();
		price=price.replaceAll("[^a-zA-Z0-9]", "");
		int a = Integer.parseInt(price);
		int product_price=a/100;
		
		System.out.println("Product Price:-"+ product_price);
		
		return product_price;
	
	}

	

}
