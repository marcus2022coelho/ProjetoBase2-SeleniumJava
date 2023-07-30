package projetoBase2.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import projetoBase2.factory.DriverFactory;

public class Hooks {
    private static WebDriver driver;


    @Before
    public void before(){
        driver = DriverFactory.inicializaDriver(System.getProperty("browser","chrome"));
    }

    @After
    public void after(){
        driver.quit();
    }

}
