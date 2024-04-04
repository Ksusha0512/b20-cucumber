package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
    public static String getConfigProp(String key){
        //right click on 'configuration.properties' and copy the root path
        File propFile = new File("src/test/resources/configuration.properties");
        Properties props = new Properties();
        try{
            props.load(new FileInputStream(propFile));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        String value = props.getProperty(key);
        return value;

    }
}
