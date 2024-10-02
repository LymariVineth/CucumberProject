package com.OWASP.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OWASP.utils.Base;

public class AddressFactory extends Base{
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-saved-address/div/app-address/mat-card/div/button")
	protected WebElement btnAddAddress;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-saved-address/div/app-address/mat-card/mat-table/mat-row[1]/mat-cell[1]")
	protected WebElement TableResultAddressUno;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-saved-address/div/app-address/mat-card/mat-table/mat-row[2]/mat-cell[1]")
	protected WebElement TableResultAddressDos;
	
	public AddressFactory(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addAddress() {
		esperaObjetoClickeable(btnAddAddress);
		btnAddAddress.click();
	}
	
	public String okAddress(String contador) {
		String resultado=null;
		if(contador.equals("1")) {
			esperaObjeto(TableResultAddressUno);
			resultado= TableResultAddressUno.getText(); 
		}else {
			esperaObjeto(TableResultAddressDos);
			resultado= TableResultAddressDos.getText();  
		}
		return resultado;
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
