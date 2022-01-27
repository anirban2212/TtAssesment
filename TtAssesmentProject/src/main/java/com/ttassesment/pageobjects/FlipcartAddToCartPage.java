package com.ttassesment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.actiondriver.Action;
import com.ttassesment.base.BaseClass;

public class FlipcartAddToCartPage extends BaseClass{
	@FindBy(xpath = "(//*[@id=\"container\"]//button[contains(text(),'')])[2]")
	WebElement flipcartAddToCartBtn;
	By flipcartPriceEle=By.xpath("(//div[@class='_25b18c']/div)[1]");
	
	public FlipcartAddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	public FlipcartCartPage flipcartAddToCart() throws Exception {
		Action.click(driver, flipcartAddToCartBtn);
		
		
		return new FlipcartCartPage();
		
		
	}
	public int flipcartProductPrice() {
		int flipcart_product_price= Action.getPrice(flipcartPriceEle);
		System.out.println("product price:-"+flipcart_product_price);
		return flipcart_product_price;
		
	
	}

}
