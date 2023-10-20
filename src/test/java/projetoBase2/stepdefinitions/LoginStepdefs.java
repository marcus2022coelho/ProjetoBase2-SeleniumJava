package projetoBase2.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projetoBase2.Enum.PerfilUsuario;
import projetoBase2.factory.DriverFactory;
import projetoBase2.object.Cliente;
import projetoBase2.pages.BasePage;
import projetoBase2.pages.LoginPage;
import projetoBase2.utils.ScreenShots;
import projetoBase2.utils.Usuario;

import java.io.IOException;
import java.util.List;

public class LoginStepdefs {
    private static WebDriver driver;
    Usuario usuario;

    @Step("Acessar tela de login")
    @Given("acesso a tela de login")
    public void acessoATelaDeLoginagora() {
        driver = DriverFactory.getDriver();
        usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
        new BasePage(driver).load( "/login_page.php");


    }
    @Step("informar usuário incorreto")
    @When("^informar usuario incorreto$")
    public void informarUsuarioincorreto() {
        usuario = new Usuario(PerfilUsuario.USERFAILED);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.informarUsuario(usuario.getUsuario());


    }
    @Step("informar usuário")
    @When("^informar usuario$")
    public void informarUsuarioAdministrator() {
        usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.informarUsuario(usuario.getUsuario());
    }
    @Step("informar senha")
    @And("^informar senha$")
    public void informarSenhaAbc() {
        usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.informarSenha(usuario.getSenha());

    }
    @Step("informar senha incorreta")
    @And("^informar senha incorreta$")
    public void informarDadosAcesso1() {
    usuario = new Usuario(PerfilUsuario.PASSWFAILED);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.informarSenha(usuario.getSenha());
    }
    @Step("tocar no parâmetro confirmar")
    @And("tocar no parâmetro confirmar")
    public void tocarNoParâmetroConfirmar() {
        new LoginPage(driver).confirmar();
    }

    @Step("o sistema deve realizar o login e exibir a tela do mantis com o usuário logado")
    @Then("o sistema deve realizar o login e exibir a tela do mantis com o usuário logado")
    public void oSistemaDeveRealizarOLoginEExibirATelaDoMantisComOUsuárioLogado() throws IOException {
        String LoggerUserName = new LoginPage(driver).validaUsuarioLogadoSucesso();
        String expectedUserName = "administrator";
        Assert.assertEquals(LoggerUserName, expectedUserName);
        ScreenShots.tirarFoto(driver,"Realizar Realizar Login_LoginSucesso");


    }
    @Step("o sistema deve exibir mensagem de erro na tela")
    @Then("o sistema deve exibir mensagem de erro na tela")
    public void oSistemaDeveExibirMensagemDeErroImpedindoAcesso() {
        ScreenShots.tirarFoto(driver,"Realizar Login_UsernameIncorreto");

        String mensagemUserInvalid  = new LoginPage(driver).MensagemUsuarioInvalido();
        String mensagemEsperada = "sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.";

        Assert.assertTrue(mensagemUserInvalid.toLowerCase().contains(mensagemEsperada));
    }

//    @DataTableType
//    public Cliente teste (List<String> seila){
//        return  new Cliente(seila.get(0),seila.get(1));
//    }

//    @When("Informar usuario")
//    public void informarDadosAcesso(Cliente cliente) {
//        new LoginPage(driver).informarUsuario(cliente.getUsername());
//    }
}

