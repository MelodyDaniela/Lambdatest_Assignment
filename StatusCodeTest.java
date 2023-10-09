import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StatusCodeTest extends TestBase{
    @Test
    void statuscodetest (){
        String startURL = "https://www.lambdatest.com/selenium-playground/status-code";
        page.navigate(startURL);
        page.bringToFront();

        // Ange den förväntade texten att leta efter
        String expectedText = "Tells a web user that a requested page is not available";

        // Skapa en Locator för texten och kontrollera om den är synlig
        Locator textLocator = page.locator("text=" + expectedText);

        if (textLocator.isVisible()) {
            System.out.println("Texten: '" + expectedText + "' är synlig på sidan.");
        }
        else {
            System.out.println("Texten: '" + expectedText + "' är inte synlig på sidan.");
        }
    }
}

