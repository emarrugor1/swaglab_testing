# Serenity JUnit Starter project

Get started quickly with Serenity BDD and JUnit 5 using Page Objects and Action Classes with this simple starter project. 

## Get the code

Click on the [Use This Template button](https://github.com/serenity-bdd/serenity-junit-starter/generate) to create a new project in your own Github account. 

Or simply [download a zip](https://github.com/serenity-bdd/serenity-junit-starter/archive/master.zip) file.

## Running the tests under Maven

The template project comes with both Maven and Gradle build scripts. To run the tests with Maven, open a command window and run:

  ./mvnw clean verify

## Use Gradle

For GRADLE, pen a command window and run:

  ./gradlew test 

## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!

## Guía para añadir nuevos casos de prueba

Esta guía te ayudará a añadir nuevos casos de prueba al proyecto de automatización utilizando Serenity BDD con Cucumber y el patrón Screenplay, especialmente si eres principiante.

### 1. Estructura del Proyecto

El proyecto sigue una arquitectura basada en el patrón Screenplay con la siguiente estructura:

- **Features**: Archivos `.feature` con escenarios Gherkin que describen el comportamiento esperado del sistema en lenguaje natural.
- **Step Definitions**: Clases Java que implementan los pasos definidos en Gherkin y los traducen a acciones que puede entender el sistema.
- **Tasks**: Clases que representan acciones o tareas completas que realiza un actor (como iniciar sesión o añadir un producto al carrito).
- **Questions**: Clases que verifican el estado actual del sistema y permiten realizar aserciones.
- **UI**: Clases que definen los elementos de la interfaz con los que interactuará la automatización.

#### 1.1. Entendiendo el patrón Screenplay

El patrón Screenplay se basa en el concepto de **Actores** que desempeñan **Tareas** (Tasks) e interactúan con la aplicación. Luego, los actores pueden hacer **Preguntas** (Questions) sobre el estado de la aplicación para verificar que se ha comportado como se esperaba.

Los componentes principales son:

- **Actor**: Representa al usuario que interactúa con el sistema.
- **Abilities**: Capacidades que el actor posee (como navegar en un navegador).
- **Tasks**: Acciones que el actor realiza (como iniciar sesión).
- **Questions**: Preguntas que el actor hace sobre el estado del sistema.
- **Interactions**: Interacciones a bajo nivel con la interfaz de usuario.

#### 1.2. ¿Dónde encontrar los archivos?

- Los archivos `.feature` se encuentran en: `src/test/resources/features/`
- Las clases Java se encuentran en: `src/test/java/starter/swaglabs/`
  - Step Definitions: `starter/swaglabs/stepdefinitions/`
  - Tasks: `starter/swaglabs/tasks/`
  - Questions: `starter/swaglabs/questions/`
  - UI: `starter/swaglabs/ui/`

### 2. Proceso para añadir un nuevo caso de prueba

#### 2.1. Crear o modificar un archivo feature

Los archivos feature contienen escenarios escritos en lenguaje Gherkin, que es fácil de leer y entender. Cada escenario describe un caso de prueba específico.

**¿Qué es Gherkin?** Es un lenguaje específico para describir comportamientos utilizando palabras clave como `Given` (Dado), `When` (Cuando) y `Then` (Entonces).

**Ubicación**: Los archivos feature se encuentran en `src/test/resources/features/`. Puedes:
- Crear un nuevo archivo `.feature` para una nueva funcionalidad.
- Añadir un nuevo escenario a un archivo existente para probar otra característica de la misma funcionalidad.

**Estructura de un escenario**:
1. **Given (Dado)**: Establece el contexto o precondiciones.
2. **When (Cuando)**: Define la acción principal que se va a probar.
3. **Then (Entonces)**: Verifica el resultado esperado.
4. También puedes usar **And (Y)** para añadir pasos adicionales a cualquiera de las secciones anteriores.

**Ejemplo paso a paso**:

1. Abre o crea un archivo `.feature` en `src/test/resources/features/cart/`
2. Añade etiquetas (tags) para categorizar tu prueba (ej: `@UI @Cart`)
3. Define un escenario con los pasos que debe seguir la prueba

```gherkin
#author: Edwin
#language: es

@UI @Catalog @Cart
Característica: Agregar productos al carrito desde el catálogo

  Como usuario autenticado,
  quiero poder agregar un producto al carrito directamente desde el catálogo,
  para seleccionar los productos que deseo comprar.

  @Successful
  Escenario: CP-009-01 - Visualización del botón "Add to cart" en cada tarjeta de producto
    Dado que el usuario ha iniciado sesión exitosamente
    Cuando navega al catálogo de productos
    Entonces cada producto listado debe mostrar un botón "Add to cart"

```

**Consejos**:
- Utiliza identificadores únicos para cada escenario (ej: CP-009-02).
- Usa parámetros entre comillas dobles para datos variables (ej: "Sauce Labs Backpack").
- Mantén los escenarios cortos y enfocados en una sola funcionalidad.
- Las etiquetas (tags) como `@UI`, `@Cart` son útiles para organizar y ejecutar conjuntos específicos de pruebas.

#### 2.2. Implementar los Step Definitions

Los Step Definitions son métodos Java que implementan los pasos descritos en el archivo feature. Cada paso en Gherkin debe tener un método correspondiente en una clase de Step Definitions.

**¿Qué son los Step Definitions?** Son clases Java que contienen métodos anotados con `@Given`, `@When` o `@Then`, y que implementan la lógica necesaria para cada paso del escenario.

**Ubicación**: Los Step Definitions se encuentran en `src/test/java/starter/swaglabs/stepdefinitions/`. Para un nuevo conjunto de funcionalidades, puedes:
- Crear una nueva clase de Step Definitions (ej: `AgregarAlCarritoStepDefinitions.java`).
- Añadir nuevos métodos a una clase existente si los pasos están relacionados con la misma funcionalidad.

**Ejemplo paso a paso**:

1. Crea o abre una clase de Step Definitions en `src/test/java/starter/swaglabs/stepdefinitions/`
2. Añade métodos para cada paso del escenario con las anotaciones correspondientes (@Dado, @Cuando, @Entonces)
3. Implementa la lógica para cada paso utilizando el patrón Screenplay

```java
// Ejemplo de implementación de nuevos pasos en AgregarAlCarritoStepDefinitions.java
package starter.swaglabs.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.swaglabs.tasks.AgregarProductoAlCarrito;
import starter.swaglabs.questions.ElIconoDelCarrito;
import starter.swaglabs.questions.ElBotonDelProducto;

public class AgregarAlCarritoStepDefinitions {
    
    // Los pasos existentes ya están implementados...
    
    @Cuando("selecciona añadir al carrito el producto {string}")
    public void seleccionaAnadirAlCarritoElProducto(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            AgregarProductoAlCarrito.conNombre(nombreProducto)
        );
    }
    
    @Entonces("el icono del carrito debe mostrar {string} producto")
    public void elIconoDelCarritoDebeMostrar(String cantidad) {
        OnStage.theActorInTheSpotlight().should(
            seeThat(ElIconoDelCarrito.muestraCantidad(), equalTo(cantidad))
        );
    }
    
    @Entonces("el botón del producto debe cambiar a {string}")
    public void elBotonDelProductoDebeCambiarA(String textoBoton) {
        OnStage.theActorInTheSpotlight().should(
            seeThat(ElBotonDelProducto.tieneTexto(textoBoton))
        );
    }
}
```

**Consejos**:
- Utiliza `OnStage.theActorInTheSpotlight()` para referirte al actor actual.
- Las anotaciones en español (@Dado, @Cuando, @Entonces) corresponden a Given, When, Then.
- Los parámetros entre llaves `{string}` en las anotaciones capturan los valores entre comillas del escenario.
- Utiliza aserciones con `should(seeThat())` para verificar condiciones.

**Importante**: Para que estos métodos funcionen, necesitarás importar:
```java
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
```

#### 2.3. Crear las Tasks necesarias

Las Tasks son clases que representan acciones completas que el actor realiza en la aplicación, como "Agregar un producto al carrito".

**¿Qué son las Tasks?** Son clases Java que implementan la interfaz `Task` y encapsulan una serie de acciones o interacciones que un actor realiza para lograr un objetivo específico.

**Ubicación**: Las Tasks se encuentran en `src/test/java/starter/swaglabs/tasks/`.

**Ejemplo paso a paso**:

1. Crea una nueva clase Task en `src/test/java/starter/swaglabs/tasks/` (ej: `AgregarProductoAlCarrito.java`)
2. Implementa la interfaz `Task` y el método `performAs()`
3. Define un método estático para crear instancias de la tarea

```java
// Ejemplo de implementación de una nueva Task: AgregarProductoAlCarrito.java
package starter.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.swaglabs.ui.PaginaCatalogo;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarProductoAlCarrito implements Task {

    private final String nombreProducto;

    public AgregarProductoAlCarrito(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static AgregarProductoAlCarrito conNombre(String nombreProducto) {
        return instrumented(AgregarProductoAlCarrito.class, nombreProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(PaginaCatalogo.BOTON_AGREGAR_AL_CARRITO.of(nombreProducto))
        );
    }
}
```

**Consejos**:
- Usa el método estático `instrumented()` para crear instancias de la tarea.
- Pasa los parámetros necesarios al constructor.
- En el método `performAs()`, utiliza `actor.attemptsTo()` para ejecutar las acciones.
- Mantén las tareas pequeñas y enfocadas en un solo objetivo.

#### 2.4. Crear las Questions necesarias

Las Questions son clases que consultan el estado actual de la aplicación y permiten realizar aserciones sobre este estado.

**¿Qué son las Questions?** Son clases Java que implementan la interfaz `Question<T>` y devuelven información sobre el estado actual de la aplicación.

**Ubicación**: Las Questions se encuentran en `src/test/java/starter/swaglabs/questions/`.

**Ejemplo paso a paso**:

1. Crea una nueva clase Question en `src/test/java/starter/swaglabs/questions/` (ej: `ElIconoDelCarrito.java`)
2. Implementa la interfaz `Question<T>` y el método `answeredBy()`
3. Define un método estático para crear instancias de la pregunta

```java
// Ejemplo de implementación de una nueva Question: ElIconoDelCarrito.java
package starter.swaglabs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import starter.swaglabs.ui.PaginaEncabezado;

public class ElIconoDelCarrito {

    @Subject("El contador del carrito muestra la cantidad esperada")
    public static Question<String> muestraCantidad() {
        return actor -> Text.of(PaginaEncabezado.CONTADOR_CARRITO)
                            .viewedBy(actor)
                            .asString();
    }
}
```

**Consejos**:
- Utiliza la anotación `@Subject` para describir lo que hace la pregunta.
- Devuelve un tipo específico que luego puedas comparar en tus aserciones.
- Usa los métodos de Serenity como `Text.of()` para obtener información de los elementos de la UI.

#### 2.5. Definir los elementos de UI necesarios

Los elementos de UI son representaciones de los componentes de la interfaz de usuario con los que interactuará la automatización.

**¿Qué son los elementos de UI?** Son definiciones de los elementos de la interfaz utilizando la clase `Target` de Serenity, que permite localizarlos en la página.

**Ubicación**: Los elementos de UI se definen en clases en `src/test/java/starter/swaglabs/ui/`.

**Ejemplo paso a paso**:

1. Crea o modifica una clase UI en `src/test/java/starter/swaglabs/ui/` (ej: `PaginaCatalogo.java`)
2. Define los elementos usando la clase `Target` y selectores CSS o XPath

```java
// Ejemplo de definición de elementos UI en PaginaCatalogo.java
package starter.swaglabs.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://www.saucedemo.com/v1/inventory.html")
public class PaginaCatalogo extends PageObject {

    // Elementos existentes...
    
    public static final Target BOTON_AGREGAR_AL_CARRITO = Target.the("botón agregar al carrito para {0}")
            .locatedBy("//div[contains(text(),'{0}')]/ancestor::div[@class='inventory_item']//button[contains(@class,'btn_inventory')]");
            
    public static final Target BOTON_PRODUCTO = Target.the("botón del producto {0}")
            .locatedBy("//div[contains(text(),'{0}')]/ancestor::div[@class='inventory_item']//button[contains(@class,'btn_inventory')]");
}

// Nuevo archivo: PaginaEncabezado.java
package starter.swaglabs.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaEncabezado extends PageObject {

    public static final Target CONTADOR_CARRITO = Target.the("contador del carrito")
            .located(By.cssSelector(".shopping_cart_badge"));
}
```

**Consejos**:
- Organiza los elementos en clases que representen páginas o componentes de la aplicación.
- Usa descripciones claras en `Target.the()` para facilitar la lectura de los informes.
- Utiliza parámetros `{0}`, `{1}`, etc. en `locatedBy()` para crear selectores dinámicos.
- Conoce los diferentes tipos de selectores:
  - CSS: `.class`, `#id`, `tag[attribute=value]`
  - XPath: `//tag[@attribute='value']`, `//tag[contains(text(),'value')]`

### 3. Ejecutar y depurar las pruebas

Una vez implementados todos los componentes, es hora de ejecutar y verificar que las pruebas funcionan correctamente.

#### 3.1. Ejecutar todas las pruebas

Para ejecutar todas las pruebas del proyecto:

```bash
./gradlew test
```

#### 3.2. Ejecutar pruebas específicas por etiquetas (tags)

Para ejecutar solo las pruebas con ciertas etiquetas:

```bash
./gradlew test -Dcucumber.filter.tags="@UI and @Cart"
```

#### 3.3. Verificar los informes generados

Después de ejecutar las pruebas, Serenity genera informes detallados:

1. Navega a la carpeta `target/site/serenity/`
2. Abre el archivo `index.html` en un navegador para ver el informe completo

#### 3.4. Depurar problemas comunes

Si encuentras problemas al ejecutar tus pruebas, verifica:

1. **Localizadores incorrectos**: Asegúrate de que los selectores CSS o XPath identifiquen correctamente los elementos.
2. **Tiempos de espera**: Si la aplicación es lenta, puedes necesitar ajustar los tiempos de espera en `serenity.conf`.
3. **Errores de compilación**: Verifica que todas las clases necesarias estén importadas correctamente.
4. **Pasos no implementados**: Asegúrate de que todos los pasos en el archivo feature tengan su correspondiente método en Step Definitions.
5. **Errores de lógica**: Revisa que la lógica implementada en Tasks y Questions sea correcta.

### 4. Buenas prácticas

#### 4.1. Organización del código

- **Naming**: Utiliza nombres descriptivos para tus clases y métodos.
  - Tasks: Usa verbos (AgregarProductoAlCarrito, NavegarAlCatalogo)
  - Questions: Usa frases que describan lo que verifican (ElIconoDelCarrito, ElBotonDelProducto)
  - UI: Usa nombres de páginas o componentes (PaginaCatalogo, PaginaEncabezado)

- **Paquetes**: Organiza tus clases en paquetes según su función:
  - `tasks`: Acciones que realiza el actor
  - `questions`: Verificaciones del estado
  - `ui`: Elementos de la interfaz
  - `stepdefinitions`: Implementaciones de los pasos Gherkin

#### 4.2. Reusabilidad

- Crea Tasks y Questions genéricas que puedan reutilizarse en diferentes escenarios.
- Extrae lógica común a métodos o clases utilitarias.
- Utiliza parámetros para hacer que tus Tasks y Questions sean más flexibles.

#### 4.3. Legibilidad

- Escribe escenarios claros y concisos en Gherkin.
- Utiliza anotaciones `@Subject` en Questions para mejorar los informes.
- Añade comentarios explicativos en código complejo.

#### 4.4. Mantenibilidad

- Mantén las Tasks pequeñas y enfocadas en un solo objetivo.
- Centraliza la definición de elementos UI para facilitar su actualización.
- Evita duplicar código entre diferentes Step Definitions.

### 5. Recursos adicionales

- [Documentación oficial de Serenity BDD](https://serenity-bdd.github.io/docs/guide/user_guide_intro)
- [Cucumber Reference](https://cucumber.io/docs/cucumber/api/)
- [Screenplay Pattern](https://serenity-js.org/handbook/design/screenplay-pattern/)
- [Selector CSS](https://www.w3schools.com/cssref/css_selectors.asp)
- [XPath Tutorial](https://www.w3schools.com/xml/xpath_intro.asp)

Con esta guía, deberías tener todo lo necesario para empezar a añadir nuevos casos de prueba al proyecto utilizando Serenity BDD, Cucumber y el patrón Screenplay. ¡Buena suerte con tus pruebas automatizadas!
