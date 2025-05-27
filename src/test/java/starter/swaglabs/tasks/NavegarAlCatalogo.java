package starter.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.swaglabs.ui.PaginaCatalogo;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavegarAlCatalogo implements Task {

    public static NavegarAlCatalogo deLaTienda() {
        return instrumented(NavegarAlCatalogo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(PaginaCatalogo.class)
        );
    }
}
