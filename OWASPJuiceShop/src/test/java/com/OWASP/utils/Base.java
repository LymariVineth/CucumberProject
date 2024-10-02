package com.OWASP.utils;

import org.openqa.selenium.WebDriver;

import com.OWASP.factory.AddressFactory;
import com.OWASP.factory.BasketFactory;
import com.OWASP.factory.HomeFactory;
import com.OWASP.factory.LoginFactory;
import com.OWASP.factory.NewAddressFactory;
import com.OWASP.factory.OrderHistoryFactory;
import com.OWASP.factory.PaymentMethodsFactory;
import com.OWASP.factory.RegisterFactory;

public class Base {
	
	

	protected static WebDriver driver;

	protected static int TIME_OUT = 10;

	protected static HomeFactory homeFactory;

	protected static RegisterFactory	registerFactory;

	protected  static LoginFactory	loginFactory;
	
	protected static AddressFactory addressFactory;
	
	protected static NewAddressFactory newAddressFactory;
	
	protected static PaymentMethodsFactory paymentMethodsFactory;
	
	protected static BasketFactory basketFactory;
	
	protected static OrderHistoryFactory orderHistoryFactory;
}
