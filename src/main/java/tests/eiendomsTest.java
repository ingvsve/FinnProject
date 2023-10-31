package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pages.hjemPage;
import pages.loggInnPage;
import pages.eiendomValgPage;
import pages.henteEiendomPage;
import pages.eiendomPage;
import utilities.driverFactory;

public class eiendomsTest{
    private WebDriver driver;
    private hjemPage hjem;
    private loggInnPage loggInn;
    private eiendomValgPage eiendomValg;
    private eiendomPage eiendom;
    private henteEiendomPage henteEiendomPage;
    
    @Before
    public void setUp() {
        WebDriver driver = driverFactory.open("incognito");//loggInnTest.loggInn();
        this.driver = driver;
        this.hjem = new hjemPage(driver);
        //this.loggInn = new loggInnPage(driver);
        this.eiendomValg = new eiendomValgPage(driver);
        this.eiendom = new eiendomPage(driver);
        this.henteEiendomPage = new henteEiendomPage(driver);
    }

    @Test
    public void eiendom(){
        driver.get("https://www.finn.no/");
        this.driver.manage().window().maximize();
        this.hjem.godtaCookies();
        this.hjem.trykkEiendom();
        this.eiendomValg.trykkBoligTilSalgs();
        this.eiendom.skrivKartSøkTekstfelt("Eiriks gate, Oslo");
        this.eiendom.flyttRadiusSliderTilVenstre();
        this.eiendom.velgByttTilUtnitt();
        this.eiendom.velgNyttUtnitt();
        this.eiendom.tegneKart();
        this.eiendom.skrivTotalprisFra("3000000");
        this.eiendom.skrivTotalprisTil("5500000");
        this.eiendom.velgToSoveromSjekkboks();
        this.eiendom.velgBalkongTerrasseSjekkboks();
        this.eiendom.velgIkkeFørsteEtasjeSjekkboks();
        this.eiendom.leggeSokeresultaterIExcel("C:\\Users\\isvendsen\\Documents\\Selenium\\bolig.xlsx", "Testautomatisering");
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}