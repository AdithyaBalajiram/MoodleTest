package com.moodle.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage 
{
	protected static WebDriver driver;
	@CacheLookup
	@FindBy(how = How.ID, using = "username")
	private static WebElement username;
	@FindBy(how = How.ID, using = "password")
	private static WebElement password;
	@FindBy(how = How.ID, using = "loginbtn")
	private static WebElement LoginBtn;
	@FindBy(how=How.XPATH,using=".//*[@class='alert alert-danger']")
	private static WebElement loginErrorMsg;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public static void EnterCredentials(String uname, String pwd) 
	{
		// TODO Auto-generated method stub
		 username.sendKeys(uname);
		 password.sendKeys(pwd);
		 LoginBtn.click();
	}
	public static Class<DashboardPage> SuccessStep(String uname, String pwd,String expectedMsg)
	{
		if(uname.equals("manager")&&(pwd.equals("test")))
		{
			
			Assert.assertEquals(DashboardPage.getPagetitle(),expectedMsg);
		}
		return null;
	}
	public static void ErrorMsgforInvalidCredentials(String uname, String pwd,String expectedMsg)
	{
		if(!uname.equals("manager")&&(!pwd.equals("test")))
		{
			String lr=loginErrorMsg.getText();
			Assert.assertEquals(lr,expectedMsg);
		}
		
	}
	
}
