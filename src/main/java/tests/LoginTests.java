package tests;

import org.testng.annotations.Test;
import pages.web.HomePage;

public class LoginTests extends BaseTest {
    @Test (priority = 0)
    public void invalidLoginTest_InvalidUserNameInvalidPassword () {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToN11()
                .goToLoginPage()
                .loginToN11("mate.mogyorosi@drukka.hu", "Asd123")
                .verifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"))
                .verifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"));
    }

    @Test (priority = 1)
    public void invalidLoginTest_EmptyUserEmptyPassword () {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToN11()
                .goToLoginPage()
                .loginToN11("","")
                .verifyLoginUserName("Lütfen e-posta adresinizi girin.")
                .verifyLoginPassword("Bu alanın doldurulması zorunludur.");
    }
}