package projetoBase2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MinhaVisaoPage extends BasePage {

    public MinhaVisaoPage(WebDriver driver) {
        super(driver);
    }

    // mapeamento dos elementos da tela




    //Atribuidos a mim - vedr tarefa

    //Ações dos elementos da tela

    public void abrirTelaDoMenuGerenciarPeloNome(String texto){
       WebElement elementoMapeadoPorTexto = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'" + texto + "')]"))));
        elementoMapeadoPorTexto.click();

    }

}
