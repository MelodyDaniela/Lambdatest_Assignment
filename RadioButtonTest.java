import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioButtonTest extends TestBase {
    @Test
    void radioButtonDemo() {

        // Navigate to URL
        String radioButtonURL = "https://www.lambdatest.com/selenium-playground/radiobutton-demo";
        page.navigate(radioButtonURL);
        page.bringToFront();

        // Locate the "Get Value" Button and click on it
        Locator getValueButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get value").setExact(true));
        getValueButton.click();

        // Locate pop-up text that comes upp after pushing button "Get Values"
        Locator paragraphElement = page.locator("p.text-gray-900.text-size-15.my-10.text-black.radiobutton");
        Assertions.assertTrue(paragraphElement.textContent().contains("Radio button is Not checked"));

        // Print message in terminal
        System.out.println("Message shown on webpage: " + paragraphElement.textContent());
    }
}
