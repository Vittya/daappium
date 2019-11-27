package pages.prl.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pages.prl.scrn.webdroid.SimplePage;

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

            SimplePage page = new SimplePage(driver);

            for (int i = 0; i < 1000; i++) {
                page.goToUrl("https://app.echosafe.eu/")
                ;
/*
                .clickIt(By.xpath("//*[@id=\"home-index\"]/div[1]/div[1]/div/div/div/div/button"))
                .typeText("aurel.bumsfeld@blinkenlights.nl",By.xpath("//*[@id=\"email\"]"))
                .typeText("Aurél",By.xpath("//*[@id=\"firstname\"]"))
                .typeText("Bumsfeld",By.xpath("//*[@id=\"lastname\"]"))
                .typeText("0036205326666", By.xpath("//*[@id=\"phone\"]"))
                .clickIt(By.xpath("//*[@id=\"fromWhere\"]/div[1]/label"))
                .typeText("****TESzT****",By.xpath("//*[@id=\"notes\"]"))
                .clickIt(By.xpath("//*[@id=\"ContactUsFormForm\"]/fieldset/div[7]/div/div/label"))
                ;//.clickIt(By.xpath("//*[@id=\"ContactUsFormForm\"]/fieldset/div[8]/button"));

 */

            }


    }

    @AfterTest(alwaysRun = true)
    public void teardown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }


}

