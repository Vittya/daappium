package pages.prl.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.prl.scrn.BasePage;
import pages.prl.scrn.FindOwnerPage;
import pages.prl.scrn.HomePage;
import pages.prl.scrn.MainNavigationBar;
import pages.prl.scrn.OwnersPage;
import pages.prl.scrn.webdroid.SimplePage;

import java.io.File;
import java.net.URL;

public class AndroidNativeWebAppParallelTests {

    private final static String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";

    private AndroidDriver<MobileElement> driver;


    @BeforeTest(alwaysRun = true)
    @Parameters({"platform", "udid", "chromeDriverPort", "chromeDriverPath"})
    public void setup(String platform, String udid, String chromeDriverPort, @Optional String chromeDriverPath) throws Exception {
        URL url = new URL(APPIUM_SERVER_URL);

        String[] platformInfo = platform.split(" ");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.UDID, udid);


        capabilities.setCapability("chromeDriverPort", chromeDriverPort);

        if (chromeDriverPath != null) {
            capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("w3c",false);
            capabilities.setCapability(AndroidMobileCapabilityType.CHROME_OPTIONS,options);
        }

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);



        driver = new AndroidDriver<MobileElement>(url, capabilities);

    }

    @Test
    public void testFindOwner() {
        try {
            SimplePage page = new SimplePage(driver);
            for (int i = 0; i < 100; i++) {
                page.goToUrl("https://staging.admin.servee.me/guests")
                        .typeText("viktor.harsanyi@drukka.hu", By.xpath("//*[@id=\"inputemail\"]"))
                        .typeText("Drukka001", By.xpath("//*[@id=\"inputpassword\"]"))
                        .hide()
                        .clickIt(By.xpath("/html/body/div/div/div[1]/div[3]/div/div/div[2]/div/div/div/div/form/div[4]/div/button"))
                        .justWait()
                        //drawer
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[1]/div/i"))
                        //entertainment
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[2]/span"))
                        //activities
                        //.clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[1]/div/i"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[2]/ul/li[1]/a/span"))
                        //events
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[1]/div/i"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[2]/ul/li[2]/a/span"))
                        //advertisments
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[1]/div/i"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[2]/ul/li[3]/a/span"))


                        //settings
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[1]/div/i"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[3]/span"))

                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[3]/ul/li[1]/a/span"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[1]/div/i"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[3]/ul/li[2]/a"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[1]/div/i"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[3]/ul/li[4]/a/span"))


                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[1]/div/i"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[3]/ul/li[5]/a/span"))

                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[1]/div/i"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[3]/ul/li[6]/a/span"))

                        //Statistics
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[1]/div/i"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[4]/a/span"))


                        //sign out
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[1]/div/i"))
                        .clickIt(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/header/div/div/ul/li[5]/a/span"))

                ;

            }
        }catch (Exception e){
            driver.startLogcatBroadcast();
            File dir = new File("C:\\Users\\ideig");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


        }

    }

    @AfterTest(alwaysRun = true)
    public void teardown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

    private BasePage launchHomePage() {
        HomePage homePage = new HomePage(driver);
        driver.get(homePage.getPageUrl());
        homePage.waitForUrlToBeLoaded();
        return homePage;
    }

}

