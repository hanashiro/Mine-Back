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

public class EditarCliente {
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
  public void testEditarCliente() throws Exception {
    driver.get("http://localhost:9000/");
    driver.findElement(By.cssSelector("a > img")).click();
    driver.findElement(By.xpath("//input[@type='search']")).clear();
    driver.findElement(By.xpath("//input[@type='search']")).sendKeys("maria");
    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
    driver.findElement(By.cssSelector("span.clienteNome.ng-binding")).click();
    driver.findElement(By.cssSelector("button.btn.btn-info")).click();
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Maria do Carmo Silva");
    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
    driver.findElement(By.cssSelector("a > img")).click();
    driver.findElement(By.xpath("//input[@type='search']")).clear();
    driver.findElement(By.xpath("//input[@type='search']")).sendKeys("maria");
    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
    driver.findElement(By.cssSelector("img.clienteFoto")).click();
    assertEquals("Maria do Carmo Silva", driver.findElement(By.cssSelector("#clienteDetalhes > span.clienteNome.ng-binding")).getText());
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
