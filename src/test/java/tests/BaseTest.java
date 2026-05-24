package tests;

import Utils.DriverManager;
import Utils.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

@Listeners ({AllureTestNg.class, TestListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected BasketPage basketPage;
    protected CheckoutYourInformationPage checkoutYourInformationPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected String validUser = System.getProperty("user");
    protected String validPassword = System.getProperty("password");


    @Parameters ({"browser"})
    @BeforeMethod (alwaysRun = true, description = "Настройка браузера")
    @Description ("Настройка браузера")
    public void setUp (@Optional("chrome") String browser, ITestContext iTestContext) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            DriverManager.setDriver(driver);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
            DriverManager.setDriver(driver);
            driver.manage().window().maximize();
        }
        iTestContext.setAttribute("driver",driver);

        loginPage = new LoginPage(DriverManager.getDriver());
        productsPage = new ProductsPage(DriverManager.getDriver());
        basketPage = new BasketPage(DriverManager.getDriver());
        checkoutYourInformationPage = new CheckoutYourInformationPage(DriverManager.getDriver());
        checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver());
        checkoutCompletePage = new CheckoutCompletePage(DriverManager.getDriver());
    }

    @AfterMethod (alwaysRun = true, description = "Закрытие браузера")
    @Description ("Закрытие браузера")
    public void tearDawn () {
        DriverManager.quitDriver();
    }
}