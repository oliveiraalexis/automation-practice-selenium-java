package com.automationpractice.myaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.PageObject;

public class PersonalInformationPage extends PageObject{
	
	private static final String URL_PERSONAL = "http://automationpractice.com/index.php?controller=identity";
	private WebElement tituloSocial;
	private WebElement nome;
	private WebElement sobrenome;
	private WebElement email;
	private WebElement diaNascimento;
	private WebElement mesNascimento;
	private WebElement anoNascimento;
	
	
	PersonalInformationPage(WebDriver browser) {
		super(browser);
		this.nome = browser.findElement(By.id("firstname"));
		this.sobrenome = browser.findElement(By.id("lastname"));
		this.email = browser.findElement(By.id("email"));
		this.diaNascimento = browser.findElement(By.id("uniform-days"));
		this.mesNascimento = browser.findElement(By.id("uniform-months"));
		this.anoNascimento = browser.findElement(By.id("uniform-years"));
		this.tituloSocial = browser.findElement(By.cssSelector(".radio .checked"));
	}
	
	public WebElement getTituloSocial() {
		return browser.findElement(By.cssSelector(".radio .checked"));
	}
	
	public void setTituloSocial(WebElement tituloSocial) {
		//implementar
	}
	
	public String getName() {
		return browser.findElement(By.id("firstname")).getText();
	}
	
	public void setName(WebElement nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return browser.findElement(By.id("lastname")).getText();
	}
	
	public void setSobrenome(WebElement sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public Boolean isPersonalInformationPage() {
		return browser.getCurrentUrl().equals(URL_PERSONAL);
	}
	
	public void salvar() {
		
	}

}
