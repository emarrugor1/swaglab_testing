# author: Oliver Cogollo
# language: es

@UI @Catalog @Cart
Característica: Remover productos del carrito desde el catálogo

  Como usuario autenticado,
  quiero poder vaciar completamente el carrito desde el catálogo,
  para cancelar la compra si así lo deseo.

  @EmptyCart
  Escenario: CP-010-02 - Remover todos los productos del carrito
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Y agrega los productos al carrito:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    Y remueve el producto "Sauce Labs Backpack" del carrito
    Y remueve el producto "Sauce Labs Bike Light" del carrito
    Entonces el contador del carrito debe mostrar 0

