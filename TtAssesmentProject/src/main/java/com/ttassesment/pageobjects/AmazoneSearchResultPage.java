package com.ttassesment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.actiondriver.Action;
import com.ttassesment.base.BaseClass;

public class AmazoneSearchResultPage extends BaseClass{
	/*
	 * @FindBy(xpath =
	 * "(//a[@class='a-link-normal s-link-style a-text-normal'])[1]") WebElement
	 * amazoneFirstProduct;
	 */
	By amazoneFirstProduct=By.xpath("(//a[@class='a-link-normal s-link-style a-text-normal'])[1]");
	public AmazoneSearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public AmazoneAddToCartPage amazoneClickFirstProduct() throws Exception {
		
		
		 Action.getFirstProduct(amazoneFirstProduct);
		   return new AmazoneAddToCartPage();
		 

		
	}

}
