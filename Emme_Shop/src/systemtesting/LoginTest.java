package systemtesting;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class LoginTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
  System.setProperty("webdriver.chrome.driver","D:\\cetra\\Users\\chromedriver.exe");

    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testLoginVenditore() {
    driver.get("http://localhost:8080/Emme_Shop/index.jsp");
    driver.manage().window().setSize(new Dimension(1326, 712));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("form:nth-child(2) span:nth-child(2) > .text-input")).click();
    driver.findElement(By.cssSelector("form:nth-child(2) span:nth-child(2) > .text-input")).sendKeys("adidas");
    driver.findElement(By.cssSelector("form:nth-child(2) span:nth-child(3) > .text-input")).click();
    driver.findElement(By.cssSelector("form:nth-child(2) span:nth-child(3) > .text-input")).sendKeys("Adidas2#");
    driver.findElement(By.cssSelector("form:nth-child(2) .send-button")).click();
    driver.findElement(By.cssSelector("ul:nth-child(1) > li")).click();
    driver.findElement(By.cssSelector("ul:nth-child(1) > li")).click();
    driver.findElement(By.cssSelector(".fa-sign-out-alt")).click();
    driver.findElement(By.cssSelector(".content")).click();
    driver.close();
  }
}
