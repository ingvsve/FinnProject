package elements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementsHenteEiendomPage {
    WebDriver driver;
    public elementsHenteEiendomPage(WebDriver driver){
        this.driver = driver;
    }
    
    public WebElement omradeElement(){
        return this.driver.findElement(By.xpath("//div[@data-testid='local-area-name']"));
    }
    
    public WebElement adresseElement(){
        //return this.driver.findElement(By.xpath("//span[@data-testid='object-address']"));
        return this.driver.findElement(By.xpath("/html/body/main/div[3]/section/div[1]/div[1]/section[1]/a/span"));
        
    }
    
    public WebElement prisantydningElement(){
        return this.driver.findElement(By.xpath("//div[@data-testid='pricing-incicative-price']//span[@class='text-28 font-bold']"));
    }
    
    public WebElement totalprisElement(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        ((JavascriptExecutor)this.driver).executeScript("window.scrollTo(0, 600);");
        //WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-testid='pricing-total-price']//dd[@class='m-0 font-bold']")));
        return this.driver.findElement(By.xpath("//div[@data-testid='pricing-total-price']//dd[@class='m-0 font-bold']"));
    }

    public WebElement omkostningerElement(){
        return this.driver.findElement(By.xpath("//div[@data-testid='pricing-registration-charge']//dd[@class='m-0 font-bold']"));
    }

    public WebElement felleskostElement(){
        return this.driver.findElement(By.xpath("//div[@data-testid='pricing-common-monthly-cost']//dd[@class='m-0 font-bold']"));
    }

    public WebElement byggeaarElement(){
        return this.driver.findElement(By.xpath("//div[@data-testid='info-construction-year']//dd[@class='m-0 font-bold']"));
    }

    public WebElement eierformElement(){
        return this.driver.findElement(By.xpath("//div[@data-testid='info-ownership-type']//dd[@class='m-0 font-bold']"));
    }

    public WebElement bruksarealElement(){
        return this.driver.findElement(By.xpath("//div[@data-testid='info-primary-area']//dd[@class='m-0 font-bold']"));
    }

    public WebElement energiElement(){
        return this.driver.findElement(By.xpath("//span[@data-testid='energy-label-info']"));
    }

    public WebElement etasjeElement(){
        return this.driver.findElement(By.xpath("//div[@data-testid='info-floor']//dd[@class='m-0 font-bold']"));
    }

    public WebElement bildeElement(){
        return this.driver.findElement(By.id("image-0"));
    }

    //public WebElement minutterTilTBaneElement(){
    //    return this.driver.findElement(By.xpath("//li[@class='dp__cardInfoListItem__1lcj0']//dd[@class='m-0 font-bold']"));
    //}

    public WebElement seHeleSnnonsenKnappElement(){
        return this.driver.findElement(By.xpath("//button[@class='button button--secondary']"));
    }
}
