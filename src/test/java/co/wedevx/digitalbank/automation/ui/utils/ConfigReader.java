package co.wedevx.digitalbank.automation.ui.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//Build a logic that reads a config file(properties file)
public class ConfigReader {
    private static Properties properties;

    //Static initializer run the block only once for the whole project
    //instance initializer run the block once for every object creation from the class
    static {
        //filepath is the directory of your properties file
        String filePath = "src/test/resources/properties/digitalbank.properties";

        //this is a class that enables you to read files
        //it throws a checked exception
        FileInputStream input = null;
        try{
            input = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(input);

        } catch (IOException e) {
            System.out.println("File not found");
        }
        finally {
            try {
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getPropertiesValue(String key){
        return properties.getProperty(key);
    }
}
