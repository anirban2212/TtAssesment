package com.ttassesment.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.actiondriver.Action;
import com.ttassesment.base.BaseClass;

public class FlipcartAddToCartPage extends BaseClass{
	@FindBy(xpath = "(//*[@id=\"container\"]//button[contains(text(),'')])[2]")
	WebElement flipcartAddToCartBtn;
	@FindBy(xpath  ="(//div[@class='_25b18c']/div)[1]")
	WebElement flipcartPriceEle;
	
	public FlipcartAddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	public FlipcartCartPage flipcartAddToCart() throws Exception {
		Action.click(driver, flipcartAddToCartBtn);
		
		
		return new FlipcartCartPage();
		
		
	}
	public int flipcartProductPriceFromAddToCartPage() {
		String price= flipcartPriceEle.getText();
		price=price.replaceAll("[^a-zA-Z0-9]", "");
		int flipcart_product_price = Integer.parseInt(price);
		System.out.println("Product Price:-"+ flipcart_product_price);
		return flipcart_product_price;
	
	}

}
