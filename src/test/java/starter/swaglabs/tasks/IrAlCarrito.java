package starter.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.swaglabs.ui.PaginaCatalogo;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IrAlCarrito implements Task {

    public static IrAlCarrito deCompras() {
        return instrumented(IrAlCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaCatalogo.ICONO_CARRITO)
        );
    }
}

