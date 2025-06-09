package starter.swaglabs.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Visibility;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import starter.swaglabs.ui.PaginaCatalogo;

public class ContadorCarrito {

    private static final By SELECTOR_CONTADOR = By.className("shopping_cart_badge");
    private static final Log log = LogFactory.getLog(ContadorCarrito.class);

    @Subject("el contador del carrito")
    public static Question<Integer> valor() {
        return actor -> {
            if (!PaginaCatalogo.CONTADOR_CARRITO.resolveFor(actor).isVisible()) {
                return 0;
            }
            String texto = PaginaCatalogo.CONTADOR_CARRITO.resolveFor(actor).getText();
            return Integer.parseInt(texto);
        };
    }

    @Subject("El icono del carrito está oculto")
    public static Question<Boolean> estaOculto() {
        // simplemente negamos el resultado de estaVisible()
        return actor -> !Visibility.of(PaginaCatalogo.CONTADOR_CARRITO)
                .answeredBy(actor);
    }
}

