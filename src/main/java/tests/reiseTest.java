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
        WebDriver driver = driverFactory.open("incognito");// loggInnTest.loggInn();
        this.driver = driver;
        this.hjem = new hjemPage(driver);
        this.loggInn = new loggInnPage(driver);
        this.reise = new reisePage(driver);
        this.reiseResultat = new reiseResultatPage(driver);
    }

    @Test
    public void testReiseResultat() {
        driver.get("https://www.finn.no/");
        this.hjem.godtaCookies();
        // this.hjem.trykkLoggInn();

        // this.loggInn.enterUsername();
        // this.loggInn.enterPassword();
        // this.loggInn.clickLoggInn();

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
        this.reiseResultat.hentPriser("C:\\Users\\isvendsen\\projects\\FinnTraining\\travelResults.xlsx", "results");
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

/*
 * Gammel versjon:
 * package tests;
 * 
 * import java.io.File;
 * import java.io.FileInputStream;
 * import java.io.FileOutputStream;
 * import java.io.IOException;
 * import java.time.Duration;
 * 
 * import org.apache.poi.xssf.usermodel.XSSFCell;
 * import org.apache.poi.xssf.usermodel.XSSFRow;
 * import org.apache.poi.xssf.usermodel.XSSFSheet;
 * import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * import org.junit.After;
 * import org.junit.Assert;
 * import org.junit.Test;
 * import org.openqa.selenium.By;
 * import org.openqa.selenium.Keys;
 * import org.openqa.selenium.WebDriver;
 * import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.chrome.ChromeDriver;
 * import org.openqa.selenium.chrome.ChromeOptions;
 * import org.openqa.selenium.support.ui.ExpectedConditions;
 * import org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * public class eiendomsTest {
 * WebDriver driver;
 * 
 * @Test
 * public void openWindowTest() {
 * // Open incognito window in Chrome
 * //driver = driverFactory.open("incognito");
 * System.setProperty("webdriver.chrome.driver",
 * "C:\\Users\\isvendsen\\Documents\\Selenium\\Software\\chromedriver.exe");
 * ChromeOptions option = new ChromeOptions();
 * option.addArguments("incognito");
 * driver = new ChromeDriver(option); // not incognito: WebDriver driver = new
 * ChromeDriver();
 * 
 * driver.get("https://www.finn.no");
 * 
 * Assert.assertEquals("FINN.no - mulighetenes marked", driver.getTitle());
 * 
 * // Accept cookies
 * driver.switchTo().frame(1);
 * driver.findElement(By.xpath("//button[@title='Jeg forstår']")).click(); //
 * egen x-path
 * driver.switchTo().defaultContent();
 * 
 * // Enter shadow DOM to access login button in header
 * WebElement element =
 * driver.findElement(By.xpath("//finn-topbar")).getShadowRoot().findElement(By.
 * cssSelector("header > nav > a:nth-child(5)"));
 * element.click();
 * 
 * // Write username and password and press log in
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 * WebElement loginLink =
 * wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
 * loginLink.click();
 * driver.findElement(By.id("username")).sendKeys(
 * "ingvild.svendsen@expleogroup.com");
 * driver.findElement(By.id("password")).sendKeys("Expleo123");
 * driver.findElement(By.id("ActionButton_0")).click();
 * 
 * // Wait for "reise" to appear, then choose Gardermoen, Barcelona, dates,
 * uncheck hotels and click on "search"
 * WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
 * WebElement loginLink2 =
 * wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//a[@href='/reise']")));
 * loginLink2.click();
 * 
 * // Write Oslo
 * WebElement FlyFra =
 * driver.findElement(By.xpath("//*[@id=\"origin-roundtrip\"]"));
 * FlyFra.sendKeys("Oslo lufthavn Gardermoen");
 * 
 * try {
 * Thread.sleep(2000);
 * } catch (InterruptedException e) {
 * e.printStackTrace();
 * }
 * FlyFra.sendKeys(Keys.RETURN);
 * 
 * // Write Barcelona
 * WebElement FlyTil =
 * driver.findElement(By.xpath("//*[@id=\"destination-roundtrip\"]"));
 * FlyTil.sendKeys("Barcelona");
 * try {
 * Thread.sleep(2000);
 * } catch (InterruptedException e) {
 * e.printStackTrace();
 * }
 * FlyTil.sendKeys(Keys.RETURN);
 * 
 * // Choose dates
 * driver.findElement(By.xpath(
 * "//input[@placeholder='Dato'][@data-testid='date-roundtrip-outbound']")).
 * click();
 * driver.findElement(By.
 * xpath("//button[@class='button button--pill button--small absolute right-10 top-4']"
 * )).click();
 * driver.findElement(By.xpath("//td[@aria-label='torsdag 9. november 2023']")).
 * click();
 * driver.findElement(By.xpath("//td[@aria-label='tirsdag 14. november 2023']"))
 * .click();
 * 
 * // Uncheck hotels checkbox and click search
 * driver.findElement(By.xpath("//label[@for='openHotelSearch']")).click();
 * driver.findElement(By.xpath("//button[@data-testid='flightSearchButton']")).
 * click();
 * 
 * // Choose direct flight
 * By yourSelector = By.xpath("//div[@role='progressbar']");
 * 
 * // Wait until progress bar disappears (aria-valuenow reaches 100 or element
 * disappears)
 * WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
 * wait3.until(ExpectedConditions.or(ExpectedConditions.attributeToBe(
 * yourSelector, "aria-valuenow",
 * "100"),ExpectedConditions.invisibilityOfElementLocated(yourSelector)));
 * driver.findElement(By.xpath("//label[@for='stopoverFilter0']")).click();
 * 
 * 
 * // Open low price calendar and save results in Excel document
 * int rowNumber = 5;
 * int columnNumber = 5;
 * driver.findElement(By.xpath("//button[@data-testid='toggleLowfare']")).click(
 * );
 * String data =
 * driver.findElement(By.xpath("//td[@data-row='"+rowNumber+"'][@data-col='"+
 * columnNumber+"']")).getText();
 * 
 * // Saving one value in Excel file
 * //public void writeData(String ExcelPath, String sheetName, int rowNumber,
 * int columnNumber, String data){}
 * try{
 * String ExcelPath =
 * "C:\\Users\\isvendsen\\projects\\FinnTraining\\travelResults.xlsx";
 * String sheetName = "results";
 * 
 * //File file = new File(ExcelPath);
 * FileInputStream file = new FileInputStream(new File(ExcelPath));
 * 
 * XSSFWorkbook wb = new XSSFWorkbook(file);
 * XSSFSheet sheet = wb.getSheet(sheetName);
 * XSSFRow row = sheet.getRow(rowNumber);
 * XSSFCell cell = row.getCell(columnNumber,
 * org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
 * 
 * if(cell == null){
 * cell = row.createCell(columnNumber);
 * cell.setCellValue(data);
 * 
 * }else{
 * cell.setCellValue(data);
 * }
 * // FileOutputStream fio = new FileOutputStream(file, false);
 * FileOutputStream outFile = new FileOutputStream(new File(ExcelPath));
 * 
 * wb.write(outFile);
 * wb.close();
 * 
 * }catch(IOException io) {
 * io.printStackTrace();
 * }
 * 
 * 
 * 
 * 
 * // Choose tider (beginning of interval)
 * String desiredTravelTimeStart = "08:00";
 * WebElement sliderTravelTimeStart = driver.findElement(By.
 * xpath("//div[@aria-label='Utreise tidligst'][@role='slider']"));
 * String currentTimeStart =
 * sliderTravelTimeStart.getAttribute("aria-valuetext").split(" ")[1];
 * sliderTravelTimeStart.click();
 * //Assert.assertEquals(desiredTravelTimeStart, currentTimeStart);
 * while (!desiredTravelTimeStart.equals(currentTimeStart)){
 * sliderTravelTimeStart.sendKeys(Keys.ARROW_RIGHT);
 * currentTimeStart =
 * sliderTravelTimeStart.getAttribute("aria-valuetext").split(" ")[1];
 * }
 * 
 * // Choose tider (end of interval)
 * String desiredTravelTimeStop = "12:00";
 * WebElement sliderTravelTimeStop = driver.findElement(By.
 * xpath("//div[@aria-label='Utreise senest'][@role='slider']"));
 * String currentTimeStop =
 * sliderTravelTimeStop.getAttribute("aria-valuetext").split(" ")[1];
 * sliderTravelTimeStop.click();
 * while (!desiredTravelTimeStop.equals(currentTimeStop)){
 * sliderTravelTimeStop.sendKeys(Keys.ARROW_LEFT);
 * currentTimeStop =
 * sliderTravelTimeStop.getAttribute("aria-valuetext").split(" ")[1];
 * }
 * 
 * // Choose desired maximum travel time and slide until the desired time is
 * reached
 * int desiredTravelTime = 8;
 * WebElement sliderTravelTime = driver.findElement(By.
 * xpath("//div[@aria-label='Maks reisetid'][@role='slider']"));
 * String maxTravelTime = sliderTravelTime.getAttribute("aria-valuetext");
 * int TravelTime = Integer.parseInt(maxTravelTime.split(" ")[0]);
 * for (int i = 0; i < (TravelTime-desiredTravelTime) ; i++ ){
 * sliderTravelTime.sendKeys(Keys.ARROW_LEFT);
 * }
 * 
 * // Check that we get the desired value
 * String aria_valuetext = sliderTravelTime.getAttribute("aria-valuetext");
 * Assert.assertEquals(desiredTravelTime,
 * Integer.parseInt(aria_valuetext.split(" ")[0]));
 * 
 * }
 * 
 * @After
 * public void afterTest() {
 * // driver.quit();
 * }
 * }
 */