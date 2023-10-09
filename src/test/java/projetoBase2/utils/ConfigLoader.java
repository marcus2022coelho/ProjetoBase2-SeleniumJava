package projetoBase2.utils;


import projetoBase2.constants.TipoAmbienteS;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;
    private String driverType;


    private ConfigLoader(){

        String env = System.getProperty("tipoAmb", String.valueOf(TipoAmbienteS.LOCAL));
        switch (TipoAmbienteS.valueOf(env)) {
            case LOCAL -> {
                properties = PropertyUtils.propertyLoader("src/test/resources/local_config.properties");
                driverType = properties.getProperty("driverType");
            }
            case GRID -> {
                properties = PropertyUtils.propertyLoader("src/test/resources/grid_config.properties");
                driverType = properties.getProperty("driverType");
            }
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
        else throw new RuntimeException("property baseUrl is not specified in the local_config.properties file");
    }
    public String getDriverType(){
        return driverType;
    }


    public String getGridHubUrl() {
        return properties.getProperty("gridHubUrl");


    }
}
