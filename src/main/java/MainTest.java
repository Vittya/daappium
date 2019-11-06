import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestNGUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.android.BaseScreen;
import pages.android.HomeScreen;
import pages.android.LoginScreen;
import util.AndroidUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class MainTest {

    private static AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    private MobileElement element;

    private HomeScreen homeScreen;
    private LoginScreen loginScreen;
    private BaseScreen baseScreen; //inner api

    //Elements
    String secondNewJob = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
            "android.widget.RelativeLayout/android.widget.ImageView";

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Samsung Galaxy S8");
        caps.setCapability("udid", "ce10171ac14acf2004"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "hu.drukka.servee");
        caps.setCapability("appActivity","hu.drukka.servee.ui.MainActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);

        homeScreen = new HomeScreen(driver);
        loginScreen = new LoginScreen(driver);
        baseScreen = new BaseScreen(driver);
        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public void basicTest () throws InterruptedException {
        loginScreen.loginToIt();
        extendLogin();
        driver.manage().timeouts().implicitlyWait(110, TimeUnit.SECONDS);
        loginScreen.selectAddButton();
        homeScreen.goTo("hu.drukka.servee","hu.drukka.servee.ui.CheckInActivity");
        //homeScreen.selectTextButton();

    }

    //@Test
    public void loginTest() throws InterruptedException{

      driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

      //homeScreen.verifyHeader();
      //homeScreen.selectTextButton();

      //baseScreen.verifyHeader();
      //baseScreen.selectLogTextBoxButton();

      loginScreen.verifyHeader();
      loginScreen.selectAddButton();

      String expectPanelText = "yoyoyo";
      String actulaPanelText = loginScreen.getPanelText();

      System.out.println("check panel text");
      AndroidUtils.outputIfMatchPassOrFail(expectPanelText,actulaPanelText);
      Assert.assertEquals(actulaPanelText,expectPanelText);
    }

    @AfterSuite
    public void teardown(){
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        System.out.println("Meghajtó Törölve");
        driver.quit();
    }

    public void extendLogin() throws InterruptedException{
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        //homeScreen.verifyHeader();
        //homeScreen.selectTextButton();

        //baseScreen.verifyHeader();
        //baseScreen.selectLogTextBoxButton();

        loginScreen.verifyHeader();

        //loginScreen.selectAddButton();
        String expectPanelText = "SIGN UP";
        String actulaPanelText = loginScreen.getPanelText();

        System.out.println("check panel text");
        AndroidUtils.outputIfMatchPassOrFail(expectPanelText,actulaPanelText);
        Assert.assertEquals(actulaPanelText,expectPanelText);



    }
}
