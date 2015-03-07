package nopcommerce.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Srikanth on 21/02/2015.
 */
public class PropertiesLoader extends BasePage{

    static Properties prop,merged;
    static String propertyFileLocation = "src/main/Configs/";

    public static String getProperty(String key)
    {
        if(getProperties()==null)
        {
            loadPropertyFile();
        }

        return merged.getProperty(key);
    }
    public static Properties getProperties() {
        return prop;
    }

    public static void setProp(Properties prop) {
        PropertiesLoader.prop = prop;
    }

    public static void setProperty(String key, String value)
    {
        if(getProperty(key)!=null)
        {
            getProperties().setProperty(key, value);
        }
    }

    private static void loadPropertyFile() {
        prop= new Properties();
        merged = new Properties();
        FileInputStream input = null;
        try {
            //   Properties merged = new Properties();
            input = new FileInputStream(propertyFileLocation+"TestData"+".properties");
            prop.load(input);
            merged.putAll(prop);
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
