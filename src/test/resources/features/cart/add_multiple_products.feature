# author: Hennys Tous
# language: es

@UI @Catalog @Cart
Característica: Agregar productos al carrito desde el catálogo

  Como usuario autenticado,
  quiero poder agregar productos al carrito directamente desde el catálogo,
  para seleccionar los productos que deseo comprar.

  @Multiple
  Escenario: CP-009-02 - Agregar múltiples productos al carrito
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Y agrega los productos al carrito:
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt  |
    Entonces el contador del carrito debe mostrar 3

