package com.sofka.pedidos.stepdefinitions;

import com.sofka.pedidos.pages.PaginaCarritoPage;
import com.sofka.pedidos.pages.PaginaInicioPage;
import com.sofka.pedidos.pages.PaginaMenuPage;
import com.sofka.pedidos.pages.PaginaMesasPage;
import com.sofka.pedidos.pages.PaginaOrdenPage;
import com.sofka.pedidos.util.Constantes;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdenStepDefinition {

    @Managed
    private WebDriver driver;

    private PaginaInicioPage paginaInicio;
    private PaginaMesasPage paginaMesas;
    private PaginaMenuPage paginaMenu;
    private PaginaCarritoPage paginaCarrito;
    private PaginaOrdenPage paginaOrden;

    @Given("que el cliente accede a la aplicacion del restaurante Sofka")
    public void elClienteAccedeALaAplicacion() {
        paginaInicio.openUrl(Constantes.URL_BASE);
    }

    @When("hace clic en Iniciar, selecciona la mesa numero {string} y agrega el primer producto disponible al carrito")
    public void haceClicEnIniciarSeleccionaMesaYAgregaProducto(String numeroDeMesa) {
        paginaInicio.clicIniciar();
        paginaMesas.seleccionarMesa(numeroDeMesa);
        paginaMenu.agregarPrimerProducto();
        paginaMenu.irAlCarrito();
    }

    @And("registra la nota {string} y confirma el pedido")
    public void registraLaNotaYConfirmaElPedido(String nota) {
        paginaCarrito.ingresarNotaAdicional(nota);
        paginaCarrito.confirmarPedido();
    }

    @Then("el sistema confirma exitosamente el pedido realizado")
    public void elSistemaConfirmaElPedido() {
        assertThat(paginaOrden.mensajeConfirmacionEsVisible()).isTrue();
    }
}
