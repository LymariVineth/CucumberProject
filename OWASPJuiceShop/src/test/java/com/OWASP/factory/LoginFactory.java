package com.OWASP.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OWASP.utils.Base;

public class LoginFactory extends Base {

	@FindBy(id = "email")
	protected WebElement inputEmail;

	@FindBy(id = "password")
	protected WebElement inputPass;
	
	@FindBy(id = "loginButton")
	protected WebElement btnLogin;

	@FindBy(xpath = "//h1[contains(text(),'Login')]")
	protected WebElement h1Login;
	
	@FindBy(linkText = "Not yet a customer?")
	protected WebElement lnkRegister;
	
	@FindBy(xpath = "//*[@class='error ng-star-inserted']")
	protected WebElement msgError;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]/span[1]/span[1]")
	protected WebElement msgOK;
	
	
	public LoginFactory(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void goToRegister() {
		esperaObjeto(lnkRegister);
		lnkRegister.click();
	}
	
	public String OKRegister() {
		esperaObjetoVisible(h1Login);
		return h1Login.getText();
	}
	

	public void fillOutForm(String user, String pass) {
		inputEmail.sendKeys(user);
		inputPass.sendKeys(pass);
	}

	public void clicLogin() {
		esperaObjeto(btnLogin);
		btnLogin.click();
	}
	
	public String FailLogin() {
		esperaObjetoVisible(msgError);
		return msgError.getText();  //
	}
	

	
	public void esperaObjeto(WebElement locator) {
		WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(10));
		espera.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void esperaObjetoVisible(WebElement locator) {
		WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(10));
		espera.until(ExpectedConditions.visibilityOf(locator));
	}
}
