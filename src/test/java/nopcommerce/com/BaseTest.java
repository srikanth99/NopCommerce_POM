package nopcommerce.com;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

/**
 * Created by Srikanth on 21/12/2014.
 */
public class BaseTest{
    WebDriver driver = BrowserFactory.getDriver();
    @BeforeClass
    public static void startBrowser() throws MalformedURLException, InterruptedException {
        BrowserFactory.StartBrowser(PropertiesLoader.getProperty("browser"), PropertiesLoader.getProperty("URL"));

    }

    @AfterClass
    public static void stopBrowser()
    {
        BrowserFactory.QuitBrowser();
    }
}
