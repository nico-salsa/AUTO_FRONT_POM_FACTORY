package com.sofka.pedidos.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaginaOrdenPage extends PageObject {

    @FindBy(xpath = "//*[contains(normalize-space(.), 'Pedido confirmado')]")
    private WebElement mensajePedidoConfirmado;

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Ver estado')]")
    private WebElement botonVerEstado;

    @FindBy(xpath = "//button[normalize-space()='Volver al menu']")
    private WebElement botonVolverAlMenu;

    public boolean mensajeConfirmacionEsVisible() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mensajePedidoConfirmado));
        return mensajePedidoConfirmado.isDisplayed();
    }
}
