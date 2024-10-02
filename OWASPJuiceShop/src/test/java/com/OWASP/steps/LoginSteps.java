package com.OWASP.steps;


import java.util.List;

import org.testng.Assert;

import com.OWASP.log.Log;
import com.OWASP.utils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends Base {

		@Given("el visitante va al link de login")
		public void el_visitante_va_al_link_de_login() {
			homeFactory.goToLogin();
			Log.info("Pantalla Login cargada..");
		}

		@When("el visitante captura credenciales de usuario")
		public void el_visitante_captura_credenciales_de_usuario(io.cucumber.datatable.DataTable dataTable) {
			List<List<String>> loginData = dataTable.asLists();
			for (List<String> list : loginData) {
				loginFactory.fillOutForm(list.get(0), list.get(1));
				Log.info("El usuario captura email y contraseña..");
			}			
		}
		
		@When("el visitante hace click en Login")
		public void el_visitante_hace_click_en_login() {
		    loginFactory.clicLogin();
		    Log.info("El usuario inicia sesión..");
		}

		@Then("deberia iniciar sesion correctamente")
		public void deberia_iniciar_sesion_correctamente() {
			Boolean exitoso=homeFactory.okLogin();			
			Assert.assertTrue(exitoso, "Login no se hizo correctamente");
			Log.info("Pantalla home cargada después de iniciar sesión..");
		}
		
		
	
		@Then("deberia mostrar un mensaje de error")
		public void deberia_mostrar_un_mensaje_de_error() {
			String Noexitoso=loginFactory.FailLogin();			
			Assert.assertEquals(Noexitoso, "Invalid email or password.","Se logueo correctamente el usuario o hay otro error diferente");
			Log.info("Se muestra mensaje de error de credenciales incorrectas..");
		}

}
