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
    }

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


    //enviar lembrete
    //preciso de qualquer tarefa
    By selecionarTarefaLembrete = (By.xpath("//tr[1]//td[contains(@class, 'column-id')]"));
    By enviarLembreteMenu = (By.xpath("//a[normalize-space()='Enviar um lembrete']"));
    By preencherTextoLembrete = (By.xpath("//*[@id=\"send-reminder-div\"]"+"/form/div/div[2]/div[1]/div/table/tbody/tr/td[2]/textarea"));
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
    By retornoFiltroTrue =  By.xpath("//*[@id=\"buglist\"]/tbody");


    //salvar o filtro
    By salvarOfiltro = (By.xpath("//a[normalize-space()='Salvar']"));
    By digitarNomeFiltro = (By.xpath("//input[@name='query_name']"));
    By salvarOfiltroDefinitivo = (By.xpath("//input[@value='Salvar Filtro Atual']"));
    By voltarSalvarFiltroButtom = By.xpath("//input[@value='Voltar']");

    //usar filtro salvo
    By aplicarFiltroSalvo = (By.xpath("//input[@value='Aplicar Filtro']"));

    //imprimir tarefas
    By imprimirTodasTarefas = (By.xpath("//a[normalize-space()='Imprimir Tarefas']"));



    // query que irá retornar caso o filtro retorne algum valor
    //retornoFiltroTrue

    public boolean resultadoEncontrado(){
        WebElement elementoRetornoFiltroTrue = wait.until(ExpectedConditions.visibilityOf(driver.findElement(retornoFiltroTrue)));
        return  !elementoRetornoFiltroTrue.findElements(By.tagName("tr")).isEmpty();
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
        WebElement selecionarTarefaDeLembrete = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(selecionarTarefaLembrete)));
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

    public void informarNomeDoFiltro(String nomeDoFiltro) {
        WebElement nomeDoFiltroField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(digitarNomeFiltro)));
        nomeDoFiltroField.sendKeys(nomeDoFiltro);
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

    public void selecionarTarefa() {
        WebElement elementoSelecionarTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarTarefa)));
        elementoSelecionarTarefa.click();
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

    public void botaoOkConfirmarTarefa(){
        WebElement elementobuttomOkCopiaTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttomOkCopiaTarefa)));
        elementobuttomOkCopiaTarefa.click();
    }
    public void setSelecionarUsuario(){
        WebElement elementoselecionarUsuario = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarUsuario)));
        elementoselecionarUsuario.click();
    }
    public String mensagemErroCampoObrigatorio(){
        WebElement elementoMensagemErroCampoObrigatorio = wait.until(ExpectedConditions.visibilityOf(driver.findElement(mensagemErroCampoObrigatorio)));
        return elementoMensagemErroCampoObrigatorio.getText();
    }
    public void voltarSalvarFiltroButtom(){
        WebElement elementovoltarSalvarFiltroButtom = wait.until(ExpectedConditions.visibilityOf(driver.findElement(voltarSalvarFiltroButtom)));
        elementovoltarSalvarFiltroButtom.click();
    }

}
