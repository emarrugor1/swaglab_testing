package starter.swaglabs.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import starter.swaglabs.ui.PaginaLogin;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CerrarSesion implements Task {

    public static CerrarSesion deLaAplicacion() {
        return instrumented(CerrarSesion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Volvemos al login, “borrando” la sesión
        actor.attemptsTo(
                Open.browserOn().the(PaginaLogin.class)
        );
    }
}
