package com.sofka.pedidos.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaginaMenuPage extends PageObject {

    @FindBy(xpath = "(//button[contains(normalize-space(.), 'Agregar')])[1]")
    private WebElement primerBotonAgregar;

    @FindBy(xpath = "//a[@href='/client/cart']")
    private WebElement botonComprar;

    public void agregarPrimerProducto() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(primerBotonAgregar));
        primerBotonAgregar.click();
    }

    public void irAlCarrito() {
        botonComprar.click();
    }
}
