import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.testng.Assert.assertEquals;

public class CheckboxesTest extends BaseTest{
    private String url = "https://the-internet.herokuapp.com/checkboxes";
    @Test
    public void checkboxes(){
        driver.get(url);
        List<WebElement> checkboxes =  driver.findElements(By.cssSelector("[type='checkbox']"));
        List<Boolean> actualCheckboxesStatus = checkboxes.stream()
                        .map(WebElement::isSelected)
                        .collect(Collectors.toList());

        List<Boolean> expectedCheckboxesStatus = new ArrayList<>();
        expectedCheckboxesStatus.add(0,false);
        expectedCheckboxesStatus.add(1,true);

        assertEquals(actualCheckboxesStatus, expectedCheckboxesStatus, "First checkbox must be unchecked, the second must be checked");

        checkboxes.get(0).click();
        checkboxes.get(1).click();

        actualCheckboxesStatus = checkboxes.stream()
                .map(WebElement::isSelected)
                .collect(Collectors.toList());

        expectedCheckboxesStatus.set(0,true);
        expectedCheckboxesStatus.set(1,false);
        assertEquals(actualCheckboxesStatus, expectedCheckboxesStatus, "After changes first checkbox must be checked, the second must be unchecked");

    }
}
