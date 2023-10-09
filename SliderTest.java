import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SliderTest extends TestBase {
    @Test
    void sliderTest() {
        // Navigate to URL
        String inputFormSubmitURL = "https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo";
        page.navigate(inputFormSubmitURL);
        page.bringToFront();

        // Locate title of page and print in terminal
        Locator title = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Slider Demo"));
        System.out.println(title);

        // Locate the slider element
        Locator slider = page.locator("#slider");

        // Get the slider handle element
        Locator sliderHandle = slider.locator(".slider-handle");
    }
}

