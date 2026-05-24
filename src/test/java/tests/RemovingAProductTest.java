package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemovingAProductTest extends BaseTest {

    @Test (testName = "Удаление товара из корзины.",
            description = "Удаление первого добавленного товара из корзины.",
            groups = "Positive")
    @Description("Удаление товара из корзины.")
    @Epic("EPIC05 Удаление товара")
    @Feature("Removing a product")
    @Story("Check Removing a product")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Issue("LinkBUG")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkingIfAnItemHasBeenRemovedFromTheCart () {
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin()
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Backpack")
                .clickButtonBasket()
                .isPageOpened()
                .clickButtonRemoveOnBasketPage();
        Assert.assertTrue(basketPage.checkRemovedItemOnBasketPage(),"Товар не удален из корзины!");
    }
}