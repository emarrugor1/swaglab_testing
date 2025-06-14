package starter.swaglabs.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import starter.swaglabs.ui.PaginaCatalogo;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IrAlDetalle implements Task {

    private final String nombreProducto;

    public IrAlDetalle(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static IrAlDetalle de(String nombreProducto) {
        return instrumented(IrAlDetalle.class, nombreProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Click en el título del producto en el catálogo
                Click.on(PaginaCatalogo.NOMBRE_PRODUCTO(nombreProducto))
        );
    }
}
