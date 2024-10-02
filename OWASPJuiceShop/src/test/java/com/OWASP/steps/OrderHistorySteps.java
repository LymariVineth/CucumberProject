package com.OWASP.steps;

import org.testng.Assert;

import com.OWASP.log.Log;
import com.OWASP.utils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderHistorySteps extends Base{
	@Given("el visitante entra a la pantalla del historico de compra")
	public void el_visitante_entra_a_la_pantalla_del_historico_de_compra() {
	    homeFactory.goToOrderHistory();
	    Log.info("El usuario selecciona la opcion del menu Order History..");
	}
	
	@When("el visitante visualiza las compras y valida el pedido Uno {string} {string} {string}")
	public void el_visitante_visualiza_las_compras_y_valida_el_pedido_uno(String item1, String item2, String item3) {
		String exitoso=orderHistoryFactory.OKHistoryOrderOne(item1, item2, item3);
		Assert.assertEquals(exitoso, "Orden completa y correcta","La validacion de la orden uno no fue exitosa");
		Log.info("El usuario visualiza los productos del pedido Uno exitosamente..");
	}
	@When("el visitante valida el pedido dos {string} {string}")
	public void el_visitante_valida_el_pedido_dos(String item4, String item5) {
		String exitoso=orderHistoryFactory.OKHistoryOrderTwo(item4, item5);	
		Assert.assertEquals(exitoso, "Orden completa y correcta","La validacion de la orden dos no fue exitosa");
		Log.info("El usuario visualiza los productos del pedido Dos exitosamente..");
	}

	@Then("deberia tomar una captura de los pedidos")
	public void deberia_tomar_una_captura_de_los_pedidos() {
	    orderHistoryFactory.captureScreenshot("HistorialOrdenesCompra");
	    Log.info("Se realiza una captura de pantalla del historial de pedidos en folder ./Screenshots...");
	}
}
