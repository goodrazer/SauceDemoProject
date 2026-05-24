package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransitionToPageCheckoutYourInformationTest extends BaseTest {

    @Test (testName = "Переход к форме 'Checkout: Your Information'.",
            description = "Проверка перехода к форме 'Checkout: Your Information'.",
            groups = "Positive")
    @Description("Проверка перехода к форме 'Checkout: Your Information'.")
    @Epic("EPIC07 Checkout: Your Information.")
    @Feature("Checkout: Your Information Page")
    @Story("Checking The Transition To The Checkout Form")
    @Severity(SeverityLevel.BLOCKER)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Issue("LinkBUG")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkingTheTransitionToTheCheckoutForm () {
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin()
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Backpack")
                .clickButtonBasket()
                .isPageOpened()
                .clickButtonCheckoutOnBasketPage()
                .isPageOpened();
        Assert.assertEquals(checkoutYourInformationPage.getTitleCheckoutYourInformation(),"Checkout: Your Information");
    }
}