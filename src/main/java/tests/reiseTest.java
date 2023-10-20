package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.hjemPage;
import pages.loggInnPage;
import pages.reisePage;
import pages.reiseResultatPage;
import utilities.driverFactory;

public class reiseTest {
    private WebDriver driver;
    private hjemPage hjem;
    private loggInnPage loggInn;
    private reisePage reise;
    private reiseResultatPage reiseResultat;

    @Before
    public void setUp() {
        WebDriver driver = driverFactory.open("incognito");//loggInnTest.loggInn();
        this.driver = driver;
        this.hjem = new hjemPage(driver);
        this.loggInn = new loggInnPage(driver);
        this.reise = new reisePage(driver);
        this.reiseResultat = new reiseResultatPage(driver);
    }

    @Test
    public void testReiseResultat (){
        driver.get("https://www.finn.no/");
        this.hjem.godtaCookies();
        this.hjem.trykkLoggInn();
        
        this.loggInn.enterUsername();
        this.loggInn.enterPassword();
        this.loggInn.clickLoggInn();
        
        this.hjem.trykkReise();

        this.reise.enterFlyFra();
        this.reise.enterFlyTil();
        this.reise.trykkUtreiseDato();
        this.reise.trykkNesteMåned();
        this.reise.trykkTorsdag9November();
        this.reise.trykkTirsdag14November();
        this.reise.avKrysningHotel();
        this.reise.trykkSøkeKnapp();
        this.reiseResultat.ventPåProgressBar();
        this.reiseResultat.trykkLavpriskalender();
        this.reiseResultat.hentPriser("C:\\Users\\isvendsen\\projects\\FinnTraining\\travelResults.xlsx" ,"results");
        this.reiseResultat.trykkDirekte();
        this.reiseResultat.endreAvreiseStart();
        this.reiseResultat.endreAvreiseSlutt();
        this.reiseResultat.endreReisetid();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}