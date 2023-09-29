package projetoBase2.factory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Propriedades {
    public static boolean FECHAR_BROWSER = true;
    public static boolean FECHAR_BROWSER1 = true;
    public static boolean FECHAR_BROWSER2 = true;

    public static Browsers BROWSER = Browsers.CHROME;
    public static Browsers BROWSER1 = Browsers.FIREFOX;
    public static Browsers BROWSER2 = Browsers.InternetExplorer;

    //Chaves das propriedades
    public static String P_WEBDRIVER_DRIVER = "webdriver.driver";
    public static String P_REMOTE_DRIVER_URL = "webdriver.remote.url";
    public static String P_TIPO_EXECUCAO = "tipo.execucao";

    public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;

    public enum Browsers {
        CHROME,
        FIREFOX,
        InternetExplorer
    }

    public enum TipoExecucao {
        LOCAL,
        GRID
    }

    private static File configProperties = new File("./environment.properties");

    public static Properties getProperties() {
        try {
            Properties props = new Properties();
            FileInputStream file = new FileInputStream(configProperties);
            props.load(file);
            return props;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
