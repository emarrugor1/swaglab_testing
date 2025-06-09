# author: Maykel Rhenals
# language: es

@UI @Catalog @Cart
Característica: Persistencia del carrito entre vistas

Como usuario autenticado,
quiero poder moverme entre varias zonas de la pagina sin perder la informacion del carrito.
y que se borre al cerrar la sesion.

 @CartPersistence
 Escenario: CP-013-01 - Mantener estado al navegar entre vistas
  Dado que el usuario ha iniciado sesión exitosamente
  Cuando navega al catálogo de productos
  Y agrega los productos al carrito:
    | Sauce Labs Backpack   |
    | Sauce Labs Bike Light |
  Y navega al detalle del producto "Sauce Labs Backpack"
  Y regresa al catálogo
  Entonces el contador del carrito debe mostrar 2

  @CartPersistence
  Escenario: CP-013-02 - Conservar estado al volver del carrito
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Y agrega los productos al carrito:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    Y visita el carrito de compras
    Y regresa al catálogo
    Entonces los botones deben decir REMOVE para:
      |Sauce Labs Backpack|
      |Sauce Labs Bike Light|

  @CartPersistence
  Escenario: CP-013-03 - Reiniciar carrito al cerrar sesión
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Y agrega los productos al carrito:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    Y cierra la sesión
    Y que el usuario ha iniciado sesión exitosamente
    Entonces el carrito debe estar vacío
    Y cada producto listado debe mostrar un botón "Add to cart"