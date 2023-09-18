package FridayProject;

import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FridayProject extends ParameterDriver {
    @Test
    @Parameters ({"username","password"})
    public void loginTestPositive(String username, String password){
        login(username,password);

        WebElement welcomeMessage = driver.findElement(By.cssSelector("div[class=\"topic-html-content-title\"]>h2"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
        Assert.assertTrue(welcomeMessage.getText().contains("Welcome"));
    }


}
