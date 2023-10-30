package projetoBase2.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ScreenShots {

    public static void tirarFoto(WebDriver driver, String nomeDoArquivo) {
        String arquivo = "C:\\Projetos\\ProjetoBase2\\screenShots\\" + nomeDoArquivo + ScreenShots.dataHoraParaArquivo();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(arquivo));
        }catch (IOException e){
            System.out.println("ocorreu um erro para copiar o arquivo");
        }
    }


    public static String dataHoraParaArquivo(){       //retorna o arquivo com o nome único, se baseando pela data
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts) + ".png";
    }


}
