# author: Hennys Tous
# language: es

@UI @Catalog @Cart
Característica: Agregar productos al carrito desde el catálogo

  Como usuario autenticado,
  quiero poder agregar productos al carrito directamente desde el catálogo,
  para seleccionar los productos que deseo comprar.

  @Successful
  Escenario: CP-009-01 - Agregar un solo producto al carrito
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Entonces el botón del producto "Sauce Labs Backpack" debe cambiar a "Remove"
    Y el contador del carrito debe mostrar 1

