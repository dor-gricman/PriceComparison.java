package Selenium.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriver {

    public static ChromeDriver initializeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();

        return new ChromeDriver(chromeOptions);
    }

    public static void quitDriver(ChromeDriver driver) {
        driver.quit();
    }
}
