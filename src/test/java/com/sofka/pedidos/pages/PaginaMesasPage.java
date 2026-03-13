package com.sofka.pedidos.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaginaMesasPage extends PageObject {

    public void seleccionarMesa(String numeroDeMesa) {
        String xpath = "//button[.//div[normalize-space()='" + numeroDeMesa + "']]";
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement botonMesa = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        botonMesa.click();
    }
}
