package com.qait.automation.gmailPom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import junit.framework.Assert;

public class gCountMails {
	WebDriver driver;

	public gCountMails(WebDriver driver) {
		this.driver = driver;
	}

	public void firstUnreadMail() {
		List<WebElement> u_mails = driver.findElements(By.cssSelector("div[class=UI] tr[class='zA zE']"));
		Reporter.log("Number of unread mails on first apge is");
		System.out.println(u_mails.size());
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		Reporter.log("First unread mail");
		u_mails.get(0).click();
	}

	public gLogut countUnreadMails() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String str = driver.findElement(By.cssSelector("div[class='TN bzz aHS-bnt'] a[class='J-Ke n0']"))
				.getAttribute("title");
		System.out.println(str);
		System.out.println(str.substring(7, 12));
		firstUnreadMail();
		driver.navigate().to(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("div[class='TN bzz aHS-bnt'] a[class='J-Ke n0']")).click();
		String str1 = driver.findElement(By.cssSelector("div[class='TN bzz aHS-bnt'] a[class='J-Ke n0']"))
				.getAttribute("title");
		System.out.println("Mails after first unread mail was read in" + str1);
		System.out.println(str1.substring(7, 12));
		Assert.assertEquals(js.executeScript("return window.getComputedStyle(document.querySelector(document.querySelector(\"div[class='TN bzz aHS-bnt'] a[class='J-Ke n0'\")).visibility").toString(),"visible");
		return new gLogut(driver);
	}
}
