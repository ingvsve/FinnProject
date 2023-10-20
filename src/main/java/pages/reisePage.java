package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import elements.elementsLoggInnPage;
import elements.elementsReisePage;

public class reisePage {
    private WebDriver driver;
    private elementsReisePage elements;

    public reisePage(WebDriver driver){
        this.driver = driver;
        elements = new elementsReisePage(driver);
    }
    public void enterFlyFra(){
        elements.flyFraElement().sendKeys("Oslo lufthavn Gardermoen");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elements.flyFraElement().sendKeys(Keys.RETURN);
    }

    public void enterFlyTil(){
        elements.flyTilElement().sendKeys("Barcelona");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elements.flyTilElement().sendKeys(Keys.RETURN);
    }

    public void trykkUtreiseDato(){
        elements.utreiseDatoElement().click();
    }
    
    public  void trykkNesteMåned(){
        elements.nesteMånedElement().click();
    }

    public void trykkTorsdag9November(){
        elements.torsdag9NovemberElement().click();
    }

    public void trykkTirsdag14November(){
        elements.tirsdag14NovemberElement().click();
    }

    public void avKrysningHotel(){
        elements.ankrysningHotelElement().click();
    }

    public void trykkSøkeKnapp(){
        elements.søkeKnappElement().click();
    }
}