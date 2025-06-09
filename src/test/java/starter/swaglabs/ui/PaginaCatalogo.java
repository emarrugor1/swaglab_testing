package starter.swaglabs.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://www.saucedemo.com/v1/inventory.html")
public class PaginaCatalogo extends PageObject {

    public static final Target TARJETAS_PRODUCTO = Target.the("tarjetas de productos")
            .located(By.className("inventory_item"));

    public static final Target NOMBRE_PRODUCTO(String nombre) {
        return Target.the("nombre del producto " + nombre)
                .located(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name' and text()='" + nombre + "']"));
    }

    public static final Target BOTON_DEL_PRODUCTO(String nombre) {
        return Target.the("botón del producto " + nombre)
                .located(By.xpath("//div[@class='inventory_item' and .//div[@class='inventory_item_name' and text()='" + nombre + "']]//button"));
    }

    public static final Target CONTADOR_CARRITO = Target.the("contador del carrito")
            .located(By.className("shopping_cart_badge"));

    public static final Target ICONO_CARRITO = Target.the("ícono del carrito")
            .located(By.className("shopping_cart_link"));
}

