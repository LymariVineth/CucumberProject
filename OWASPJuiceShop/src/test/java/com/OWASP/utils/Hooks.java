package com.OWASP.utils;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OWASP.factory.AddressFactory;
import com.OWASP.factory.BasketFactory;
import com.OWASP.factory.HomeFactory;
import com.OWASP.factory.LoginFactory;
import com.OWASP.factory.NewAddressFactory;
import com.OWASP.factory.OrderHistoryFactory;
import com.OWASP.factory.PaymentMethodsFactory;
import com.OWASP.factory.RegisterFactory;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hooks extends Base {
	
	 static int z;
     static String reportName = new SimpleDateFormat("YYYYMMddhhmmss").format(new Date()); 

	@Before
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
		
		homeFactory = new HomeFactory(driver);
		loginFactory = new LoginFactory(driver);
		registerFactory = new RegisterFactory(driver);
		addressFactory= new AddressFactory(driver);
		newAddressFactory= new NewAddressFactory(driver);
		paymentMethodsFactory=new PaymentMethodsFactory(driver);		
		basketFactory=new BasketFactory(driver);
		orderHistoryFactory=new OrderHistoryFactory(driver);
	}


	@After
	public static void tearDown(Scenario scenario) {	
		
			if (scenario.isFailed()) {
				String screenName = scenario.getName().replaceAll(" ", "_");
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", screenName);
			}
				
		if(driver!=null) {
			driver.quit();
		}
	}
	


}
