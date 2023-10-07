package projetoBase2.factory;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import projetoBase2.utils.ConfigLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver inicializaDriver(String browser) {
        ConfigLoader configLoader = ConfigLoader.getInstance();
        String driverType = configLoader.getDriverType();

        switch (driverType) {
            case "local" -> {
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

            }
            case "grid" -> {
                String gridHubUrl = configLoader.getGridHubUrl(); //método getGridHubUrl() no ConfigLoader para obter a URL do hub do Selenium Grid
                if (gridHubUrl != null) {
                    DesiredCapabilities capabilities = new DesiredCapabilities();

                    switch (browser) {
                        case "chrome" -> {
                            capabilities.setBrowserName("chrome");
                            capabilities.setVersion("88.0");
                            capabilities.setPlatform(Platform.WINDOWS);
                        }
                        case "firefox" -> {
                            capabilities.setBrowserName("firefox");
                            capabilities.setVersion("85.0");
                            capabilities.setPlatform(Platform.WINDOWS);
                        }
                        case "edge" -> {
                            capabilities.setBrowserName("MicrosoftEdge");
                            capabilities.setVersion("91.0");
                            capabilities.setPlatform(Platform.WINDOWS);
                        }
                    }
                    try {
                        driver = new RemoteWebDriver(new URL(gridHubUrl), capabilities);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid gridHubUrl: " + gridHubUrl, e);
                    }
                } else {
                    throw new RuntimeException("gridHubUrl is not specified in the configuration.");
                }
            }
            default -> throw new IllegalStateException("Invalid driverType: " + driverType);
        }

        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}


