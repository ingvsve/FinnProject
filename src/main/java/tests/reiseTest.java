package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.hjemPage;
import pages.reisePage;
import pages.reiseResultatPage;


public class reiseTest {
    WebDriver driver;

    @Before
    public static void setup(){
        
    }

    @Test
    public static void testReiseResultat (){
        WebDriver driver = loggInnTest.loggInn();
        hjemPage.trykkReise(driver);
        reisePage.enterFlyFra(driver);
        reisePage.enterFlyTil(driver);
        reisePage.trykkUtreiseDato(driver);
        reisePage.trykkNesteMåned(driver);
        reisePage.trykkTorsdag9November(driver);
        reisePage.trykkTirsdag14November(driver);
        reisePage.avKrysningHotel(driver);
        reisePage.trykkSøkeKnapp(driver);
        reiseResultatPage.ventPåProgressBar(driver);
        reiseResultatPage.trykkDirekte(driver);
        reiseResultatPage.endreAvreiseStart(driver);
        reiseResultatPage.endreAvreiseSlutt(driver);
        reiseResultatPage.endreReisetid(driver);
        reiseResultatPage.trykkLavpriskalender(driver);
        reiseResultatPage.hentPriser(driver, "C:\\Users\\isvendsen\\projects\\FinnTraining\\travelResults.xlsx" ,"results");
    }

    @After
    public static void tearDown() {
        //driver.quit();
    }
}