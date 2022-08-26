package com.automationpractice.myaccount;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.automationpractice.login.LoginPage;

public class MyAccountTest {
	
	private LoginPage paginaDeLogin;
	private MyAccountPage paginaMinhaConta;
	private PersonalInformationPage paginaInformacoesPessoais;
	
	@BeforeEach
	public void before() {
		this.paginaDeLogin = new LoginPage();
		this.paginaDeLogin.fillLogin("teste99@gmail.com", "teste99");
		this.paginaMinhaConta = paginaDeLogin.login();
	}
	
	@AfterEach
	public void after() {
		this.paginaMinhaConta.fechar();
	}
	
	@Test
	public void deveriaEstarNaPaginaMinhaConta() {
		Assertions.assertTrue(this.paginaMinhaConta.isMyAccountPage());
	}
	
	@Test
	public void deveriaExibirNomeUsuarioLogado() {
		Assertions.assertTrue(this.paginaMinhaConta.getLoggedUsername().equals("Alexis Oliveira"));
	}
	
	@Test
	public void deveriaExibirBotaoLogout() {
		Assertions.assertTrue(this.paginaMinhaConta.getLogoutButton());
	}
	
	@Test
	public void deveriaAbrirPaginaDeInformacoesPessoais() {
		this.paginaInformacoesPessoais = this.paginaMinhaConta.clickPersonalInformationButton();
		Assertions.assertTrue(this.paginaInformacoesPessoais.isPersonalInformationPage());
	}
}
