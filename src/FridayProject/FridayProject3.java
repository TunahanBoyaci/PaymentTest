package FridayProject;

import Utilities.MyMethods;
import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FridayProject3 extends ParameterDriver {
    @Test
    @Parameters({"username","password"})
    public void placeAndOrder(String username, String password){
        login(username,password);

        WebElement addButton = driver.findElement(By.cssSelector("input[onclick=\"AjaxCart.addproducttocart_catalog('/addproducttocart/catalog/2/1/1    ');return false;\"]"));
        addButton.click();

        WebElement recipentInbox = driver.findElement(By.cssSelector("input[name='giftcard_2.RecipientName']"));
        recipentInbox.sendKeys("Mark");

        WebElement recipentInbox2 = driver.findElement(By.cssSelector("input[name='giftcard_2.RecipientEmail']"));
        recipentInbox2.sendKeys("johnsmith2@gmail.com");

        WebElement addButton2 = driver.findElement(By.cssSelector("input[id=\"add-to-cart-button-2\"]"));
        addButton2.click();

        WebElement cartButton = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        cartButton.click();

        MyMethods.myWait(1);
        WebElement agreeButton = driver.findElement(By.cssSelector("input[id='termsofservice']"));
        agreeButton.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector("button[id=\"checkout\"]"));
        checkoutButton.click();

        MyMethods.myWait(2);
        WebElement conButton = driver.findElement(By.cssSelector("input[title=\"Continue\"]"));
        conButton.click();

        WebElement payButton = driver.findElement(By.cssSelector("input[id=\"paymentmethod_0\"]"));
        payButton.click();

        WebElement divButton = driver.findElement(By.cssSelector("input[class=\"button-1 payment-method-next-step-button\"]"));
        divButton.click();

        WebElement govButton = driver.findElement(By.cssSelector("input[class=\"button-1 payment-info-next-step-button\"]"));
        govButton.click();

        WebElement cavButton = driver.findElement(By.cssSelector("input[class=\"button-1 confirm-order-next-step-button\"]"));
        cavButton.click();

        WebElement covMessage = driver.findElement(By.cssSelector("div[class=\"title\"]>strong"));
        Assert.assertTrue(covMessage.isDisplayed());
        Assert.assertTrue(covMessage.getText().contains("successfully "));
    }
}
