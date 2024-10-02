package com.OWASP.factory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OWASP.utils.Base;

public class OrderHistoryFactory extends Base{
	String screenShotId = new SimpleDateFormat("YYYYMMddhhmmss").format(new Date());
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-order-history/mat-card/div/mat-card-title")
	protected WebElement titleHistory;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-order-history/mat-card/div/div/div[2]/div/mat-table/mat-row[1]/mat-cell[1]")
	protected WebElement itemOne;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-order-history/mat-card/div/div/div[2]/div/mat-table/mat-row[2]/mat-cell[1]")
	protected WebElement itemTwo;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-order-history/mat-card/div/div/div[2]/div/mat-table/mat-row[3]/mat-cell[1]")
	protected WebElement itemThree;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-order-history/mat-card/div/div/div[1]/div/mat-table/mat-row[1]/mat-cell[1]")
	protected WebElement itemFour;
	
	@FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-order-history/mat-card/div/div/div[1]/div/mat-table/mat-row[2]/mat-cell[1]")
	protected WebElement itemFive;
	
		
	public OrderHistoryFactory(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public String OKHistoryOrderOne(String item1, String item2, String item3) {
		esperaObjeto(titleHistory);
		String one = itemOne.getText();
		String two= itemTwo.getText();
		String three= itemThree.getText();
		int i=0;
		if (one.equals(item1)) {
		    i=i+1;
		}
		if (two.equals(item2)) {
			i=i+1;
		}
        if (three.equals(item3)) {	
			i=i+1;
		}
	
		if(i==3) 
			return "Orden completa y correcta";
		else
			return "Productos no coinciden con Orden 1";
		
	}
	
	public String OKHistoryOrderTwo(String item4, String item5) {
		esperaObjeto(titleHistory);
		String four = itemFour.getText();
		String five= itemFive.getText();
		int i=0;
		if (four.equals(item4)) {
		    i=i+1;
		} 
        if (five.equals(item5)) {
			i=i+1;
		}
	
		if(i==2) 
			return "Orden completa y correcta";
		else
			return "Productos no coinciden con Orden 2";
	}
	
	public void esperaObjeto(WebElement locator) {
		WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(10));
		espera.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public void captureScreenshot(String Test) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+Test+"_"+screenShotId+".jpg");
		try {
			FileUtils.copyFile(sourceFile, destFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
