package pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen {
    private AndroidDriver driver;

    @AndroidFindBy(id = "hu.drukka.servee:id/btnSignUp")
    private MobileElement header;

    @AndroidFindBy(accessibility = "Text")
    private MobileElement textButton;

    public HomeScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyHeader(){
        System.out.println("HOME_SCREEN_PAGE: Verifying Header appears.");
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(header));
    }

    public void selectTextButton(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.id("hu.drukka.servee:id/btnSignUp")).click();

        System.out.println("HOME_SCREEN_PAGE: Selecting [TEXT] button.\n");
        this.textButton.click();
    }

    public void goTo(String pack,String activity){
        driver.startActivity(new Activity(pack,activity));
        System.out.println("start activity: "+activity);
    }
}
