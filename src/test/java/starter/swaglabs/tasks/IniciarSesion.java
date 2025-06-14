package starter.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.swaglabs.ui.PaginaLogin;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesion implements Task {

    private final String usuario;
    private final String contrasena;

    public IniciarSesion(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static IniciarSesion comoUsuarioEstandar() {
        return instrumented(IniciarSesion.class, "standard_user", "secret_sauce");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(PaginaLogin.CAMPO_USUARIO),
                Enter.theValue(contrasena).into(PaginaLogin.CAMPO_CONTRASENA),
                Click.on(PaginaLogin.BOTON_LOGIN)
        );
    }
}
