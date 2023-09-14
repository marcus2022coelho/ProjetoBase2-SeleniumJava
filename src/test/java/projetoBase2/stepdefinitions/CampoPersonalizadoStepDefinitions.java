package projetoBase2.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projetoBase2.factory.DriverFactory;
import projetoBase2.pages.BasePage;
import projetoBase2.pages.CampoPersonalizadoPage;

import java.util.concurrent.TimeUnit;

public class CampoPersonalizadoStepDefinitions{

    private static  WebDriver driver;


    @When("^acesso ao menu Gerencir Campos Personalizados$")
    public void selecionoNoMenuGerenciarCamposPersonalizados() {
        driver = DriverFactory.getDriver();
       new BasePage(driver).load("/manage_custom_field_page.php");
    }

    @When("^informo o nome do campo Personalizado")
    public void informo_o_nome_do_CampoPersonalizado() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.preencherNomeCampo(BasePage.gerarNomeAleatorio());
    }

    @When("^seleciono para adicionar o campo$")
    public void seleciono_para_adicionar_o_campo() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.adicionarCampoButton();
    }

    @Then("^confirmo a criacao do campo$")
    public void confirmo_a_criacao_do_campo() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.confirmoCriacao();
    }

    //criar campo com um nome já existente
    @And("^informo o nome do campo personalizado duplicado")
    public void informo_o_nome_do_campoDuplicado() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.preencherNomeCampo("Nome do campo igual");
    }
    @When("^seleciono para adicionar o campo repetido$")
    public void seleciono_para_adicionar_o_campoDuasVezes() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.adicionarCampoButton();
        new BasePage(driver).load("/manage_custom_field_page.php");
        campoPersonalizadoPage.preencherNomeCampo("Nome do campo igual");
        campoPersonalizadoPage.adicionarCampoButton();

    }

    @Then("^sistema retorna mensagem informando que o campo não pode ser repetido$")
    public void criacao_do_campo_repetido() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        String texto = campoPersonalizadoPage.campoPersonalizadoMesmoNome();
        Assert.assertTrue(texto.contains("Por favor, utilize o botão \"Voltar\" de seu navegador web para voltar à pagina anterior"));
    }

    // editar campo personalizado
    @When("^seleciono para alterar o campo$")
    public void seleciono_para_alterar_o_campo() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.selecionarCampoEdicao();
    }

    @When("^seleciono o \"([^\"]*)\",\"([^\"]*)\"$")
    public void seleciono_o(String acessoDeLeitura, String acessoDeEscrita) {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.preenchoAcessoLeitura(acessoDeLeitura);
        campoPersonalizadoPage.preenchoAcessoEscrita(acessoDeEscrita);
    }

    @Then("^confirmo a edicao do campo$")
    public void confirmo_a_edicao_do_campo() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.concluirEdicaoCampo();
       new BasePage(driver).validaMensagemSucesso();


    }

    // vincular campo personalizado
    @Given("^seleciono a tarefa para vincular$")
    public void seleciono_a_tarefa_para_vincular() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.selecionarTarefaVincular();
    }

    @When("^seleciono o projeto para vincular$")
    public void seleciono_o_projeto_para_vincular_em() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.vincularCampoProjeto();
    }

    @Then("^seleciono para vincular o campo personalizado$")
    public void seleciono_para_vincular_o_campo_personalizado() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.vincularCampoBotao();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"http://127.0.0.1:8989/manage_custom_field_edit_page.php?field_id=1");


    }

    // excluir vinculo
    @When("^seleciono o campo personaliado para excluir$")
    public void seleciono_o_campo_personaliado_para_excluir() throws InterruptedException {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.preencherNomeCampo("campoParaSerApagado");
        campoPersonalizadoPage.adicionarCampoButton();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @When("^clico para apagar campo personalizado$")
    public void clico_para_apagar_campo_personalizado() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.apagarCampoPersonalizado();
    }

    @When("^confirmo para excluir o campo$")
    public void confirmo_para_excluir_o_campo() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.confirmarButton();
    }

    @Then("^visualizo a mensagem de sucesso$")
    public void visualizo_a_mensagem_de_sucesso() {
        CampoPersonalizadoPage campoPersonalizadoPage = new CampoPersonalizadoPage(driver);
        campoPersonalizadoPage.visualizarMensagem();
        new BasePage(driver).validaMensagemSucesso();

    }




}
