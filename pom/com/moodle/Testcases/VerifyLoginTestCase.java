package com.moodle.Testcases;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.moodle.pages.DashboardPage;
import com.moodle.pages.LoginPage;

public class VerifyLoginTestCase 
{

	@Test
	public static void LoginApplication()
	{
		
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://qa.moodle.net/login/index.php");
		LoginPage login= PageFactory.initElements(driver, LoginPage.class);
		login.EnterCredentials("manager","test");
		login.SuccessStep("manager", "test","Dashboard");
		driver.close();
	}
	
}
