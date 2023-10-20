package elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementsLoggInnPage {
        WebDriver driver;
    // private static WebElement element = null;

    public elementsLoggInnPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement usernameWebElement(){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        WebElement usernameElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        return usernameElement;
    }
    
    public WebElement passwordWebElement(){
        return this.driver.findElement(By.id("password"));
    }
    
    public WebElement actionButtonWebElement(){
        return this.driver.findElement(By.id("ActionButton_0"));
    }
}
