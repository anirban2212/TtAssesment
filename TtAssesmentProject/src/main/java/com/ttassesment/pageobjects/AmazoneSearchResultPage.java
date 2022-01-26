package com.ttassesment.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.actiondriver.Action;
import com.ttassesment.base.BaseClass;

public class AmazoneSearchResultPage extends BaseClass{
	@FindBy(xpath = "(//a[@class='a-link-normal s-link-style a-text-normal'])[1]")
	WebElement amazoneFirstProduct;
	public AmazoneSearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public AmazoneAddToCartPage amazoneClickFirstProduct() throws Exception {
		/*
		 * Action.click(driver, amazoneFirstProduct); Thread.sleep(3000);
		 * 
		 * String oldTab = driver.getWindowHandle();
		 * 
		 * ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		 * newTab.remove(oldTab); // change focus to new tab
		 * driver.switchTo().window(newTab.get(2)); Thread.sleep(5000); return new
		 * AmazoneAddToCartPage();
		 */
		
		  String firstproductUrl = driver.findElement(By.xpath("(//a[@class='a-link-normal s-link-style a-text-normal'])[1]")).
		  getAttribute("href"); Actions action = new Actions(driver);
		  action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform(); // opening the URL saved.
		   driver.get(firstproductUrl); 
		   return new AmazoneAddToCartPage();
		 

		
	}

}
