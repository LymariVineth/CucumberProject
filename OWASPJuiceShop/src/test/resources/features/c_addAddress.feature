@AddAddress
Feature: Agregar Direcciones

  Background: 
    Given Estando en la pantalla de home
    |http://localhost:3000/#/|
    And el visitante captura credenciales de usuario y se loguea
    |test001@gmail.com|12345Qwe|


	
  Scenario: Agregar direcciones validas
    Given el visitante va a la opcion del menu agregar direcciones
    When el visitante hace click para agregar una nueva direccion
    And el visitante completa la informacion "<id>" "<Country>" "<Name>" "<Phone>" "<CP>" "<Address>" "<City>" "<State>"
    And el visitante hace click en Agregar Direccion
    Then deberia registrarse la direccion correctamente
    
  Examples:
  |id|Country|Name|Phone|CP|Address|City|State|
  |1|Mexico|DireccionUNO|8158748596|34217|Prueba|Durango|Durango|
  |2|Mexico|DireccionDOS|8158748596|66607|Prueba|Monterrey|NL|
