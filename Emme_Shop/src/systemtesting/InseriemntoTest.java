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

import managernegozio.Prodotto;
import model.CategoriaDAO;
import model.ProdottoDAO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
public class InseriemntoTest {
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
  public void untitled() throws Exception {
	 
	  driver.get("http://localhost:8080/Emme_Shop/index.jsp");
	    driver.manage().window().setSize(new Dimension(1338, 724));
	    driver.findElement(By.linkText("Accedi")).click();
	    driver.findElement(By.cssSelector("form:nth-child(2) span:nth-child(2) > .text-input")).click();
	    driver.findElement(By.cssSelector("form:nth-child(2) span:nth-child(2) > .text-input")).sendKeys("adidas");
	    driver.findElement(By.cssSelector("form:nth-child(2) span:nth-child(3) > .text-input")).click();
	    driver.findElement(By.cssSelector("form:nth-child(2) span:nth-child(3) > .text-input")).sendKeys("Adidas2#");
	    driver.findElement(By.cssSelector("form:nth-child(2) .send-button")).click();
	    driver.findElement(By.cssSelector(".category img")).click();
	    driver.findElement(By.name("nomeCategoria")).click();
	    driver.findElement(By.name("nomeCategoria")).sendKeys("Calze");
	    driver.findElement(By.name("descCategoria")).click();
	    driver.findElement(By.name("descCategoria")).sendKeys("Calze per tutta la famiglia");
	    driver.findElement(By.id("nextBtn1")).click();
	    driver.findElement(By.linkText("Completa Inserimento...")).click();
	    driver.findElement(By.cssSelector(".categorySeller:nth-child(1) > .img img")).click();
	    driver.findElement(By.cssSelector("a > img:nth-child(1)")).click();
	    driver.findElement(By.name("nomeProdotto")).click();
	    driver.findElement(By.name("nomeProdotto")).sendKeys("Calze Shorts");
	    driver.findElement(By.name("descProdotto")).click();
	    driver.findElement(By.name("descProdotto")).sendKeys("Calze basse");
	    driver.findElement(By.name("prezzoProdotto")).click();
	    driver.findElement(By.name("prezzoProdotto")).sendKeys("12.99");
	    driver.findElement(By.name("ivaProdotto")).click();
	    driver.findElement(By.name("ivaProdotto")).sendKeys("12");
	    driver.findElement(By.name("qtaProdotto")).click();
	    driver.findElement(By.name("qtaProdotto")).sendKeys("12");
	    driver.findElement(By.name("scontoProdotto")).click();
	    driver.findElement(By.name("scontoProdotto")).sendKeys("10");
	    driver.findElement(By.id("nextBtn1")).click();
	    driver.findElement(By.linkText("Completa Inserimento...")).click();
	    driver.findElement(By.cssSelector(".fa-sign-out-alt")).click();
    
    ProdottoDAO model=new ProdottoDAO();
    int id=model.getIDProd("Calze","Adidas","Calze Shorts");
	Prodotto actual = model.getProductById(id);
	
    assertEquals("Calze Shorts", actual.getNome());
	
    CategoriaDAO modeld= new CategoriaDAO();
   
    modeld.deleteCategory("Adidas", "Calze");
  }
    
}

