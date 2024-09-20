import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FormAuthenticationTest extends BaseTest{
    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";
    private String url = "https://the-internet.herokuapp.com/login";
    @Test
    public void shouldLogInWhenEnteringValidDataInBothFields(){
        driver.get(url);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = driver.findElement(By.className("subheader")).getText().trim();
        driver.findElement(By.cssSelector("[class='button secondary radius'")).click();

        assertEquals(actualMessage, expectedMessage, "unsuccessful login");

    }

    @Test
    public void shouldNotLogInWithValidUsernameAndNoPassword() {
        driver.get(url);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText().trim();
        String expectedMessage = "Your password is invalid!\n×";
        assertEquals(actualMessage, expectedMessage, "successful login");
    }

    @Test
    public void shouldNotLogInWithValidPasswordAndNoUsername() {
        driver.get(url);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText().trim();
        String expectedMessage = "Your username is invalid!\n×";
        assertEquals(actualMessage, expectedMessage, "successful login");
    }

    @Test
    public void shouldNotLogInWithNoPasswordAndUsername() {
        driver.get(url);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText().trim();
        String expectedMessage = "Your username is invalid!\n×";
        assertEquals(actualMessage, expectedMessage, "successful login");
    }
}
