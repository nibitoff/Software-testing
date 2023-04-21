package authorizedUser;

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

// niktovicd@gmail.com
// tBy%mvW8s#*CDrhb

public class CreatePostTestTest {
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

    ;

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
    public void createPostTest() throws InterruptedException {
        String postText = "Ut tempus nisl non dolor tristique, sit amet bibendum lorem tincidunt. Integer et iaculis felis. Aliquam vehicula, mauris vitae ultricies vestibulum, urna dolor vehicula purus, a volutpat augue lectus nec nisl.";

        var wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.xing.com/");

        try {
            driver.findElement(By.xpath("//*[@id=\"consent-accept-button\"]")).click();
        } catch (org.openqa.selenium.NoSuchElementException ignored) {
            ;
        }

        fluentWait(By.linkText("Log in")).click();
//        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("username")).sendKeys("niktovicd@gmail.com");
        driver.findElement(By.id("password")).sendKeys("tBy%mvW8s#*CDrhb");
        driver.findElement(By.cssSelector(".erMSDu")).click();

        driver.get("https://www.xing.com/chats");
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/nav/ul/li[1]/a")));
        }

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/nav/ul/li[1]/a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/section/section/div/div[1]/div/div/button[2]")));
        driver.findElement(By.xpath("//*[@id=\"content\"]/section/section/div/div[1]/div/div/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/section/div[2]")).sendKeys(postText);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/section/section/span[2]/button/div")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/nav/ul/li[3]/a")));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/nav/ul/li[3]/a")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/section/div/div[3]/section[3]/div/ul/li[3]/a/div/p[1]")));
        driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div[3]/section[3]/div/ul/li[3]/a/div/p[1]")).click();

        js.executeScript("window.scrollTo(0,0)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"observed-Discover/mefeed-0\"]/div[2]/div[1]/a/p/span/span")));
        assertThat(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/section/div/main/section/section/div/div[2]/div/section/ul/li[1]/article/div[2]/div[1]/a/p")).getText(), is(postText));
    }
}
