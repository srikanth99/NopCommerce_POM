package nopcommerce.com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;

/**
 * Created by Srikanth on 21/12/2014.
 */
public class Utils extends BasePage{
    public static boolean isTextPresent(String text)
    {
        return driver.findElement(By.cssSelector("BODY")).getText().contains(text);
    }

    public static void selectFromDropDownMenu(By element,String text)
    {
        Select select=new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }
}
