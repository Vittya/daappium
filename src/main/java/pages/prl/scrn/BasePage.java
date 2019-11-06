package pages.prl.scrn;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

abstract public class BasePage {

    public static final String BASE_URL = "https://google.com";

    protected AppiumDriver driver;

    protected BasePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    abstract public String getPageUrl();

    public void waitUntil(ExpectedCondition conditionToBe) {
        WebDriverWait wait = new WebDriverWait(driver, 10L);
        wait.until(conditionToBe);
    }

    public void waitForUrlToBeLoaded() {
        waitUntil(ExpectedConditions.urlToBe(getPageUrl()));
    }
}


