package pages;

import org.openqa.selenium.WebDriver;

import elements.elementsEiendomValgPage;

public class eiendomValgPage {
    private elementsEiendomValgPage elements;
    private WebDriver driver;

    public eiendomValgPage(WebDriver driver){
        this.driver = driver;
        elements = new elementsEiendomValgPage(driver);
    }

    public void trykkBoligTilSalgs(){
        elements.boligTilSalgsElement().click();
    }
}
