package projetoBase2.stepdefinitions;

//import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import projetoBase2.factory.DriverFactory;
import projetoBase2.pages.BasePage;
import projetoBase2.pages.GerenciarUsuarioPage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GerenciarUsuarioStepDefinitions {
    private static WebDriver driver;


    @And("^acessar menu Gerenciar usuarios$")
    public void acessar_menu_Gerenciar_Usuarios() {
        driver = DriverFactory.getDriver();
        new BasePage(driver).load("/manage_user_page.php");
    }


    // criar novo usuario
    @When("^selecionar o parâmetro '(.+)'$")
    public void selecionar_o_parâmetro(String string) {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.clicarBotaoCriarNovaConta();

    }

    //    @When("^preenche o campo \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
//    public void preencher_os_campos(String nomeUsuarioTeste, String nomeVerdadeiroTeste, String emailTeste, String nivelAcessoTeste) {
//        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
//        gerenciarUsuarioPage.preencherUsuario();
//        gerenciarUsuarioPage.preencherNomeVerdadeiro(nomeVerdadeiroTeste);
//        gerenciarUsuarioPage.preencherEmail(emailTeste);
//        gerenciarUsuarioPage.preencherNivelAcesso(nivelAcessoTeste);
//
//        }
    @And("^preenche o campo nome de usuario$")
    public void prencherOCampoNomeUsuario() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.preencherUsuario();
    }

    @And("^preenche o campo nome de usuario com um nome já existente$")
    public void prencherOCampoNomeUsuarioIgual() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        BasePage basePage = new BasePage(driver);

        // deletar o nome antes de incluir
        By elemento = new By.ByXPath("//a[normalize-space()='Usuario Mesmo Nome']");

        basePage.load("/manage_user_page.php");
        if (basePage.validarSeElementoExiste(driver, elemento)) {
            gerenciarUsuarioPage.clicarBotaoCriarNovaConta();
            gerenciarUsuarioPage.preencherUsuarioIgual();
        } else {
            // criar um usuário para depois repetir o processo
            metodoCriarUsuario(gerenciarUsuarioPage);
            gerenciarUsuarioPage.clicarBotaoCriarNovaConta();
            gerenciarUsuarioPage.preencherUsuarioIgual();
        }

    }

    private void metodoCriarUsuario(GerenciarUsuarioPage gerenciarUsuarioPage) {
        gerenciarUsuarioPage.clicarBotaoCriarNovaConta();
        gerenciarUsuarioPage.preencherUsuarioIgual();
        gerenciarUsuarioPage.preencherNomeVerdadeiro();
        gerenciarUsuarioPage.preencherEmail();
        gerenciarUsuarioPage.preencherNivelAcesso();
        gerenciarUsuarioPage.criarUsuario();
        new BasePage(driver).load("/manage_user_page.php");
    }


    @And("^preenche o campo nome verdadeiro$")
    public void prencherOCampoNomeVerdadeiro() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.preencherNomeVerdadeiro();
    }

    @And("^preenche o campo email$")
    public void prencherOCampoEmail() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.preencherEmail();
    }

    @And("^preenche o campo nivel de acesso$")
    public void prencherOCampoNivelAcesso() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.preencherNivelAcesso();
    }

    @And("^tocar no parâmetro Criar Usuario$")
    public void clicarCriarUsuario() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.criarUsuario();
    }


    @Then("o sistema deve criar o usuário com sucesso")
    public void o_sistema_deve_criar_o_usuário_com_sucesso() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/manage_user_create.php");

        // tentei por alert, tentei pegando pelo texto do elemento, nao consegui caprturar o texto do elemento, validar em outro momento.l
//        Alert alerta = driver.switchTo().alert();
//        String textoAlerta = alerta.getText();
//        String palavraEsperada = "criado";
//        Assert.assertTrue(textoAlerta.contains(palavraEsperada));

    }
    //criar usuário utilizando mesmo nome e com o campo nome em branco

    @Then("^o sistema deve exibir mensagem erro$")
    public void validarMensagemErroAoCriarUsuarioMesmoNome() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        String mensagemAtual = gerenciarUsuarioPage.validaMensagemErro();
        String mensagemEsperada = "Por favor, utilize o botão \"Voltar\"";

        new BasePage(driver).validarMensagem(mensagemEsperada, mensagemAtual);
    }


    // editar o usuario
    @Given("^selecionar o Nome de Usuario$")
    public void selecionar_o_Nome_de_Usuario() {

        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        BasePage basePage = new BasePage(driver);

        // validar se o nome existe para ser editado
        By elemento = new By.ByXPath("//a[normalize-space()='Usuario Mesmo Nome']");

        basePage.load("/manage_user_page.php");
        if (basePage.validarSeElementoExiste(driver, elemento)) {
            gerenciarUsuarioPage.selecionarPerfil();
        } else {
            // criar um usuário para depois repetir o processo
            metodoCriarUsuario(gerenciarUsuarioPage);
            basePage.load("/manage_user_page.php");
            gerenciarUsuarioPage.selecionarPerfil();

        }


    }

    @When("^atualizar o \"([^\"]*)\"$")
    public void atualizar_o(String editarNivelAcesso) {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.alterarNivelDeAcesso(editarNivelAcesso);
    }

    @And("^tocar no parâmetro Atualizar Usuário$")
    public void atualizarUsuatioButton(){
    GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
    gerenciarUsuarioPage.validarAlteracaoNivel();


    }

    @Then("^o sistema atualizou o usuario$")
    public void o_sistema_atualizou_o_usuario() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        new BasePage(driver).validaMensagemSucesso();


    }

    // excluir usuario
    @When("^selecionar o usuario para excluir$")
    public void selecionar_o_usuario_para_excluir() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.selecionarPerfil();
    }

    @Then("^confirmar a exclusao do usuario$")
    public void confirmar_a_exclusao_do_usuario() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.excluirPerfilButton();
    }

    @Then("^o sistema exibe a mensagem confirmando$")
    public void o_sistema_exibe_a_mensagem_confirmando() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.confirmarAexclusao();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/manage_user_delete.php");
    }

    // redefinir a senha

    @When("^seleciono para redefinir a senha$")
    public void seleciono_para_redefinir_a_senha() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.redefinirAsenha();
    }

    @Then("^o sistema orienta sobre a redefinicao$")
    public void o_sistema_orienta_sobre_a_redefinicao() {

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/manage_user_reset.php");
    }

    // representar usuario
    @Given("^selecionar o Usuario para representar$")
    public void selecionar_o_Usuario_para_representar() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.usuarioParaRepresentar();
    }

    @When("^seleciono para representar o usuario$")
    public void seleciono_para_representar_o_usuario() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.representarUsuarioPerfil();
    }

    @Then("^o sistema solicita a confirmacao$")
    public void o_sistema_solicita_a_confirmacao() {
        GerenciarUsuarioPage gerenciarUsuarioPage = new GerenciarUsuarioPage(driver);
        gerenciarUsuarioPage.confirmarRepresentar();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/my_view_page.php");
    }

}
