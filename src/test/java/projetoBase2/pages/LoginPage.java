package projetoBase2.pages;

//import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import projetoBase2.utils.ScreenShots;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //elementos da tela de login
    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@type='submit']")
     private  WebElement  confirmarbotão;

    @FindBy(id ="password" )
    private WebElement passwordField;

    @FindBy(xpath = "//span[@class='user-info']")
    private WebElement validaUsuarioLogado;

    By MensagemUsuarioIncorreto = (By.xpath("//p[contains(text(),'Sua conta pode estar desativada ou bloqueada ou o ')]"));


  //Ações da tela

    public void informarUsuario(String username){
        //por ser um campo aberto não necessita fazer dessa forma
        usernameField.sendKeys(username);
    }

    public void informarSenha(String password){
        passwordField.sendKeys(password);

    }

    public void confirmar(){
        wait.until(ExpectedConditions.elementToBeClickable(confirmarbotão)).click();
        ScreenShots.tirarFoto(driver,"Realizar Login_LoginSucesso");
//        Allure.step("Realizar Login_LoginSucesso");
//
    }

    public String validaUsuarioLogadoSucesso(){
       String nameUser =  validaUsuarioLogado.getText();
       return nameUser;

    }

    public String MensagemUsuarioInvalido(){
        WebElement mensagemUserInvalid = wait.until(ExpectedConditions.visibilityOf(driver.findElement(MensagemUsuarioIncorreto)));
        return  mensagemUserInvalid.getText();
    }







    //Mapeamento da tela de LoginPage
//    By usernameField =  By.xpath("//input[@id=\"username\"]"); //By.id("username");
//    By confirmarbotão = By.xpath("//input[@type='submit']");
//    By passwordField = By.id("password");
//    By validaUsuarioLogado = By.xpath("//span[@class='user-info']");

}
