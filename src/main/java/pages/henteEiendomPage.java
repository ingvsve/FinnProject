package pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.elementsHenteEiendomPage;
import utilities.Excel;

public class henteEiendomPage {
    private elementsHenteEiendomPage elements;
    private WebDriver driver;
    String prisantydning;
    String adresse;
    String totalpris;
    String omkostninger;
    String felleskostnader;
    String byggeaar;
    String eierform;
    String bruksareal;
    String energimerkingFarge;
    String energimerkingBokstav;
    String etasje;
    String bildeLink;
    String avstandTbane;
    public boolean solgt;


    public henteEiendomPage(WebDriver driver){
        this.driver = driver;
        elements = new elementsHenteEiendomPage(driver);
    }

    public void hentePrisantydning(){
        try {this.prisantydning = elements.prisantydningElement().getText().split("kr")[0].replaceAll("\\s", "");
        } catch (StaleElementReferenceException e) {
            this.prisantydning = "0";
        }
    }

    public void henteAdresse(){
        this.adresse = elements.adresseElement().getText();
    }

    public void henteTotalpris(){
        this.totalpris = elements.totalprisElement().getText().split("kr")[0].replaceAll("\\s", "");
    }
    
    public void henteOmkostninger(){
        this.omkostninger = elements.omkostningerElement().getText().split("kr")[0].replaceAll("\\s", "");
    }
    
    public void henteFelleskostnader(){
        this.felleskostnader = elements.felleskostElement().getText().split("kr")[0].replaceAll("\\s", "");
    }

    public void henteByggeaar(){
        this.byggeaar = elements.byggeaarElement().getText();
    }

    public void henteEierform(){
        this.eierform = elements.eierformElement().getText();
    }

    public void henteBruksareal(){
        this.bruksareal = elements.bruksarealElement().getText().split("m")[0].replaceAll("\\s", "");
    }

    public void henteEnergimerkingFarge(){
        this.energimerkingFarge = elements.energiElement().getText().split(" ")[2];
    }

    public void henteEnergimerkingBokstav(){
        this.energimerkingBokstav = elements.energiElement().getText().split(" ")[0];
    }

    public void henteEtasje(){
        this.etasje = elements.etasjeElement().getText();
    }

    public void henteBildeLink(){
        this.bildeLink = elements.bildeElement().getAttribute("srcset").split(" ")[0];
    }

    public void boligSolgt(){
        try {
            this.solgt = elements.seHeleSnnonsenKnappElement().isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException noSuchElement) {
            this.solgt = false;
        }
    }

    public void ExcelEiendommer(String ExcelPath, String sheetName, String finnkode, int rowNumber){
        // Finne ut hvilken rad som er den neste ledige int antallEiendommer

        String[] informasjon = {finnkode, this.adresse, this.prisantydning, this.totalpris, this.omkostninger, this.felleskostnader, this.byggeaar, this.eierform, 
            this.bruksareal, "Blå", "X", this.etasje};
        for (int columnNumber=0; columnNumber<informasjon.length; columnNumber++){
            Excel.writeData(ExcelPath, sheetName, rowNumber, columnNumber, informasjon[columnNumber]);
            }
        Excel.leggeInnBilde(ExcelPath, sheetName, rowNumber, informasjon.length, this.bildeLink);        
    }
}
