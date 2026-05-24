package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class FillingOutTheCheckoutFormTest extends BaseTest {
    @Test (testName = "Проверка заполнения формы 'Checkout Your Information' валидными значениями",
            description = "Проверка заполнения формы 'Checkout Your Information' валидными значениями ФИО и почтового индекса",
            priority = 1,
            groups = "Positive")
    @Description("Проверка заполнения формы 'Checkout Your Information' валидными значениями")
    @Epic("EPIC02 Проверка заполнения формы 'Checkout Your Information'")
    @Feature("Checkout Your Information Page")
    @Story("Check Filling Out The Checkout Form ValidValue")
    @Severity(SeverityLevel.BLOCKER)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkFillingOutTheCheckoutFormValidValue() {
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin(validUser, validPassword)
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Backpack")
                .clickButtonBasket()
                .isPageOpened()
                .clickButtonCheckoutOnBasketPage()
                .isPageOpened()
                .inputCheckoutYourInformationPageValidValues();
        Assert.assertEquals(checkoutOverviewPage.getTitleCheckoutOverview(),"Checkout: Overview");
    }

    @Test (testName = "Проверка заполнения формы 'Checkout Your Information' невалидным именем",
            description = "Проверка заполнения формы 'Checkout Your Information' невалидным именем",
            priority = 3,
            groups = "Negative",
            enabled = false)
    @Description("Проверка заполнения формы 'Checkout Your Information' невалидным именем")
    @Epic("EPIC02 Проверка заполнения формы 'Checkout Your Information'")
    @Feature("Checkout Your Information Page")
    @Story("Check Filling Out The Checkout Form Invalid First Name")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Issue("LinkBUG")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkFillingOutTheCheckoutFormInvalidFirstName() {
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin(validUser, validPassword)
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Backpack")
                .clickButtonBasket()
                .isPageOpened()
                .clickButtonCheckoutOnBasketPage()
                .isPageOpened()
                .inputCheckoutYourInformationPageInvalidValues("","Malevaniy","87486734");
        Assert.assertEquals(checkoutYourInformationPage.getTextErrorMessage(),"Error: First Name is required");
    }

    @Test (testName = "Проверка заполнения формы 'Checkout Your Information' невалидной фамилией",
            description = "Проверка заполнения формы 'Checkout Your Information' невалидной фамилией",
            priority = 4,
            groups = "Negative",
            enabled = false)
    @Description("Проверка заполнения формы 'Checkout Your Information' невалидной фамилией")
    @Epic("EPIC02 Проверка заполнения формы 'Checkout Your Information'")
    @Feature("Checkout Your Information Page")
    @Story("Check Filling Out The Checkout Form Invalid Last Name")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Issue("LinkBUG")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkFillingOutTheCheckoutFormInvalidLastName() {
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin(validUser, validPassword)
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Backpack")
                .clickButtonBasket()
                .isPageOpened()
                .clickButtonCheckoutOnBasketPage()
                .isPageOpened()
                .inputCheckoutYourInformationPageInvalidValues("Anton","","87486734");
        Assert.assertEquals(checkoutYourInformationPage.getTextErrorMessage(),"Error: Last Name is required");
    }

    @Test (testName = "Проверка заполнения формы 'Checkout Your Information' невалидным почтовым индексом",
            description = "Проверка заполнения формы 'Checkout Your Information' невалидным почтовым индексом",
            priority = 5,
            groups = "Negative",
            enabled = false)
    @Description("Проверка заполнения формы 'Checkout Your Information' невалидным почтовым индексом")
    @Epic("EPIC02 Проверка заполнения формы 'Checkout Your Information'")
    @Feature("Checkout Your Information Page")
    @Story("Check Filling Out The Checkout Form Invalid Postal Code")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Issue("LinkBUG")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkFillingOutTheCheckoutFormInvalidPostalCode() {
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin(validUser, validPassword)
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Backpack")
                .clickButtonBasket()
                .isPageOpened()
                .clickButtonCheckoutOnBasketPage()
                .isPageOpened()
                .inputCheckoutYourInformationPageInvalidValues("Anton","Malevaniy","");
        Assert.assertEquals(checkoutYourInformationPage.getTextErrorMessage(),"Error: Postal Code is required");
    }

    @DataProvider(name = "Тестовые даннны для негативных проверок заполнения полей при оформлении заказа клиентом")
    public Object[][] loginData (){
        return new Object[][] {
                {"","Malevaniy","87486734","Error: First Name is required"},
                {"Anton","","87486734","Error: Last Name is required"},
                {"Anton","Malevaniy","","Error: Postal Code is required"},
        };
    }

    @Test (testName = "Проверка заполнения формы 'Checkout' невалидными значениями",
            description = "Проверка заполнения формы 'Checkout' невалидными значениями",
            dataProvider = "Тестовые даннны для негативных проверок заполнения полей при оформлении заказа клиентом",
            priority = 2,
            groups = "Negative")
    @Description("Проверка заполнения формы 'Checkout' невалидными значениями")
    @Epic("EPIC02 Проверка заполнения формы 'Checkout Your Information'")
    @Feature("Checkout Your Information Page")
    @Story("Check Input Negative Login")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Flaky
    @Owner("Malevaniy Anton")
    public void inputNegativeLogin (String firstName, String lastName, String postalCode,String errorMessage) {
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin(validUser, validPassword)
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Backpack")
                .clickButtonBasket()
                .isPageOpened()
                .clickButtonCheckoutOnBasketPage()
                .isPageOpened()
                .inputCheckoutYourInformationPageInvalidValues(firstName, lastName, postalCode);
        assertEquals(checkoutYourInformationPage.getTextErrorMessage(), errorMessage);
    }
}