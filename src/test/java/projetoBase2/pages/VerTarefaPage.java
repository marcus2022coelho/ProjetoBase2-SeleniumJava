package projetoBase2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class VerTarefaPage extends BasePage {

    public VerTarefaPage(WebDriver driver) {
        super(driver);
        VerTarefaPage verTarefaPage;


    }

    //private String texto;
    // bptão padrão para todos os botóes
    //By elementoVisualizado = By.xpath("(//*[text()='" + texto + "'])[1]");

    //atualizar gravidade
    By botaoAtualizarGravidade = By.xpath("//input[@value='Atualizar Gravidade']");

    //atualizar prioridade
    By botaoAtualizarPrioridade = By.xpath("//input[@value='Atualizar Prioridade']");

    // marcar/desmarcar pegajoso
    By botaoMarcarDesmarcarPegajoso = By.xpath("//input[@value='Marcar/Desmarcar Pegajosos']");

    //atualizarPrioridade
    By selecionarNovaPrioridade = By.xpath("//select[@name='priority']");

    //atualizar gravidade
    By selecionarNovaGravidade = By.xpath("//select[@name='severity']");

    //atualizar status
    By selecionarNovoStatus = By.xpath("//select[@name='status']");
    By adicionarAnotacao = By.xpath("//textarea[@id='bugnote_text']");
    By buttomAtualizarStatus = By.xpath("//input[@value='Atualizar Status']");

    //atualizar categoria
    By atualizarCategoria = By.xpath("//select[@name='action']");
    By buttomOk = By.xpath("//input[@value='OK']");
    By selecaoNovaCategoria = By.xpath("//select[@name='category']");

    //atualizar visibilidade
    By atualizarVisibilidadeSeletor = By.xpath("//select[@name='action']");
    By selecaoNovaVisibilidade = By.xpath("//select[@name='view_status']");

    //adicionar anotação
    By adicionarAnotacaoSeletor = By.xpath("//select[@name='action']");

    //mover tarefa
    By botaoMoverTarefa = By.xpath("//input[@value='Mover Tarefas']");

    //Atribuir tarefa
    By botaoAtribuirTarefa = By.xpath("//input[@value='Atribuir Tarefas']");

    //fechar tarefa
    By anotacaoTarefa = By.xpath("//textarea[@id='bugnote_text']");
    By buttonFecharTarefas = By.xpath("//input[@value='Fechar Tarefas']");
    By fecharTarefaSeletorElemento = By.xpath("//select[@name='action']");
    By seletoracaoPadraoVerTarefaAction = By.xpath("//select[@name='action']");

    //Resolver Tarefa
    By buttonResolverTarefa = By.xpath("//input[@value='Resolver Tarefas']");
    By seletorResolucaoTarefa = By.xpath("//select[@name='resolution']");

    //apagar tarefa
    By elementoVerTarefaComum = (By.xpath("//a[contains(@href, 'view_all_bug_page.php')]"));
    By tarefaExclusao = (By.xpath("//table[@id='buglist']/tbody/tr[1]"));
    By apagarTarefaButtonConfirmar = (By.xpath("//input[@value='Apagar']"));
    By apagarTarefaButton = (By.xpath("//input[@value='Apagar Tarefas']"));
    By selecionarTarefa = By.xpath("//span[@class='lbl']");
    // botão destinado a realizar a ação que foi selecionada no seletor de opcoes
    By buttomOkAcaoComboBox = By.xpath("//input[@value='OK']");

    //clonar tarefa
    By copiarTarefas = By.xpath("//input[@value='Copiar Tarefas']");
    By confirmarCopiarTarefa = By.xpath("//input[@value='Copiar Tarefas']");
    By buttomOkCopiaTarefa = By.xpath("//input[@value='OK']");

    //fixarDesfixar
    By elementoFixarDesfixar = By.xpath("//select[@name='action']");


    //enviar lembrete
    //preciso de qualquer tarefa
    //tr[1]//td[@class='column-id']//a[contains(text(),'00000')]
    By selecionarTarefaLembrete = (By.xpath("//tr[1]//td[contains(@class, 'column-id')]"));
    By enviarLembreteMenu = (By.xpath("//a[normalize-space()='Enviar um lembrete']"));
    By preencherTextoLembrete = (By.xpath("//*[@id=\"send-reminder-div\"]" + "/form/div/div[2]/div[1]/div/table/tbody/tr/td[2]/textarea"));
    By buttonEnviarLembrete = (By.xpath("//input[@value='Enviar']"));
    By confirmarEnvioSucesso = (By.xpath("//*[contains(., 'Operação realizada com sucesso.')]"));
    By selecionarUsuario = (By.xpath("//option[@value='1']"));
    By mensagemErroCampoObrigatorio = By.xpath("//p[contains(text(),'Um parâmetro necessário para esta página (to) não ')]");
    //p[contains(text(),'Um parâmetro necessário para esta página (to) não ')]

    //pesquisar tarefa
    By clicoRelator = By.id("reporter_id_filter");
    By selecionarAtribuidoA = By.id("handler_id_filter");
    By clicarPrioridade = By.id("show_priority_filter");
    By clicarResolucao = By.id("show_resolution_filter");
    By pesquisarTarefa = (By.xpath("//input[@value='Aplicar Filtro']"));
    // retorno da busca do filtro
    By retornoFiltroTrue = By.xpath("//*[@id=\"buglist\"]/tbody");


    //salvar o filtro
    By salvarOfiltro = (By.xpath("//a[normalize-space()='Salvar']"));
    By digitarNomeFiltro = (By.xpath("//input[@name='query_name']"));
    By salvarOfiltroDefinitivo = (By.xpath("//input[@value='Salvar Filtro Atual']"));
    By voltarSalvarFiltroButtom = By.xpath("//input[@value='Voltar']");

    //usar filtro salvo
    By aplicarFiltroSalvo = (By.xpath("//input[@value='Aplicar Filtro']"));

    //imprimir tarefas
    By imprimirTodasTarefas = (By.xpath("//a[normalize-space()='Imprimir Tarefas']"));

    
    
    // clicar botão visivel
    public void tocarBotaoPeloNome(String textoBotao){
        By elementoVisualizado = By.xpath("//input[@value='"+ textoBotao +"']");
        WebElement elementoElementoVisualizado = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoVisualizado)));
        elementoElementoVisualizado.click();
    }
    //atualizar prioridade buttom
    public void tocarBotaoAtualizarPrioridade(){
        WebElement elementoBotaoAtualizarPrioridade = wait.until(ExpectedConditions.visibilityOf(driver.findElement(botaoAtualizarPrioridade)));
        elementoBotaoAtualizarPrioridade.click();
    }
    //atualizar gravidade buttom
    public void tocarBotaoAtualizarGravidade(){
        WebElement elementoBotaoAtualizarPrioridade = wait.until(ExpectedConditions.visibilityOf(driver.findElement(botaoAtualizarGravidade)));
        elementoBotaoAtualizarPrioridade.click();
    }

    //Marcar/Desmarcar Pegajosos
    public void tocarMarcarDesmarcarPegajosos (){
        WebElement elementobotaoMarcarDesmarcarPegajoso = wait.until(ExpectedConditions.visibilityOf(driver.findElement(botaoMarcarDesmarcarPegajoso)));
        elementobotaoMarcarDesmarcarPegajoso.click();
    }

    //mover tarefa
    public void selecaoUsuarioMoverTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='project_id']")));
        dropdown.selectByValue("41");
    }

    public void selecionarBotaoMoverTarefa() {
        WebElement elementoButtomMoverTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(botaoMoverTarefa)));
        elementoButtomMoverTarefa.click();
    }
    // query que irá retornar caso o filtro retorne algum valor
    //retornoFiltroTrue

    public boolean resultadoEncontrado() {
        WebElement elementoRetornoFiltroTrue = wait.until(ExpectedConditions.visibilityOf(driver.findElement(retornoFiltroTrue)));
        return !elementoRetornoFiltroTrue.findElements(By.tagName("tr")).isEmpty();
    }

    // Atribuir Tarefa
    public void selecaoUsuarioAtribuirTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='assign']")));
        dropdown.selectByValue("1");
    }

    public void selecionarBotaoAtribuirTarefa() {
        WebElement elementoButtomAtribuirTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(botaoAtribuirTarefa)));
        elementoButtomAtribuirTarefa.click();
    }


    public void selecionarMenuVerTarefas() {
        WebElement verTarefaMenuComum = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementoVerTarefaComum)));
        verTarefaMenuComum.click();
    }

    public void selecionarTarefaExcluir() {
        WebElement tarefaDeExclusao = wait.until(ExpectedConditions.visibilityOf(driver.findElement(tarefaExclusao)));
        tarefaDeExclusao.click();
    }

    public void buttonApagarTarefa() {
        WebElement apagarTarefa = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(apagarTarefaButtonConfirmar)));
        apagarTarefa.click();
    }

    public void confirmaApagarTarefa() {
        WebElement confirmarApagarTarefa = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(apagarTarefaButton)));
        confirmarApagarTarefa.click();
    }

    public void confirmaCopiarTarefa() {
        WebElement elementoConfirmarCopiarTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmarCopiarTarefa)));
        elementoConfirmarCopiarTarefa.click();
    }

    //enviar lembrete
    public void selecionarTarefaLembrete() {
        WebElement selecionarTarefaDeLembrete = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarTarefaLembrete)));
        selecionarTarefaDeLembrete.click();
    }

    public void enviarLembreteTarefa() {
        WebElement enviarLembreteField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(enviarLembreteMenu)));
        enviarLembreteField.click();
    }

    public void informarOusuario(String usuarioRecebe) {
        Select dropdown = new Select(driver.findElement(By.id("recipient")));
        dropdown.selectByVisibleText(usuarioRecebe);
    }

    public void ecrevoMensagemLembrete(String textoLembrete) {
        WebElement enviarLembreteField = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(preencherTextoLembrete)));
        enviarLembreteField.sendKeys(textoLembrete);
    }

    public void enviarLembrete() {
        WebElement enviarLembreteButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttonEnviarLembrete)));
        enviarLembreteButton.click();
    }

    public String visualizoMensagemEnvioSucesso() {
        WebElement mensagemLembrete = wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmarEnvioSucesso)));
        return mensagemLembrete.getText();
    }

    //realizar a pesquisa
    public void selecionarRelator(String relator) {
        WebElement habilitarRelator = wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicoRelator)));
        habilitarRelator.click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='reporter_id[]']")));
        dropdown.selectByVisibleText(relator);
    }

    public void selecionarAtribuidoA(String atribuidoA) {
        WebElement selectatribuidoA = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarAtribuidoA)));
        selectatribuidoA.click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='handler_id[]']")));
        dropdown.selectByVisibleText(atribuidoA);
    }

    public void selecionarPrioridade(String prioridade) {
        WebElement clicoPrioridade = wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicarPrioridade)));
        clicoPrioridade.click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='priority[]']")));
        dropdown.selectByVisibleText(prioridade);
    }

    public void clicoParaPesquisar() {
        WebElement clicoPesquisar = wait.until(ExpectedConditions.visibilityOf(driver.findElement(pesquisarTarefa)));
        clicoPesquisar.click();
    }


    //salvar o filtro
    public void informarRelator(String relator) {
        WebElement selecionarLink = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(clicoRelator)));
        selecionarLink.click();
    }

    public void informarAtribuir(String atribuidoA) {
        WebElement selecionarLinkAtribuir = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(selecionarAtribuidoA)));
        selecionarLinkAtribuir.click();
    }

    public void salvarFitroSucesso() {
        WebElement salvarFitro = wait.until(ExpectedConditions.visibilityOf(driver.findElement(salvarOfiltro)));
        salvarFitro.click();
    }

    public void informarNomeDoFiltro() {
        WebElement nomeDoFiltroField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(digitarNomeFiltro)));
        nomeDoFiltroField.sendKeys(gerarNomeAleatorio());
    }

    public void salvarFitroDefinitivo() {
        WebElement salvarFitroDefinitivo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(salvarOfiltroDefinitivo)));
        salvarFitroDefinitivo.click();
    }

    public void selecionarNomeFiltro(String nomeDoFiltro) {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='source_query_id']")));
        dropdown.selectByVisibleText(nomeDoFiltro);
    }


    //imprimir tarefas
    public void imprimirTarefas() {
        WebElement imprimirTarefasButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(imprimirTodasTarefas)));
        imprimirTarefasButton.click();
    }

    public String selecionarTarefa() {
        WebElement elementoSelecionarTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarTarefa)));
        elementoSelecionarTarefa.click();

        //Ao selecionar a tarefa, o sistema irá guardar a tarefa, para identificarmos futuras mudanças na tarefa e realizar testes de assercao
        By elementoValorDaLinhaTarefaSelecionada = By.xpath("//span[@class='lbl']/ancestor::tr//td[4]");
        WebElement numeroDaTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoValorDaLinhaTarefaSelecionada)));
        return numeroDaTarefa.getText();

    }
    public void selecionarTarefaPeloNumero(){
        WebElement elementoSelecionaTarefaPeloNumero = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[@class='column-id']//a[contains(text(),'00000')]"))));

    }

    public int validaQuantidadeDeLinhasTabelaTarefas() {
        int inicioValorLinha = driver.findElements(By.xpath("//table[@class=\"table table-bordered table-condensed table-hover table-striped\"]/tbody/tr")).size();
        return inicioValorLinha;
    }

    public boolean retornaSeTarefaExiste() {
        return returnIfElementExistsByTime(selecionarTarefa, 5);

    }

    public void seletorDeteleTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByValue("DELETE");
    }

    public void selecionarAcaoButtomComboBox() {
        WebElement elementoBotaoOk = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttomOkAcaoComboBox)));
        elementoBotaoOk.click();
    }

    public void seletorCopiarTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByValue("COPY");

    }

    public void copiartarefas() {
        WebElement elementoCopiarTarefaButtom = wait.until(ExpectedConditions.visibilityOf(driver.findElement(copiarTarefas)));
        elementoCopiarTarefaButtom.click();
    }

    public void botaoOkConfirmarTarefa() {
        WebElement elementobuttomOkCopiaTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttomOkCopiaTarefa)));
        elementobuttomOkCopiaTarefa.click();
    }

    public void setSelecionarUsuario() {
        WebElement elementoselecionarUsuario = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarUsuario)));
        elementoselecionarUsuario.click();
    }

    public String mensagemErroCampoObrigatorio() {
        WebElement elementoMensagemErroCampoObrigatorio = wait.until(ExpectedConditions.visibilityOf(driver.findElement(mensagemErroCampoObrigatorio)));
        return elementoMensagemErroCampoObrigatorio.getText();
    }

    public void voltarSalvarFiltroButtom() {
        WebElement elementovoltarSalvarFiltroButtom = wait.until(ExpectedConditions.visibilityOf(driver.findElement(voltarSalvarFiltroButtom)));
        elementovoltarSalvarFiltroButtom.click();
    }

    public void seletorMoverTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByVisibleText("Mover");
    }

    public void seletorAtribuirTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByValue("ASSIGN");
    }

    public void seletorFecharTarefa() {
        WebElement dropdownWait = wait.until(ExpectedConditions.visibilityOf(driver.findElement(fecharTarefaSeletorElemento)));
        Select dropdown = new Select(dropdownWait);
        dropdown.selectByValue("CLOSE");
    }

    public void seletorResolverTarefa() {
        WebElement dropdownWait = wait.until(ExpectedConditions.visibilityOf(driver.findElement(seletoracaoPadraoVerTarefaAction)));
        Select dropdown = new Select(dropdownWait);
        dropdown.selectByValue("RESOLVE");
    }

    public void seletorFixarDesfixarTarefa() {
        WebElement elementoFixarDesfixarW = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoFixarDesfixar)));
        Select dropdown = new Select(elementoFixarDesfixarW);
        dropdown.selectByValue("SET_STICKY");
    }

    public void seletorAtualizarPrioridadeTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByValue("UP_PRIOR");
    }

    public void seletorAtualizarGravidadeTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByValue("EXT_UPDATE_SEVERITY");
    }

    public void seletorAtualizarStatusTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByValue("UP_STATUS");
    }

    public void seletorAtualizarCategoriaTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByValue("Atualizar Categoria");
    }

    public void seletorAtualizarVisibilidadeTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByValue("Atualizar Visibilidade");
    }

    public void seletorAdicionarAnotaçãoTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByValue("Adicionar Anotação");
    }

    public void seletorAplicarMarcadoresTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByValue("Aplicar marcadores");
    }

    // fechar tarefa
    public void fecharTarefa() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='action']")));
        dropdown.selectByValue("CLOSE");
    }

    public void anotacaoTarefa() {
        WebElement elementoAnotacaoFecharTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(anotacaoTarefa)));
        elementoAnotacaoFecharTarefa.sendKeys("teste fechar tarefa");
    }

    public void tocarFecharTarefas() {
        WebElement elementoFecharTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttonFecharTarefas)));
        elementoFecharTarefa.click();
    }

    //resolver tarefa
    public void tocarResolverTarefas() {
        WebElement elementoResolverTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttonResolverTarefa)));
        elementoResolverTarefa.click();
    }

    public void resolucaoTarefa() {
        WebElement elementoSeletorResolucaoTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(seletorResolucaoTarefa)));
        Select dropdown = new Select(elementoSeletorResolucaoTarefa);
        dropdown.selectByValue("20");
    }
    public void setSelecionarNovaPrioridade() {
        WebElement elementoSeletorResolucaoTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarNovaPrioridade)));
        Select dropdown = new Select(elementoSeletorResolucaoTarefa);
        dropdown.selectByValue("20");
    }
    public void setSelecionarNovaGravidade() {
        WebElement elementoSeletorResolucaoTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarNovaGravidade)));
        Select dropdown = new Select(elementoSeletorResolucaoTarefa);
        dropdown.selectByValue("20");
    }

    //Atualizar tarefa
    public void setSelecionarNovoStatus() {
        WebElement elementoSeletorResolucaoTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarNovoStatus)));
        Select dropdown = new Select(elementoSeletorResolucaoTarefa);
        dropdown.selectByValue("20");
    }
    public void setAdicionarAnotacao(){
        WebElement elementoAdicionarAnotacao = wait.until(ExpectedConditions.visibilityOf(driver.findElement(adicionarAnotacao)));
        elementoAdicionarAnotacao.sendKeys("Anotação teste atualizar status");
    }

    public boolean RetornaSeExisteStatusResolvido() {
        By elementoResolvidoStatus = By.xpath("//span[@title='corrigido']");
        return returnIfElementExistsByTime(elementoResolvidoStatus, 2);

    }
    public void tocarAtualizarTarefaButtom(){
        WebElement elementobuttomAtualizarStatus = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttomAtualizarStatus)));
        elementobuttomAtualizarStatus.click();
    }



    // pegar o campo Estado de uma linha especifica
    public void pegarValorLinha() {
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);
        String numeroTarefa = verTarefaPage.ifTarefaNaoExisteCriaUmaNovaEseleciona();

    }



    public void setSelecionarNovaCategoria() {
        WebElement elementoNovaCategoria = wait.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarCategoria)));
        Select dropDown = new Select(elementoNovaCategoria);
        dropDown.selectByValue("UP_CATEGORY");
    }

    public void setTocarbuttomOK() {
        WebElement elementoButtomOK = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttomOk)));
        elementoButtomOK.click();
    }


    public void selecionarNovaCategoria() {
        WebElement elementoSelecaoNovaCategoria = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecaoNovaCategoria)));
        Select dropdown = new Select(elementoSelecaoNovaCategoria);
        dropdown.selectByValue("1");
    }

    public void setSelecionarAtualizarVisibilidade() {
        WebElement elementoAtualizarVisibilidadeSeletor = wait.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarVisibilidadeSeletor)));
        Select dropDown = new Select(elementoAtualizarVisibilidadeSeletor);
        dropDown.selectByValue("VIEW_STATUS");
    }


    public void selecionarNovavisibilidade() {
        WebElement elementoSelecaoNovavisibilidade = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecaoNovaVisibilidade)));
        Select dropdown = new Select(elementoSelecaoNovavisibilidade);
        dropdown.selectByValue("10");
    }

    public void selecionarAdicionarAnotacao(){
        WebElement elementoAdicionarAnotacao = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@name='action']"))));
        Select dropdown = new Select(elementoAdicionarAnotacao);
        dropdown.selectByValue("EXT_ADD_NOTE");
    }
}
