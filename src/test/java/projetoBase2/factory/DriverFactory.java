package projetoBase2.factory;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver inicializaDriver(String browser) {
        switch (browser) {
            case "chrome" -> {
                ChromeDriverManager.chromedriver().setup();
                //System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver114new.exe"); -- foi retirado pois o comando: ChromeDriverManager.chromedriver().setup();, verifica a versão do chrome e caso esteja diferente, baixa a correta para utilizar nos testes, isso é bom para rodar na NUVEM.
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                ChromeDriverManager.firefoxdriver().setup();
                //System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriverNEW.exe");
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("Browser inválid" + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}


