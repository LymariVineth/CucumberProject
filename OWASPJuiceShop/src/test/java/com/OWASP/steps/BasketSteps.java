package com.OWASP.steps;

import org.testng.Assert;

import com.OWASP.log.Log;
import com.OWASP.utils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasketSteps extends Base{	
	String Address;
	String Payment;
	
	@Given("el visitante busca tres productos y los agrega {string} {string} {string} {string} {string}")
	public void el_visitante_busca_tres_productos_y_los_agrega(String item1, String item2, String item3, String address, String payment) {
		homeFactory.addItems(item1, item2, item3);
		Log.info("El usuario busca y agrega a la cesta los productos "+item1+", "+item2+" y "+item3+"...");
		Address=address;
		Payment=payment;	
		
	}
	@When("el visitante entra a la cesta")
	public void el_visitante_entra_a_la_cesta() {
	    homeFactory.goToBasket();
	    Log.info("El usuario selecciona la opcion del menu Basket..");
	}
	@When("el visitante da click en checkout")
	public void el_visitante_da_click_en_checkout() {
	   basketFactory.goToSelectAddress();
	   Log.info("El usuario hace click en boton checkout..");
	}
	@Then("el visistante selecciona el domicilio")
	public void el_visistante_selecciona_el_domicilio() {
	    basketFactory.selectAddres(Address);
	    basketFactory.goToSelectDelivery();
	    Log.info("El usuario selecciona un domicilio y continua..");
	}
	@Then("el visitante selecciona el tipo de envio")
	public void el_visitante_selecciona_el_tipo_de_envio() {
	    basketFactory.selectDelivery();
	    basketFactory.goToSelectPayment();
	    Log.info("El usuario selecciona una forma de envio y continua..");
	}
	@Then("el visitante selecciona el metodo de pago y realiza el pago")
	public void el_visitante_selecciona_el_metodo_de_pago_y_realiza_el_pago() {
		basketFactory.selectPayment(Payment);
		basketFactory.goToSummary();
		 Log.info("El usuario selecciona una forma de pago y continua..");
		basketFactory.buy();
		 Log.info("El usuario finaliza la orden..");
	}
	@Then("deberia mostrar el resumen de la compra")
	public void deberia_mostrar_el_resumen_de_la_compra() {
		String exitoso=basketFactory.OKPurchase();	
		Assert.assertEquals(exitoso, "Thank you for your purchase!","No se realizo la compra correctamente");
		 Log.info("El usuario visualiza el detalle de la compra confirmada..");
	}
	
	
	@Given("el visitante busca tres productos y los agrega {string} {string} {string} {string}")
	public void el_visitante_busca_tres_productos_y_los_agrega(String item1, String item2, String address, String payment) {
		homeFactory.addItems(item1, item2);
		Log.info("El usuario busca y agrega a la cesta los productos "+item1+", "+item2+"...");
		Address=address;
		Payment=payment;
	}
}
