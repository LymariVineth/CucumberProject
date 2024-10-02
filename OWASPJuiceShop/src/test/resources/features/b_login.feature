@Login
Feature: Inicio de sesion de usuarios

  Background: 
    Given Estando en la pantalla de home
    |http://localhost:3000/#/|
    And Quitar el modal

	@LoginExitoso
  Scenario: Login de usuarios Exitoso
    Given el visitante va al link de login
    When el visitante captura credenciales de usuario
    |test001@gmail.com|12345Qwe|
    And el visitante hace click en Login
    Then deberia iniciar sesion correctamente
 

  @LoginNoExitoso
  Scenario: Login de usuarios No Exitoso
    Given el visitante va al link de login
    When el visitante captura credenciales de usuario
    |test001@gmail.com|12345Qweq|
    And el visitante hace click en Login
    Then deberia mostrar un mensaje de error

  