# author: Hennys Tous
# language: es

@UI @Catalog @Cart
Característica: Agregar productos al carrito desde el catálogo

  Como usuario autenticado,
  quiero poder agregar productos al carrito directamente desde el catálogo,
  para seleccionar los productos que deseo comprar.

  @Duplicate
  Escenario: CP-009-03 - Evitar productos duplicados en el carrito
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Entonces el contador del carrito debe mostrar 1

