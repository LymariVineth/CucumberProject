package com.OWASP.steps;

import java.util.List;

import org.testng.Assert;

import com.OWASP.utils.Base;
import com.OWASP.log.Log;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class RegisterSteps extends Base {
	
	@Given("Estando en la pantalla de home")
	public void estando_en_la_pantalla_de_home(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> loginData = dataTable.asLists();
		for (List<String> list : loginData) {
			driver.get(list.get(0));
			Log.info("Pantalla home cargada..");	
		}
	}


	@Given("Quitar el modal")
	public void quitar_el_modal() {    	    
			homeFactory.quitInitialModal();
			Log.info("Se quita la modal inicial...");
		
	}

	@Given("Entrando al  modulo de login")
	public void entrando_al_modulo_de_login() {
		
			homeFactory.goToLogin();
			Log.info("Se muestra pantalla de login...");
		
	}

	@Given("el visitante va al link de registro")
	public void el_visitante_va_al_link_de_registro() {
		
			
			loginFactory.goToRegister();
			Log.info("Se muestra pantalla de registro de usuario...");
		
	}
	
	@When("el visitante completa la informacion {string} {string} {string} {string}")
	public void el_visitante_completa_la_informacion(String email, String pass, String repass, String answer) {
	
			registerFactory.fillOutForm(email,pass,repass,answer);
			Log.info("El usuario captura informacion de registro...");
		
	}
	
	@And("el visitante hace click en registrarse")
	public void el_visitante_hace_click_en_registrarse() {
		
		
			registerFactory.clicRegister();
			Log.info("El visitante hace click en boton registrar...");
		
	}

	@Then("deberia tener la cuenta creada")
	public void deberia_tener_la_cuenta_creada() {
			String exitoso=loginFactory.OKRegister();
			Assert.assertEquals(exitoso, "Login","No se creo correctamente el usuario");
			Log.info("El visitante se registra correctamente...");
		
	}

}
