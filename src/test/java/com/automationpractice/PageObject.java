package com.automationpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
	
protected WebDriver browser;
	
	public PageObject() { //construtor sem parâmetro
		System.setProperty("webdriver.chrome.driver","src/test/resources/ChromeDriver/chromedriver.exe");
		this.browser = new ChromeDriver();
		this.browser.manage().timeouts()
		.implicitlyWait(5, TimeUnit.SECONDS) //Esperar 5 segundos antes de lançar erro por não encontrar um elemento
		.pageLoadTimeout(10, TimeUnit.SECONDS); //Esperar uma página carregar por 10 segundos antes de lancar erro
	}
	
	public PageObject(WebDriver browser) { //construtor com parâmetro
		System.setProperty("webdriver.chrome.driver","src/test/resources/ChromeDriver103.0.5060.53/chromedriver.exe");
		this.browser = browser;
	}
	
	public void fechar() {
		this.browser.quit();
	}

}
