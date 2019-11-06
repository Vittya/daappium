package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    public HomePage (WebDriver driver) {
        super(driver);
    }

    String baseURL = "http://development.admin.servee.proxy.drukka.hu/guests";

    By signInButtonBy = By.id("search undefined");



    public HomePage goToN11 (){

        return this;
    }

    public LoginPage goToLoginPage (){
        click(signInButtonBy);
        return new LoginPage(driver);
    }

    public HomePage clickIt(By element){
        click(element);
        return this;
    }
}