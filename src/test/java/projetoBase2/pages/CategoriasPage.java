package projetoBase2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CategoriasPage extends  BasePage{
    public CategoriasPage(WebDriver driver) {
        super(driver);
    }
    By elementoMenuGerenciar = (By.xpath("//*[@class=\"menu-icon fa fa-gears\"]"));
    By elementoGerenciarProjetos = (By.xpath("//a[contains(@href, 'manage_proj_page.php')]"));
    By categoriaField = (By.xpath("//input[@name='name']"));
    By adicionarCategoria = (By.xpath("//input[@value='Adicionar Categoria']"));

    // adicionar alterar categoria
    By adicionarAlterarCategoria = (By.xpath("//input[@value='Adicionar e editar Categoria']"));
    By atualizarCategoriaButton = (By.xpath("//input[@value='Atualizar Categoria']"));
    By validarCriacaoAlteracao = (By.xpath("//*[contains(., 'Operação realizada com sucesso.')]"));

    // campo vazio
    By validarTexto = (By.xpath("//*[contains(., 'APPLICATION ERROR #11')]"));

    //exclusão da categoria
    By selecionarCategoriaExclusao = (By.xpath("//*[@id=\"categories\"]"
            + "/div/div[2]/div/div/table/tbody/tr[1]/td[3]/div/div[2]/form/fieldset/button"));
    By buttonConfirmaExclusao = (By.xpath("//input[@value='Apagar Categoria']"));
    By validarMensagemSucesso = (By.xpath("//*[contains(., 'Operação realizada com sucesso.')]"));

    // alterar categoria
    By acoesAlterarCategoria = (By.xpath("//*//*[@id=\"categories\"]/div/div[2]/div/div/table/tbody/tr[2]/td[3]/div/div[1]/form/fieldset/button"));

    public void gerenciarMenu() {
        WebElement menuGerenciar = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementoMenuGerenciar)));
        menuGerenciar.click();
    }

    public void abaGerenciarProjetos() {
        WebElement menuGerenciarProjetos = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementoGerenciarProjetos)));
        menuGerenciarProjetos.click();
    }

    public void preencherNomeCategoria(String nomeDaCategoria) {
        WebElement nomeCategoriaField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(categoriaField)));
        nomeCategoriaField.sendKeys(nomeDaCategoria);
    }

    public void categoriaButton() {
        WebElement adicionarCategoriaButton = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(adicionarCategoria)));
        adicionarCategoriaButton.click();
    }

    // adicionar e alterar categoria
    public void informarNomeCategoria() {
        WebElement nomeCategoriaField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(categoriaField)));
        nomeCategoriaField.sendKeys(gerarNomeAleatorio());
    }

    public void buttonAdicionarAlterar() {
        WebElement adicionarAlterarCategoriaButton = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(adicionarAlterarCategoria)));
        adicionarAlterarCategoriaButton.click();
    }

    public void selecionarAtribuir(String atribuidoA) {
        Select dropdown = new Select(driver.findElement(By.id("proj-category-assigned-to")));
        dropdown.selectByVisibleText(atribuidoA);
    }

    public void atualizarCategoriaButton() {
        WebElement atualizarButton = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(atualizarCategoriaButton)));
        atualizarButton.click();

        WebElement validarMensagemSucesso = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(validarCriacaoAlteracao)));
        validarMensagemSucesso.getText();
    }

    // adicionar vazio
    public void adicionarCategoriaVazio() {
        WebElement adicionarVazioCategoriaButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(adicionarCategoria)));
        adicionarVazioCategoriaButton.click();
    }

    public String validarMensagemTela() {
        WebElement validarMensagemVazio = wait.until(ExpectedConditions.visibilityOf(driver.findElement(validarTexto)));
        return validarMensagemVazio.getText();
    }

    // excluir categoria
    public void excluirCategoriaSelecionar() {
        WebElement selecionarCategoria = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarCategoriaExclusao)));
        selecionarCategoria.click();
    }

    public void confirmarExclusao() {
        WebElement confirmarExclusaoButton = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(buttonConfirmaExclusao)));
        confirmarExclusaoButton.click();
    }

    public void visualizarMensagemSucesso() {
        WebElement validarMensagemSucessoExclusao = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(validarMensagemSucesso)));
        validarMensagemSucessoExclusao.getText();
    }

    // alterar atribuirA
    public void alterarCategoriaButton() {
        WebElement alterarCategoriaButton = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(acoesAlterarCategoria)));
        alterarCategoriaButton.click();
    }

    public void alterarAtribuirA(String selecionarAtribuidoA) {
        Select dropdown = new Select(driver.findElement(By.id("proj-category-assigned-to")));
        dropdown.selectByVisibleText(selecionarAtribuidoA);
    }

    public void alterarButtonCategoria() {
        WebElement alterarButton = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(atualizarCategoriaButton)));
        alterarButton.click();
    }

}
