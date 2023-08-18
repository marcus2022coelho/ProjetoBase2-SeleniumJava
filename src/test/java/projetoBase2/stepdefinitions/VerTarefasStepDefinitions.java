package projetoBase2.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tr.Ve;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projetoBase2.Enum.PerfilUsuario;
import projetoBase2.factory.DriverFactory;
import projetoBase2.pages.BasePage;
import projetoBase2.pages.CriarTarefaPage;
import projetoBase2.pages.LoginPage;
import projetoBase2.pages.VerTarefaPage;
import projetoBase2.utils.Usuario;

import java.util.concurrent.TimeUnit;

public class VerTarefasStepDefinitions {

    private static WebDriver driver;
    Usuario usuario;
    LoginPage loginPage;

    @And("^acesso ao menu Ver Tarefas$")
    public void carregou_a_pagina_do_Mantis() {
        driver = DriverFactory.getDriver();
        usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
        new BasePage(driver).load("/view_all_bug_page.php");
    }

    // apagar tarefa
    @When("^seleciono a tarefa a ser apagada$")
    public void seleciono_a_tarefa_a_ser_apagada() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);

        if (verTarefasPage.retornaSeTarefaExiste()){
            verTarefasPage.selecionarTarefa();
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


    @When("^seleciono para apagar a tarefa$")
    public void seleciono_para_apagar_a_tarefa() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.seletorDeteleTarefa();
        verTarefasPage.selecionarAcaoButtomComboBox();
    }

    @When("^o sistema confirma para apagar a tarefa$")
    public void o_sistema_confirma_para_apagar_a_tarefa() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.confirmaApagarTarefa();
    }

    @Then("^a tarefa foi excluida$")
    public void a_tarefa_foi_excluida() {

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/view_all_bug_page.php");
    }

    // clonar a tarefa
    @Given("^seleciono a tarefa a ser clonada$")
    public void seleciono_a_tarefa_a_ser_clonada() {

        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);

        if (verTarefasPage.retornaSeTarefaExiste()){
            verTarefasPage.selecionarTarefa();
        }else{
            CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);

            driver.get("http://127.0.0.1:8989/bug_report_page.php");
            criarTarefaPage.inserirResumo("Tarefa criada para ser copiada");
            criarTarefaPage.inserirDescricao("Tarefa criada para ser copiada");
            criarTarefaPage.inserirPassosReproduzir("Tarefa criada para ser copiada");
            criarTarefaPage.inserirInformacoesAdicionais("Tarefa criada para ser copiada");
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

    @When("^seleciono para copiar tarefa$")
    public void selecionoCopiarTarefa() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.seletorCopiarTarefa();
        verTarefasPage.botaoOkConfirmarTarefa();

    }

    @When("^confirmo para copiar a tarefa$")
    public void confirmarCopiarTarefa() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.confirmaCopiarTarefa();

    }

    @Then("^salvo a tarefa clone$")
    public void salvo_a_tarefa_clone() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/view_all_bug_page.php");

    }

    // enviar lembrete
    @And ("^selecionar a tarefa$")
        public void selecionarTarefa(){
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.selecionarTarefaLembrete();
    }

    @Given("^tarefa de enviar lembrete$")
    public void tarefa_de_enviar_lembrete()  {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.selecionarTarefaLembrete();
    }

    @And("^tocar no parâmetro enviar um lembrete$")
    public void tocarEnviarUmLembrete() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.enviarLembreteTarefa();
    }

    @And("^selecionar um usuário$")
    public void selecionarUmUsuario(){
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.setSelecionarUsuario();
    }

    @And("^preencho o campo \"([^\"]*)\"$")
    public void seleciono_o(String textoLembrete) {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.ecrevoMensagemLembrete(textoLembrete);
    }

    @When("^seleciono para Enviar$")
    public void seleciono_para_Enviar()  {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.enviarLembrete();
    }

    @Then("^o sistema conclui o envio do lembrete$")
    public void o_sistema_conclui_o_envio_do_lembrete() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);

        String textoSucesso = verTarefasPage.visualizoMensagemEnvioSucesso();
        String textoEsperado = "operação realizada com sucesso";

        Assert.assertTrue(textoSucesso.toLowerCase().contains(textoEsperado));
    }
    @Then ("^o sistema exibe mensagem de erro na tela e não envia o lembrete$")
    public void enviarLembreteSemInformarCampoObrigatorio(){
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        String textoErro = verTarefasPage.mensagemErroCampoObrigatorio();
        String textoEsperadoo = "Um parâmetro necessário para esta página (to) não foi encontrado.";

       Assert.assertTrue(textoErro.contains(textoEsperadoo));
    }


    //pesquisar tarefa
    @Given("^filtro pelos campos \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void filtro_pelos_campos(String relator, String atribuidoA, String prioridade)  {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);

        verTarefasPage.selecionarRelator(relator);
        verTarefasPage.selecionarAtribuidoA(atribuidoA);
        verTarefasPage.selecionarPrioridade(prioridade);
    }

    @When("^realizo a pesquisa$")
    public void realizo_a_pesquisa()  {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.clicoParaPesquisar();
    }

    @Then("^o sistma retornou os registros$")
    public void o_sistma_retornou_os_registros()  {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        // método que retorna true caso existam valores na tabela

        Assert.assertTrue(verTarefasPage.resultadoEncontrado());

    }

    //salvar o filtro
    @When("^clico para salvar o filtro$")
    public void clico_para_salvar_o_filtro() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.salvarFitroSucesso();
    }

    @When("^preencho o \"([^\"]*)\"$")
    public void preencho_o(String nomeDoFiltro)  {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.informarNomeDoFiltro(nomeDoFiltro);
    }

    @Then("^o sistema salva o filtro$")
    public void o_sistema_salva_o_filtro()  {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.salvarFitroDefinitivo();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"http://127.0.0.1:8989/view_all_bug_page.php");
    }

    //tela de salvar filtro_voltar

    @When ("^tocar no parâmetro voltar$")
    public void tocarNoParâmetroVoltar(){
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.voltarSalvarFiltroButtom();
    }
    @Then ("^o sistema deve retornar para a tela anterior$")
    public void validarRetornoTelaDeFiltro(){
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"http://127.0.0.1:8989/view_all_bug_page.php?");

    }


    //pesquisa com filtro salvo
    @When("^seleciono o \"([^\"]*)\" que foi salvo$")
    public void seleciono_o_que_foi_salvo(String nomeDoFiltro) {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.selecionarNomeFiltro(nomeDoFiltro);
    }

    @Then("^o sistema realiza o filtro$")
    public void o_sistema_realiza_o_filtro() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        Assert.assertTrue(verTarefasPage.resultadoEncontrado());
    }

    //imprimir tarefas
    @When("^seleciono para imprimir tarefas$")
    public void seleciono_para_imprimir_tarefas() {
    VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.imprimirTarefas();
    }
    @Then("^o sistema retorna as tarefas$")
    public void o_sistema_retorna_as_tarefas() {

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/print_all_bug_page.php");
    }
}
