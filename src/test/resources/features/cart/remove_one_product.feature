# author: Hennys Tous
# language: es

@UI @Catalog @Cart
Característica: Remover productos del carrito desde el catálogo

  Como usuario autenticado,
  quiero poder remover productos específicos del carrito desde el catálogo,
  para ajustar mi selección de compra.

  @Remove
  Escenario: CP-010-01 - Remover un producto entre varios
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Y agrega los productos al carrito:
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt  |
    Y remueve el producto "Sauce Labs Bike Light" del carrito
    Entonces el contador del carrito debe mostrar 2

