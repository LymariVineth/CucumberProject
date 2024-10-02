package com.OWASP.steps;

import java.util.List;

import org.testng.Assert;

import com.OWASP.log.Log;
import com.OWASP.utils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressSteps extends Base{
	String contador;
	
	
	@Given("el visitante captura credenciales de usuario y se loguea")
	public void el_visitante_captura_credenciales_de_usuario_y_se_loguea(io.cucumber.datatable.DataTable dataTable) {
		homeFactory.quitInitialModal();		
		Log.info("Usuario quita la modal inicial..");
		homeFactory.goToLogin();
		Log.info("Pantalla Login cargada..");
		List<List<String>> loginData = dataTable.asLists();
		for (List<String> list : loginData) {
			loginFactory.fillOutForm(list.get(0), list.get(1));
			Log.info("Usuario captura email y contraseña..");
		}	
		loginFactory.clicLogin();
		Log.info("El usuario inicia sesión correctamente..");
	}
	
	@Given("el visitante va a la opcion del menu agregar direcciones")
	public void el_visitante_va_a_la_opcion_del_menu_agregar_direcciones() {
	    homeFactory.goToAddAddress();
	    Log.info("El usuario selecciona la opcion del menu Orders y Payment..");
	}
	@When("el visitante hace click para agregar una nueva direccion")
	public void el_visitante_hace_click_para_agregar_una_nueva_direccion() {
	    addressFactory.addAddress();
	    Log.info("El usuario selecciona la opcion del menu My saved address..");
	}
	@When("el visitante completa la informacion {string} {string} {string} {string} {string} {string} {string} {string}")
	public void el_visitante_completa_la_informacion(String id,String country, String name, String phone, String cp, String address, String city, String state) {
	    newAddressFactory.fillOutForm(country, name, phone, cp, address, city, state);
	    contador=id;
	    Log.info("El usuario captura el formulario para agregar un nuevo domicilio..");
	}
	@When("el visitante hace click en Agregar Direccion")
	public void el_visitante_hace_click_en_agregar_direccion() {
		newAddressFactory.agregarAddress();
		Log.info("El usuario agrega un domicilio..");
	}
	@Then("deberia registrarse la direccion correctamente")
	public void deberia_registrarse_la_direccion_correctamente() {		   
			String exitoso=addressFactory.okAddress(contador);	
			if(exitoso.equals("DireccionUNO")) {
				Assert.assertEquals(exitoso, "DireccionUNO","No se agrego la direccion correctamente");
				Log.info("El usuario guarda el domicilio uno..");
				
			}else {
				Assert.assertEquals(exitoso, "DireccionDOS","No se agrego la direccion correctamente");
				Log.info("El usuario guarda el domicilio dos..");
			}
			
		
	}
}
