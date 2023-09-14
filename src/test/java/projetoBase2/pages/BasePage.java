package projetoBase2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import projetoBase2.factory.DriverFactory;
import projetoBase2.utils.ConfigLoader;

import java.util.Random;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String valorColunaNum;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void load(String endPoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }

    protected boolean returnIfElementExistsByTime(By locator, int time) {
        boolean result = false;
        try {
            ;
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            result = true;
        } catch (Exception e) {
        }
        return result;
    }

    protected WebElement waitForElementByTime(By locator, int time) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    // método para criar uma tarefa
    public String ifTarefaNaoExisteCriaUmaNovaEseleciona() {
        driver = DriverFactory.getDriver();
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);

        if (verTarefaPage.retornaSeTarefaExiste()) {
            verTarefaPage.selecionarTarefa();
        } else {
            CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);

            driver.get("http://127.0.0.1:8989/bug_report_page.php");
            criarTarefaPage.inserirResumo("Tarefa criada a partir da basePage");
            criarTarefaPage.inserirDescricao("Tarefa criada a partir da basePage");
            criarTarefaPage.inserirPassosReproduzir("Tarefa criada a partir da basePage");
            criarTarefaPage.inserirInformacoesAdicionais("Tarefa criada a partir da basePage");
            criarTarefaPage.tocarCriarTarefa();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.get("http://127.0.0.1:8989/view_all_bug_page.php");
            verTarefaPage.selecionarTarefa();
        }
        return valorColunaNum;
    }

    // select genérico -
    public void selecionarOpcaoPorValue(WebElement selectElemento, String value) {
        Select select = new Select(selectElemento);
        select.selectByValue(value);
    }

    // método para selecionar tarefa pelo numero e caso não exista, cria uma nova tarefa
    public String ifTarefaNaoExisteCriaUmaNovaEselecionaPeloNumeroTarefa() {
        driver = DriverFactory.getDriver();
        VerTarefaPage verTarefaPage = new VerTarefaPage(driver);

        if (verTarefaPage.retornaSeTarefaExiste()) {
            verTarefaPage.selecionarTarefa();
            valorColunaNum = verTarefaPage.selecionarTarefa();
        } else {
            CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);

            driver.get("http://127.0.0.1:8989/bug_report_page.php");
            criarTarefaPage.inserirResumo("Tarefa criada a partir da basePage");
            criarTarefaPage.inserirDescricao("Tarefa criada a partir da basePage");
            criarTarefaPage.inserirPassosReproduzir("Tarefa criada a partir da basePage");
            criarTarefaPage.inserirInformacoesAdicionais("Tarefa criada a partir da basePage");
            criarTarefaPage.tocarCriarTarefa();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.get("http://127.0.0.1:8989/view_all_bug_page.php");
            verTarefaPage.selecionarTarefa();
            valorColunaNum = verTarefaPage.selecionarTarefa();
        }
        return valorColunaNum;
    }

    //método para gerar nomes aleatórios
    public static String gerarNomeAleatorio() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder nomeAleatorio = new StringBuilder();
        Random random = new Random();
        int tamanhoDoNome = 8;

        for (int i = 0; i < tamanhoDoNome; i++) {
            int indice = random.nextInt(caracteres.length());
            char caractere = caracteres.charAt(indice);
            nomeAleatorio.append(caractere);
        }
        return nomeAleatorio.toString();
    }

    public void validaMensagemSucesso() {
        String xpathMensagem = "//*[contains(text(), 'com sucesso')]";

        WebElement elementoMensagem = driver.findElement(By.xpath(xpathMensagem));


        Assert.assertNotNull(elementoMensagem, "A mensagem de sucesso não foi encontrada.");

        String mensagemAtual = elementoMensagem.getText();

        // Use o Assert para verificar se a mensagem atual contém a mensagem esperada.
        Assert.assertTrue(mensagemAtual.contains("sucesso"), "A mensagem de sucesso não contém o texto esperado.");
    }

    public void validaSucessoStatusCode200(){
        driver = DriverFactory.getDriver();
        long statusCode = (long) ((JavascriptExecutor) driver).executeScript("return window.performance.getEntries()[0].response.status;");
        Assert.assertEquals(statusCode, 200, "Código de status HTTP diferente de 200.");
    }
}

