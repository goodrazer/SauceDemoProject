package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutCompletePage extends BasePage{

    private final By TITLE_CHECKOUT_COMPLETE = By.xpath("//span[@data-test='title']");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Проверка отображения страницы 'Checkout: Overview Page'")
    @Override
    public CheckoutCompletePage  isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CHECKOUT_COMPLETE));
        return this;
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL + "/checkout-complete.html");
        return null;
    }

    @Step("Переход к странице с успешным результатом статуса покупки товара")
    public String getTextTitleCheckoutCompletePage() {
        return driver.findElement(TITLE_CHECKOUT_COMPLETE).getText();
    }
}