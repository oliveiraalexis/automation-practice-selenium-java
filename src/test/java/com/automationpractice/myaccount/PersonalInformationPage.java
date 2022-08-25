package com.automationpractice.myaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.PageObject;

public class PersonalInformationPage extends PageObject{
	
	private static final String URL_PERSONAL = "http://automationpractice.com/index.php?controller=identity";
	private WebElement tituloSocial;
	private String nome;
	private String sobrenome;
	private String email;
	private String nascimento;
	
	
	public PersonalInformationPage(WebDriver browser) {
		super(browser);
		browser.navigate().to(URL_PERSONAL);
	}
	
	public WebElement getTituloSocial() {
		System.out.println (browser.findElement(By.cssSelector(".radio .checked")));
		return browser.findElement(By.cssSelector(".radio .checked"));
	}
	
	public void setTituloSocial(WebElement tituloSocial) {
		//implementar
	}
	
	public String getName() {
		return browser.findElement(By.id("firstname")).getText();
	}
	
	public void setName(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return browser.findElement(By.id("lastname")).getText();
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public Boolean isPersonalInformationPage() {
		return browser.getCurrentUrl().equals(URL_PERSONAL);
	}
	
	public void salvar() {
		
	}

}
