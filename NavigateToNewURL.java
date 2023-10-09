import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NavigateToNewURL extends TestBase {

    @Test
    void navigatetonewurl() {

        // Navigate to url
        String startURL = "https://www.lambdatest.com/selenium-playground/";
        page.navigate(startURL);
        page.bringToFront();

        //Locate the radio button demo link and click on it
        Locator radioButtonDemo = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Radio Buttons Demo"));
        radioButtonDemo.click();

        // Created 2 variables of url to assert that we are now in correct web page. Let terminal print out if they match.
        String currentUrl = page.url();
        String expectedUrl = "https://www.lambdatest.com/selenium-playground/radiobutton-demo";
        Assertions.assertEquals(expectedUrl, currentUrl);
        System.out.println(expectedUrl);
        System.out.println(currentUrl);
        System.out.println("du har hamnat på rätt URL");
    }
}