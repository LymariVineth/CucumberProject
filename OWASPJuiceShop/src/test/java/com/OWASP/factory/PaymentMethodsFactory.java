package com.OWASP.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OWASP.utils.Base;

public class PaymentMethodsFactory extends Base{
	@FindBy(id = "mat-expansion-panel-header-0")
	protected WebElement btnAddCard;
	
	@FindBy(id = "mat-input-3")
	protected WebElement inputName;	
	
	@FindBy(id = "mat-input-4")
	protected WebElement inputCard;
	
	@FindBy(id = "mat-input-5")
	protected WebElement selMonth;
	
	@FindBy(id = "mat-input-6")
	protected WebElement selYear;
	
	@FindBy(id = "submitButton")
	protected WebElement btnGuardarPayment;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-saved-payment-methods/mat-card/app-payment-method/div/div[1]/mat-table/mat-row/mat-cell[2]")
	protected WebElement TableResultPaymentUno;
	
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-saved-payment-methods/mat-card/app-payment-method/div/div[1]/mat-table/mat-row[2]/mat-cell[2]")
	protected WebElement TableResultPaymentDos;
	
	public PaymentMethodsFactory(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addPayment() {
		esperaObjetoClickeable(btnAddCard);
		btnAddCard.click();
	}
	
	
	public void fillOutForm(String name, String card, String month, String year) {
		inputName.sendKeys(name);
		inputCard.sendKeys(card);
        Select select = new Select(selMonth);
        select.selectByValue(month);
        Select select2 = new Select(selYear);
        select2.selectByValue(year);				
	}
	
	public void agregarPago() {
		esperaObjetoClickeable(btnGuardarPayment);
		btnGuardarPayment.click();
	}
	
	public String okPayment(String contador) {
		String resultado=null;
		if(contador.equals("1")) {
			esperaObjeto(TableResultPaymentUno);
			resultado= TableResultPaymentUno.getText(); 
		}else {
			esperaObjeto(TableResultPaymentDos);
			resultado= TableResultPaymentDos.getText();  
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
