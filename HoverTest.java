import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HoverTest extends TestBase {
    @Test
    void hovertest() {
        // Navigate to URL
        String inputFormSubmitURL = "https://www.lambdatest.com/selenium-playground/hover-demo";
        page.navigate(inputFormSubmitURL);
        page.bringToFront();

        // Locate and hover over element
        //Locator elementToHover = page.getByRole(AriaRole.GENERIC, new Page.GetByRoleOptions().setName("Link Hover"));
        Locator elementToHover = page.locator(".font-semibold.text-gray-800.hover\\:underline");
        String styleBeforeHover = elementToHover.getAttribute("style");
        elementToHover.hover();

        String styleAfterHover = elementToHover.getAttribute("style");

        Assertions.assertNotEquals(styleBeforeHover, styleAfterHover);
        Assertions.assertTrue(styleAfterHover.contains("text-decoration: underline;"));
    }
}