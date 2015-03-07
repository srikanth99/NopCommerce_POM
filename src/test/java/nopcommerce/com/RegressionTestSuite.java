package nopcommerce.com;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 21/12/2014.
 */
public class RegressionTestSuite extends BaseTest{

    //Test data
    String email=PropertiesLoader.getProperty("username");
    String password=PropertiesLoader.getProperty("password");

//Create Login Page & Home Page objects
    LoginPage objLogin = new LoginPage();
    HomePage objHomePage = new HomePage();

    @Test
    public void verifyUserLoggedInSuccessfully(){
        Assert.assertTrue(objHomePage.isUserInHomePage());
         //navigate to login page
        objHomePage.gotoLoginPage();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //verify user is in login page
        Assert.assertTrue(Utils.isTextPresent("Welcome, Please Sign In!"));
        //login to application
        objLogin.loginAsUser(email, password);

        //Verify home page
        Assert.assertTrue(objHomePage.getHomePageUserName().toLowerCase().contains(email));

    }

}
