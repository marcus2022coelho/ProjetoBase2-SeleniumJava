package projetoBase2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.beans.Expression;
import java.util.concurrent.TimeUnit;

public class CriarTarefaPage extends BasePage{

    public CriarTarefaPage(WebDriver driver) {
        super(driver);
    }
// Mapeamento da tela criar tarefa

    By menuCriarTarefa = (By.xpath("//i[@class='menu-icon fa fa-edit']"));
    By campoCategoria = (By.xpath("//select[@id='category_id']"));
    By campoFrequencia = (By.xpath("//select[@id='reproducibility']"));
    By campoGravidade = (By.id("severity"));
    By campoPrioridade = (By.id("priority"));
    By campoAtribuir = (By.id("handler_id"));
    By campoResumo = (By.id("summary"));
    By campoDescricao = (By.id("description"));
    By campoPassosReproduzir = (By.id("steps_to_reproduce"));
    By campoInformacoesAdicionais = (By.id("additional_info"));
    By campoVisibilidade = (By.xpath("//tbody/tr[13]/td[1]//label[1]"));
    // botão criar tarefa
    By botaoCriarTarefa = (By.xpath("//input[@value='Criar Nova Tarefa']"));
    By confirmacaoTarefaCriadaSucesso = (By.xpath("//*[contains(text(), 'sucesso')]"));
    By mensagemCampoObrigatorio = (By.xpath("//*[contains(text(), 'Por favor, verifique novamente suas entradas.')]"));

    //cadastrar acoes dos elementos

    public void selecionarCategoria (String categoria){
        Select dropdown = new Select(driver.findElement(By.id("category_id")));
        dropdown.selectByValue("1");
    }

    public void selecionarFrequencia (String frequencia){
        Select dropdown = new Select(driver.findElement(By.id("reproducibility")));
        dropdown.selectByVisibleText(frequencia);
    }

    public void selecionarGravidade (String gravidade){
        Select dropdown = new Select(driver.findElement(By.id("severity")));
        dropdown.selectByVisibleText(gravidade);
    }

    public void selecionarPrioridade (String priodidade){
        Select dropdown = new Select(driver.findElement(By.id("priority")));
        dropdown.selectByVisibleText(priodidade);
    }

    public void selecionarAtribuir (String atribuir){
        Select dropdown =  new Select(driver.findElement(By.id("handler_id")));
        dropdown.selectByVisibleText(atribuir);
    }

    public void inserirResumo (String resumo){
        WebElement elementoResumo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(campoResumo)));
        elementoResumo.sendKeys(resumo);
    }
    public void inserirDescricao (String descricao){
        WebElement elementoDescricao = wait.until(ExpectedConditions.visibilityOf(driver.findElement(campoDescricao)));
        elementoDescricao.sendKeys(descricao);
    }
    public void inserirPassosReproduzir (String passosReproduzir){
        WebElement elementoPassosReproduzir = wait.until(ExpectedConditions.visibilityOf(driver.findElement(campoPassosReproduzir)));
        elementoPassosReproduzir.sendKeys(passosReproduzir);
    }

    public void inserirInformacoesAdicionais (String informacoesAdicionais){
        WebElement elementoInformacoesAdicionais = wait.until(ExpectedConditions.visibilityOf(driver.findElement(campoInformacoesAdicionais)));
        elementoInformacoesAdicionais.sendKeys(informacoesAdicionais);
    }

    public void selecionarVisibilidade(){
        WebElement elementoVisibilidade =  wait.until(ExpectedConditions.visibilityOf(driver.findElement(campoVisibilidade)));
        elementoVisibilidade.click();

    }
    public void tocarCriarTarefa (){
        WebElement elementoCriarTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(botaoCriarTarefa)));
        elementoCriarTarefa.click();

    }
    public void menuCriarTarefa(){
        WebElement elementoMenuCriarTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(menuCriarTarefa)));
        elementoMenuCriarTarefa.click();
    }
    public String mensagemCriarTarefaSucesso(){
        WebElement mensagemDeSucesso = wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmacaoTarefaCriadaSucesso)));
        return  mensagemDeSucesso.getText();
    }
    public String mensagemCampoObrigatorio(){
        WebElement elementoMensagemCampoObrigatorio = wait.until(ExpectedConditions.visibilityOf(driver.findElement(mensagemCampoObrigatorio)));
        return  elementoMensagemCampoObrigatorio.getText();
    }










}
