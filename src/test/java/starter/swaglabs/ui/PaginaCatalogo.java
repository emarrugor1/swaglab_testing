package starter.swaglabs.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://www.saucedemo.com/v1/inventory.html")
public class PaginaCatalogo extends PageObject {

    public static final Target TARJETAS_PRODUCTO = Target.the("tarjetas de productos")
            .located(By.className("inventory_item"));

}