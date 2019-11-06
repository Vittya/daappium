package pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.AndroidUtils;

import java.util.concurrent.TimeUnit;

public class LoginScreen {

    private AndroidDriver driver;

    @AndroidFindBy(id = "hu.drukka.servee:id/tvTitle")
    private MobileElement header;

    @AndroidFindBy(id = "hu.drukka.servee:id/btnSignUp")
    private MobileElement addButton;

    @AndroidFindBy(id = "hu.drukka.servee:id/btnSignUp")
    private MobileElement panel;

    @AndroidFindBy(id = "hu.drukka.servee:id/tilEmail")
    private MobileElement element;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SIGN UP']")
    AndroidElement kurvaGomb;

    public LoginScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyHeader(){
        System.out.println("LOG_TEXT_BOX_PAGE: Verifying Header appears.");
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(header));
    }

    public void selectAddButton(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
       // driver.findElement(By.id("hu.drukka.servee:id/btnSignUp")).click();
        kurvaGomb.click();
        driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
        //this.addButton.click();
        System.out.println("LOG_TEXT_BOX_PAGE: Selecting [ADD] button.\n");

    }

    public void loginToIt(){
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        //Click and pass Splash
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("hu.drukka.servee:id/btnSignUp"))).click();

        //Click I am searching a job
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("hu.drukka.servee:id/btnLogin"))).click();


        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //element = (MobileElement)driver.findElement(By.id("hu.drukka.servee:id/tilEmail"));
        element.clear();
        element.click();

        AndroidUtils.commandEvaluator(driver,"mate.mogyorosi@drukka.hu");

        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        AndroidUtils.commandEvaluator(driver,"|asd123");
        //driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.hideKeyboard();

    }

    public String getPanelText(){
        return this.panel.getText();
    }
}
