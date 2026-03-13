package com.sofka.pedidos.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaCarritoPage extends PageObject {

    @FindBy(xpath = "//textarea[@placeholder='Notas para este plato...']")
    private WebElement campoNotasPlato;

    @FindBy(xpath = "//textarea[@placeholder='Ej: sin picante, enviar cubiertos extras...']")
    private WebElement campoNotasAdicionales;

    @FindBy(xpath = "//button[normalize-space()='Confirmar pedido']")
    private WebElement botonConfirmarPedido;

    public void ingresarNotaAdicional(String nota) {
        if (nota != null && !nota.isEmpty()) {
            campoNotasAdicionales.sendKeys(nota);
        }
    }

    public void confirmarPedido() {
        botonConfirmarPedido.click();
    }
}
