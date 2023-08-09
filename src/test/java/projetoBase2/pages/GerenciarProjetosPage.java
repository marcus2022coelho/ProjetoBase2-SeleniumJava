package projetoBase2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class GerenciarProjetosPage extends BasePage {


    public GerenciarProjetosPage(WebDriver driver) {
        super(driver);
    }

    By elementoComumMenuGerenciar = (By.xpath("//*[@class=\"menu-icon fa fa-gears\"]"));
    By elementoComumGerenciarProjetos = (By.xpath("//a[contains(@href, 'manage_proj_page.php')]"));
    By botaoNovoProjeto = (By.xpath("//button[contains(@class, 'btn btn-primary btn-white btn-round')]"));
    By elementoComumNomeProjeto = By.id("project-name");
    By selecionarStatus = By.id("project-status");
    By selecionarVisibilidade = By.id("project-view-state");
    By elementoComumDescProjeto = By.id("project-description");
    By elementoComumSalvar = (By.xpath("//input[@value='Adicionar projeto']"));
    By operacaoRealizadaSucesso = (By.xpath("//*[contains(., 'Operação realizada com sucesso.')]"));
    By MensagemErroSalvarProjetoMesmoNome = By.xpath("//p[contains(text(),'Um projeto com este nome já existe.')]");

    // editar o projeto
    By selectProjeto = (By.xpath("//tbody/tr[1]/td[1]/a[1]"));
    By atualizarOprojetoEditado = (By.xpath("//input[@value='Atualizar Projeto']"));

    // excluir o projeto
    By selectProjetoExcluir = (By.xpath("//tbody/tr[1]/td[1]/a[1]"));
    By excluirProjetoBotao = (By.xpath("//input[@value='Apagar Projeto']"));

    // adicionar usuario projeto
    By projetoAdicionarUsuario = (By.xpath("//a[contains(@href, 'manage_proj_edit_page.php?project_id=36')]"));
    By usuarioAdicionado = (By.xpath("//input[@value='Adicionar Usuário']"));

    //validar se projeto existe
    By validarProjetoExiste = (By.xpath("//tbody/tr[1]/td[1]/a[1]"));
    By validarProjetoExiste2 = (By.xpath("//tbody/tr[1]/td[1]/a[1]"));

    //selecionar projeto pelo nome
    By SelecionarProjetoPeloNome = (By.xpath("//tbody//tr//td//a[contains(text(),'Cadastrar o projeto com mesmo nome')]"));

    // selecionar e clicar no projeto pelo nome
    public void clicarProjetoPeloNome(){
        WebElement clicarProjetoPeloNome = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SelecionarProjetoPeloNome)));
        clicarProjetoPeloNome.click();
    }

    // método para clicar no projeto existente, pegando sempre a primeira posição da tabela de projetos
    public void clicarSobreProjeto(){
        WebElement clicarSobreProjeto = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(validarProjetoExiste)));;
        clicarSobreProjeto.click();
    }

    // método para retornar o elemento como um WebEelement
    public WebElement clicarSobreProjeto2(){
        WebElement clicarSobreProjeto2 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(validarProjetoExiste2)));
        return clicarSobreProjeto2;
    }

    // retornar true ou false se o elemento existe na tela
    public boolean retornarSeProjetoExiste() {
       return returnIfElementExistsByTime(validarProjetoExiste,5);
    }


    public void selecionarGerenciarMenu() {
        WebElement menuGerenciarAdmin = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumMenuGerenciar)));
        menuGerenciarAdmin.click();
    }

    public void selecionarGerenciarProjetosAba() {
        WebElement gerenciarProjetosAba = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumGerenciarProjetos)));
        gerenciarProjetosAba.click();
    }

    public void selecionarBotaoNovoProjeto() {
        WebElement clicarBotaoNovoProjeto = wait.until(ExpectedConditions.visibilityOf(driver.findElement(botaoNovoProjeto)));
        clicarBotaoNovoProjeto.click();
    }

    public void preencherNomeDoProjeto(String nomeDoProjeto) {
        WebElement nomeProjetoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumNomeProjeto)));
        nomeProjetoField.clear();
        nomeProjetoField.sendKeys(nomeDoProjeto);
    }

    public void selecionarEstado(String Estado) {
        Select dropdown = new Select(driver.findElement(By.id("project-status")));
        dropdown.selectByVisibleText(Estado);
    }

    public void selecionarVisibilidade(String Visibilidade) {
        Select dropdown = new Select(driver.findElement(By.id("project-view-state")));
        dropdown.selectByVisibleText(Visibilidade);
    }

    public void preencherCampoDescricao(String campoDescricao) {
        WebElement descricaoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumDescProjeto)));
        descricaoField.clear();
        descricaoField.sendKeys(campoDescricao);
    }

    public void clicarBotaoAdicionarProjeto() {
        WebElement salvarBotaoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumSalvar)));
        salvarBotaoField.click();
    }
    public String getConfirmacaoCriacaoProjeto(){
        WebElement confirmaCriacaoProjeto = wait.until(ExpectedConditions.visibilityOf(driver.findElement(operacaoRealizadaSucesso)));
        return confirmaCriacaoProjeto.getText();
    }


    // Editar o projeto
    public void selectProjetoAtualizar() {
        WebElement selectEditProjetoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectProjeto)));
        selectEditProjetoField.click();
    }

    public void editarNomeDoProjeto(String nomeProjetoEdit) {
        WebElement editNomeProjetoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumNomeProjeto)));
        editNomeProjetoField.clear();
        editNomeProjetoField.sendKeys(nomeProjetoEdit);
    }

    public void editarEstado(String Estado) {
        Select dropdown = new Select(driver.findElement(By.id("project-status")));
        dropdown.selectByVisibleText(Estado);
    }

    public void editarVisibilidade(String Visibilidade) {
        Select dropdown = new Select(driver.findElement(By.id("project-view-state")));
        dropdown.selectByVisibleText(Visibilidade);
    }

    public void editarCampoDescricao(String campoDescricaoEdit) {
        WebElement editarDescricaoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumDescProjeto)));
        editarDescricaoField.clear();
        editarDescricaoField.sendKeys(campoDescricaoEdit);
    }

    public void atualizarOprojeto() {
        WebElement atualizarOProjetoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarOprojetoEditado)));
        atualizarOProjetoField.click();
    }

    public void preencherNomeProjetoIgual(String nomeProjetoIgual) {
        WebElement nomeProjetoIgualField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumNomeProjeto)));
        nomeProjetoIgualField.clear();
        nomeProjetoIgualField.sendKeys(nomeProjetoIgual);
    }

    public void selecionarEstadoIgual(String estadoIgual) {
        Select dropdown = new Select(driver.findElement(By.id("project-status")));
        dropdown.selectByVisibleText(estadoIgual);
    }

    public void selecionarVisibilidadeIgual(String visibilidadeIgual) {
        Select dropdown = new Select(driver.findElement(By.id("project-view-state")));
        dropdown.selectByVisibleText(visibilidadeIgual);
    }

    public void preencherCampoDescricaoIgual(String campoDescricaoIgual) {
        WebElement descricaoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumDescProjeto)));
        descricaoField.clear();
        descricaoField.sendKeys(campoDescricaoIgual);
    }

    public void salvarProjetoBotao() {
        WebElement mesmoProjetoSalvar = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumSalvar)));
        mesmoProjetoSalvar.click();
    }

    public String MensagemDeErroSalvarProjetoMesmoNome() {
        WebElement mensagemDeErro = wait.until(ExpectedConditions.visibilityOf(driver.findElement(MensagemErroSalvarProjetoMesmoNome)));
        return mensagemDeErro.getText();
    }

    // excluir o projeto
    public void selecionarProjetoExcluir() {
        WebElement excluirProjetoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectProjetoExcluir)));
        excluirProjetoField.click();
    }

    public void apagarProjetoBotao() {
        WebElement apagarProjetoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(excluirProjetoBotao)));
        apagarProjetoField.click();
    }

    public void confirmaApagaProjetoBotao() {
        WebElement confirmaExlcusaoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(excluirProjetoBotao)));
        confirmaExlcusaoField.click();
    }

}
