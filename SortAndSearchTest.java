import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SortAndSearchTest extends TestBase {
    @Test
    void testTableSorting () {
        // Navigera till webbsidan
        String startURL = "https://www.lambdatest.com/selenium-playground/table-sort-search-demo";
        page.navigate(startURL);
        page.bringToFront();

        // Click on tablehead "Name" to sort information i falling order
        page.click("th:has-text('Name')");

        // Get text from first row in column "Name"
        String firstRowNameT = page.locator("tbody tr:first-child td:nth-child(1)").innerText();

        // Verify that first name in column "Name" is T. Fitzpatrick and print in terminal
        Assertions.assertEquals("T. Fitzpatrick", firstRowNameT);
        System.out.println("Result: " + firstRowNameT + ", Extected name: T.Fitzpatrick");

    }
}
