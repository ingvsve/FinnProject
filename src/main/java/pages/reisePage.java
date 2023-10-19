package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import elements.elementsReisePage;

public class reisePage {
    public static void enterFlyFra(WebDriver driver){
        elementsReisePage.flyFraElement(driver).sendKeys("Oslo lufthavn Gardermoen");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementsReisePage.flyFraElement(driver).sendKeys(Keys.RETURN);
    }

    public static void enterFlyTil(WebDriver driver){
        elementsReisePage.flyTilElement(driver).sendKeys("Barcelona");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementsReisePage.flyTilElement(driver).sendKeys(Keys.RETURN);
    }

    public static void trykkUtreiseDato(WebDriver driver){
        elementsReisePage.utreiseDatoElement(driver).click();
    }
    
    public static void trykkNesteMåned(WebDriver driver){
        elementsReisePage.nesteMånedElement(driver).click();
    }

    public static void trykkTorsdag9November(WebDriver driver){
        elementsReisePage.torsdag9NovemberElement(driver).click();
    }

    public static void trykkTirsdag14November(WebDriver driver){
        elementsReisePage.tirsdag14NovemberElement(driver).click();
    }

    public static void avKrysningHotel(WebDriver driver){
        elementsReisePage.ankrysningHotelElement(driver).click();
    }

    public static void trykkSøkeKnapp(WebDriver driver){
        elementsReisePage.søkeKnappElement(driver).click();
    }
}