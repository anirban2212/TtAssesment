package com.ttassesment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.actiondriver.Action;
import com.ttassesment.base.BaseClass;

public class FlipcartSearchResultPage extends BaseClass{
	
	
	
	
	/*
	 * @FindBy(xpath = "(//a[@class='_1fQZEK'])[1]") WebElement
	 * flipcartFirstProduct;
	 */
	 
	By flipcartFirstProduct=By.xpath("(//a[@class='_1fQZEK'])[1]");
	
	public FlipcartSearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public FlipcartAddToCartPage flipcartClickFirstproduct() throws Exception {

		
		Action.getFirstProduct(flipcartFirstProduct);
			
		
			  return new FlipcartAddToCartPage();
			 

	}
	
	
	
	
}
