@Basket
Feature: Agregar Productos al carrito y pagarlos

  Background: 
    Given Estando en la pantalla de home
    |http://localhost:3000/#/|
    And el visitante captura credenciales de usuario y se loguea
    |test001@gmail.com|12345Qwe|


	@CheckoutUno
  Scenario: Agregar tres productos al carrito y pagarlos
    Given el visitante busca tres productos y los agrega "<ProductoUno>" "<ProductoDos>" "<ProductoTres>" "<Address>" "<Payment>"
    When el visitante entra a la cesta
    And el visitante da click en checkout
    Then el visistante selecciona el domicilio 
    And el visitante selecciona el tipo de envio
    And el visitante selecciona el metodo de pago y realiza el pago
    Then deberia mostrar el resumen de la compra
    
  Examples:
  |ProductoUno|ProductoDos|ProductoTres|Address|Payment|
  |Apple Juice|Banana|T-Shirt|2|1|
  
  	@CheckoutUDos
  Scenario: Agregar dos productos al carrito y pagarlos
    Given el visitante busca tres productos y los agrega "<ProductoUno>" "<ProductoDos>" "<Address>" "<Payment>"
    When el visitante entra a la cesta
    And el visitante da click en checkout
    Then el visistante selecciona el domicilio 
    And el visitante selecciona el tipo de envio
    And el visitante selecciona el metodo de pago y realiza el pago
    Then deberia mostrar el resumen de la compra
    
  Examples:
  |ProductoUno|ProductoDos|Address|Payment|
  |Carrot|Lemon|2|1|