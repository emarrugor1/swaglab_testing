package starter.swaglabs.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://www.saucedemo.com/v1/")
public class PaginaLogin extends PageObject {

    public static final Target CAMPO_USUARIO = Target.the("campo de usuario")
            .located(By.id("user-name"));

    public static final Target CAMPO_CONTRASENA = Target.the("campo de contraseña")
            .located(By.id("password"));

    public static final Target BOTON_LOGIN = Target.the("botón de inicio de sesión")
            .located(By.id("login-button"));
}
