package com.automationpractice.login;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.automationpractice.myaccount.MyAccountPage;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	private MyAccountPage paginaMinhaConta;
	
	@BeforeEach
	public void before() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void after() {
		this.paginaDeLogin.fechar();
	}
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		this.paginaDeLogin.fillLogin("teste99@gmail.com", "teste99");
		this.paginaMinhaConta = this.paginaDeLogin.login();
		
		Assertions.assertFalse(this.paginaDeLogin.isLoginPage());
		Assertions.assertTrue(this.paginaMinhaConta.isMyAccountPage());
		Assertions.assertEquals("Alexis Oliveira", this.paginaMinhaConta.getLoggedUsername());
	}
	
	@Test
	public void naoDeveriaEfetuarLoginComEmailInvalido() {
		this.paginaDeLogin.fillLogin("fulanogmail.com", "pass");
		this.paginaDeLogin.login();
		
		Assertions.assertTrue(this.paginaDeLogin.isLoginPage());
		Assertions.assertTrue(this.paginaDeLogin.isInvalidEmail());
	}
	
	@Test
	public void naoDeveriaEfetuarLoginComSenhaInvalida() {
		this.paginaDeLogin.fillLogin("fulano@gmail.com", "pass");
		this.paginaDeLogin.login();
		
		Assertions.assertTrue(this.paginaDeLogin.isLoginPage());
		Assertions.assertTrue(this.paginaDeLogin.isInvalidPassword());
	}
	

}
