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

    public static WebElement usernameWebElement(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement usernameElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        return usernameElement;
    }
    
    public static WebElement passwordWebElement(WebDriver driver){
        return driver.findElement(By.id("password"));
    }
    
    public static WebElement actionButtonWebElement(WebDriver driver){
        return driver.findElement(By.id("ActionButton_0"));
    }
}
