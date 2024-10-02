package com.OWASP.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OWASP.utils.Base;

public class RegisterFactory extends Base {

	/**
	 * Web Elements
	 */

	@FindBy(how = How.ID, using = "emailControl")
	WebElement inputEmail;

	@FindBy(how = How.ID, using = "passwordControl")
	WebElement inputPass;

	@FindBy(how = How.ID, using = "repeatPasswordControl")
	WebElement inputRePass;

	@FindBy(how = How.XPATH, using = "//*[@id=\"mat-select-value-3\"]/span")
	WebElement SelQuestion;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mat-option-4\"]/span")
	WebElement optionQuestion;

	@FindBy(how = How.ID, using = "securityAnswerControl")
	WebElement inputAnswer;
	
	@FindBy(how = How.ID, using = "registerButton")
	WebElement btnRegister;

	public RegisterFactory(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillOutForm(String email, String pass, String repass, String Answer) {
		inputEmail.sendKeys(email);
		inputPass.sendKeys(pass);
		inputRePass.sendKeys(repass);
		SelQuestion.click();
		optionQuestion.click();
		inputAnswer.sendKeys(Answer);
	}

	public void clicRegister() {
		esperaObjetoClickeable(btnRegister);
		btnRegister.click();
	}
	
	public void esperaObjeto(WebElement locator) {
		WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(10));
		espera.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public void esperaObjetoClickeable(WebElement locator) {
		WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(10));
		espera.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
