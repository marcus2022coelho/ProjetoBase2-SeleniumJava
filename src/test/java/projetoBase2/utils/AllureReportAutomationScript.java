package projetoBase2.utils;

public class AllureReportAutomationScript {

        public static void main(String[] args) {
            // Comando para gerar relatórios do Allure
            String allureExecutable = "C:\\Projetos\\ProjetoBase2\\allure-2.24.1\\bin\\allure.bat";
            String generateCommand = allureExecutable + " allure generate C:\\Projetos\\ProjetoBase2\\allure-results --clean";


            // Comando para abrir relatórios no navegador padrão
            String openCommand = "allure open";

            try {
                // Execute o comando para gerar relatórios
                Process generateProcess = Runtime.getRuntime().exec(generateCommand);
                int generateExitCode = generateProcess.waitFor();

                if (generateExitCode == 0) {
                    System.out.println("Relatórios do Allure gerados com sucesso.");

                    // Execute o comando para abrir os relatórios
                    Process openProcess = Runtime.getRuntime().exec(openCommand);
                    int openExitCode = openProcess.waitFor();

                    if (openExitCode == 0) {
                        System.out.println("Relatórios do Allure abertos no navegador.");
                    } else {
                        System.err.println("Erro ao abrir os relatórios do Allure.");
                    }
                } else {
                    System.err.println("Erro ao gerar os relatórios do Allure.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }