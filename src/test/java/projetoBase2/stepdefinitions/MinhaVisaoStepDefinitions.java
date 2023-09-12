package projetoBase2.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projetoBase2.factory.DriverFactory;
import projetoBase2.pages.BasePage;
import projetoBase2.pages.MinhaVisaoPage;
import projetoBase2.utils.Usuario;

public class MinhaVisaoStepDefinitions {

    private static WebDriver driver;
    Usuario usuario;
    MinhaVisaoPage minhaVisaoPage;

    @And("^acesso ao menu minhaVisao$")
    public void acessoMenuMinhaVisao() {
        driver = DriverFactory.getDriver();
        new BasePage(driver).load("/my_view_page.php");

    }


    @When("tocar no parâmetro {string}")
    public void tocarNoParâmetroAtribuidosAMim(String texto) {
        MinhaVisaoPage minhaVisaoPage = new MinhaVisaoPage(driver);
        minhaVisaoPage.abrirTelaDoMenuGerenciarPeloNome(texto);

    }

     //Atribuídos a Mim
    @Then("o sistema redireciona o usuario para a tela de tarefas atribuidas a mim")
    public void o_sistema_redireciona_o_usuario_para_a_tela_de_tarefas_atribuidas_a_mim() {
        String URL = driver.getCurrentUrl();
        String searchURL = "view_all_bug_page";
        Assert.assertTrue(URL.contains(searchURL),"A página não foi carregada com sucesso");
    }
    @Then("o sistema redireciona o usuario para a tela de tarefas Nao atribuidas")
    public void o_sistema_redireciona_o_usuario_para_a_tela_de_tarefas_nao_atribuidas() {
        String URL = driver.getCurrentUrl();
        String searchURL = "view_all_bug_page";
        Assert.assertTrue(URL.contains(searchURL),"A página não foi carregada com sucesso");
    }

    @Then("o sistema redireciona o usuario para a tela de tarefas")
    public void o_sistema_redireciona_o_usuario_para_a_tela_de_tarefa() {
        String URL = driver.getCurrentUrl();
        String searchURL = "view_all_bug_page";
        Assert.assertTrue(URL.contains(searchURL),"A página não foi carregada com sucesso");
    }


}
