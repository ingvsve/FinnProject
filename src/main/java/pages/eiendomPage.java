package pages;

import org.apache.olingo.odata2.api.edm.provider.Key;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.elementsEiendomPage;
import net.bytebuddy.asm.Advice.Enter;

public class eiendomPage {
    private elementsEiendomPage elements;
    private WebDriver driver;

    public eiendomPage(WebDriver driver){
        this.driver = driver;
        elements = new elementsEiendomPage(driver);
    }

    public void skrivTotalprisFra(String minstrepris){
        elements.totalprisFraElement().sendKeys(minstrepris);
    }

    public void skrivTotalprisTil(String makspris){
        elements.totalprisTilElement().sendKeys(makspris);
    }

    public void velgToSoveromSjekkboks(){
        elements.toSoveromSjekkboksElement().click();
    }

    public void velgIkkeFørsteEtasjeSjekkboks(){
        elements.ikkeFørsteEtasjeSjekkboksElement().click();
    }
    
    public void skrivKartSøkTekstfelt(String sted){
        elements.kartSøkTekstfeltElement().click();
        elements.kartSøkTekstfeltElement().sendKeys(sted);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //elements.kartSøkTekstfeltElement().click();
        //elements.kartSøkTekstfeltElement().sendKeys(Keys.RETURN);
    }

    public void velgEiriksGateElement(){
        elements.eiriksGateElement().click();
    }

    public void pilNedKartSokeElement(){
        elements.kartSøkTekstfeltElement().sendKeys(Keys.ARROW_DOWN);
    }

    public void enterKartSokeElement(){
        elements.kartSøkTekstfeltElement().sendKeys(Keys.ENTER);
    }

    public void pilNedEiriksGate(){
        elements.eiriksGateElement().sendKeys(Keys.ARROW_DOWN);
    }

    public void flyttRadiusSliderTilHøyre(){
        elements.radiusSliderElement().sendKeys(Keys.ARROW_RIGHT);
    }

    public void flyttRadiusSliderTilVenstre(){
        elements.radiusSliderElement().sendKeys(Keys.ARROW_LEFT);
    }

    public void velgBalkongTerrasseSjekkboks(){
        elements.balkongTerrasseElement().click();
    }

    public void velgByttTilUtnitt(){
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("window.scrollTo(0, 0);");
        //js.executeScript("arguments[0].scrollIntoView(true);", elements.byttTilUtsnittElement()); 
        elements.byttTilUtsnittElement().click();
    }

    public void velgNyttUtnitt(){
        elements.byttTilUtsnittElement().click();
    }
}
