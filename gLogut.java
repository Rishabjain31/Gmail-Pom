package com.qait.automation.gmailPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class gLogut {
	WebDriver driver;
	
	public gLogut(WebDriver driver) {
		this.driver = driver;
	}
	
	public void logout() {
		driver.findElement(By.cssSelector("span[class='gb_db gbii']")).click();
		driver.findElement(By.cssSelector("a[id='gb_71']")).click();
        Reporter.log("You have been successfully logged out");
        Assert.assertEquals(driver.getCurrentUrl(), "https://accounts.google.com/signin/v2/sl/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}
}
