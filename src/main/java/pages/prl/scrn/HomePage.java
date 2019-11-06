package pages.prl.scrn;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(tagName = "h2")
    private WebElement textLabel;

    @FindBy(xpath = "//img[contains(@src, 'pets.png')]")
    private WebElement img;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return BASE_URL + "/";
    }

    public String getLabelText() {
        return textLabel.getText();
    }

    public boolean isPetImgDisplayed() {
        return img.isDisplayed();
    }
}

