/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starter.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.actions.Click;
import starter.swaglabs.ui.PaginaCarrito;

/**
 *
 * @author mayke
 */
public class RemoverProductoEnCarrito implements Task {
    private final String nombreProducto;

    public RemoverProductoEnCarrito(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static RemoverProductoEnCarrito conNombre(String nombreProducto) {
        return instrumented(RemoverProductoEnCarrito.class, nombreProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaCarrito.BOTON_REMOVER_EN_CARRITO.of(nombreProducto))
        );
    }
}
