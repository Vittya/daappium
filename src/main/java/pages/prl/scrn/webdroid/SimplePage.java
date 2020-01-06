package pages.prl.scrn.webdroid;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import util.Filter;

import java.util.concurrent.TimeUnit;


public class SimplePage extends GenWebAndroidBuilder {
    public SimplePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public SimplePage toPage(){return this;}

    public SimplePage clickIt( String eString){

        clickEvent(By.xpath(eString));
        System.out.println("clicked "+eString);
        return this;
    }

    public SimplePage goToUrl(String url){
        goTo(url);
        System.out.println("accessed "+url);
        return this;
    }

    public SimplePage typeText(String k){
        String[] strings = Filter.preProcessor(k);
        sendKeys(strings[0],By.xpath(strings[1]));
        return this;
    }

    public SimplePage typeText(String k,String v){

        sendKeys(k,By.xpath(v));
        return this;
    }

    public SimplePage justWait(String time){
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(time), TimeUnit.SECONDS);
        System.out.println("wait "+time);
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

    public SimplePage swipe_scroll(int sy,int sx,int ey, int ex,int d){
        swipe(sy,sx,ey,ex,d);
        return this;
    }

    public SimplePage swipe_scroll(int duration){
        swipe(0,500,1000,500,duration);
        return this;
    }
}
