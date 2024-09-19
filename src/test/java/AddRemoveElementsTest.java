import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddRemoveElementsTest extends BaseTest {

    String deleteButtonLocator = "[onclick='deleteElement()']";

@Test
    public void addRemoveElements(){
    driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

    WebElement element = driver.findElement(By.cssSelector("[onclick='addElement()']"));
    element.click();
    element.click();

   List<WebElement> deleteButtons = driver.findElements(By.cssSelector(deleteButtonLocator));
   assertEquals(deleteButtons.size(), 2, "Количество элементов !=2");

   deleteButtons.get(1).click();
   deleteButtons = driver.findElements(By.cssSelector(deleteButtonLocator));


    assertEquals(deleteButtons.size(),1,"Количество элементов !=1");


}

}
