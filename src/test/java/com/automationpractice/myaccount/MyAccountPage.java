package com.automationpractice.myaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automationpractice.PageObject;

public class MyAccountPage extends PageObject{
	
	private static final String URL_MYACCOUNT = "http://automationpractice.com/index.php?controller=my-account";
	
	public MyAccountPage (WebDriver browser) {
		super(browser);
	}
	
	public String getLoggedUsername() {
		return browser.findElement(By.className("account")).getText().toString();
	}
	
	public Boolean isMyAccountPage() {
		return browser.getCurrentUrl().equals(URL_MYACCOUNT);
	}
	
	public PersonalInformationPage clickPersonalInformationButton() {
		browser.findElement(By.cssSelector("a[title='Information']")).click();
		return new PersonalInformationPage(browser);
	}
	
	public Boolean getLogoutButton() {
		return browser.findElement(By.className("logout")).isDisplayed();
	}

}
