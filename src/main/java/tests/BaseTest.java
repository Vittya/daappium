package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ideig\\driverChrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://drukkadigitals.com/");
        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }
}