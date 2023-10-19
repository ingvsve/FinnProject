package elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementsHjemPage {
    WebDriver driver;
    // private static WebElement element = null;

    public elementsHjemPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement cookieWebElement(){
        return driver.findElement(By.xpath("//button[@title='Jeg forstår']"));
    }

    public WebElement headerWebElement(){
        return driver.findElement(By.xpath("//finn-topbar")).getShadowRoot().findElement(By.cssSelector("header > nav > a:nth-child(5)"));
    }

    public WebElement reiseElement(){
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/reise']")));
    }

    //eiendom
}