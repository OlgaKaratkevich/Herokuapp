import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTest extends BaseTest {

    @Test
    public void testName() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebDriver frame = driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        String text = frame.findElement(By.xpath("//body[@id='tinymce']/p")).getText();
        assertEquals(text, "Your content goes here.", "text doesn't match");
    }
}
