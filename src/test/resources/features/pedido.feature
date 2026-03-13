Feature: El cliente realiza un pedido completo en el restaurante y recibe confirmacion

  Scenario Outline: Registro exitoso de un pedido desde la seleccion de mesa hasta la confirmacion
    Given que el cliente accede a la aplicacion del restaurante Sofka
    When hace clic en Iniciar, selecciona la mesa numero "<mesa>" y agrega el primer producto disponible al carrito
    And registra la nota "<nota>" y confirma el pedido
    Then el sistema confirma exitosamente el pedido realizado

    Examples:
      | mesa | nota                    |
      | 3    | Sin cebolla, por favor  |
      | 7    |                         |
