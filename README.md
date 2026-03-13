# Pruebas Automatizadas - Pedidos Restaurante Sofka (POM + Page Factory)

Proyecto de pruebas automatizadas E2E para el flujo de pedidos del restaurante Sofka, implementado con el patrón **Page Object Model (POM)** + **Page Factory** (`@FindBy`).

## Stack Tecnológico

| Tecnología | Versión |
|---|---|
| Java | 16 |
| Serenity BDD | 4.2.1 |
| Cucumber | 7.20.1 |
| JUnit 5 | 5.11.4 |
| Gradle | 8.14 |
| Selenium WebDriver | (incluido en Serenity) |

## Estructura del Proyecto

```
src/test/
├── java/com/sofka/pedidos/
│   ├── pages/                    # Page Objects con @FindBy
│   │   ├── PaginaInicioPage.java
│   │   ├── PaginaMesasPage.java
│   │   ├── PaginaMenuPage.java
│   │   ├── PaginaCarritoPage.java
│   │   └── PaginaOrdenPage.java
│   ├── stepdefinitions/          # Glue de Cucumber (Given/When/Then)
│   │   └── OrdenStepDefinition.java
│   ├── runners/                  # Runner JUnit 5 + Cucumber
│   │   └── TestRunnerPedido.java
│   └── util/
│       └── Constantes.java       # URL base y constantes
└── resources/
    ├── features/
    │   └── pedido.feature        # Escenarios Gherkin
    ├── serenity.conf             # Configuración WebDriver + Chrome
    └── serenity.properties       # Nombre del proyecto
```

## Patrón POM + Page Factory

Cada página de la aplicación tiene su propia clase Page Object que:
- Extiende `PageObject` de Serenity BDD.
- Usa `@FindBy` para declarar los elementos web (XPaths).
- Expone métodos de acción (`clicIniciar()`, `seleccionarMesa()`, etc.).
- Serenity inicializa automáticamente los elementos vía Page Factory.

Los **Step Definitions** orquestan las llamadas a los Page Objects según los pasos Gherkin.

## Escenario de Prueba (HDU-01)

Flujo completo de pedido: Inicio → Selección de mesa → Menú → Carrito → Confirmación.

| Ejemplo | Mesa | Nota adicional |
|---|---|---|
| 1 | 3 | Sin cebolla, por favor |
| 2 | 7 | *(vacía)* |

## Prerrequisitos

- **Java 16** instalado y configurado en `JAVA_HOME`.
- **Google Chrome** instalado.
- La aplicación del restaurante corriendo en `http://localhost:5173`.

## Ejecución

```bash
# Ejecutar tests y generar reporte Serenity
./gradlew clean test aggregate
```

En Windows:
```bash
gradlew.bat clean test aggregate
```

## Reporte

Al finalizar la ejecución, el reporte Serenity con screenshots se genera en:

```
target/site/serenity/index.html
```

Abrirlo en el navegador para ver los resultados detallados, pasos ejecutados y capturas de pantalla.
