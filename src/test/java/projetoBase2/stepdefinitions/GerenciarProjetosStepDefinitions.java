package projetoBase2.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import projetoBase2.factory.DriverFactory;
import projetoBase2.pages.BasePage;
import projetoBase2.pages.GerenciarProjetosPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GerenciarProjetosStepDefinitions {
    private static WebDriver driver;

//    @Given("o usuario efetuou login$")
//    public void oUsuarioEfetuouLogin() {
//        usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
//        loginPage.AbrirPagina();
//    }
//
//    @Given("usuario fizer o login$")
//    public void oUsuarioFizerOlogin() {
//        loginPage.preencherUsuario(usuario.getUsuario());
//        loginPage.clicarEntrarUsuario();
//        loginPage.preencherSenha(usuario.getSenha());
//        loginPage.clicarEntrarUsuario();
//    }


    //Login e navegação até a tela dos testes
    @And("^acessar Gerenciar no Menu$")
    public void acessarGerenciarNoMenu() {
        driver = DriverFactory.getDriver();
        new BasePage(driver).load("/manage_overview_page.php");
    }

    @And("^acessar Gerenciar Projetos$")
    public void acessarGerenciarProjetos() {
        driver = DriverFactory.getDriver();
        new BasePage(driver).load("/manage_proj_page.php");
    }


    // criar novo projeto
    @And("^acessar Criar novo Projeto$")
    public void acessarCriarNovoProjeto() {
        new GerenciarProjetosPage(driver).selecionarBotaoNovoProjeto();

    }

    @When("^preencher os campos a seguir \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void preencherOsCamposAseguir(String nomeDoProjeto, String Estado, String Visibilidade,
                                         String campoDescricao) {
        GerenciarProjetosPage gerenciarProjetosPage = new GerenciarProjetosPage(driver);


        gerenciarProjetosPage.preencherNomeDoProjeto(nomeDoProjeto);
        gerenciarProjetosPage.selecionarEstado(Estado);
        gerenciarProjetosPage.selecionarVisibilidade(Visibilidade);
        gerenciarProjetosPage.preencherCampoDescricao(campoDescricao);
    }

    @Then("^o projeto foi criado$")
    public void oProjetoFoiCriado() {
        GerenciarProjetosPage gerenciarProjetosPage = new GerenciarProjetosPage(driver);
        gerenciarProjetosPage.clicarBotaoAdicionarProjeto();

        String texto = gerenciarProjetosPage.getConfirmacaoCriacaoProjeto();
        String textoEsperado = "sucesso.";

        Assert.assertTrue(texto.toLowerCase().contains(textoEsperado));
    }

    // Editar projeto
    @And("^selecionar o Projeto$")
    public void selecionarOprojeto() {
        new GerenciarProjetosPage(driver).selectProjetoAtualizar();

    }

    @When("^atualizar os campos necessarios \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void atualizarOsCamposNecessarios(String nomeProjetoEdit, String Estado, String Visibilidade,
                                             String campoDescricaoEdit) {
        GerenciarProjetosPage gerenciarProjetosPage = new GerenciarProjetosPage(driver);
        gerenciarProjetosPage.editarNomeDoProjeto(nomeProjetoEdit);
        gerenciarProjetosPage.editarEstado(Estado);
        gerenciarProjetosPage.editarVisibilidade(Visibilidade);
        gerenciarProjetosPage.editarCampoDescricao(campoDescricaoEdit);
    }

    @Then("^o sistema atualizou o projeto$")
    public void oSistemaAtualizouOprojeto() {
        new GerenciarProjetosPage(driver).atualizarOprojeto();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/manage_proj_page.php");
    }


    //excluir projeto

    @And("^seleciono o projeto para excluir$")
    public void selecionoOprojetoParaExcluir() {
        GerenciarProjetosPage gerenciarProjetosPage = new GerenciarProjetosPage(driver);

        if (gerenciarProjetosPage.retornarSeProjetoExiste()) {
            gerenciarProjetosPage.clicarSobreProjeto();
        } else {
            gerenciarProjetosPage.selecionarBotaoNovoProjeto();
            gerenciarProjetosPage.preencherNomeDoProjeto("Projeto criado para ser excluído");
            gerenciarProjetosPage.selecionarEstado("desenvolvimento");
            gerenciarProjetosPage.selecionarVisibilidade("privado");
            gerenciarProjetosPage.preencherCampoDescricao("teste preencher descrição para excluir projeto - automação cenário excluir projeto");
            gerenciarProjetosPage.salvarProjetoBotao();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(gerenciarProjetosPage.clicarSobreProjeto2()));
            gerenciarProjetosPage.clicarSobreProjeto();

        }
    }


    @When("^seleciono apagar o projeto$")
    public void selecionarApagarOprojeto() {
        GerenciarProjetosPage gerenciarProjetosPage = new GerenciarProjetosPage(driver);

        gerenciarProjetosPage.apagarProjetoBotao();
    }

    @Then("^o sistema exclui o projeto$")
    public void oSistemaExcluiOprojeto() {

        new GerenciarProjetosPage(driver).confirmaApagaProjetoBotao();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/manage_proj_page.php");
    }

    // Cadastrar Projeto com o mesmo nome

    @And("^tocar em criar novo projeto$")
    public void acessarCriarNovoProjetoNomeIgual() {
        GerenciarProjetosPage gerenciarProjetosPage = new GerenciarProjetosPage(driver);
        gerenciarProjetosPage.selecionarBotaoNovoProjeto();

        // criar um projeto com os dados que serão repetidos nas steps posteriores, para não criarmos dependencia de já existir um projeto na base
        gerenciarProjetosPage.preencherNomeDoProjeto("Cadastrar o projeto com mesmo nome");
        gerenciarProjetosPage.selecionarEstado("desenvolvimento");
        gerenciarProjetosPage.selecionarVisibilidade("privado");
        gerenciarProjetosPage.preencherCampoDescricao("Cadastrar o projeto com mesmo nome ");
        gerenciarProjetosPage.salvarProjetoBotao();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(gerenciarProjetosPage.clicarSobreProjeto2()));
        gerenciarProjetosPage.selecionarBotaoNovoProjeto();


    }

    @When("^Tocar no parâmetro salvar$")
    public void salvo_o_projeto_igual() {
        GerenciarProjetosPage gerenciarProjetosPage = new GerenciarProjetosPage(driver);
        gerenciarProjetosPage.salvarProjetoBotao();
    }

    @Then("^o sistema exibe a mensagem de erro$")
    public void oSistemaExibeAmensagemDeErro() {
        GerenciarProjetosPage gerenciarProjetosPage = new GerenciarProjetosPage(driver);

        String ErroCriarProjetoMesmoNome = gerenciarProjetosPage.MensagemDeErroSalvarProjetoMesmoNome();
        String textoEsperado = "um projeto com este nome já existe";

        Assert.assertTrue(ErroCriarProjetoMesmoNome.toLowerCase().contains(textoEsperado));

        driver = DriverFactory.getDriver();
        new BasePage(driver).load("/manage_overview_page.php");
        driver = DriverFactory.getDriver();
        new BasePage(driver).load("/manage_proj_page.php");

        gerenciarProjetosPage.clicarProjetoPeloNome();
        gerenciarProjetosPage.apagarProjetoBotao();
        gerenciarProjetosPage.confirmaApagaProjetoBotao();

    }
}
