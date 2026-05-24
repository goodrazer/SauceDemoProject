package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasketPage extends BasePage{

    private final By PRODUCT_SAUCE_LABS_BACKPACK = By.xpath("//*[@data-test='inventory-item-name']");
    private final By BUTTON_REMOVE = By.id("remove-sauce-labs-backpack");
    private final By EMPTY_BASKET_ITEM = By.xpath("//*[@class='removed_cart_item']");
    private final By BUTTON_CONTINUE_SHOPPING = By.id("continue-shopping");
    private final By BUTTON_CHECKOUT = By.id("checkout");
    private final By TITLE_BASKET = By.xpath("//*[@data-test='title']");
    private final By COST_OF_THE_FIRST_ITEM = By.xpath("//div[@data-test='inventory-item-price']");
    private final By DESCRIPTION_OF_THE_FIRST_ITEM = By.xpath("//div[@data-test='inventory-item-desc']");

    public BasketPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL + "/cart.html");
        return this;
    }

    @Step("Ожидание загрузки страницы 'Basket'")
    @Override
    public BasketPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_CHECKOUT));
        return this;
    }

    @Step("Получение текста заголовка страницы 'Basket' ")
    public String getTextTitleBasket() {
        return driver.findElement(TITLE_BASKET).getText();

    }

    @Step("Получение наименования товара, добавленного в корзину")
    public String getNameSauceLabsBackpackOnBasketPage() {
        return driver.findElement(PRODUCT_SAUCE_LABS_BACKPACK).getText();
    }

    @Step("Клик по кнопке 'Remove' на странице 'Basket'")
    public BasketPage clickButtonRemoveOnBasketPage () {
        driver.findElement(BUTTON_REMOVE).click();
        return this;
    }

    @Step("Проверка удаления товара из корзины")
    public boolean checkRemovedItemOnBasketPage () {
        return driver.findElements(EMPTY_BASKET_ITEM).size() > 0;
    }
    @Step("Клик по кнопке 'Continue shopping' на странице 'Basket'")
    public ProductsPage clickButtonContinueShoppingOnBasketPage () {
        driver.findElement(BUTTON_CONTINUE_SHOPPING).click();
        return new ProductsPage(driver);
    }

    @Step("Клик по кнопке 'CHECKOUT' на странице 'Basket'")
    public CheckoutYourInformationPage clickButtonCheckoutOnBasketPage () {
        driver.findElement(BUTTON_CHECKOUT).click();
        return new CheckoutYourInformationPage(driver);
    }

    @Step("Получение стоимости товара, добавленного в корзину")
    public String getCostOfTheFirstItemOnBasketPage() {
        return driver.findElement(COST_OF_THE_FIRST_ITEM).getText();
    }

    @Step("Получение описания товара, добавленного в корзину")
    public String getDescriptionOfTheFirstItemOnBasketPage() {
        return driver.findElement(DESCRIPTION_OF_THE_FIRST_ITEM).getText();
    }
}