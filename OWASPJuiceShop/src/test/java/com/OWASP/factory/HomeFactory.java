package com.OWASP.factory;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OWASP.utils.Base;

public class HomeFactory extends Base {

	@FindBy(id = "navbarAccount")
	protected WebElement btnAccount;
	
	@FindBy(id = "navbarLogoutButton")
	protected WebElement btnLogOut;
	
			
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]")
	protected WebElement btnBasket;
	
	
	
	@FindBy(xpath = "//*[@id=\"mat-menu-panel-3\"]/div/button[1]")
	protected WebElement menuOrderHistory;
	
	@FindBy(xpath = "//*[@id=\"mat-menu-panel-0\"]/div/button[2]")
	protected WebElement menuOrdersPayment;
	
	@FindBy(xpath = "//*[@id=\"mat-menu-panel-3\"]/div/button[3]")
	protected WebElement menuAddAddress;
	
	@FindBy(xpath = "//*[@id=\"mat-menu-panel-3\"]/div/button[4]")
	protected WebElement menuAddPayment;
	
	@FindBy(id = "navbarLoginButton")
	protected WebElement btnLogin;
	
	@FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]")
	protected WebElement btnDismiss;
	
	
	@FindBy(xpath = "//*[@id='searchQuery']/span/mat-icon[2]")
	protected WebElement btnSearch;
	
	@FindBy(id = "mat-input-0")
	protected WebElement inputSearch;	
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile/div/mat-card/div[2]/button")
	protected WebElement btnAddItem;

	public HomeFactory(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void quitInitialModal() {
		esperaObjeto(btnDismiss);
		btnDismiss.click();
	}

	public void goToLogin() {
		esperaObjeto(btnAccount);
		btnAccount.click();
		esperaObjeto(btnLogin);
		btnLogin.click();
	}
	
	public Boolean okLogin() {
		esperaObjeto(btnAccount);
		btnAccount.click();
		
		return btnLogOut.isDisplayed();  
	}
	
	public void goToAddAddress() {
		esperaObjeto(btnAccount);
		btnAccount.click();
		esperaObjeto(menuOrdersPayment);
		menuOrdersPayment.click();
		esperaObjeto(menuAddAddress);
		menuAddAddress.click();
	}
	
	public void goToAddPayment() {
		esperaObjeto(btnAccount);
		btnAccount.click();
		esperaObjeto(menuOrdersPayment);
		menuOrdersPayment.click();
		esperaObjeto(menuAddPayment);
		menuAddPayment.click();
	}
	
	public void goToOrderHistory() {
		esperaObjeto(btnAccount);
		btnAccount.click();
		esperaObjeto(menuOrdersPayment);
		menuOrdersPayment.click();
		esperaObjeto(menuOrderHistory);
		menuOrderHistory.click();
	}
	
	public void addItems(String productoUno, String productoDos, String productoTres) {
		esperaObjeto(btnSearch);	
				
		for(int i=0;i<3;i++) {
			if(i==0) {
				btnSearch.click();	
				inputSearch.sendKeys(productoUno);
				inputSearch.sendKeys(Keys.ENTER);
			}
			else if(i==1) {
				btnSearch.click();	
				inputSearch.sendKeys(productoDos);
				inputSearch.sendKeys(Keys.ENTER);
			}
			else {
				btnSearch.click();	
				inputSearch.sendKeys(productoTres);
				inputSearch.sendKeys(Keys.ENTER);
			}
			esperaObjetoVisible(btnAddItem);
			btnAddItem.click();
			inputSearch.clear();
		}
		
	}
	
	public void addItems(String productoUno, String productoDos) {
		esperaObjeto(btnSearch);	
				
		for(int i=0;i<2;i++) {
			if(i==0) {
				btnSearch.click();	
				inputSearch.sendKeys(productoUno);
				inputSearch.sendKeys(Keys.ENTER);
			}
			else {
				btnSearch.click();	
				inputSearch.sendKeys(productoDos);
				inputSearch.sendKeys(Keys.ENTER);
			}
			esperaObjetoVisible(btnAddItem);
			btnAddItem.click();
			inputSearch.clear();
		}
		
	}
	
	public void goToBasket() {
		esperaObjeto(btnBasket);
		btnBasket.click();		
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
