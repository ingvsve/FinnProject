package tests;

import org.openqa.selenium.WebDriver;

import pages.hjemPage;
import utilities.driverFactory;

public class åpneNettleser {
        public static WebDriver åpneCookiesLoggInn(){
                WebDriver driver = driverFactory.open("incognito");
                driver.get("https://www.finn.no/");
                hjemPage page = new hjemPage(driver);
                page.godtaCookies();
                page.trykkLoggInn();
                return driver;
        }
}
