package com.ttassesment.actiondriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ttassesment.base.BaseClass;

public class Action extends BaseClass{
	
	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	
	public static void click(WebDriver driver, WebElement ele) {
		try {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
		System.out.println("sucessfully clicked on the element-"+ele);
		}
		catch(Exception e) {
			System.out.println("Failed to click on the element-'"+ele+"' reason"+e);
			throw e;
		}

	}
	
	public static void enterIntoTextBoxJs(WebElement ele, String text) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value', text)", ele);	
	}
	public static void enterIntoTextBoxJs(By locator,String value) {
		try {
		WebElement element=driver.findElement(locator);
		explicitWait(driver, element, 5);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+value+"'", element);
		System.out.println("Entered ='"+value+"' to the '"+locator+"' field");
		
		}
		catch(Exception e) {
			System.out.println("Failed to Enter ='"+value+"' to the '"+locator+"' field");
			throw e;
		}		
	}
	public static void type(WebElement ele, String text) {
		try {
			explicitWait(driver, ele, 10);
			if(ele.isDisplayed()){
				ele.clear();
				ele.sendKeys(text);
				System.out.println("Successfully entered value");

			}
			else {
				System.out.println("Unable to enter value");

			}
			
		} catch (Exception e) {
			System.out.println(ele+"Location Not found,reason"+e);
			throw e;
			
		} 

	}	
	public static void JSClick(WebDriver driver, WebElement ele) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			System.out.println("Click Action is performed");


		}
		catch (Exception e) {
			System.out.println("Click Action is not performed");
			throw e;

		} 
		
	}
	
	public static void getFirstProduct(By locator) {
		try {
		WebElement ele=driver.findElement(locator);
		explicitWait(driver, ele, 5);
		String firstproductUrl=ele.getAttribute("href");
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform(); // opening the URL saved.
		driver.get(firstproductUrl); 
		System.out.println("sucessfully clicked on the first product");
		
		}
		catch(Exception e) {
			System.out.println("Failed to get the first procuct"+e);
			throw e;
		}
		
		
	}
	
	
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	public static int getPrice(By locator) {
		WebElement element=driver.findElement(locator);
		String price=element.getText();
		price=price.replaceAll("[^a-zA-Z0-9]", "");
		int product_price = Integer.parseInt(price);
		return product_price;
		//System.out.println("Product Price:-"+product_price);
		
	}
	
	
	
	

}
