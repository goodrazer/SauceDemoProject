package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutYourInformationPage extends BasePage{

    private final By TITLE_CHECKOUT_YOUR_INFORMATION = By.xpath("//span[@data-test='title']");
    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By POSTAL_CODE = By.id("postal-code");
    private final By BUTTON_CONTINUE = By.id("continue");
    private final By BUTTON_CANCEL = By.id("cancel");
    private final By ERROR = By.xpath("//h3[@data-test='error']");

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Получение заголовка страницы: 'Checkout: Your Information'")
    public String getTitleCheckoutYourInformation() {
        return driver.findElement(TITLE_CHECKOUT_YOUR_INFORMATION).getText();
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL + "/checkout-step-one.html");
        return this;
    }

    @Step("Проверка загрузки страницы 'Checkout: Your Information'")
    @Override
    public CheckoutYourInformationPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CHECKOUT_YOUR_INFORMATION));
        return this;
    }

    @Step("Заполнение страныцы 'Checkout: Your Information' валидными параметрами покупателя")
    public CheckoutOverviewPage inputCheckoutYourInformationPageValidValues() {
        driver.findElement(FIRST_NAME).sendKeys("Anton");
        driver.findElement(LAST_NAME).sendKeys("Malevaniy");
        driver.findElement(POSTAL_CODE).sendKeys("87486734");
        driver.findElement(BUTTON_CONTINUE).click();
        return new CheckoutOverviewPage(driver);
    }

    @Step("Заполнение страныцы 'Checkout: Your Information' невалидными параметрами покупателя: " +
            "{firstName}, {lastName}, {postalCode}")
    public CheckoutYourInformationPage inputCheckoutYourInformationPageInvalidValues(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
        driver.findElement(BUTTON_CONTINUE).click();
        return this;
    }

    @Step("Клик по кнопке 'Cancel' на странице 'Checkout: Your Information'")
    public BasketPage clickButtonCancelOnCheckoutYourInformationPage() {
        driver.findElement(BUTTON_CANCEL).click();
        return new BasketPage(driver);
    }

    @Step("Получение ошибки при вводе невалидных значений на странице 'Checkout: Your Information'")
    public String getTextErrorMessage() {
        return driver.findElement(ERROR).getText();
    }
}