package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class elementsEiendomValgPage {
    WebDriver driver;
    public elementsEiendomValgPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement boligTilSalgsElement(){
        return this.driver.findElement(By.xpath("//a[@href='https://www.finn.no/realestate/homes/search.html?filters=']"));
    }

}
