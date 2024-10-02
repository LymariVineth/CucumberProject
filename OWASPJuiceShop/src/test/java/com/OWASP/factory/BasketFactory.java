package com.OWASP.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OWASP.utils.Base;

public class BasketFactory extends Base {
	
	
	@FindBy(id = "checkoutButton")
	protected WebElement btnCheckOut;
	
	@FindBy(xpath = "//*[@id='card']/app-address/mat-card/mat-table/mat-row[1]/mat-cell[1]//child::label")
	protected WebElement checkAddress1;
	
	@FindBy(xpath = "//*[@id='card']/app-address/mat-card/mat-table/mat-row[2]/mat-cell[1]//child::label")
	protected WebElement checkAddress2;
	
	@FindBy(xpath = "//*[@id='card']/app-address/mat-card/button")
	protected WebElement btnContinueEnvio;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-delivery-method/mat-card/div[3]/mat-table/mat-row[1]/mat-cell[2]")
	protected WebElement checkDelivery;
	
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-delivery-method/mat-card/div[4]/button[2]")
	protected WebElement btnContinuePayment;

	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-payment/mat-card/div/app-payment-method/div/div[1]/mat-table/mat-row[1]/mat-cell[1]//child::label")
	protected WebElement checkPayment1;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-payment/mat-card/div/app-payment-method/div/div[1]/mat-table/mat-row[2]/mat-cell[1]//child::label")
	protected WebElement checkPayment2;
	
	
	
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-payment/mat-card/div/div[2]/button[2]")
	protected WebElement btnContinueDetails;
	
	@FindBy(id = "checkoutButton")
	protected WebElement btnBuy;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-order-completion/mat-card/div[1]/div/mat-card[1]/div/h1")
	protected WebElement h1OkPurchase;
	
	
	
	public BasketFactory(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToSelectAddress() {
		esperaObjetoClickeable(btnCheckOut);
		btnCheckOut.click();
	}
	
	public void selectAddres(String address) {
		esperaObjetoClickeable(checkAddress1);
		if(address.equals("1")) {
			checkAddress1.click();
		}
		else {
			checkAddress2.click();
		}
	}
	
	public void goToSelectDelivery() {
		esperaObjetoClickeable(btnContinueEnvio);
		btnContinueEnvio.click();
	}
	
	public void selectDelivery() {
		esperaObjetoClickeable(checkDelivery);
		checkDelivery.click();
	}
	
	public void goToSelectPayment() {
		esperaObjetoClickeable(btnContinuePayment);
		btnContinuePayment.click();
	}
	
	public void selectPayment(String payment) {
		esperaObjetoClickeable(checkPayment1);
		if(payment.equals("1")) {			
			checkPayment1.click();
		}
		else {
			checkPayment2.click();
		}
		
		
	}

	public void goToSummary() {
		esperaObjetoClickeable(btnContinueDetails);
		btnContinueDetails.click();
		
	}
	
	public void buy() {
		esperaObjetoClickeable(btnBuy);
		btnBuy.click();
	}
	
	public String OKPurchase() {
		esperaObjeto(h1OkPurchase);
		return h1OkPurchase.getText();
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
