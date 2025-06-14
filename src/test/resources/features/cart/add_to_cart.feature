#author: Edwin
#language: es

  @UI @Catalog @Cart
  Característica: Agregar productos al carrito desde el catálogo

  Como usuario autenticado,
  quiero poder agregar productos al carrito directamente desde el catálogo,
  para seleccionar los productos que deseo comprar.

  @Successful
  Escenario: CP-009-00 - Visualización del botón "Add to cart" en cada tarjeta de producto
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Entonces cada producto listado debe mostrar un botón "Add to cart"

