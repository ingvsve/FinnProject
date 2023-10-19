package pages;

import elements.elementsLoggInnPage;

import org.openqa.selenium.WebDriver;

public class loggInnPage{
    public static void enterUsername(WebDriver driver){
        elementsLoggInnPage.usernameWebElement(driver).sendKeys("ingvild.svendsen@expleogroup.com");
    }
    
    public static void enterPassword(WebDriver driver){
        elementsLoggInnPage.passwordWebElement(driver).sendKeys("Expleo123");
    }
        
    public static void clickLoggInn(WebDriver driver){
        elementsLoggInnPage.actionButtonWebElement(driver).click();
    }
}