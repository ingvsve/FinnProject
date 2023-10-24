package pages;

import org.openqa.selenium.WebDriver;
import elements.elementsHjemPage;

public class hjemPage {
    private elementsHjemPage elements;
    private WebDriver driver;

    public hjemPage(WebDriver driver){
        this.driver = driver;
        elements = new elementsHjemPage(driver);
    }
    
    public void godtaCookies(){
        this.driver.switchTo().frame(1);
        elements.cookieWebElement().click();
        this.driver.switchTo().defaultContent();
    }

    public void trykkLoggInn (){
        elements.headerWebElement().click();
    }

    public void trykkReise (){
        elements.reiseElement().click();   
    }

    public void trykkEiendom (){
        elements.eiendomElement().click();   
    }    
}
