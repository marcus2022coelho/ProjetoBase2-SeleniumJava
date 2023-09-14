package projetoBase2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CampoPersonalizadoPage extends BasePage{
    public CampoPersonalizadoPage(WebDriver driver) {
        super(driver);
    }
    By elementoComumGerenciarMenu = (By.xpath("//*[@class=\"menu-icon fa fa-gears\"]"));
    By campoPersonalizadoMenu = (By.xpath("//a[contains(@href, 'manage_custom_field_page.php')]"));
    By nomeCampoPersonalizado = (By.xpath("//input[contains(@class, 'input-sm')]"));
    By adicionarCampoPersonalizado = (By.xpath("//input[@value='Novo Campo Personalizado']"));

    // editar campo
    By campoPersonalizadoComum = (By.xpath("//a[contains(@href, 'manage_custom_field_edit_page.php?field_id=1')]"));
    By atualizarCampoPersonalizado = (By.xpath("//input[@value='Atualizar Campo Personalizado']"));
    By alterarAcessoLeitura = (By.xpath("//*[@id='custom-field-access-level-r']/option"));
    By alterarAcessoEscrita = By.id("custom-field-access-level-rw");

    // vincular campo
    By campoParaVincular = (By.xpath("//*[@id='custom-field-project-id']/option"));
    By buttonVincular = (By.xpath("//input[@value='Vincular Campo Personalizado']"));

    // excluir o vinculo
    By excluirVinculoCampo = (By.xpath("//a[normalize-space()='campoParaSerApagado']"));
    By apagarVinculoCampoPersonalizado = (By.xpath("//input[@value='Apagar Campo Personalizado']"));
    By confirmaExclusao = (By.xpath("//input[@value='Apagar Campo']"));
    By mensagemDeSucesso = (By.xpath("//*[contains(., 'Operação realizada com sucesso.')]"));

    public void gerenciarNoMenu() {
        WebElement clicarGerenciarMenu = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumGerenciarMenu)));
        clicarGerenciarMenu.click();
    }

    public void clicarNoMenuCampoPersonalizado() {
        WebElement menuCampoPersonalizado = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(campoPersonalizadoMenu)));
        menuCampoPersonalizado.click();
    }

    public void preencherNomeCampo(String campoPersonalizado) {
        WebElement nomeCampoPersonalizadoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(nomeCampoPersonalizado)));
        nomeCampoPersonalizadoField.sendKeys(campoPersonalizado);
    }

    public void adicionarCampoButton() {
        WebElement buttonAdicionarCampo = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(adicionarCampoPersonalizado)));
        buttonAdicionarCampo.click();
    }

    public void confirmoCriacao() {
        WebElement criacaoComSucesso = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(mensagemDeSucesso)));
        criacaoComSucesso.getText();
    }

    // campo personalizado com o mesmo nome
    public String campoPersonalizadoMesmoNome(){
        By mensagemErroCampoMesmoNome = (By.xpath("//div[@class='error-info']"));
        WebElement elementoMensagemErroCampoMesmoNome = wait.until(ExpectedConditions.visibilityOf(driver.findElement(mensagemErroCampoMesmoNome)));
        return elementoMensagemErroCampoMesmoNome.getText();

    }

    // editar campo personalizado
    public void selecionarCampoEdicao() {
        WebElement editarCampoPersonalizado = wait.until(ExpectedConditions.visibilityOf(driver.findElement(campoPersonalizadoComum)));
        editarCampoPersonalizado.click();
    }

    public void preenchoAcessoLeitura(String acessoDeLeitura) {
        WebElement editarAcessoLeitura = wait.until(ExpectedConditions.visibilityOf(driver.findElement(alterarAcessoLeitura)));
        editarAcessoLeitura.click();
    }

    public void preenchoAcessoEscrita(String acessoDeEscrita) {
        WebElement editarAcessoEscrita = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(alterarAcessoEscrita)));
        editarAcessoEscrita.click();
    }

    public void concluirEdicaoCampo() {
        WebElement buttonAtualizarCampo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarCampoPersonalizado)));
        buttonAtualizarCampo.click();
    }

    // vincular campo ao projeto
    public void selecionarTarefaVincular() {
        WebElement tarefaParaVincular = wait.until(ExpectedConditions.visibilityOf(driver.findElement(campoPersonalizadoComum)));
        tarefaParaVincular.click();
    }

    public void vincularCampoProjeto() {
        WebElement selecionarVincularCampo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(campoParaVincular)));
        selecionarVincularCampo.click();
    }

    public void vincularCampoBotao() {
        WebElement buttonVincularCampo = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(buttonVincular)));
        buttonVincularCampo.click();
    }

    // excluir campo
    public void selecionarCampoExcluir() {
        WebElement campoExcluirVinculo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(excluirVinculoCampo)));
        campoExcluirVinculo.click();
    }

    public void apagarCampoPersonalizado() {
        WebElement apagarCampoPersonalizadoVinculo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(apagarVinculoCampoPersonalizado)));
        apagarCampoPersonalizadoVinculo.click();
    }

    public void confirmarButton() {
        WebElement confirmarExclusaoButton = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(confirmaExclusao)));
        confirmarExclusaoButton.click();
    }

    public void visualizarMensagem() {
        WebElement visualizarMensagem = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(mensagemDeSucesso)));
        visualizarMensagem.getText();
    }

}
