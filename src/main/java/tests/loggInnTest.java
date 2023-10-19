package tests;

import org.openqa.selenium.WebDriver;

import pages.hjemPage;
import pages.loggInnPage;
import utilities.driverFactory;

public class loggInnTest {
    public static WebDriver loggInn(){
        // elementsHjemPage elementsHjemPageObject = new elementsHjemPage(driver);
        WebDriver driver = driverFactory.open("incognito");
        driver.get("https://www.finn.no/");
        hjemPage hjem = new hjemPage(driver);
        hjem.godtaCookies(driver);
        hjem.trykkLoggInn();

        loggInnPage.enterUsername(driver);
        loggInnPage.enterPassword(driver);
        loggInnPage.clickLoggInn(driver);
        return driver;
    }
}
