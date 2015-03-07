package nopcommerce.com;

import org.openqa.selenium.By;

/**
 * Created by Srikanth on 21/12/2014.
 */
public class HomePage extends BasePage{
    //Home Page Locators
//    String homePageUserName = "a.account";
//    String loginPage="a.ico-login";
    By homePageUserName = By.cssSelector("a.account");
    By loginPage=By.cssSelector("a.ico-login");

    public boolean isUserInHomePage()
    {
       return Utils.isTextPresent("Register");
    }
    //Get the User name from Home Page
    public String getHomePageUserName(){

//        System.out.println("homePageUserName: "+driver.findElement(By.cssSelector(homePageUserName)).getText());
        return    driver.findElement(homePageUserName).getText();
    }

    public void gotoLoginPage()
    {
     driver.findElement(loginPage).isDisplayed();
     driver.findElement(loginPage).click();
    }


}
