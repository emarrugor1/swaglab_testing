package starter.swaglabs.stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.swaglabs.questions.ElBotonAgregarAlCarrito;
import starter.swaglabs.tasks.IniciarSesion;
import starter.swaglabs.tasks.NavegarAlCatalogo;

public class AgregarAlCarritoStepDefinitions {

    @Before
    public void configurarEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario ha iniciado sesión exitosamente")
    public void queElUsuarioHaIniciadoSesionExitosamente() {
        OnStage.theActorCalled("Usuario").attemptsTo(
                IniciarSesion.comoUsuarioEstandar()
        );
    }

    @Cuando("navega al catálogo de productos")
    public void navegaAlCatalogoDeProdutos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarAlCatalogo.deLaTienda()
        );
    }

    @Entonces("cada producto listado debe mostrar un botón {string}")
    public void cadaProductoListadoDebeMostrarUnBoton(String textoBoton) {
        System.out.println("Verificando botón '" + textoBoton + "' en todos los productos");
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ElBotonAgregarAlCarrito.esVisibleEnTodosLosProductos(textoBoton)).isTrue()
        );
    }
}
