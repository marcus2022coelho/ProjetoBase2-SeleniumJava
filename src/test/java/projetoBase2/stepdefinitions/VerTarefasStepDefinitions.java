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
import projetoBase2.pages.*;
import projetoBase2.utils.Usuario;

import java.util.concurrent.TimeUnit;

public class VerTarefasStepDefinitions {

    private static WebDriver driver;
    Usuario usuario;
    LoginPage loginPage;
    private int valorInicial;

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

        if (verTarefasPage.retornaSeTarefaExiste()) {
            verTarefasPage.selecionarTarefa();
        } else {
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

        if (verTarefasPage.retornaSeTarefaExiste()) {
            verTarefasPage.selecionarTarefa();
        } else {
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
    @And("^selecionar a tarefa$")
    public void selecionarTarefa() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.ifTarefaNaoExisteCriaUmaNovaEseleciona();
        int valorInicial = verTarefasPage.validaQuantidadeDeLinhasTabelaTarefas();

    }

    @Given("^selecionar a tarefa para enviar lembrete$")
    public void tarefa_de_enviar_lembrete() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.selecionarTarefaLembrete();
    }

    @And("^tocar no parâmetro enviar um lembrete$")
    public void tocarEnviarUmLembrete() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.enviarLembreteTarefa();
    }

    @And("^selecionar um usuário$")
    public void selecionarUmUsuario() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.setSelecionarUsuario();
    }

    @And("^preencho o campo \"([^\"]*)\"$")
    public void seleciono_o(String textoLembrete) {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.ecrevoMensagemLembrete(textoLembrete);
    }

    @When("^seleciono para Enviar$")
    public void seleciono_para_Enviar() {
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

    @Then("^o sistema exibe mensagem de erro na tela e não envia o lembrete$")
    public void enviarLembreteSemInformarCampoObrigatorio() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        String textoErro = verTarefasPage.mensagemErroCampoObrigatorio();
        String textoEsperadoo = "Um parâmetro necessário para esta página (to) não foi encontrado.";

        Assert.assertTrue(textoErro.contains(textoEsperadoo));
    }


    //pesquisar tarefa
    @Given("^filtro pelos campos \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void filtro_pelos_campos(String relator, String atribuidoA, String prioridade) {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);

        verTarefasPage.selecionarRelator(relator);
        verTarefasPage.selecionarAtribuidoA(atribuidoA);
        verTarefasPage.selecionarPrioridade(prioridade);
    }

    @When("^realizo a pesquisa$")
    public void realizo_a_pesquisa() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.clicoParaPesquisar();
    }

    @Then("^o sistma retornou os registros$")
    public void o_sistma_retornou_os_registros() {
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

    @When("^preencho o nome do Filtro$")
    public void preencho_o() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.informarNomeDoFiltro();
    }

    @Then("^o sistema salva o filtro$")
    public void o_sistema_salva_o_filtro() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.salvarFitroDefinitivo();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/view_all_bug_page.php");
    }

    //tela de salvar filtro_voltar

    @When("^tocar no parâmetro voltar$")
    public void tocarNoParâmetroVoltar() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.voltarSalvarFiltroButtom();
    }

    @Then("^o sistema deve retornar para a tela anterior$")
    public void validarRetornoTelaDeFiltro() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/view_all_bug_page.php?");

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

    // mover tarefa
    @When("^selecionar o parâmetro mover")
    public void selecionarmoverTarefa() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.seletorMoverTarefa();
        verTarefasPage.botaoOkConfirmarTarefa();
    }

    @And("^selecionar o usuario a qual a tarefa será movida$")
    public void selecionarUsuarioParaMoverTarefa() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.selecaoUsuarioMoverTarefa();
    }

    @And("^tocar no parâmetro mover tarefas$")
    public void tocarBotaoMoverTarefas() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.selecionarBotaoMoverTarefa();
    }

    @Then("^o sistema realiza a acao de mover a tarefa$")
    public void validaMoverTarefa() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/view_all_bug_page.php");
    }

    //Atribuir tarefa
    @When("^selecionar o parâmetro atribuir")
    public void selecionarAtribuirTarefa() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        verTarefasPage.seletorAtribuirTarefa();
        verTarefasPage.botaoOkConfirmarTarefa();
    }

    @And("^selecionar o usuario a qual a tarefa será atribuida")
    public void selecionarUsuarioParaAtribuirTarefa() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.selecaoUsuarioAtribuirTarefa();
    }

    @And("^tocar no parâmetro Atribuir Tarefas$")
    public void tocarBotaoAtribuirTarefas() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.selecionarBotaoAtribuirTarefa();
    }

    @Then("^o sistema realiza a ação de atribuir a tarefa$")
    public void validaAtribuirTarefa() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/view_all_bug_page.php");
    }

    //fechar tarefa
    @When("^selecionar o parâmetro fechar")
    public void selecionarFecharTarefa() {
        VerTarefaPage verTarefasPage = new VerTarefaPage(driver);
        valorInicial = verTarefasPage.validaQuantidadeDeLinhasTabelaTarefas();
        verTarefasPage.seletorFecharTarefa();
        verTarefasPage.botaoOkConfirmarTarefa();
    }

    @And("^adicionar uma anotacao$")
    public void adicionarAnotacaoFecharTarefa() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.anotacaoTarefa();
    }

    @And("^tocar no parâmetro Fechar tarefa$")
    public void tocarButtomFecharTarefa() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.tocarFecharTarefas();
    }

    @Then("^o sistema deve fechar a tarefa$")
    public void validaFecharTarefa() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        //para saber se fechou, estou validando se a tabela onde as tarefas são contidas diminuiu de tamanho
        int valorFinal = verTarefaPage.validaQuantidadeDeLinhasTabelaTarefas();
        Assert.assertTrue(valorFinal < valorInicial);
        System.out.println(valorFinal);
    }

    //resolver tarefa
    @When("^selecionar o parâmetro resolver$")
    public void selecionarResolverTarefa() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.seletorResolverTarefa();
        verTarefaPage.botaoOkConfirmarTarefa();

    }

    @And("^escolher resolução das tarefas$")
    public void escolherResoluçãoDaTarefa() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.resolucaoTarefa();

    }

    @And("^tocar no parâmetro Resolver tarefa$")
    public void tocarButtonResolverTarefa() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.tocarResolverTarefas();
    }

    @Then("^o sistema deve atualizar o estado da tarefa$")
    public void validaResolverTarefa() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);

        driver.get("http://127.0.0.1:8989/view_all_bug_page.php");
        boolean existeStatusResolvido = verTarefaPage.RetornaSeExisteStatusResolvido();

        Assert.assertTrue(existeStatusResolvido);
        System.out.println("testes passaram");

    }

    // fixar / desfixar

    @When("^selecionar o parâmetro fixar/desfixar")
    public void selecionarFixarDesfixarTarefa() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.seletorFixarDesfixarTarefa();
        verTarefaPage.botaoOkConfirmarTarefa();

    }

    @And("^tocar no parâmetro Marcar/Desmarcar Pegajosos$")
    public void selecionarMarcarDesmarcarPegajoso() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.tocarMarcarDesmarcarPegajosos();
    }

    @Then("^o sistema realiza a ação$")
    public void validaAcaoFixarDesfixar() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://127.0.0.1:8989/view_all_bug_page.php");
    }

    //Atualizar prioridade
    @When("^selecionar o parâmetro atualizar prioridade")
    public void selecionaratualizarPrioridade() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.seletorAtualizarPrioridadeTarefa();
        verTarefaPage.botaoOkConfirmarTarefa();

    }
    @And("^selecionar a nova prioridade$")
    public void selecionarNovaPrioridade() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.setSelecionarNovaPrioridade();

    }
    @And("^tocar no parâmetro atualizar prioridade$")
    public void selecionarButtomAtualizarPrioridade() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.tocarBotaoAtualizarPrioridade();
    }
    @Then ("^o sistema atualiza a prioridade da tarefa$")
    public void validarAtualizacaoPrioridade(){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"http://127.0.0.1:8989/view_all_bug_page.php");

}
    //Atualizar gravidade
    @When("^selecionar o parâmetro atualizar gravidade")
    public void selecionarAtualizarGravidade() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.seletorAtualizarGravidadeTarefa();
        verTarefaPage.botaoOkConfirmarTarefa();

    }
    @And("^selecionar a nova gravidade")
    public void selecionarNovaGravidade() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.setSelecionarNovaGravidade();

    }
    @And("^tocar no parâmetro atualizar gravidade")
    public void selecionarButtomAtualizarGravidade() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.tocarBotaoAtualizarGravidade();
    }
    @Then ("^o sistema atualiza a gravidade da tarefa$")
    public void validarAtualizacaoGravidade(){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"http://127.0.0.1:8989/view_all_bug_page.php");
}
    //Atualizar Status
    @When("^selecionar o parâmetro atualizar status")
    public void selecionarAtualizarStatus() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.seletorAtualizarStatusTarefa();
        verTarefaPage.botaoOkConfirmarTarefa();

    }
    @And("^selecionar o novo status")
    public void selecionarNovoStatus() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.setSelecionarNovoStatus();

    }
    @And("^incluir uma anotação$")
    public void incluirAnotacao(){
    VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
    verTarefaPage.setAdicionarAnotacao();
    }

    @And("^tocar no parâmetro Atualizar Status")
    public void selecionarButtomAtualizarStatus() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.tocarAtualizarTarefaButtom();
    }
    @Then ("^o sistema atualiza o status da tarefa$")
    public void validarAtualizacaoStatus(){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"http://127.0.0.1:8989/view_all_bug_page.php");

}
//atualizarCategoria

    @When("^selecionar \"(.*)\"$")
    public void teste(String textoBotao){
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.tocarBotaoPeloNome(textoBotao);

    }
    @And ("^tocar no parâmetro OK$")
    public void tocarNoParametroOK(){
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.setTocarbuttomOK();
    }

    @And ("^selecionar nova categoria$")
    public void selecionarNovaCategoriaStep(){
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.selecionarNovaCategoria();
    }


    @And ("^selecionar o parâmetro atualizar categoria$")
    public void selecionarNovaCategoria(){
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.setSelecionarNovaCategoria();
    }

    @Then ("^o sistema atualiza a categoria da tarefa$")
    public void validarAtualizacaoCategoria(){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"http://127.0.0.1:8989/view_all_bug_page.php");

    }

    @And ("^selecionar o parâmetro atualizar visibilidade")
    public void setSelecionarAtualizarVisibilidade(){
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.setSelecionarAtualizarVisibilidade();
    }

    @And ("^selecionar nova visibilidade$")
    public void selecionarNovaVisibilidade(){
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.selecionarNovavisibilidade();
    }

    @Then ("^o sistema atualiza a visibilidade da tarefa$")
    public void validarAtualizacaovisibilidade(){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"http://127.0.0.1:8989/view_all_bug_page.php");

    }

    //adicionar anotacao
    @When("^selecionar o parâmetro adicionar anotacao$")
    public void selecionarAdicionarAnotacao(){
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        verTarefaPage.selecionarAdicionarAnotacao();

    }

    @Then ("^o sistema atualiza a tarefa$")
    public void validarAtualizacaoTarefa(){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"http://127.0.0.1:8989/view_all_bug_page.php");

    }}


