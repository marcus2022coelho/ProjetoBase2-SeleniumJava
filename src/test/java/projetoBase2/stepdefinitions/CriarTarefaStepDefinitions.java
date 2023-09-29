package projetoBase2.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import projetoBase2.factory.DriverFactory;
import projetoBase2.pages.BasePage;
import projetoBase2.pages.CriarTarefaPage;
import projetoBase2.pages.GerenciarProjetosPage;

import java.util.concurrent.TimeUnit;

public class CriarTarefaStepDefinitions {
    private static WebDriver driver;

    // criar novo projeto
    @And("^acesso ao menu Criar Tarefas$")
    public void acessarCriarNovaTarefa() {
        driver = DriverFactory.getDriver();
        //new GerenciarProjetosPage(driver).selecionarBotaoNovoProjeto();
        //new BasePage(driver).load("/bug_report_page.php");
        CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);
        criarTarefaPage.menuCriarTarefa();

    }

    @And("^preencher todos os campos a seguir \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void preencherOsCamposAseguir(String categoria, String frequencia, String gravidade,
                                         String prioridade, String atribuir, String resumo, String descricao, String passosReproduzir, String informacoesAdicionais, String visibilidade) {
        CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);

        criarTarefaPage.selecionarCategoria(categoria);
        criarTarefaPage.selecionarFrequencia(frequencia);
        criarTarefaPage.selecionarGravidade(gravidade);
        criarTarefaPage.selecionarPrioridade(prioridade);
        criarTarefaPage.selecionarAtribuir(atribuir);
        criarTarefaPage.inserirResumo(resumo);
        criarTarefaPage.inserirDescricao(descricao);
        criarTarefaPage.inserirPassosReproduzir(passosReproduzir);
        criarTarefaPage.inserirInformacoesAdicionais(informacoesAdicionais);
        criarTarefaPage.selecionarVisibilidade();
    }

    @When("^tocar em criar nova tarefa$")
    public void clicarNovaTarefa() {
        CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);
        criarTarefaPage.tocarCriarTarefa();
    }

    @Then("^o sistema deve criar a nova tarefa$")
    public void validaNovaTarefaCriadaComSucesso() {
        CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);
        String textoSucesso = criarTarefaPage.mensagemCriarTarefaSucesso();
        String textoEsperado = "sucesso";

        Assert.assertTrue(textoSucesso.toLowerCase().contains(textoEsperado));

    }

    // criar tarefa sem preencher os campos obrigatórios
    @And("^preencher os campos a seguir \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void preencherOsCamposAseguir(String frequencia, String gravidade,
                                         String prioridade, String atribuir, String resumo, String descricao, String passosReproduzir, String informacoesAdicionais, String visibilidade) {
        CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);

        criarTarefaPage.selecionarFrequencia(frequencia);
        criarTarefaPage.selecionarGravidade(gravidade);
        criarTarefaPage.selecionarPrioridade(prioridade);
        criarTarefaPage.selecionarAtribuir(atribuir);
        criarTarefaPage.inserirResumo(resumo);
        criarTarefaPage.inserirDescricao(descricao);
        criarTarefaPage.inserirPassosReproduzir(passosReproduzir);
        criarTarefaPage.inserirInformacoesAdicionais(informacoesAdicionais);
        criarTarefaPage.selecionarVisibilidade();
    }
    @Then("^o sistema exibirá mensagem informativa e não salvará a tarefa$")
    public void validaNaoCriacaoDaTarefa() {
        CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);
        String textoAtual = criarTarefaPage.mensagemCampoObrigatorio();
        String textoEsperado = "Por favor, verifique novamente suas entradas.";

        assert textoAtual.contains(textoEsperado);

    }



}
