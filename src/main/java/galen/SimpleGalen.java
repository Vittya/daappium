package galen;

import com.galenframework.testng.GalenTestNgTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SimpleGalen extends GalenTestNgTestBase {
    @Override
    public WebDriver createDriver(Object[] objects) {
        return new ChromeDriver();
    }

    @Test
    @Parameters({"chromeDriverPort", "chromeDriverPath"})
    public void verifyPage(){
        load("http://www.drukkadigitals.com",1024,768);
    }
}
