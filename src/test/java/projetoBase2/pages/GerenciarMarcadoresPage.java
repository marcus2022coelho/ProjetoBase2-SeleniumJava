package projetoBase2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class GerenciarMarcadoresPage extends BasePage {

    public GerenciarMarcadoresPage(WebDriver driver) {
        super(driver);
    }

    By comumMenuGerenciar = (By.xpath("//*[@class=\"menu-icon fa fa-gears\"]"));
    By menuGerenciarMarcadores = (By.xpath("//a[contains(@href, 'manage_tags_page.php')]"));
    By informarNomeDoMarcador = By.id("tag-name");
    By informarDescricaoMarcador = By.id("tag-description");
    By buttonCriarMarcador = (By.xpath("//input[@name='config_set']"));

    // edição do marcador
    By editarMarcador = (By.xpath("//a[normalize-space()='Criacao do Marcador']"));
    By elementoComumAtualizarMarcador = (By.xpath("//input[@value='Atualizar Marcador']"));

    // excluir marcador
    By selecionarMarcadorExcluir = (By.xpath("//a[normalize-space()='marcador exclusao']"));
    By elementoComumExcluir = (By.xpath("//input[@value='Apagar Marcador']"));

    // tarefas relacionadas
    By marcadorComTarefas = (By.xpath("//a[contains(@href, 'tag_view_page.php?tag_id=4')]"));
    By tarefasRelacionadas = (By.xpath("//a[@class='btn btn-primary btn-white btn-round btn-sm pull-right']"));

    public void selecionarGerenciar() {
        WebElement gerenciarMenu = wait.until(ExpectedConditions.visibilityOf(driver.findElement(comumMenuGerenciar)));
        gerenciarMenu.click();
    }

    public void selecionarGerenciarMarcadoresMenu() {
        WebElement gerenciarMarcadores = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(menuGerenciarMarcadores)));
        gerenciarMarcadores.click();
    }

    public void preencherNomedoMarcador(String nomeDoMarcador) {
        WebElement nomeDoMarcadorField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(informarNomeDoMarcador)));
        nomeDoMarcadorField.sendKeys(nomeDoMarcador);
    }

    public void preencherDescricaoDoMarcador(String descricaoDoMarcador) {
        WebElement descricaoDoMarcadorField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(informarDescricaoMarcador)));
        descricaoDoMarcadorField.clear();
        descricaoDoMarcadorField.sendKeys(descricaoDoMarcador);
    }

    public void criarGerenciarMarcador() {
        WebElement criarMarcador = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttonCriarMarcador)));
        criarMarcador.click();
    }

    // editar marcador
    public void selecionarMarcadorCriado() {
        WebElement selecionarMarcador = wait.until(ExpectedConditions.visibilityOf(driver.findElement(editarMarcador)));
        selecionarMarcador.click();
    }

    public void buttonAtualizarMarcador() {
        WebElement botaoAtualizarMarcador = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumAtualizarMarcador)));
        botaoAtualizarMarcador.click();
    }

    public void alterarCriadorMarcador(String criadorDoMarcador) {
        Select dropdown = new Select(driver.findElement(By.id("tag-user-id")));
        dropdown.selectByVisibleText(criadorDoMarcador);
    }

    public void concluirAtualizacao() {
        WebElement concluirAtualizacao = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumAtualizarMarcador)));
        concluirAtualizacao.click();
    }

    // excluir marcador
    public void selecionarMarcadorExcluir() {
        WebElement selecionarParaExcluir = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarMarcadorExcluir)));
        selecionarParaExcluir.click();
    }

    public void botaoExcluir() {
        WebElement botaoDeExclusao = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumExcluir)));
        botaoDeExclusao.click();
    }

    public void confirmarExclusao() {
        WebElement confirmacaoDeExclusao = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumExcluir)));
        confirmacaoDeExclusao.click();
    }

    // tarefas relacionadas
    public void selecionarMarcadorTarefas() {
        WebElement selecionarMarcadorComTarefas = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(marcadorComTarefas)));
        selecionarMarcadorComTarefas.click();
    }

    public void selecionarTarefasRelacionadas() {
        WebElement botaoTarefasRelacionadas = wait.until(ExpectedConditions.visibilityOf(driver.findElement(tarefasRelacionadas)));
        botaoTarefasRelacionadas.click();
    }


}
