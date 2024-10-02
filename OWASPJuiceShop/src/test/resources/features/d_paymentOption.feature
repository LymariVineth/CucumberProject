@AddPaymentMethod
Feature: Agregar Metodos de Pago

  Background: 
    Given Estando en la pantalla de home
    |http://localhost:3000/#/|
    And el visitante captura credenciales de usuario y se loguea
    |test001@gmail.com|12345Qwe|


	
  Scenario: Agregar metodos de pago
    Given el visitante va a la opcion del menu agregar metodos de pago
    When el visitante hace click para agregar un nuevo metodo de pago
    And el visitante completa la informacion "<id>" "<Name>" "<NumTarjeta>" "<ExpMes>" "<ExpAnio>"
    And el visitante hace click en Agregar Metodo Pago
    Then deberia registrarse la tarjeta correctamente
    
  Examples:
  |id|Name|NumTarjeta|ExpMes|ExpAnio|
  |1|LymariAntuna|5425233430109903|4|2080|
  |2|VinethAntuna|4701322211111234|12|2081|
