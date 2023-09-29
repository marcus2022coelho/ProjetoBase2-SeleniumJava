package projetoBase2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class GerenciarUsuarioPage extends  BasePage{

    public GerenciarUsuarioPage(WebDriver driver) {
        super(driver);
    }
    // elementos comuns

    By elementoComumGerenciarUsuarios = (By.xpath("//a[contains(@href, '/manage_user_page.php')]"));

    // elementos cenario de edicao
    By editarUsuarios = (By.xpath("//tbody//tr//td//a[contains(text(),'administrator')]"));
    By atualizarButtonUsuario = (By.xpath("//input[@value='Atualizar Usuário']"));

    // excluir perfil
    By selecionarPerfil = (By.xpath("//a[normalize-space()='Usuario Mesmo Nome']"));
    By excluirPerfil = (By.xpath("//input[@value='Apagar Usuário']"));
    By confirmarExclusao = (By.xpath("//input[@value='Apagar Conta']"));

    // redefinir a senha
    By redefinirSenhaButton = (By.xpath("//input[@value='Redefinir Senha']"));

    // representar o usuario
    By selecionarUsuarioRepresentar = (By.xpath("//a[contains(@href, 'manage_user_edit_page.php?user_id=31')]"));
    By representarUsuarioButton = (By.xpath("//input[@value='Representar Usuário']"));
    By cliqueAquiProsseguir = (By.xpath("//a[normalize-space()='Clique aqui para prosseguir']"));



    //criar novo usuario
    By criarNovaConta = (By.xpath("//a[@class='btn btn-primary btn-white btn-round btn-sm']"));
    By nomeUsuario = (By.xpath("//input[@id='user-username']"));
    By nomeVerdadeiro = (By.xpath("//input[@id='user-realname']"));
    By email = (By.xpath("//input[@id='email-field']"));
    By botaoCriarUsuario = (By.xpath("//input[@value='Criar Usuário']"));

    //criar novo usuario - com o mesmo nome retorna erro
    By erroCriarUserMesmoNome = (By.xpath("//div[@class='error-info']"));


    //criar novo usuario - com o mesmo nome retorna er
    public String validaMensagemErro(){
        WebElement elementoErroCriarUserMesmoNome = wait.until(ExpectedConditions.visibilityOf(driver.findElement(erroCriarUserMesmoNome)));
        String msgErroUserMesmoNome = elementoErroCriarUserMesmoNome.getText();
        return  msgErroUserMesmoNome;
    }


    //criar novo usuario
    public void preencherUsuario(){
        WebElement elementNomeUsuario = wait.until(ExpectedConditions.visibilityOf(driver.findElement(nomeUsuario)));
        elementNomeUsuario.sendKeys("teste" + BasePage.gerarNomeAleatorio());
    }
    public void preencherUsuarioIgual(){
        WebElement elementNomeUsuario = wait.until(ExpectedConditions.visibilityOf(driver.findElement(nomeUsuario)));
        elementNomeUsuario.sendKeys("Usuario Mesmo Nome");
    }
    public void preencherUsuarEditar(){
        WebElement elementNomeUsuario = wait.until(ExpectedConditions.visibilityOf(driver.findElement(nomeUsuario)));
        elementNomeUsuario.sendKeys("Usuario editar");
    }

    public void preencherNomeVerdadeiro(){
        WebElement elementnomeVerdadeiro = wait.until(ExpectedConditions.visibilityOf(driver.findElement(nomeVerdadeiro)));
        elementnomeVerdadeiro.sendKeys(BasePage.gerarNomeAleatorio());
    }
    public void preencherEmail(){
        WebElement elementEmail = wait.until(ExpectedConditions.visibilityOf(driver.findElement(email)));
        elementEmail.sendKeys(BasePage.gerarEmailAleatório());
    }
    public void preencherNivelAcesso( ){
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@id='user-access-level']")))));
        dropdown.selectByVisibleText("desenvolvedor");

    }
    public void criarUsuario (){
        WebElement elementbotaoCriarUsuario = wait.until(ExpectedConditions.visibilityOf(driver.findElement(botaoCriarUsuario)));
        elementbotaoCriarUsuario.click();
    }

    // validar mensagem de sucesso ao criar usuario
    public String validaMensagemCriarUsuarioSucesso(){
        WebElement mensagemSucesso = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), 'criado')]"))));
        return  mensagemSucesso.getText();
    }



   // ------------

    // metodos comuns



    public void editarUsuario() {
        WebElement editarUsuarioField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(editarUsuarios)));
        editarUsuarioField.click();
    }

    public void alterarNivelDeAcesso(String editarNivelAcesso) {
        Select dropdown = new Select(driver.findElement(By.id("edit-access-level")));
        dropdown.selectByVisibleText(editarNivelAcesso);
    }

    public void validarAlteracaoNivel() {
        WebElement atualizarButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarButtonUsuario)));
        atualizarButton.click();
    }

    // excluir usuario
    public void selecionarPerfilExclusaoDuplicado() {
        WebElement selecionarPerfilField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarPerfil)));
        selecionarPerfilField.click();
    }
    public void selecionarPerfil() {
        WebElement selecionarPerfilField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarPerfil)));
        selecionarPerfilField.click();
    }

    public void excluirPerfilButton() {
        WebElement excluirButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(excluirPerfil)));
        excluirButton.click();
    }

    public void confirmarAexclusao() {
        WebElement confirmaExclusaoButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmarExclusao)));
        confirmaExclusaoButton.click();
    }

    // redefinir a senha

    public void redefinirAsenha() {
        WebElement buttonRedefinirSenha = wait.until(ExpectedConditions.visibilityOf(driver.findElement(redefinirSenhaButton)));
        buttonRedefinirSenha.click();
    }

    // representar usuario
    public void usuarioParaRepresentar() {
        WebElement representarUsuarioField = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(selecionarUsuarioRepresentar)));
        representarUsuarioField.click();
    }

    public void representarUsuarioPerfil() {
        WebElement buttonRepresentarUsuario = wait.until(ExpectedConditions.visibilityOf(driver.findElement(representarUsuarioButton)));
        buttonRepresentarUsuario.click();
    }

    public void confirmarRepresentar() {
        WebElement confirmaRepresentarUsuario = wait.until(ExpectedConditions.visibilityOf(driver.findElement(cliqueAquiProsseguir)));
        confirmaRepresentarUsuario.click();
    }

    // criar novo usuário
     public void clicarBotaoCriarNovaConta(){
        WebElement elementoCriarNovaConta = wait.until(ExpectedConditions.visibilityOf(driver.findElement(criarNovaConta)));
        elementoCriarNovaConta.click();
     }

}
