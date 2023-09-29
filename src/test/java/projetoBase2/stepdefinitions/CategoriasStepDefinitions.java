package projetoBase2.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projetoBase2.factory.DriverFactory;
import projetoBase2.pages.BasePage;
import projetoBase2.pages.CategoriasPage;

public class CategoriasStepDefinitions {

    private static WebDriver driver;



    @And("^informo o \"([^\"]*)\"$")
    public void informo_o_nome_da_categoria(String nomeDaCategoria) {
        driver = DriverFactory.getDriver();
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.preencherNomeCategoria(nomeDaCategoria);
    }

    @When("^adiciono a categoria$")
    public void adiciono_a_categoria() {
        driver = DriverFactory.getDriver();
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.categoriaButton();
    }

    @Then("^confirmo a criacao na lista$")
    public void confirmo_a_criacao_na_lista() {

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"http://127.0.0.1:8989/manage_proj_page.php");
    }

    // adicionar ou alterar categoria
    @Given("^preencho o nome da categoria$")
    public void preencho_o_nome_da_categoria() {
        driver = DriverFactory.getDriver();
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.informarNomeCategoria();
    }

    @When("^seleciono para alterar a categoria$")
    public void seleciono_para_alterar_a_categoria() {
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.buttonAdicionarAlterar();
    }

    @When("^edito o campo \"([^\"]*)\"$")
    public void edito_a(String atribuidoA) {
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.selecionarAtribuir(atribuidoA);
    }

    @Then("^atualizo a categoria$")
    public void atualizo_a_categoria() {
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.atualizarCategoriaButton();

        new BasePage(driver).validaMensagemSucesso();


    }

    // categoria vazio
    @When("^seleciono para adicionar a categoria$")
    public void seleciono_para_adicionar_a_categoria() {
        driver = DriverFactory.getDriver();
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.adicionarCategoriaVazio();
    }

    @Then("^o sistema exibe a mensagem de campo vazio$")
    public void o_sistema_exibe_a_mensagem_de_campo_vazio() {
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        String texto = categoriasPage.validarMensagemTela();
        String mensagemErro = "Um campo necessário 'Categoria' estava vazio";

        assert texto.contains(mensagemErro): "o valor não foi encontrado na mensagem";
    }

    // excluir a categoria
    @When("^seleciono a categoria para excluir$")
    public void seleciono_a_categoria_para_excluir() {
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.excluirCategoriaSelecionar();
    }

    @When("^confirmar para excluir$")
    public void confirmar_para_excluir() {
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.confirmarExclusao();
    }

    @Then("^visualizo a mensagem de confirmacao$")
    public void visualizo_a_mensagem_de_confirmacao() {
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.visualizarMensagemSucesso();
    }

    // alterar a categoria
    @When("^seleciono alterar a categoria$")
    public void seleciono_alterar_a_categoria() {
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.alterarCategoriaButton();
    }

    @When("^seleciono para alterar \"([^\"]*)\"$")
    public void seleciono_para_alterar(String atribuidoA) {
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.alterarAtribuirA(atribuidoA);
    }

    @Then("^confirmo a edicao da categoria$")
    public void confirmo_a_edicao_da_categoria() {
        CategoriasPage categoriasPage = new CategoriasPage(driver);
        categoriasPage.alterarButtonCategoria();
    }
}
