package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.provider.Key;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.elementsEiendomPage;
import elements.elementsHenteEiendomPage;
import net.bytebuddy.asm.Advice.Enter;
import utilities.Excel;

public class eiendomPage {
    private elementsEiendomPage elements;
    private henteEiendomPage henteEiendom;
    private WebDriver driver;
    private String finnkode;
    private String eiendomlenke;

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
        elements.kartSøkTekstfeltElement().sendKeys(sted); // Keys.ARROW_DOWN, Keys.ENTER);
        new Actions(driver).moveToElement(elements.byttTilUtsnittElement()).moveByOffset(0, 12).click().perform();
        new Actions(driver).moveToElement(elements.byttTilUtsnittElement()).moveByOffset(0, 12).click().perform();
        elements.kartSøkTekstfeltElement().sendKeys(Keys.ARROW_DOWN);
        elements.kartSøkTekstfeltElement().sendKeys(Keys.ENTER);
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
        js.executeScript("window.scrollTo(0, 400);");
        elements.byttTilUtsnittElement().click();
        /*Point location = elements.byttTilUtsnittElement().getLocation();
        int xCoordinate = location.getX();
        int yCoordinate = location.getY();
        System.out.println("Element Location - X: " + xCoordinate + ", Y: " + yCoordinate);*/
    }

    public void velgNyttUtnitt(){
        elements.nyttUtsnittElement().click();
    }

    public void tegneKart(){
        Actions action = new Actions(this.driver);
        action.moveToElement(elements.kartElement()).moveByOffset(-15, 20).click().perform();
        action.moveToElement(elements.kartElement()).moveByOffset(-15, 20).click().perform(); //Start Grønland, går med klokka
        action.moveToElement(elements.kartElement()).moveByOffset(-25, -30).click().perform();
        action.moveToElement(elements.kartElement()).moveByOffset(40, -45).click().perform();
        action.moveToElement(elements.kartElement()).moveByOffset(75, -40).click().perform();
        action.moveToElement(elements.kartElement()).moveByOffset(120, -5).click().perform();
        action.moveToElement(elements.kartElement()).moveByOffset(135, 25).click().perform();
        action.moveToElement(elements.kartElement()).moveByOffset(90, 40).click().perform();
        action.moveToElement(elements.kartElement()).moveByOffset(50,45).click().perform();
        action.moveToElement(elements.kartElement()).moveByOffset(-15,20 ).click().perform(); // Slutt Grønland
    }

    public void leggeSokeresultaterIExcel(String ExcelPath, String sheetName){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("floor_navigator=NOTFIRST"));
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("window.scrollTo(0, 0);");
        List<WebElement> sokeresultater = elements.sokeresultaterElement();
        ArrayList<String> listeMedFinnkoder = Excel.lageListeFinnkoder(ExcelPath, sheetName);
        int rowNumber = listeMedFinnkoder.size();
        int iterator = 0;
        boolean finnkodenFinnes = true;
        boolean leilighetSolgt = false;
        for (WebElement resultat:sokeresultater){
            try {
                ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView(true);", resultat);
                finnkode = resultat.getAttribute("id");
                this.eiendomlenke = resultat.getAttribute("href");
            } catch (StaleElementReferenceException e) {
                List<WebElement> sokeresultater2 = elements.sokeresultaterElement();
                resultat = sokeresultater2.get(iterator);
                ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView(true);", resultat);
                finnkode = resultat.getAttribute("id");
                this.eiendomlenke = resultat.getAttribute("href");
            }
            
            finnkodenFinnes = Excel.erFinnkodenDer(ExcelPath, sheetName, finnkode, listeMedFinnkoder);
            System.out.println("Finnkoden finnes: " + finnkodenFinnes);
            if (!finnkodenFinnes){
                System.out.println("Skriver inn leilighet med finnkode: " + finnkode);
                ((JavascriptExecutor)this.driver).executeScript("window.open('"+eiendomlenke+"')");
                ArrayList<String> tabs = new ArrayList<String> (this.driver.getWindowHandles());
                String newTabHandle = tabs.get(tabs.size() - 1);
                this.driver.switchTo().window(newTabHandle);
                henteEiendom = new henteEiendomPage(this.driver);
                henteEiendom.boligSolgt();
                if (!henteEiendom.solgt){
                    henteEiendom.hentePrisantydning();
                    henteEiendom.henteAdresse();
                    henteEiendom.henteTotalpris();
                    henteEiendom.henteOmkostninger();
                    henteEiendom.henteFelleskostnader();
                    henteEiendom.henteByggeaar();
                    henteEiendom.henteEierform();
                    henteEiendom.henteBruksareal();
                    //henteEiendom.henteEnergimerkingFarge();
                    //henteEiendom.henteEnergimerkingBokstav();
                    henteEiendom.henteEtasje();
                    henteEiendom.henteBildeLink();
                    rowNumber ++;
                    iterator ++;
                    henteEiendom.ExcelEiendommer(ExcelPath, sheetName, finnkode, rowNumber);
                }
                this.driver.close();
                this.driver.switchTo().window(tabs.get(0)); // switch back to main screen
            }
        }
    }

    /*public Boolean finnkodeSjekk(String finnkode){
        if(finnkode er der){
            return true;
        } else {
            return false;
        }
    }*/
}
