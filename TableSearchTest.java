import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableSearchTest extends TestBase {

    @Test
    void tablesearchFilter() {

        // Navigate to URL
        String inputFormSubmitURL = "https://www.lambdatest.com/selenium-playground/table-search-filter-demo";
        page.navigate(inputFormSubmitURL);
        page.bringToFront();

        // Locate textbox and fill it with "Development"
        Locator searchInput = page.locator("#task-table-filter");
        Assertions.assertTrue(searchInput.isVisible());
        System.out.println(searchInput);
        searchInput.fill("Development");

        // Press Enter Key
        page.keyboard().press("Enter");
        Locator tableRow = page.locator("table tbody tr");
        Assertions.assertFalse(tableRow.count() == 1);

        // create variable and enter empty space in textbox
        int secondExpectedRowCount = 14;
        searchInput.fill("");

        // Assert that amount expected rows is the same as outcome. Print in terminal.
        Assertions.assertEquals(14, tableRow.count());

        if (tableRow.count() == secondExpectedRowCount) {
            System.out.println("14 rader hittades totalt!");
        }
    }
}