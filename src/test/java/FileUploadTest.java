import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/image.png");
        String fileName = file.getName();
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();
        assertEquals(driver.findElement(By.id("uploaded-files")).getText(), fileName);
    }
}
