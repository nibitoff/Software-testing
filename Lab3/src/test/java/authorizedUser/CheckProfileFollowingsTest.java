package authorizedUser;// Generated by Selenium IDE

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckProfileFollowingsTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    public WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return foo;
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkProfileFollowingsTest() {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.xing.com/");

        try {
            driver.findElement(By.xpath("//*[@id=\"consent-accept-button\"]")).click();
        } catch (org.openqa.selenium.NoSuchElementException ignored) {
        }

        fluentWait(By.linkText("Log in")).click();
        driver.findElement(By.id("username")).sendKeys("niktovicd@gmail.com");
        driver.findElement(By.id("password")).sendKeys("tBy%mvW8s#*CDrhb");
        driver.findElement(By.cssSelector(".erMSDu")).click();

        driver.get("https://www.xing.com/chats");
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/nav/ul/li[1]/a")));
        }


        driver.get("https://www.xing.com/discover/updates");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/nav/ul/li[3]/a")));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/nav/ul/li[3]/a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/section/div/div[3]/section[3]/div/ul/li[1]/a/div/p[1]")));
        driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div[3]/section[3]/div/ul/li[1]/a/div/p[1]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"news-sources-list\"]/li[1]/a/span[1]")));
        assertThat(driver.findElement(By.xpath("//*[@id=\"news-sources-list\"]/li[1]/a/span[1]")).getText(), is("Handelsblatt"));
    }
}