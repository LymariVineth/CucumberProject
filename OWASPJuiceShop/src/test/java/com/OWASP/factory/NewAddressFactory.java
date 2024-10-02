package com.OWASP.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OWASP.utils.Base;

public class NewAddressFactory extends Base{
	@FindBy(xpath = "//*[@placeholder='Please provide a country.']")
	protected WebElement inputCountry;
	
	
	@FindBy(xpath = "//*[@placeholder='Please provide a name.']")
	protected WebElement inputName;
	
	@FindBy(xpath = "//*[@placeholder='Please provide a mobile number.']")
	protected WebElement inputPhone;
	
	@FindBy(xpath = "//*[@placeholder='Please provide a ZIP code.']")
	protected WebElement inputCP;
	
	@FindBy(xpath = "//*[@placeholder='Please provide an address.']")
	protected WebElement inputAddress;
	
	@FindBy(xpath = "//*[@placeholder='Please provide a city.']")
	protected WebElement inputCity;
	
	@FindBy(xpath = "//*[@placeholder='Please provide a state.']")
	protected WebElement inputState;
	
	@FindBy(id = "submitButton")
	protected WebElement BtnAdd;
	
	
	public NewAddressFactory(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillOutForm(String country, String name, String phone, String cp, String address, String city, String state) {
		inputCountry.sendKeys(country);
		inputName.sendKeys(name);
		inputPhone.sendKeys(phone);
		inputCP.sendKeys(cp);
		inputAddress.sendKeys(address);
		inputCity.sendKeys(city);
		inputState.sendKeys(state);	
		
	}
	
	public void agregarAddress() {
		esperaObjetoClickeable(BtnAdd);
		BtnAdd.click();
	}
	
	public void esperaObjetoClickeable(WebElement locator) {
		WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(10));
		espera.until(ExpectedConditions.elementToBeClickable(locator));
	}


}
