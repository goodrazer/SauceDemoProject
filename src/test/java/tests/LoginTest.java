package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    @Test (testName = "Проверка заполнения формы 'LOGIN' валидными значениями",
            description = "Проверка заполнения формы 'LOGIN' валидными значениями логина и пароля",
            priority = 1,
            groups = "Positive")
    @Description("Проверка заполнения формы 'LOGIN' валидными значениями логина и пароля")
    @Epic("EPIC03 Проверка заполнения формы 'LOGIN'")
    @Feature("Checkout Login Page")
    @Story("Check Login Positive Cred")
    @Severity(SeverityLevel.BLOCKER)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkLoginWithPositiveCred() {
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin(validUser,validPassword);
        Assert.assertEquals(productsPage.getTitleProducts(),"Products");
    }

    @Test (testName = "Проверка заполнения формы 'LOGIN' невалидным значением пароля",
            description = "Проверка заполнения формы 'LOGIN' валидным значением логина и невалидным значением пароля",
            priority = 4,
            groups = "Negative",
            enabled = false)
    @Description("Проверка заполнения формы 'LOGIN' невалидным значением пароля")
    @Epic("EPIC03 Проверка заполнения формы 'LOGIN'")
    @Feature("Checkout Login Page")
    @Story("Check Login Negative Cred")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("d/1AIseV9Yldw2TUETiLPccJkU5HIWytrCk/view")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkLoginWitchEmptyPassword () {
        loginPage.openPage()
                .isPageOpened()
                .negativeLogin("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required");
    }

    @Test (testName = "Проверка заполнения формы 'LOGIN' невалидным значением логина",
            description = "Проверка заполнения формы 'LOGIN' невалидным значением логина и валидным значением пароля",
            priority = 3,
            groups = "Negative")
    @Description("Проверка заполнения формы 'LOGIN' невалидным значением логина")
    @Epic("EPIC03 Проверка заполнения формы 'LOGIN'")
    @Feature("Checkout Login Page")
    @Story("Check Login Negative Cred")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("d/1AIseV9Yldw2TUETiLPccJkU5HIWytrCk/view")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkLoginWitchEmptyUser () {
        loginPage.openPage()
                .isPageOpened()
                .negativeLogin("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
    }

    @Test (testName = "Проверка заполнения формы 'LOGIN' невалидными значениями",
            description = "Проверка заполнения формы 'LOGIN' невалидным значением логина и невалидным значением пароля",
            priority = 5,
            groups = "Negative",
            enabled = false)
    @Description("Проверка заполнения формы 'LOGIN' невалидным значением логина и невалидным значением пароля")
    @Epic("EPIC03 Проверка заполнения формы 'LOGIN'")
    @Feature("Checkout Login Page")
    @Story("Check Login Negative Cred")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("d/1AIseV9Yldw2TUETiLPccJkU5HIWytrCk/view")
    @Issue("LinkBUG")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkLoginWitchNegativeCred () {
        loginPage.openPage()
                .isPageOpened()
                .negativeLogin("Invalid_Login", "Invalid_password");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
    }

    @DataProvider (name = "Тестовые даннны для негативных проверок заполнения полей при логине клиента", indices = {0,2})
    public Object[][] loginData (){
        return new Object[][] {
                {"standard_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"Invalid_Login","Invalid_password","Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test (testName = "Проверка заполнения формы 'LOGIN' невалидными значениями",
            description = "Проверка заполнения формы 'LOGIN' невалидными значениями",
            dataProvider = "Тестовые даннны для негативных проверок заполнения полей при логине клиента",
            priority = 2,
            groups = "Negative")
    @Description("Проверка заполнения формы 'LOGIN' невалидными значениями")
    @Epic("EPIC03 Проверка заполнения формы 'LOGIN'")
    @Feature("Checkout Login Page")
    @Story("Check Login Negative Cred")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("d/1AIseV9Yldw2TUETiLPccJkU5HIWytrCk/view")
    @Issue("LinkBUG")
    @Flaky
    @Owner("Malevaniy Anton")
    public void inputNegativeLogin (String user, String password, String errorMessage) {
        loginPage.openPage()
                .isPageOpened()
                .negativeLogin(user, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }
}