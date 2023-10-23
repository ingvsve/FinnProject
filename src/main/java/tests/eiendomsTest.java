package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

//import pages.hjemPage;
//import pages.loggInnPage;
import utilities.driverFactory;

public class eiendomsTest{
    private WebDriver driver;
    //private hjemPage hjem;
    //private loggInnPage loggInn;
    //private eiendomPage eiendom;
    
    @Before
    public void setUp() {
        WebDriver driver = driverFactory.open("incognito");//loggInnTest.loggInn();
        this.driver = driver;
        //this.hjem = new hjemPage(driver);
        //this.loggInn = new loggInnPage(driver);
        //this.eiendom = new eiendomPage(driver);
    }

    @Test
    public void eiendom(){

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}