package com.cognizant.googleAutomate;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutomatingGoogle {

	WebDriver driver;
	JavascriptExecutor jse;

	@Test
	@Parameters({"chromeDriver","location"})
	public void setUp(String chromeDriver,String location) {
		System.out.println("AutomatingGoogle->Inside setUp method");
		System.setProperty(chromeDriver, location);
		driver = new ChromeDriver();
		jse = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 PropertyConfigurator.configure("log4j.properties");

	}

	@Test
	@Parameters({"baseurl","sendKey1","sendKey2","baseurl2","userName","userNumber"})
	public void test(String baseurl,String sendKey1,String sendKey2,String baseurl2, String userName,String userNumber) throws InterruptedException {
		System.out.println("AutomatingGoogle->Inside test method");
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get(baseurl);

		WebElement emailField = wait.until(ExpectedConditions.visibilityOf(searchPage.searchText(driver)));

		emailField.sendKeys(sendKey1);
		Thread.sleep(2000);

		WebElement clearText = wait.until(ExpectedConditions.visibilityOf(searchPage.searchText(driver)));
		clearText.clear();

		WebElement sel = wait.until(ExpectedConditions.visibilityOf(searchPage.searchText(driver)));
		sel.sendKeys(sendKey2);

		WebElement seleniumClick = wait.until(ExpectedConditions.visibilityOf(searchPage.searchClick(driver)));
		seleniumClick.click();

		jse.executeScript("window.scrollBy(0,2900)");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,-2900)");
		Thread.sleep(3000);

		driver.navigate().back();

		driver.get(baseurl2);

		searchPage.clickSignup(driver).click();
		
		searchPage.writeName(driver).sendKeys(userName);
		searchPage.writeNumber(driver).sendKeys(userNumber);
		
		//assertTrue(true);

	}

	/*
	 * @Test public void tearDown(ITestResult result) {
	 * 
	 * System.out.println("AutomatingGoogle->Inside setUp method");
	 * 
	 * if(result.getStatus()==ITestResult.FAILURE) {
	 * System.out.println("TEST FAILED :"); }
	 * if(result.getStatus()==ITestResult.SUCCESS) {
	 * System.out.println("TEST PASSED"); }
	 * 
	 * }
	 */
}
