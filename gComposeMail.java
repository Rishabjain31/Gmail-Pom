package com.qait.automation.gmailPom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import junit.framework.Assert;

public class gComposeMail {
	WebDriver driver;

	public gComposeMail(WebDriver driver) {
		this.driver = driver;
	}

	public void composeMail() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.cssSelector("div[gh='cm']")).click();
		driver.findElement(By.cssSelector("textarea[aria-label='To']")).sendKeys("coolrishabh.jain420@gmail.com");
		driver.findElement(By.cssSelector("input[name='subjectbox']")).sendKeys("Mail");
		driver.findElement(By.cssSelector("div[aria-label=\"Message Body\"]")).sendKeys("This is a trial mail.");
		driver.findElement(By.cssSelector("div[class='J-J5-Ji btA'] div[role='button']")).click();
		Assert.assertEquals(js.executeScript("return window.getComputedStyle(document.querySelector(\"div[gh='cm']\")).visibility").toString(),"visible");
		Reporter.log("mail sent successfully");
	}
}
