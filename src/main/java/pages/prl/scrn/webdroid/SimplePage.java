package pages.prl.scrn.webdroid;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class SimplePage extends GenWebAndroidBuilder {
    public SimplePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public SimplePage toPage(){return this;}

    public SimplePage clickIt(By e){
        clickEvent(e);
        return this;
    }

    public SimplePage goToUrl(String url){
        goTo(url);
        return this;
    }

    public SimplePage typeText(String k, By e){
        sendKeys(k,e);
        return this;
    }

    public SimplePage justWait(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return this;
    }

    public SimplePage pressButton(AndroidKey k){
        press(k);
        return this;
    }

    public SimplePage hide(){
        hideKey();
        return this;
    }
}
