package starter.swaglabs.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class PaginaCarrito extends PageObject {

    public static final Target NOMBRES_PRODUCTOS = Target.the("nombres de los productos en el carrito")
            .located(By.className("inventory_item_name"));

    public static final Target BOTON_REMOVER_EN_CARRITO = Target.the("Remove para {0} en carrito")
            .locatedBy(
                    "//div[contains(@class,'cart_item') " +
                            "  and .//div[@class='inventory_item_name' and normalize-space(text())='{0}']" +
                            "]//button[contains(@class,'cart_button') and normalize-space(text())='REMOVE']"
            );
}

