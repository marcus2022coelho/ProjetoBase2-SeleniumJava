package projetoBase2.pages;

//import io.qameta.allure.Allure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import projetoBase2.utils.ScreenShots;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //elementos da tela de login
    By usernameField = (By.xpath("//input[@id='username']"));

    By confirmarbotao = (By.xpath("//input[@type='submit']"));

    By passwordField = (By.xpath("//input[@id='password']"));

    By validaUsuarioLogado = (By.xpath("//span[@class='user-info']"));

    By MensagemUsuarioIncorreto = (By.xpath("//p[contains(text(),'Sua conta pode estar desativada ou bloqueada ou o ')]"));


    //Ações da tela

    public void informarUsuario(String username) {
        WebElement usernameFieldCampo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(usernameField)));
        usernameFieldCampo.sendKeys(username);
    }

    public void informarSenha(String password) {
        WebElement campoPassword = wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordField)));
        campoPassword.sendKeys(password);

    }

    public void confirmar() {
        WebElement confirmarbotaoTela = wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmarbotao)));
        wait.until(ExpectedConditions.elementToBeClickable(confirmarbotaoTela)).click();

    }

    public String validaUsuarioLogadoSucesso() {
        WebElement validaUsuarioLogadoTela = wait.until(ExpectedConditions.visibilityOf(driver.findElement(validaUsuarioLogado)));
        String nameUser = validaUsuarioLogadoTela.getText();
        return nameUser;

    }

    public String MensagemUsuarioInvalido() {
        WebElement mensagemUserInvalid = wait.until(ExpectedConditions.visibilityOf(driver.findElement(MensagemUsuarioIncorreto)));
        return mensagemUserInvalid.getText();
    }

}
