package pages.prl.scrn.webdroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenWebAndroidBuilder {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    public GenWebAndroidBuilder(AndroidDriver<MobileElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
    }

    public void goTo(String url){
        driver.get(url);
    }

    public void waitFor(By e){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(e));
    }

    public void clickEvent(By e){
        waitFor(e);
        driver.findElement(e).click();
    }

    void sendKeys(String k,By e){
        waitFor(e);
        driver.findElement(e).sendKeys(k);
    }

    void press(AndroidKey k){
        driver.pressKey(new KeyEvent(k));
    }

    public void hideKey(){
        driver.hideKeyboard();
    }
}
