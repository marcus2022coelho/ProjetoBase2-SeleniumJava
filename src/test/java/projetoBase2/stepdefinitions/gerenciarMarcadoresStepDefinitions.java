package projetoBase2.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projetoBase2.factory.DriverFactory;
import projetoBase2.pages.BasePage;
import projetoBase2.pages.GerenciarMarcadoresPage;
import projetoBase2.pages.GerenciarUsuarioPage;

public class gerenciarMarcadoresStepDefinitions {
    WebDriver driver;

    @And("^seleciono para Gerenciar os Marcadores$")
    public void acessar_menu_Gerenciar_Marcadores() {
        driver = DriverFactory.getDriver();
        new BasePage(driver).load("/manage_tags_page.php");
    }

    @When("^tocar no parâmetro Criar Marcador$")
    public void tocarCriarMarcador() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        gerenciarMarcadoresPage.criarGerenciarMarcador();
    }

    @When("^informo o \"([^\"]*)\",\"([^\"]*)\"$")
    public void informo_o(String nomeDoMarcador, String descricaoDoMarcador) {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        gerenciarMarcadoresPage.preencherNomedoMarcador(nomeDoMarcador);
        gerenciarMarcadoresPage.preencherDescricaoDoMarcador(descricaoDoMarcador);
    }

    @Then("^confirmo a criacao do marcador$")
    public void confirmo_a_criacao_do_marcador() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        gerenciarMarcadoresPage.criarGerenciarMarcador();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/manage_tags_page.php");
    }

    //editar marcador
    @Given("^seleciono o marcador$")
    public void seleciono_o_marcador() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        BasePage basePage = new BasePage(driver);

        // validar se o nome existe para ser editado
        By elemento = new By.ByXPath("//a[normalize-space()='Criacao do Marcador']");

        basePage.load("/manage_tags_page.php");
        if (basePage.validarSeElementoExiste(driver, elemento)) {
            gerenciarMarcadoresPage.selecionarMarcadorCriado();
        } else {
            // criar um usuário para depois repetir o processo
            gerenciarMarcadoresPage.criarGerenciarMarcador();
            gerenciarMarcadoresPage.preencherNomedoMarcador("Criacao do Marcador");
            gerenciarMarcadoresPage.preencherDescricaoDoMarcador("descricao Do Marcador");
            gerenciarMarcadoresPage.criarGerenciarMarcador();
            basePage.load("/manage_tags_page.php");
            gerenciarMarcadoresPage.selecionarMarcadorCriado();

        }


    }

    @When("^seleciono para atualizar o marcador$")
    public void seleciono_para_atualizar_o_marcador() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        gerenciarMarcadoresPage.buttonAtualizarMarcador();
    }

    @And("^atualizo a descrição do marcador$")
    public void atualizarDescricaoMarcador() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        gerenciarMarcadoresPage.preencherDescricaoDoMarcador("alteração teste");

    }

    @Then("^seleciono para concluir a atualizacao$")
    public void seleciono_para_concluir_a_atualizacao() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        gerenciarMarcadoresPage.concluirAtualizacao();

        String URL = driver.getCurrentUrl();
        String URLEsperada = "http://127.0.0.1:8989/tag_view_page.php?tag_";
        assert URL.contains(URLEsperada);
    }

    //excluir marcador
    @Given("^seleciono o marcador para excluir$")
    public void seleciono_o_marcador_para_excluir() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        BasePage basePage = new BasePage(driver);

        // validar se o nome existe para ser excluído
        By elemento = new By.ByXPath("//a[normalize-space()='marcador exclusao']");



        basePage.load("/manage_tags_page.php");
        if (basePage.validarSeElementoExiste(driver, elemento)) {
            gerenciarMarcadoresPage.selecionarMarcadorExcluir();
        } else {
            // criar um usuário para depois repetir o processo
            gerenciarMarcadoresPage.criarGerenciarMarcador();
            gerenciarMarcadoresPage.preencherNomedoMarcador("marcador exclusao");
            gerenciarMarcadoresPage.preencherDescricaoDoMarcador("descricao Do Marcador");
            gerenciarMarcadoresPage.criarGerenciarMarcador();
            basePage.load("/manage_tags_page.php");
            gerenciarMarcadoresPage.selecionarMarcadorExcluir();

        }
    }

    @When("^seleciono para excluir$")
    public void seleciono_para_excluir() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        gerenciarMarcadoresPage.botaoExcluir();
    }

    @Then("^confirmo a exclusao$")
    public void confirmo_a_exclusao() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        gerenciarMarcadoresPage.confirmarExclusao();
    }

    @Then("^valido a exclusao do marcador$")
    public void valido_a_exclusao_do_marcador() {

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/manage_tags_page.php");
    }

    //visualizar tarefas
    @Given("^seleciono o marcador original$")
    public void seleciono_o_marcador_original() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        gerenciarMarcadoresPage.selecionarMarcadorTarefas();
    }

    @When("^seleciono para visualizar as tarefas$")
    public void seleciono_para_visualizar_as_tarefas() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);
        gerenciarMarcadoresPage.selecionarTarefasRelacionadas();
    }

    @Then("^sistema redireciona o usuario para a tela de visualizar tarefas$")
    public void confirmo_a_visualizacao_das_tarefas_relacionadas() {
        GerenciarMarcadoresPage gerenciarMarcadoresPage = new GerenciarMarcadoresPage(driver);

        String URL = driver.getCurrentUrl();
        String URLesperada = "http://127.0.0.1:8989/view_all_bug_page.php?filter=";
        assert URL.contains(URLesperada);
    }


}
