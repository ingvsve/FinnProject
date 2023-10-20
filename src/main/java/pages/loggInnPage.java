package pages;

import elements.elementsLoggInnPage;

import org.openqa.selenium.WebDriver;

public class loggInnPage{
    private WebDriver driver;
    private elementsLoggInnPage elements;

    public loggInnPage(WebDriver driver){
        this.driver = driver;
        elements = new elementsLoggInnPage(driver);
    }

    public void enterUsername(){
        elements.usernameWebElement().sendKeys("ingvild.svendsen@expleogroup.com");
    }
    
    public void enterPassword(){
        elements.passwordWebElement().sendKeys("Expleo123");
    }
        
    public void clickLoggInn(){
        elements.actionButtonWebElement().click();
    }
}