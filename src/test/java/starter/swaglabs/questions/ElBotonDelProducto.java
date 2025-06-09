package starter.swaglabs.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import starter.swaglabs.ui.PaginaCatalogo;

public class ElBotonDelProducto {

    @Subject("El texto del botón Add/Remove para el producto")
    public static Question<String> tieneTexto(String nombreProducto) {
        return Text.of(PaginaCatalogo.BOTON_DEL_PRODUCTO(nombreProducto));
    }
}
