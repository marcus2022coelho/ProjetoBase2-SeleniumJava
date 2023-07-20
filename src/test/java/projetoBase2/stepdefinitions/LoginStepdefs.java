package projetoBase2.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projetoBase2.factory.DriverFactory;
import projetoBase2.object.Cliente;
import projetoBase2.pages.BasePage;
import projetoBase2.pages.LoginPage;

import java.util.List;

public class LoginStepdefs {
    private static WebDriver driver;

    @Given("acesso a tela de login")
    public void acessoATelaDeLoginagora() {
        driver = DriverFactory.getDriver();
        new BasePage(driver).load( "/login_page.php");

    }

    @When("informar usuario {string}")
    public void informarUsuarioAdministrator(String username) {
        new LoginPage(driver).informarUsuario(username);

    }

    @And("informar senha {string}")
    public void informarSenhaAbc(String password) {
        new LoginPage(driver).informarSenha(password);
    }

    @And("tocar no parâmetro confirmar")
    public void tocarNoParâmetroConfirmar() {
        new LoginPage(driver).confirmar();
    }

    @Then("o sistema deve realizar o login e exibir a tela do mantis com o usuário logado")
    public void oSistemaDeveRealizarOLoginEExibirATelaDoMantisComOUsuárioLogado() {
        String LoggerUserName = new LoginPage(driver).validaUsuarioLogadoSucesso();
        String expectedUserName = "administrator";
        Assert.assertEquals(LoggerUserName, expectedUserName);

    }

//    @DataTableType
//    public Cliente teste (List<String> seila){
//        return  new Cliente(seila.get(0),seila.get(1));
//    }

//    @When("Informar usuario")
//    public void informarDadosAcesso(Cliente cliente) {
//        new LoginPage(driver).informarUsuario(cliente.getUsername());
//    }

    @And("Informar senha")
    public void informarDadosAcesso1(DataTable dataTable) {
        List<String> lista1 = dataTable.row(0);
        new LoginPage(driver).informarSenha(lista1.get(1));


    }
}

