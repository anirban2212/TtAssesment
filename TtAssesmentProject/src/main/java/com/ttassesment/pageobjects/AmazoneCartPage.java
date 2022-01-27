package com.ttassesment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ttassesment.actiondriver.Action;
import com.ttassesment.base.BaseClass;

public class AmazoneCartPage extends BaseClass{
	By amazoneFinalPriceEle=By.xpath("//span[@id='sc-subtotal-amount-buybox']/span");
	
	public AmazoneCartPage() {
		PageFactory.initElements(driver, this);
		
	}
	
public int amazoneProductPriceFromCartPage() {
		
		int a =Action.getPrice(amazoneFinalPriceEle);
		int product_price=a/100;
		
		System.out.println("Final Product Price Of Amazone:-"+ product_price);
		
		return product_price;
	
	}

}
