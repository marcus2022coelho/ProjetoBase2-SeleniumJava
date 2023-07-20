package projetoBase2.utils;


import projetoBase2.constants.TipoAmbienteS;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){

        String env = System.getProperty("tipoAmb", String.valueOf(TipoAmbienteS.PROD));
        switch (TipoAmbienteS.valueOf(env)) {
            case PROD -> properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
            case STAGE -> properties = PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
            default -> throw new IllegalStateException("Invalid env:" + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the prod_config.properties file");
    }


}
