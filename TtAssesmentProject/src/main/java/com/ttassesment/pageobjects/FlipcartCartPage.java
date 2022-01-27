package com.ttassesment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.actiondriver.Action;
import com.ttassesment.base.BaseClass;

public class FlipcartCartPage extends BaseClass{
	
	@FindBy(xpath = "(//button[@class='_23FHuj'])[2]")
	WebElement flipcartIncreaseBtn;
	
	By flipcartFinalPriceEle=By.xpath("//div[@class='Ob17DV _3X7Jj1']/span");
	
	public FlipcartCartPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void flipcartIncreaseQuantity()throws InterruptedException {
		Action.click(driver, flipcartIncreaseBtn);
		Thread.sleep(3000);
		
		
		
	}
	
	public int flipcartCheckoutPrice() {
		int final_Product_Price=Action.getPrice(flipcartFinalPriceEle);
		System.out.println("Total Checkout Ammount:-"+ final_Product_Price);
		return final_Product_Price;
	
	}
	public AmazoneHomePage launchAmazone() {
		driver.get("https://www.amazon.in/");
		Action.implicitWait(driver, 10);
		return new AmazoneHomePage();
	}
	

	

}
