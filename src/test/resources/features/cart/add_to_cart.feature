@UI @Catalog @Cart
Feature: Agregar productos al carrito desde el catálogo

  Scenario: CP-009-01 - Visualización del botón "Add to cart" en cada tarjeta de producto
    Given que el usuario ha iniciado sesión exitosamente
    When navega al catálogo de productos
    Then cada producto listado debe mostrar un botón "Add to cart"
