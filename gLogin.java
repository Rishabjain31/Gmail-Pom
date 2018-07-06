package com.qait.automation.gmailPom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class gLogin {
	WebDriver driver;

	public gLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void logMessage(String message) {
		Reporter.log(message, true);
	}

	public gCountMails login() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.id("identifierId")).sendKeys("coolrishabh.jain420@gmail.com");
		// driver.findElement(By.id("identifierId")).click();
		driver.findElement(By.cssSelector("div[class='qhFLie'] div[id='identifierNext']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='Xb9hP']//child::input[@type='password']")).sendKeys("rishabhjain");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js.executeScript("document.querySelector(\"div[class=qhFLie] div[id=passwordNext]\").click()");
		logMessage("you have been logged in");
		Assert.assertEquals(driver.getCurrentUrl(), "https://mail.google.com/mail/u/0/#inbox");
		return new gCountMails(driver);
	}
}