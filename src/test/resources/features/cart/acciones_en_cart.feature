# author: Maykel Rhenals
# language: es

@UI @Catalog @Cart
Característica: Acciones desde la vista del carrito

  Como usuario autenticado,
  quiero poder visitar el carrito y eliminar los productos desde el mismo.

  @CartViewRemove
  Escenario: CP-012-01 - Remover un producto desde la vista del carrito
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Y agrega los productos al carrito:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    Y visita el carrito de compras
    Y quita el producto "Sauce Labs Bike Light" del carrito
    Entonces los productos en el carrito deben ser:
      | Sauce Labs Backpack   |
    Y el contador del carrito debe mostrar 1


  @CartViewRemoveAll
  Escenario: CP-012-02 - Remover todos los productos desde la vista del carrito
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Y agrega los productos al carrito:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    Y visita el carrito de compras
    Y quita el producto "Sauce Labs Backpack" del carrito
    Y quita el producto "Sauce Labs Bike Light" del carrito
    Entonces los productos en el carrito deben ser:
      | |
    Y el contador del carrito debe mostrar 0
