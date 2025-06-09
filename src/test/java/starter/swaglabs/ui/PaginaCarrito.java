package starter.swaglabs.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaCarrito extends PageObject {

    public static final Target NOMBRES_PRODUCTOS = Target.the("nombres de los productos en el carrito")
            .located(By.className("inventory_item_name"));
}
