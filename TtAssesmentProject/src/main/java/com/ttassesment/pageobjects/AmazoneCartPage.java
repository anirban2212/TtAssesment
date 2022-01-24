package com.ttassesment.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.base.BaseClass;

public class AmazoneCartPage extends BaseClass{
	@FindBy(xpath = "//span[@id='sc-subtotal-amount-buybox']/span")
	WebElement amazonePriceEle;
	
	public AmazoneCartPage() {
		PageFactory.initElements(driver, this);
		
	}
	
public int amazoneProductPriceFromCartPage() {
		
		String price= amazonePriceEle.getText();
		price=price.replaceAll("[^a-zA-Z0-9]", "");
		int a = Integer.parseInt(price);
		int product_price=a/100;
		
		System.out.println("Product Price:-"+ product_price);
		
		return product_price;
	
	}

}
