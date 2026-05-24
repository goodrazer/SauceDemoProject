package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransitionToProductsPageFromCheckoutOverviewTest extends BaseTest {

    @Test (testName = "Переход к форме 'Products' из 'CheckoutOverview'.",
            description = "Проверка перехода к форме 'Products' с формы 'CheckoutOverview' по кнопке 'Cancel'.",
            groups = "Positive")
    @Description("Проверка перехода к форме 'Products' с формы 'CheckoutOverview' по кнопке 'Cancel'.")
    @Epic("EPIC08 Возврат к форме продуктов")
    @Feature("Checkout Overview Page")
    @Story("Execution Transition To Products Page From Checkout Overview")
    @Severity(SeverityLevel.NORMAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Issue("LinkBUG")
    @Owner("Malevaniy Anton")
    public void executionTransitionToProductsPageFromCheckoutOverview() {
        loginPage.openPage()
                .positiveLogin()
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Backpack")
                .clickButtonBasket()
                .isPageOpened()
                .clickButtonCheckoutOnBasketPage()
                .isPageOpened()
                .inputCheckoutYourInformationPageValidValues()
                .clickButtonCancel()
                .isPageOpened();
        Assert.assertEquals(productsPage.getTitleProducts(),"Products");
    }
}