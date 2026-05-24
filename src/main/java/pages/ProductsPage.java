package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By TITLE = By.xpath("//*[@data-test='title']");
    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    private final By NAME_PRODUCT_SAUCE_LABS_BACKPACK = By.xpath("//*[@data-test='inventory-item-name']");
    private final By BUTTON_BASKET = By.xpath("//a[@data-test='shopping-cart-link']");
    private final By COST_OF_THE_FIRST_ITEM = By.xpath("//div[@data-test='inventory-item-price']");
    private final By DESCRIPTION_OF_THE_FIRST_ITEM = By.xpath("//div[@data-test='inventory-item-desc']");

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL + "/inventory.html");
        return this;
    }

    @Step("Проверка открытия страницы 'Products'")
    @Override
    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Step("Получение наименования заголовка страницы 'Products'")
    public String getTitleProducts(){
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление товара с параметром {Product} в корзину по кнопке 'ADD TO CART'")
    public ProductsPage clickButtonAddToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Получение наименования товара")
    public String getNameProductSauceLabsBackpack() {
        return driver.findElement(NAME_PRODUCT_SAUCE_LABS_BACKPACK).getText();
    }

    @Step("Получение стоимости первого товара на странице 'Products'")
    public String getCostOfTheFirstItem() {
        return driver.findElement(COST_OF_THE_FIRST_ITEM).getText();
    }

    @Step("Получение описания первого товара на странице 'Products'")
    public String getDescriptionOfTheFirstItem() {
        return driver.findElement(DESCRIPTION_OF_THE_FIRST_ITEM).getText();
    }

    @Step("Клик по кнопке корзины")
    public BasketPage clickButtonBasket() {
        driver.findElement(BUTTON_BASKET).click();
        return new BasketPage(driver);
    }
}