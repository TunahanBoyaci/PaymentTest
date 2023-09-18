package FridayProject;

import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FridayProject2 extends ParameterDriver {
    @Test
    @Parameters({"username","password"})
    public void loginTestNegative(String username, String password){
        login(username,password);

        WebElement message = driver.findElement(By.cssSelector("div[class=\"validation-summary-errors\"]>span"));
        Assert.assertTrue(message.isDisplayed());
        Assert.assertTrue(message.getText().contains("unsuccessful"));
    }
}
