import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class postTest {
    WebDriver driver;

    @Before
    public void loginInit() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("localhost:8080");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.name("submit"));
        username.sendKeys("test");
        password.sendKeys("test");
        loginButton.click();
        Thread.sleep(3000);
        Assert.assertEquals("Nebula - Feed", driver.getTitle());
    }

    @Test
    public void testPostButton() throws InterruptedException{
      WebElement postButton = driver.findElement(By.name("post"));
      postButton.click();
      Thread.sleep(3000);
      Assert.assertEquals("Post Thread - Nebula", driver.getTitle());
    }

    @Test
    public void testPost() throws InterruptedException{
      WebElement postButton = driver.findElement(By.name("post"));
      postButton.click();
      Thread.sleep(3000);
      postButton = driver.findElement(By.name("submit"));
      WebElement title = driver.findElement(By.id("title"));
      WebElement description = driver.findElement(By.id("description"));
      title.sendKeys("test");
      description.sendKeys("test");
      postButton.click();
      Thread.sleep(1000);
      Assert.assertEquals("Nebula - Feed", driver.getTitle());
    }

    @Test
    public void testComments() throws InterruptedException{
      WebElement card = driver.findElement(By.name("card"));
      card.click();
      Thread.sleep(3000);
      Assert.assertEquals("Nebula - Comments", driver.getTitle());
    }

    @After
    public void closePage() { driver.quit(); }

}
