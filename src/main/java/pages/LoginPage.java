package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By USERNAME_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    @Step("Открытие стартовой страницы 'Login'")
    public LoginPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Проверка отображения страницы 'Login'")
    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    @Step("Авторизация покупателя с вводом валидных парметров: " +
            "{user} и {password} на странице 'Login'")
    public ProductsPage positiveLogin(String validUser, String validPassword) {
        driver.findElement(USERNAME_FIELD).sendKeys(validUser);
        driver.findElement(PASSWORD_FIELD).sendKeys(validPassword);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Авторизация покупателя на форме 'Login' c заполнением невалидных параметров: " +
            "{user} и {password} на странице 'Login'")
    public LoginPage negativeLogin(String user, String password) {
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    @Step("Получение текста ошибки при вводе невалидных данных покупателя на странице 'Login'")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}