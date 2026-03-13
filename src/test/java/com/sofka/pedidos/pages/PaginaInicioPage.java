package com.sofka.pedidos.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaInicioPage extends PageObject {

    @FindBy(xpath = "//button[normalize-space()='Iniciar']")
    private WebElement botonIniciar;

    public void clicIniciar() {
        botonIniciar.click();
    }
}
