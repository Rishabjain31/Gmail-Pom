package com.qait.automation.gmailPom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class gTest {
	WebDriver driver;
	gLogin obj;
	gComposeMail obj1;
	gLogut obj2;
	gCountMails obj3;

	@BeforeClass
	public void launchURL() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rishabh.jain1\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://gmail.com");
		obj = new gLogin(driver);
		driver.manage().window().maximize();
	}

	@Test
	public void firstCase() {
		obj3=obj.login();
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
	}
	@Test(dependsOnMethods= {"firstCase"})
	public void secondCase() {
		driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
		obj2=obj3.countUnreadMails();
	}
	@Test(priority=3)
	public void thirdCase() {
		obj2.logout();
	}
	@AfterClass
	public void closeUrl() {
		driver.quit();
	}
}


