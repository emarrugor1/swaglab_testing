package starter.swaglabs.questions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.swaglabs.ui.PaginaCatalogo;

public class ElBotonAgregarAlCarrito {

    private static final Logger LOG = LoggerFactory.getLogger(ElBotonAgregarAlCarrito.class);
    private static final By SELECTOR_BOTON = By.className("btn_inventory");

    @Subject("El botón #textoBoton es visible en todos los productos")
    public static Question<Boolean> esVisibleEnTodosLosProductos(String textoBoton) {
        return actor -> {
            ListOfWebElementFacades productos = PaginaCatalogo.TARJETAS_PRODUCTO.resolveAllFor(actor);
            validarProductosEncontrados(productos);

            LOG.info("Verificando {} productos con botón '{}'", productos.size(), textoBoton);
            return productos.stream().allMatch(producto ->
                    tieneBotonCon(producto, textoBoton));
        };
    }

    private static void validarProductosEncontrados(ListOfWebElementFacades productos) {
        if (productos.isEmpty()) {
            LOG.error("No se encontraron productos en el catálogo");
            throw new AssertionError("No se encontraron productos en el catálogo");
        }
    }

    private static boolean tieneBotonCon(WebElementFacade producto, String textoBoton) {
        try {
            WebElementFacade boton = producto.find(SELECTOR_BOTON);
            boolean coincideTexto = boton.getText().equalsIgnoreCase(textoBoton);
            boolean esVisible = boton.isDisplayed();

            if (!coincideTexto || !esVisible) {
                LOG.debug("Botón encontrado pero no cumple condiciones: " +
                        "texto coincide: {}, es visible: {}", coincideTexto, esVisible);
            }

            return coincideTexto && esVisible;
        } catch (Exception e) {
            LOG.debug("No se pudo encontrar el botón: {}", e.getMessage());
            return false;
        }
    }
}