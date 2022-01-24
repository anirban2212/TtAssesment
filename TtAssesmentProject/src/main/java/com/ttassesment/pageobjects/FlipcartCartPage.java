package com.ttassesment.pageobjects;

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
	
	@FindBy(xpath = "//div[@class='Ob17DV _3X7Jj1']/span")
	WebElement flipcartPriceEle;
	
	public FlipcartCartPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void flipcartIncreaseQuantity()throws InterruptedException {
		System.out.println(driver.getTitle());

		Action.click(driver, flipcartIncreaseBtn);
		Thread.sleep(3000);
		
		
		
	}
	
	public int flipcartProductPrice() {
		String price= flipcartPriceEle.getText();
		price=price.replaceAll("[^a-zA-Z0-9]", "");
		int product_price = Integer.parseInt(price);
		System.out.println("Total Amount:-"+ product_price);
		return product_price;
	
	}
	public AmazoneHomePage launchAmazone() {
		Actions action =
				  new Actions(driver);
				  action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform(); //opening the URL saved. 
				  driver.get("https://www.amazon.in/");
		Action.implicitWait(driver, 10);
		  String parent=driver.getWindowHandle(); 
		driver.switchTo().window(parent);	
		return new AmazoneHomePage();
	}
	

	

}
