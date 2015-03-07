package nopcommerce.com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Srikanth on 07/03/2015.
 */
public class BrowserFactory extends BasePage {
    public static WebDriver StartBrowser(String Browser, String URL) throws MalformedURLException, InterruptedException {
        if (driver == null || !isSessionActive()) {
            driver = startRemoteWebBrowser(Browser, URL);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static boolean isSessionActive() {
        try {

            return driver.findElements(By.tagName("body")).size() > 0;

        } catch (Exception e) {

        }
        return false;
    }

    public static void QuitBrowser() {
        driver = null;
    }

    protected static WebDriver startRemoteWebBrowser(String browser, String URL) {

        if (false) {
            try {

                System.out.println("grid started...");
                // Create an object for Desired Capabilities
                DesiredCapabilities caps=DesiredCapabilities.firefox();
                caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                caps.setCapability("version", "3.0");
                caps.setCapability("platform", "Windows 8");
                // Create the Remote web driver object run them in selenium grid
                driver = new RemoteWebDriver(new URL(PropertiesLoader.getProperty("selgrid")), caps);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            try {
                if (browser.equalsIgnoreCase("Firefox")) {
                    //Create firefox profile
                    FirefoxProfile firefoxprofile = new FirefoxProfile();
                    firefoxprofile.setAssumeUntrustedCertificateIssuer(true);
                    firefoxprofile.setAcceptUntrustedCertificates(true);
                    //create firefox webdriver object with defined firefox profile
                    driver = new FirefoxDriver(firefoxprofile);
                } else if (browser.equalsIgnoreCase("Chrome")) {

                   System.setProperty("webdriver.chrome.driver", "src/main/browsers/chromedriver.exe");
                    driver = new ChromeDriver();
//                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("test-type");
//                    capabilities.setCapability("chrome.binary","src/main/browsers/chromedriver.exe");
//                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//                    driver = new ChromeDriver(capabilities);

                } else if (browser.equalsIgnoreCase("IE")) {
                    System.setProperty("webdriver.ie.driver", "src/main/browsers/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                } else if (browser.equalsIgnoreCase("Safari")) {
//                    driver = new SafariDriver();
                } else if (browser.equalsIgnoreCase("Opera")) {
//                    driver = new OperaDriver();
                } else {
                    throw new RuntimeException("Browser give " + browser + " did not load..");
                }
            }
            catch(Exception e)
            {
                throw new RuntimeException("Browser give " + browser + " did not load..");
            }
        }
        driver.get(URL);
        return driver;
    }
}
