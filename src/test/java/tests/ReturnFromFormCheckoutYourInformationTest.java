package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturnFromFormCheckoutYourInformationTest extends BaseTest {

    @Test (testName = "Переход к форме 'Checkout Your Information'.",
            description = "Проверка перехода к форме 'Checkout Your Information'.",
            groups = "Positive")
    @Description("Переход к форме 'Checkout Your Information'.")
    @Epic("EPIC05 Удаление товара")
    @Feature("Checkout Your Information Page")
    @Story("Checking Return From Form Checkout Your Information")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Issue("LinkBUG")
    @Flaky
    @Owner("Malevaniy Anton")
    public void CheckingReturnFromFormCheckoutYourInformation() {
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin()
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Backpack")
                .clickButtonBasket()
                .isPageOpened()
                .clickButtonCheckoutOnBasketPage()
                .isPageOpened()
                .clickButtonCancelOnCheckoutYourInformationPage();
        Assert.assertEquals(basketPage.getTextTitleBasket(),"Your Cart");
    }
}