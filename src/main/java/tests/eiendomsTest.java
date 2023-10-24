package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.hjemPage;
import pages.loggInnPage;
import pages.eiendomValgPage;
import pages.eiendomPage;
import utilities.driverFactory;

public class eiendomsTest{
    private WebDriver driver;
    private hjemPage hjem;
    private loggInnPage loggInn;
    private eiendomValgPage eiendomValg;
    private eiendomPage eiendom;
    
    @Before
    public void setUp() {
        WebDriver driver = driverFactory.open("incognito");//loggInnTest.loggInn();
        this.driver = driver;
        this.hjem = new hjemPage(driver);
        //this.loggInn = new loggInnPage(driver);
        this.eiendomValg = new eiendomValgPage(driver);
        this.eiendom = new eiendomPage(driver);
    }

    @Test
    public void eiendom(){
        driver.get("https://www.finn.no/");
        this.driver.manage().window().maximize();
        this.hjem.godtaCookies();
        this.hjem.trykkEiendom();
        this.eiendomValg.trykkBoligTilSalgs();
        //this.eiendom.skrivTotalprisFra("4400000");
        //this.eiendom.skrivTotalprisTil("5800000");
        //this.eiendom.velgToSoveromSjekkboks();
        //this.eiendom.velgBalkongTerrasseSjekkboks();
        //this.eiendom.velgIkkeFørsteEtasjeSjekkboks();
        this.eiendom.skrivKartSøkTekstfelt("Eiriks gate");
        this.eiendom.pilNedKartSokeElement();
        this.eiendom.pilNedKartSokeElement();
        this.eiendom.enterKartSokeElement();
        this.eiendom.flyttRadiusSliderTilVenstre();
        this.eiendom.velgByttTilUtnitt();
        this.eiendom.velgNyttUtnitt();

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}