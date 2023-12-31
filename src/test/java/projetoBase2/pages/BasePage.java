package projetoBase2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import projetoBase2.utils.ConfigLoader;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }



}
