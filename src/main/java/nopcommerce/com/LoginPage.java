package nopcommerce.com;

import org.openqa.selenium.By;

/**
 * Created by Srikanth on 21/12/2014.
 */
public class LoginPage extends BasePage{

//    String username = "Email";
//    String password = "Password";
//    String login = "input.button-1.login-button";
    By username=By.id("Email");
    By password = By.id("Password");
    By login =By.cssSelector("input.button-1.login-button");
    //Set user name in textbox
    public void enterUserName(String strUserName){

        driver.findElement(username).sendKeys(strUserName);
    }

    //Set password in password textbox
    public void enterPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
        driver.findElement(login).click();
    }

    public void loginAsUser(String username,String pasword){
        //Fill user name
        this.enterUserName(username);
        //Fill password
        this.enterPassword(pasword);
        //Click Login button
        this.clickLogin();
    }

}
