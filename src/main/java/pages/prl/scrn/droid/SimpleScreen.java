package pages.prl.scrn.droid;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import jdk.nashorn.internal.objects.annotations.Function;
import org.openqa.selenium.By;

import java.util.List;


public class SimpleScreen extends GenAndroidCaseBuilder   {

    public SimpleScreen(AndroidDriver<MobileElement> driver){
        super(driver);
    }

    public SimpleScreen toScreen(){
        return this;
    }

    public SimpleScreen clickIt(By element){
        clickEvent(element);
        return this;
    }

    public SimpleScreen clickIt(MobileElement element){
        clickEvent(element);
        return this;
    }

    public SimpleScreen typeText(By element, String text){
        sendText(element,text);
        return this;
    }

    public SimpleScreen typeText(MobileElement element,String text){
        sendText(element,text);
        return this;
    }


    public SimpleScreen repeatClick(int times,List<MobileElement> list){
        for(int i=0;i<times;i++)
        for(MobileElement e:list) clickIt(e);
        return this;
    }

    public SimpleScreen repeatClick(int times,By e){
        for(int i=0;i<times;i++)
             clickIt(e);
        return this;
    }
}
