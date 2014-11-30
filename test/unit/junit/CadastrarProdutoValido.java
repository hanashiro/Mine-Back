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

public class CadastrarProdutoValido {
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
  public void testCadastrarProdutoValido() throws Exception {
    driver.get("http://localhost:9000/");
    driver.findElement(By.xpath("//nav[@id='dock']/ul/li[5]/a/img")).click();
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("789");
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("7898357");
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("7898357410015");
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Dolly Citrus");
    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.findElement(By.xpath("//div[6]/a/div")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("1.80");
    driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("3");
    driver.findElement(By.xpath("(//input[@type='text'])[7]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("30");
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("10");
    driver.findElement(By.xpath("//textarea")).clear();
    driver.findElement(By.xpath("//textarea")).sendKeys("O sabor brasileiro");
    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
    assertEquals("Produto cadastrado com sucesso", driver.findElement(By.cssSelector("div.toast-item.toast-type-success")).getText());
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
