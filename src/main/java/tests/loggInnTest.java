package tests;

import org.openqa.selenium.WebDriver;

import pages.loggInnPage;

public class loggInnTest {
    public static WebDriver loggInn(){
        // elementsHjemPage elementsHjemPageObject = new elementsHjemPage(driver);
        WebDriver driver = åpneNettleser.åpneCookiesLoggInn();
        loggInnPage.enterUsername(driver);
        loggInnPage.enterPassword(driver);
        loggInnPage.clickLoggInn(driver);
        return driver;
    }
}
