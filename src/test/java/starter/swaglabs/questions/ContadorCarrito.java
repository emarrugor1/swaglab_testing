package starter.swaglabs.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.By;
import starter.swaglabs.ui.PaginaCatalogo;

public class ContadorCarrito {

    private static final By SELECTOR_CONTADOR = By.className("shopping_cart_badge");

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
}

