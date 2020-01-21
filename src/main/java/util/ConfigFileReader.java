package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    Properties prop;

    public ConfigFileReader() {
        this.prop = new Properties();
        FileInputStream inputStream = null;
        String configFileName = "testdata.properties";
        String configFilePath = System.getProperty("user.dir") + "/" + "src/main/resources/config" + "/" + configFileName;
        try {
            inputStream = new FileInputStream(configFilePath);
            prop.load(inputStream);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String propertyName)
    {
        return this.prop.getProperty(propertyName);
    }



}
