package com.ttassesment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.base.BaseClass;

public class AmazoneSearchResultPage extends BaseClass{
	public AmazoneSearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public AmazoneAddToCartPage amazoneClickFirstProduct() {
		String firstproductUrl = driver.findElement(By.xpath("(//a[@class='a-link-normal s-link-style a-text-normal'])[1]")).getAttribute("href");
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform(); // opening the URL saved.
		driver.get(firstproductUrl);
		return new AmazoneAddToCartPage();

		
	}

}
