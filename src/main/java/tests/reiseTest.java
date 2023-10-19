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

    @Before
    public void setUp() {
        WebDriver driver = driverFactory.open("incognito");//loggInnTest.loggInn();
        this.driver = driver;
        hjem = new hjemPage(driver);
    }

    public reiseTest(){
        hjem = new hjemPage(driver);
    }

    @Test
    public void testReiseResultat (){
        driver.get("https://www.finn.no/");
        //hjemPage page = new hjemPage(driver);
        hjem.godtaCookies(driver);
        hjem.trykkLoggInn();

        
        loggInnPage.enterUsername(driver);
        loggInnPage.enterPassword(driver);
        loggInnPage.clickLoggInn(driver);
        
        hjem.trykkReise();

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
    public void tearDown() {
        driver.quit();
    }
}