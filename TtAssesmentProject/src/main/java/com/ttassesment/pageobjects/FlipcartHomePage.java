package com.ttassesment.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.actiondriver.Action;
import com.ttassesment.base.BaseClass;

public class FlipcartHomePage extends BaseClass{
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	WebElement flipcartSearchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement flipcartSearchBtn;
	
	@FindBy(xpath = "//input[@type='text' and @id='twotabsearchtextbox']")
	WebElement amazoneSearchBox;
	@FindBy(xpath = "//input[@type='submit' and @id='nav-search-submit-button']")
	WebElement amazoneSearchBtn;
	
	
	
	
	
	//initialize all the page objects of this particular class
		//when we call the obj of this particular class then this contructor will be called and all the obj will be initialied
	
	public FlipcartHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public FlipcartSearchResultPage flipcartSearchProduct(String productName) throws Exception{
		Action.type(flipcartSearchBox, productName);
		Action.JSClick(driver, flipcartSearchBtn);
		Thread.sleep(2000);
		
		
		return new FlipcartSearchResultPage();
		
	}
	
	
	
	
	

}
