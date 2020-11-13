package com.cognizant.googleAutomate;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchPage {
	
	public static WebElement element = null;
	static Logger log=Logger.getLogger(searchPage.class);
	
	 
	public static WebElement searchText(WebDriver driver) {
		element = driver.findElement(By.name("q"));
		log.info("search Text element found");
		return element;
	}

	public static WebElement searchClick(WebDriver driver) {
		element = driver.findElement(By.className("gNO89b"));
		log.info("search button element clicked");
		return element;
	}

	public static WebElement clickSignup(WebDriver driver) {
		element = driver.findElement(By.linkText("Sign up"));
		log.info("signup element clicked");
		return element;
	}
	
	public static WebElement writeName(WebDriver driver) {
		element = driver.findElement(By.name("name"));
		log.info("name entered");
		return element;
	}
	
	public static WebElement writeNumber(WebDriver driver) {
		element = driver.findElement(By.name("phone_number"));
		log.info("number entered");
		return element;
	}
	

}
