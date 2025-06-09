package starter.swaglabs.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import starter.swaglabs.ui.PaginaCarrito;

import java.util.List;
import java.util.stream.Collectors;

@Subject("los productos en el carrito coinciden con los esperados")
public class ProductosEnCarrito {

    public static Question<Boolean> coincidenCon(List<String> nombresEsperados) {
        return actor -> {
            List<String> nombresEnCarrito = PaginaCarrito.NOMBRES_PRODUCTOS.resolveAllFor(actor).stream()
                    .map(WebElementFacade::getText)
                    .map(String::trim)
                    .collect(Collectors.toList());



            // Si la lista de esperados es nula o sólo contiene celdas vacías, esperamos carrito vacío
            if (nombresEsperados == null
                    || nombresEsperados.stream().allMatch(s -> s == null || s.trim().isEmpty())) {
                return nombresEnCarrito.isEmpty();
            }

            return nombresEnCarrito.containsAll(nombresEsperados) && nombresEsperados.containsAll(nombresEnCarrito);
        };
    }
}
