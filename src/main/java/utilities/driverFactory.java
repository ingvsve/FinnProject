package utilities;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class driverFactory {
    public static WebDriver open(String windowType) {
        if (windowType.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\isvendsen\\Documents\\Selenium\\Software\\chromedriver-118.exe");
            ChromeOptions option = new ChromeOptions();
            option.addArguments("incognito");
            WebDriver driver = new ChromeDriver(option); // not incognito: WebDriver driver = new ChromeDriver();
            return driver;
        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\isvendsen\\Documents\\Selenium\\Software\\geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver(options);
            //WebDriver driver = new FirefoxDriver(options);
            //driver.findElement(By.id("startPrivateBrowsing")).click();
            //ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            //driver.switchTo().window(tabs.get(1));
            //driver.get("https://www.yr.no/nb");
            //driver.switchTo().window(tabs.get(0)); // switch back to main screen
            //driver.close();
            //driver.switchTo().window(tabs.get(0)); // switch back to main screen
            return driver;
        }
    }
}
