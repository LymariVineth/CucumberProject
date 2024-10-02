@Register
Feature: Crear nuevos clientes

  Background: 
    Given Estando en la pantalla de home
    |http://localhost:3000/#/|
    And Quitar el modal
    And Entrando al  modulo de login

  Scenario: Registro de usuarios
    Given el visitante va al link de registro
    When el visitante completa la informacion "<Email>" "<Password>" "<RePassword>" "<Answer>"
    And el visitante hace click en registrarse
    Then deberia tener la cuenta creada
    
  Examples:
  |Email|Password|RePassword|Answer|
  |test001@gmail.com|12345Qwe|12345Qwe|Respuesta|
  |test002@gmail.com|12345Qwe|12345Qwe|Respuesta|