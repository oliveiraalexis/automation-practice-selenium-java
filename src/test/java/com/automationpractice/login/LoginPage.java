package com.automationpractice.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.PageObject;
import com.automationpractice.myaccount.MyAccountPage;

public class LoginPage extends PageObject{
	
	private static final String URL_LOGIN = "http://automationpractice.com/index.php?controller=authentication";
	
	public WebDriver getBrowser() {
		return browser;
	}

	public void setBrowser(WebDriver browser) {
		this.browser = browser;
	}

	public LoginPage () {
		super();
		browser.navigate().to(URL_LOGIN);
	}
	
	
	public void fillLogin(String email, String password) {
		browser.findElement(By.id("email")).sendKeys(email);
		browser.findElement(By.id("passwd")).sendKeys(password);
	}
	
	public MyAccountPage login() {
		browser.findElement(By.id("SubmitLogin")).click();
		return new MyAccountPage(browser);
	}
	
	public Boolean isLoginPage() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}
	
	public Boolean isInvalidEmail() {
		return browser.getPageSource().contains("Invalid email address.");
	}
	
	public Boolean isInvalidPassword() {
		return browser.getPageSource().contains("Invalid password.");
	}

}
