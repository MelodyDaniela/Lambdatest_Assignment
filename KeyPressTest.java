import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class KeyPressTest extends TestBase {
    @Test
    void keyPress (){
        // Navigate to URL
        String keyPressURL = "https://www.lambdatest.com/selenium-playground/key-press";
        page.navigate(keyPressURL);
        page.bringToFront();

        // Locate the textbox and type "TEST" and then press the "ENTER" key on the keyboard.
        Locator textBox = page.getByRole(AriaRole.TEXTBOX);
        textBox.fill("TEST");
        page.keyboard().press("Enter");

        // Save result-text in a string variable and print out result/response in terminal
        String resultText = page.locator("#result").textContent();
        System.out.println("Result: " + resultText + " Button on the keyboard");
    }
}
