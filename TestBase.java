import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2500));
        //browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));
        //browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));
    }

    @BeforeEach
    public void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tillåt alla cookies"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();

            Locator skipTip = page.locator("button[aria-label='Skip']");

            if (skipTip.isVisible()) {
                skipTip.click();
            }
        }
    }

    @AfterEach
    public void closeContext() {
        page.close();
        context.close();
    }

    @AfterAll
    static public void closeBrowser(){
        browser.close();
        playwright.close();
    }
}

