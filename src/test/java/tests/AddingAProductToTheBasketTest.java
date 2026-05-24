package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddingAProductToTheBasketTest extends BaseTest {
    @Test (testName = "Добавление товара в корзину",
            description = "Добавление первого товара в корзину",
            groups = "Positive")
    @Description ("Добавление первого товара в корзину")
    @Epic("EPIC01 Добавление товара в корзину")
    @Feature("Basket Page")
    @Story("Positive adding a product to the cart")
    @Severity(SeverityLevel.BLOCKER)
    @Link ("https://github.com/goodrazer/PageObjectSauceDemo/blob/master/README.md")
    @TmsLink("TestCaseLink")
    @Issue("LinkBUG")
    @Flaky
    @Owner("Malevaniy Anton")
    public void addingAProductToTheCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin(validUser, validPassword)
                .clickButtonAddToCart("Sauce Labs Backpack");
        String expectedName = productsPage.getNameProductSauceLabsBackpack();
        String expectedPrice = productsPage.getCostOfTheFirstItem();
        String expectedDescription = productsPage.getDescriptionOfTheFirstItem();
        productsPage.clickButtonBasket()
                .isPageOpened()
                .getNameSauceLabsBackpackOnBasketPage();
        String actualName = basketPage.getNameSauceLabsBackpackOnBasketPage();
        softAssert.assertEquals(actualName, expectedName,
                "Наименование товара в корзине не совпадает с выбранным!");
        String actualPrice = basketPage.getCostOfTheFirstItemOnBasketPage();
        softAssert.assertEquals(actualPrice, expectedPrice,
                "Валюта или стоимость в корзине не совпадает с валютой или стоимостью товара на странице продукты!");
        String actualDescription = basketPage.getDescriptionOfTheFirstItemOnBasketPage();
        softAssert.assertEquals(actualDescription, expectedDescription,
                "Описание товара в корзине не совпадает с описанием товара на странице продукты!");
        softAssert.assertAll();
    }
}