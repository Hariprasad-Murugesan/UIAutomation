package TestCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    protected RemoteWebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void preConditions(String browser, String url) {
        if (browser.equalsIgnoreCase("chrome")) {
           WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
        	WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser value: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void postConditions() throws InterruptedException {
        Thread.sleep(5000);
        if (driver != null) {
            driver.quit();
        }
    }
}
