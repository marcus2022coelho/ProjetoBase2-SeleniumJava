package projetoBase2.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoginTest {

    @CucumberOptions(
            plugin = {"pretty", "html:target/cucumber.html", "summary"},
            //dryRun = true,
            tags = "@regressao",
            glue = {"projetoBase2"},
            features = "src/test/resources/features/login.feature"

    )
    public class TesteNGRunnerTest extends AbstractTestNGCucumberTests {


        @BeforeClass
        public void beforeclass() {
            System.out.println("BeforeClass-testeNG");
        }

        @AfterClass
        public void afterclass() {
            System.out.println("AfterClass-testeNG");
        }

    }
}
