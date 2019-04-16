import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest {
    WebDriver driver;

    @Before
    public void openLoginPage() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("localhost:8080");
        Assert.assertEquals("Login - Nebula", driver.getTitle());
    }

    @Test
    public void testEmptyLogin() throws InterruptedException{
        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();
        Thread.sleep(3000);
        Assert.assertEquals("Registration - Nebula", driver.getTitle());
    }

    @Test
    public void testRegisterButton() throws InterruptedException{
        WebElement registerButton = driver.findElement(By.name("register"));
        registerButton.click();
        Thread.sleep(3000);
        Assert.assertEquals("Registration - Nebula", driver.getTitle());
    }

    @Test
    public void testRealLogin() throws InterruptedException{
        WebElement loginButton = driver.findElement(By.name("submit"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("test");
        password.sendKeys("test");
        loginButton.click();
        Thread.sleep(1000);
        Assert.assertEquals("Nebula - Feed", driver.getTitle());



    }

    @After
    public void closePage() { driver.quit(); }

}
