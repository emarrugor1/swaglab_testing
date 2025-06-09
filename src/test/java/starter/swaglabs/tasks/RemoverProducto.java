package starter.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import starter.swaglabs.ui.PaginaCatalogo;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RemoverProducto implements Task {

    private final String nombreProducto;

    public RemoverProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static RemoverProducto delCarrito(String nombreProducto) {
        return instrumented(RemoverProducto.class, nombreProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target tarjeta = PaginaCatalogo.BOTON_DEL_PRODUCTO(nombreProducto);
        actor.attemptsTo(
                Click.on(tarjeta)
        );
    }
}
