package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CadastrarClienteSomenteCamposObrigatorios {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:9000/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @Test
  public void testCadastrarClienteSomenteCamposObrigatorios() throws Exception {
    driver.get("http://localhost:9000/");
    driver.findElement(By.xpath("//nav[@id='dock']/ul/li[2]/a/img")).click();
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Marcos da Silva");
    driver.findElement(By.name("00E")).click();
    driver.findElement(By.xpath("//li[2]/a/tab-heading")).click();
    driver.findElement(By.xpath("//li[3]/a/tab-heading")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.xpath("(//div[@id='selectLogradouroOptions'])[4]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("Hotel do Vale");
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.xpath("(//div[@id='selectLogradouroOptions'])[12]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("Santa Cecilia");
    driver.findElement(By.xpath("(//input[@type='text'])[9]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("25");
    driver.findElement(By.name("00T")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("Novo Horizonte");
    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[13]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys("min");
    driver.findElement(By.id("selectEstadoOptions")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[15]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[15]")).sendKeys("pira");
    driver.findElement(By.xpath("(//div[@id='selectCidadeOptions'])[4]")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[13]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys("");
    driver.findElement(By.xpath("(//div[@id='selectEstadoOptions'])[26]")).click();
    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
    assertEquals("Cliente cadastrado com sucesso", driver.findElement(By.cssSelector("div.toast-item.toast-type-success")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
