package starter.swaglabs.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.swaglabs.questions.ContadorCarrito;
import starter.swaglabs.questions.ElBotonAgregarAlCarrito;
import starter.swaglabs.questions.ElBotonDelProducto;
import starter.swaglabs.questions.ProductosEnCarrito;
import starter.swaglabs.tasks.*;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


public class AgregarAlCarritoStepDefinitions {

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario ha iniciado sesión exitosamente")
    public void queElUsuarioHaIniciadoSesionExitosamente() {
        OnStage.theActorCalled("Usuario").attemptsTo(
                IniciarSesion.comoUsuarioEstandar()
        );
    }

    @Cuando("navega al catálogo de productos")
    public void navegaAlCatalogoDeProductos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarAlCatalogo.deLaTienda()
        );
    }

    @Entonces("cada producto listado debe mostrar un botón {string}")
    public void cadaProductoListadoDebeMostrarUnBoton(String textoBoton) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ElBotonAgregarAlCarrito.esVisibleEnTodosLosProductos(textoBoton)).isTrue()
        );
    }

    @Cuando("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarProducto.alCarrito(nombreProducto)
        );
    }

    @Entonces("el botón del producto {string} debe cambiar a {string}")
    public void elBotonDelProductoDebeCambiar(String producto, String textoBoton) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ElBotonAgregarAlCarrito.botonDelProductoEs(producto, textoBoton)).isTrue()
        );
    }

    @Entonces("el contador del carrito debe mostrar {int}")
    public void elContadorDelCarritoDebeMostrar(int cantidadEsperada) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ContadorCarrito.valor()).isEqualTo(cantidadEsperada)
        );
    }

    @Cuando("agrega los productos al carrito:")
    public void agregaLosProductosAlCarrito(io.cucumber.datatable.DataTable dataTable) {
        for (String producto : dataTable.asList()) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    AgregarProducto.alCarrito(producto)
            );
        }
    }

    @Cuando("remueve el producto {string} del carrito")
    public void remueveElProductoDelCarrito(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RemoverProducto.delCarrito(producto)
        );
    }

    @Cuando("visita el carrito de compras")
    public void visitaElCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IrAlCarrito.deCompras()
        );
    }

    @Entonces("los productos en el carrito deben ser:")
    public void losProductosEnElCarritoDebenSer(io.cucumber.datatable.DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ProductosEnCarrito.coincidenCon(dataTable.asList())).isTrue()
        );
    }

    @Cuando("quita el producto {string} del carrito")
    public void quitaElProductoDelCarrito(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RemoverProductoEnCarrito.conNombre(producto)
        );
    }

    @Cuando("navega al detalle del producto {string}")
    public void navegaAlDetalle(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IrAlDetalle.de(producto)
        );
    }

    @Cuando("regresa al catálogo")
    public void regresaAlCatalogo() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarAlCatalogo.deLaTienda()
        );
    }

    @Cuando("cierra la sesión")
    public void cerrarSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CerrarSesion.deLaAplicacion()
        );
    }

    @Cuando("inicia sesión nuevamente")
    public void iniciaSesionNuevamente() {
        OnStage.theActorCalled("Usuario").attemptsTo(
                IniciarSesion.comoUsuarioEstandar()
        );
    }

    @Entonces("el carrito debe estar vacío")
    public void carritoDebeEstarVacio() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ContadorCarrito.estaOculto()).isTrue()
        );
    }

    @Entonces("los botones deben decir REMOVE para:")
    public void botonesDelCatalogoDebenDecir(io.cucumber.datatable.DataTable dataTable) {
        // 1) Obtenemos los nombres de los productos que siguen en el carrito
        List<String> productosEnCarrito = dataTable.asList();

        // 2) Para cada uno, verificamos que su botón en el catálogo diga “Remove”
        productosEnCarrito.forEach(nombreProducto ->
                OnStage.theActorInTheSpotlight().should(
                        seeThat(
                                ElBotonDelProducto.tieneTexto(nombreProducto),
                                equalTo("REMOVE")
                        )
                )
        );
    }

}

