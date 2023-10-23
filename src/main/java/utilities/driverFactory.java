package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class driverFactory {
    public static WebDriver open(String windowType) {
        if (windowType.equals("incognito")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\isvendsen\\Documents\\Selenium\\Software\\chromedriver-118.exe");
            ChromeOptions option = new ChromeOptions();
            option.addArguments("incognito");
            WebDriver driver = new ChromeDriver(option); // not incognito: WebDriver driver = new ChromeDriver();
            return driver;
        } else {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\isvendsen\\Documents\\Selenium\\Software\\chromedriver-118.exe");
            WebDriver driver = new ChromeDriver();
            return driver;
        }
    }
}
