import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputFormSubmitTest extends TestBase {
    @Test
    void inputformsubmit() {

        // Navigate to URL
        String inputFormSubmitURL ="https://www.lambdatest.com/selenium-playground/input-form-demo";
        page.navigate(inputFormSubmitURL);
        page.bringToFront();

        //Locate att textboxes and fill them in
        Locator textboxName = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name"));
        textboxName.fill("Melody");

        Locator textboxEmail = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email"));
        textboxEmail.fill("melody.bonnet@gmail.com");

        Locator textboxPassword = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"));
        textboxPassword.fill("password123");

        Locator textboxCompany = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Company"));
        textboxCompany.fill("Nackademin");

        Locator textboxWebsite = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Website"));
        textboxWebsite.fill("Nackdemin.se");

        // Locate combobox and choose an option in the list
        Locator comboboxCountry = page.getByRole(AriaRole.COMBOBOX);
        SelectOption selectOption = new SelectOption();
        selectOption.setValue("SE");
        comboboxCountry.selectOption(selectOption);

        // Continue to locate and fill in all boxes
        Locator textboxCity = page.locator("#inputCity");
        textboxCity.fill("Stockholm");

        Locator textboxAddress1 = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address 1"));
        textboxAddress1.fill("Gatuadress");

        Locator textboxAddress2 = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address 2"));
        textboxAddress2.fill("1");

        Locator textboxZipCode = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Zip Code"));
        textboxZipCode.fill("111 23");

        Locator textboxState = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("State"));
        textboxState.fill("Sverige");

        // Locate submit button and click on it to send info to computer
        Locator buttonSubmit = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));
        buttonSubmit.click();

        // Locate and print result text on webpage
        Locator resultHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Input form validations").setExact(true));
        // String headingText = page.innerText("h2");
        Assertions.assertTrue(resultHeading.textContent().contains("Input form validations"));
        System.out.println("Message shown on webpage: " + resultHeading);
    }
}
