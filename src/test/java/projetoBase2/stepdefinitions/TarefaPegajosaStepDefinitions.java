package projetoBase2.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projetoBase2.Enum.PerfilUsuario;
import projetoBase2.factory.DriverFactory;
import projetoBase2.pages.CriarTarefaPage;
import projetoBase2.pages.TarefaPegajosaPage;
import projetoBase2.pages.VerTarefaPage;
import projetoBase2.utils.Usuario;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class TarefaPegajosaStepDefinitions {
    private static WebDriver driver;
    private int quantidadeLinhaInicial;
    VerTarefaPage verTarefasPage;


    @When("^selecionar o numero da tarefa$")
    public void selecionei_o_numero_da_tarefa() {
        driver = DriverFactory.getDriver();
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);

        if (verTarefasPage.retornaSeTarefaExiste()){
            verTarefasPage.selecionarTarefaLembrete();
        }else{
            CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);

            driver.get("http://127.0.0.1:8989/bug_report_page.php");
            criarTarefaPage.inserirResumo("criado para a feature de exclusao");
            criarTarefaPage.inserirDescricao("criado para a feature de exclusao");
            criarTarefaPage.inserirPassosReproduzir("criado para a feature de exclusao");
            criarTarefaPage.inserirInformacoesAdicionais("criado para a feature de exclusao");
            criarTarefaPage.tocarCriarTarefa();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.get("http://127.0.0.1:8989/view_all_bug_page.php");
            verTarefasPage.selecionarTarefa();
        }
    }

    @And("^marcar a tarefa como pegajosa$")
    public void marquei_a_tarefa_como_pegajosa() {
        driver = DriverFactory.getDriver();
        TarefaPegajosaPage tarefaPegajosaPage = new TarefaPegajosaPage(driver);
       int quantidadeLinhaInicial =  tarefaPegajosaPage.validarQuantidadeDeLinhaTabelaHistorico();
        tarefaPegajosaPage.macarTarefa();
    }

    @Then("^o sistema deve exibir em histórico da tarefa a ação realizada$")
    public void exibirHistóricoDaTarefa(){
        TarefaPegajosaPage tarefaPegajosaPage = new TarefaPegajosaPage(driver);
        int quantidadeLinhaFinal = tarefaPegajosaPage.validarUltimaLinhaDaTabela();

        Assert.assertTrue(quantidadeLinhaFinal > quantidadeLinhaInicial, "A quantidade final não é maior que a quantidade inicial");

    }
    @And("^desmarcar a tarefa como pegajosa$")
    public void desmarquei_a_tarefa_como_pegajosa() {
        driver = DriverFactory.getDriver();
        TarefaPegajosaPage tarefaPegajosaPage = new TarefaPegajosaPage(driver);
        int quantidadeLinhaInicial =  tarefaPegajosaPage.validarQuantidadeDeLinhaTabelaHistorico();
        tarefaPegajosaPage.macarTarefa();
    }

}

