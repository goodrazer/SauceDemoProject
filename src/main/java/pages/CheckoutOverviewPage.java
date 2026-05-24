package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutOverviewPage extends BasePage {

    private final By TITLE_CHECKOUT_OVERVIEW = By.xpath("//span[@data-test='title']");
    private final By ELEMENT_QTY = By.xpath("//div[@data-test='cart-quantity-label']");
    private final By ELEMENT_DESCRIPTION = By.xpath("//div[@data-test='cart-desc-label']");
    private final By BLOCK_WITH_PURCHASED_GOODS = By.xpath("//div[@data-test='inventory-item']");
    private final By ELEMENT_PAYMENT_INFORMATION = By.xpath("//div[@data-test='payment-info-label']");
    private final By ELEMENT_SAUCE_CARD = By.xpath("//div[@data-test='payment-info-value']");
    private final By ELEMENT_SHIPPING_INFORMATION = By.xpath("//div[@data-test='shipping-info-label']");
    private final By ELEMENT_DELIVERY_OPTION = By.xpath("//div[@data-test='shipping-info-value']");
    private final By ELEMENT_PRICE_TOTAL = By.xpath("//div[@data-test='total-info-label']");
    private final By ELEMENT_ITEM_TOTAL = By.xpath("//div[@data-test='subtotal-label']");
    private final By ELEMENT_TAX = By.xpath("//div[@data-test='tax-label']");
    private final By ELEMENT_TOTAL = By.xpath("//div[@class='summary_total_label']");
    private final By BUTTON_CANCEL = By.id("cancel");
    private final By BUTTON_FINISH = By.id("finish");
    private final By NAME_PRODUCT1 = By.xpath("//div[@data-test='inventory-item-name']");
    private final By DESCRIPTION_PRODUCT1 = By.xpath("//div[@data-test='inventory-item-desc']");
    private final By COST_PRODUCT1 = By.xpath("//div[@data-test='inventory-item-price']");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL + "/checkout-step-two.html");
        return this;
    }

    @Step("Проверка отображения страницы 'Checkout: Overview'")
    @Override
    public CheckoutOverviewPage  isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CHECKOUT_OVERVIEW));
        return this;
    }

    @Step("Получение заголовка страницы: 'Checkout: Overview'")
    public String getTitleCheckoutOverview() {
        return driver.findElement(TITLE_CHECKOUT_OVERVIEW).getText();
    }

    @Step("Получение наименования приобретаемого продукта на странице 'Checkout: Overview'")
    public String getNameProduct() {
        return driver.findElement(NAME_PRODUCT1).getText();
    }

    @Step("Проверка описания приобретаемого продукта на странице 'Checkout: Overview'")
    public String getDescriptionProduct() {
        return driver.findElement(DESCRIPTION_PRODUCT1).getText();
    }

    @Step("Проверка стоимости приобретаемого продукта на странице 'Checkout: Overview'")
    public String getCostProduct() {
        return driver.findElement(COST_PRODUCT1).getText();
    }

    @Step("Получение информации об оплате на странице 'Checkout: Overview'")
    public String getTextElementPaymentInformation() {
        return driver.findElement(ELEMENT_PAYMENT_INFORMATION).getText();
    }

    @Step("Получение номера заказа на странице 'Checkout: Overview'")
    public String getTextElementSauceCard() {
        return driver.findElement(ELEMENT_SAUCE_CARD).getText();
    }

    @Step("Получение элемента 'QTY' на странице 'Checkout: Overview'")
    public String getTextElementQyt() {
        return driver.findElement(ELEMENT_QTY).getText();
    }

    @Step("Получение элемента 'Description' на странице 'Checkout: Overview'")
    public String getTextElementDescription() {
        return driver.findElement(ELEMENT_DESCRIPTION).getText();
    }

    @Step("Проверка отображения блока с приобретенными товарами на странице 'Checkout: Overview'")
    public boolean checkIsDisplayedBlockWithPurchasedGoods() {
        driver.findElement(BLOCK_WITH_PURCHASED_GOODS).isDisplayed();
        return false;
    }

    @Step("Получение элемента 'SHIPPING INFORMATION' на странице оформления заказа на странице 'Checkout: Overview'")
    public String getTextElementShippingInformation() {
        return driver.findElement(ELEMENT_SHIPPING_INFORMATION).getText();
    }

    @Step("Получение элемента 'DELIVERY OPTION' на странице 'Checkout: Overview'")
    public String getTextElementDeliveryOption() {
        return driver.findElement(ELEMENT_DELIVERY_OPTION).getText();
    }

    @Step("Получение элемента 'PRICE TOTAL' на странице 'Checkout: Overview'")
    public String getTextElementPriceTotal() {
        return driver.findElement(ELEMENT_PRICE_TOTAL).getText();
    }

    @Step("Проверка отображения элемента 'Item Total' на странице 'Checkout: Overview'")
    public boolean checkIsDisplayedElementItemTotal() {
        driver.findElement(ELEMENT_ITEM_TOTAL).isDisplayed();
        return false;
    }

    @Step("Получение текста элемента 'Item Total'на странице 'Checkout: Overview'")
    public String getTextItemTotal() {
        return driver.findElement(ELEMENT_ITEM_TOTAL).getText();
    }

    @Step("Проверка отображения элемента 'Tax' на странице 'Checkout: Overview'")
    public boolean checkIsDisplayedElementTax() {
        driver.findElement(ELEMENT_TAX).isDisplayed();
        return false;
    }

    @Step("Получение валюты и стоимости надбавки магазина на странице 'Checkout: Overview'")
    public String getTextElementTax() {
        return driver.findElement(ELEMENT_TAX).getText();
    }

    @Step("Проверка отображения элемента 'Total' на странице 'Checkout: Overview'")
    public boolean checkIsDisplayedElementTotal() {
        driver.findElement(ELEMENT_TOTAL).isDisplayed();
        return false;
    }

    @Step("Проверка валюты и общей стоимости приобратаемых товаров на странице 'Checkout: Overview'")
    public String getTextElementTotal() {
        return driver.findElement(ELEMENT_TOTAL).getText();
    }

    @Step("Проверка отображения кнопки 'Cancel' на странице 'Checkout: Overview'")
    public boolean checkIsDisplayedButtonCancel() {
        driver.findElement(ELEMENT_TOTAL).isDisplayed();
        return false;
    }

    @Step("Проверка отображения кнопки 'Finish' на странице 'Checkout: Overview Page'")
    public boolean checkIsDisplayedButtonFinish() {
        driver.findElement(ELEMENT_TOTAL).isDisplayed();
        return false;
    }

    @Step("Клик по кнопке 'Cancel' на странице 'Checkout: Overview'")
    public ProductsPage clickButtonCancel() {
        driver.findElement(BUTTON_CANCEL).click();
        return new ProductsPage(driver);
    }

    @Step("Клик по кнопке 'Finish' на странице 'Checkout: Overview'")
    public CheckoutCompletePage clickButtonFinish() {
        driver.findElement(BUTTON_FINISH).click();
        return new CheckoutCompletePage(driver);
    }
}