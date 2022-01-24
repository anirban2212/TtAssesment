package com.ttassesment.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ttassesment.actiondriver.Action;
import com.ttassesment.base.BaseClass;

public class AmazoneHomePage extends BaseClass{
	
	@FindBy(xpath = "//input[@type='text' and @id='twotabsearchtextbox']")
	WebElement amazoneSearchBox;
	@FindBy(xpath = "//input[@type='submit' and @id='nav-search-submit-button']")
	WebElement amazoneSearchBtn;
	public AmazoneHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public AmazoneSearchResultPage amazoneSearchProduct() throws InterruptedException {
		
		//driver.findElement(By.xpath("//input[@type='text' and @id='twotabsearchtextbox']")).sendKeys(productName1,Keys.TAB);
		//Action.enterIntoTextBoxJs(amazoneSearchBox, product);
		
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].setAttribute('value', 'iphone 12 mini')",amazoneSearchBox);
		 
		Action.click(driver, amazoneSearchBtn);
		String oldTab = driver.getWindowHandle();
	    
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));
		Thread.sleep(5000);
		return new AmazoneSearchResultPage();
		
		
		
		
		
		
		
	}

}
