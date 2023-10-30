package projetoBase2.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import projetoBase2.constants.TipoAmbienteS;
import projetoBase2.factory.DriverFactory;
import projetoBase2.utils.DataBaseConfig;
import projetoBase2.utils.DataBaseHelper;
import projetoBase2.utils.DatabaseManipulator;
import projetoBase2.utils.ScreenShots;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Hooks {
    private static WebDriver driver;


    @Before
    public void before() {
        driver = DriverFactory.inicializaDriver(System.getProperty("browser", "firefox"));
    }

    // banco de dados
    @Before
    public void prepararBD() {
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        // Consulta SQL
       // dataBaseHelper.executeSQL("SELECT * FROM mantis_user_table;");
        dataBaseHelper.executeSQL("DELETE FROM mantis_user_table WHERE username <> 'administrator' AND email <> 'root@localhost';");
        // Se a consulta foi executada com sucesso, não acontecerá uma exceção
        System.out.println("A consulta foi executada com sucesso.");

  }

    @After
    public void after(Scenario scenario) {
        try {
            String nomeDoCenario = scenario.getName();
            ScreenShots.tirarFoto(driver, nomeDoCenario);

            byte[] screenshotBytes = FileUtils.readFileToByteArray(new File("C:\\Projetos\\ProjetoBase2\\screenShots\\" + nomeDoCenario + ScreenShots.dataHoraParaArquivo()));
            scenario.attach(screenshotBytes, "image/png", nomeDoCenario);
        } catch (WebDriverException | IOException e) {
            System.err.println("Erro ao capturar o screenshot: " + e.getMessage());
        }
        driver.quit();
    }


}
