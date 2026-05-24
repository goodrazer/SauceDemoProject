package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurchaseOfGoodsTest extends BaseTest {

    @Test (testName = "Покупка товара",
            description = "Проверка покупки первого товара",
            priority = 2,
            timeOut = 20000,
            groups = "Positive")
    @Description("Проверка заполнения формы 'LOGIN' невалидными значениями")
    @Epic("EPIC04 Покупка товара")
    @Feature("Purchase Of Goods")
    @Story("Check Purchase Of Good")
    @Severity(SeverityLevel.BLOCKER)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("d/1AIseV9Yldw2TUETiLPccJkU5HIWytrCk/view")
    @Flaky
    @Owner("Malevaniy Anton")
    public void purchaseOfGoods() {
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin()
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Backpack")
                .clickButtonBasket()
                .isPageOpened()
                .clickButtonCheckoutOnBasketPage()
                .isPageOpened()
                .inputCheckoutYourInformationPageValidValues()
                .isPageOpened()
                .clickButtonFinish()
                .getTextTitleCheckoutCompletePage();
        String actualTitle = checkoutCompletePage.getTextTitleCheckoutCompletePage();
        String expectedTitle = "Checkout: Complete!";
        Assert.assertEquals(actualTitle,expectedTitle, "Покупка не произведена!");
    }

    @Test (testName = "Проверка данных приобретаемого товара на форме 'Checkout Overview'.",
            description = "Проверка имени, описания и стоимости товара на форме 'Checkout Overview'.",
            priority = 1,
            groups = "Positive")
    @Description("Проверка имени, описания и стоимости товара на форме 'Checkout Overview'.")
    @Epic("EPIC04 Покупка товара")
    @Feature("Purchase Of Goods")
    @Story("Check Purchase Of Good")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Issue("LinkBUG")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkProductNameAndCostAndDescription() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin()
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Backpack")
                .clickButtonBasket()
                .isPageOpened()
                .clickButtonCheckoutOnBasketPage()
                .isPageOpened()
                .inputCheckoutYourInformationPageValidValues()
                .isPageOpened();
        String expectedName = basketPage.getNameSauceLabsBackpackOnBasketPage();
        String expectedPrice = basketPage.getCostOfTheFirstItemOnBasketPage();
        String expectedDescription = basketPage.getDescriptionOfTheFirstItemOnBasketPage();
        String actualName = checkoutOverviewPage.getNameProduct();
        softAssert.assertEquals(actualName, expectedName, "Название товара на форме оформления заказа " +
                "не совпадает с выбранным в корзине!");
        String actualPrice = checkoutOverviewPage.getCostProduct();
        softAssert.assertEquals(actualPrice, expectedPrice,
                "Валюта или стоимость товара на форме оформления заказа не " +
                        "совпадает с валютой или стоимостью товара в корзине!");
        String actualDescription = checkoutOverviewPage.getDescriptionProduct();
        softAssert.assertEquals(actualDescription, expectedDescription,
                "Описание товара на форме оформления заказа не совпадает с описанием товара в корзине!");
        String actualTextElementItemTotal = checkoutOverviewPage.getTextItemTotal();
        String expectedCleanedTotal = actualTextElementItemTotal.replace("Item total: ", "").trim();
        softAssert.assertEquals(expectedCleanedTotal, "$29.99", "Валюта или стоимость не совпадают");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementTax(),
                "Tax: $2.40");
        softAssert.assertEquals(checkoutOverviewPage.getTextElementTotal(),
                "Total: $32.39");
        softAssert.assertAll();
    }
}