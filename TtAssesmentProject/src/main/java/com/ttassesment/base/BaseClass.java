package com.ttassesment.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import com.ttassesment.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeTest
	public void loadConfig() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void launchApp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String browsername=prop.getProperty("browser");
		if(browsername.contains("Chrome")) {
			driver=new ChromeDriver();
			
		}
		else if(browsername.contains("Firefox")) {
			driver=new FirefoxDriver();
			
		}
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 30);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(2000);
		
		
	}
	

}
