import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControls() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[@onclick = 'swapCheckbox()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']//p[@id='message']")));
        List<WebElement> checkboxes = driver.findElements(By.id("checkbox"));
        assertTrue(checkboxes.isEmpty());

        WebElement input = driver.findElement(By.xpath("//input[@type = 'text']"));
        assertFalse(input.isEnabled());
        driver.findElement(By.xpath("//button[@onclick= 'swapInput()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='input-example']//p[@id='message']")));
        assertTrue(input.isEnabled());
    }
}
