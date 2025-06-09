# author: Oliver Cogollo
# language: es

@UI @Catalog @Cart
Característica: Ver productos en el carrito

  Como usuario autenticado,
  quiero poder visualizar los productos en el carrito,
  para confirmar que he agregado los correctos.

  @VerifyCart
  Escenario: CP-011-01 - Visualizar los productos agregados en el carrito
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Y agrega los productos al carrito:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    Y visita el carrito de compras
    Entonces los productos en el carrito deben ser:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

