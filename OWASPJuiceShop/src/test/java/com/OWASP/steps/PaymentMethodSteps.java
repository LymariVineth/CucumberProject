package com.OWASP.steps;

import org.testng.Assert;

import com.OWASP.log.Log;
import com.OWASP.utils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentMethodSteps extends Base {
	String contador;
	
	@Given("el visitante va a la opcion del menu agregar metodos de pago")
	public void el_visitante_va_a_la_opcion_del_menu_agregar_metodos_de_pago() {
	    homeFactory.goToAddPayment();
	    Log.info("El usuario selecciona la opcion del menu My payment Option..");
	}
	@When("el visitante hace click para agregar un nuevo metodo de pago")
	public void el_visitante_hace_click_para_agregar_un_nuevo_metodo_de_pago() {
	    paymentMethodsFactory.addPayment();
	    Log.info("Pantalla agregar metodo de pago cargada..");
	}
	@When("el visitante completa la informacion {string} {string} {string} {string} {string}")
	public void el_visitante_completa_la_informacion(String id, String Name, String NumTarjeta, String ExpMes, String ExpAnio) {
		paymentMethodsFactory.fillOutForm(Name, NumTarjeta, ExpMes, ExpAnio);
	    contador=id;
	    Log.info("El usuario captura la informacion de la tarjeta correctamente..");
	}
	@When("el visitante hace click en Agregar Metodo Pago")
	public void el_visitante_hace_click_en_agregar_metodo_pago() {
	    paymentMethodsFactory.agregarPago();
	    Log.info("El usuario hace click en boton agregar..");
	}
	@Then("deberia registrarse la tarjeta correctamente")
	public void deberia_registrarse_la_tarjeta_correctamente() {
		String exitoso=paymentMethodsFactory.okPayment(contador);	
		if(exitoso.equals("LymariAntuna")) {
			Assert.assertEquals(exitoso, "LymariAntuna","No se agrego el metodo de pago correctamente");
			Log.info("La tarjeta Uno se agrega correctamente..");
			
		}else {
			Assert.assertEquals(exitoso, "VinethAntuna","No se agrego el metodo de pago correctamente");
			Log.info("La tarjeta Dos se agrega correctamente..");
		}
	}
}
