import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StartPageTest extends TestBase {

    @Test
    void goToPage() {
        // Navigate to URL
        String startURL = "https://www.lambdatest.com/selenium-playground/";
        page.navigate(startURL);
        page.bringToFront();

        // Assert that you are on correct web page and let terminal print expected & current url.
        String expectedUrl = "https://www.lambdatest.com/selenium-playground/";
        String currentUrl = page.url();
        Assertions.assertEquals(expectedUrl, currentUrl);
        System.out.println(expectedUrl);
        System.out.println(currentUrl);

        // Scroll down
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        page.waitForTimeout(2000);

        // Scroll up
        page.evaluate("window.scrollTo(0, 0);");
        page.waitForTimeout(2000);

        // Localize the Header and print the title in terminal
        Locator header = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Selenium Playground"));
        String headingText = page.innerText("h1");
        Assertions.assertTrue(headingText.contains("Selenium Playground"));
        System.out.println("The title on Start Page is: " + headingText);

    }

}
