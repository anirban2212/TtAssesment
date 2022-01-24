package com.ttassesment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.base.BaseClass;

public class FlipcartSearchResultPage extends BaseClass{
	
	
	
	@FindBy(xpath = "(//a[@class='_1fQZEK'])[1]")
	WebElement flipcartFirstProduct;
	
	public FlipcartSearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public FlipcartAddToCartPage flipcartClickFirstproduct() throws Exception {

		// Action.click(driver, firstProduct);

		String firstproductUrl = driver.findElement(By.xpath("(//a[@class='_1fQZEK'])[1]")).getAttribute("href");
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform(); // opening the URL saved.
		driver.get(firstproductUrl);
		return new FlipcartAddToCartPage();

	}
	
	
	
	
}
