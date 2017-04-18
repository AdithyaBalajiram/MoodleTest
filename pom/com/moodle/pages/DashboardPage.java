package com.moodle.pages;

import org.openqa.selenium.WebDriver;

public class DashboardPage extends LoginPage
{
	public DashboardPage(WebDriver driver)
	{
		super(driver);
	}
	public static String getPagetitle()
	{
		String dashboardTitle=driver.getTitle();
		return dashboardTitle;
	}
}
