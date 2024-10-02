@OrderHistory
Feature: Revisar historial de compras

  Background: 
    Given Estando en la pantalla de home
    |http://localhost:3000/#/|
    And el visitante captura credenciales de usuario y se loguea
    |test001@gmail.com|12345Qwe|


	
  Scenario: Historial de compras
    Given el visitante entra a la pantalla del historico de compra
    When el visitante visualiza las compras y valida el pedido Uno "<ProductoUno>" "<ProductoDos>" "<ProductoTres>"
    And el visitante valida el pedido dos "<ProductoCuatro>" "<ProductoCinco>"
    Then deberia tomar una captura de los pedidos
    Examples:
    |ProductoUno|ProductoDos|ProductoTres|ProductoCuatro|ProductoCinco|
    |Apple Juice (1000ml)|Banana Juice (1000ml)|OWASP Juice Shop T-Shirt|Carrot Juice (1000ml)|Lemon Juice (500ml)|
    