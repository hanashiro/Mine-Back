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

public class CadastrarFornecedorSomenteCamposObrigatorios {
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
  public void testCadastrarFornecedorSomenteCamposObrigatorios() throws Exception {
    driver.get("http://localhost:9000/");
    driver.findElement(By.xpath("//nav[@id='dock']/ul/li[8]/a/img")).click();
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Coca-cola");
    driver.findElement(By.xpath("//li[3]/a/tab-heading")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("ru");
    driver.findElement(By.id("selectLogradouroOptions")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[11]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[11]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("Tiburcio de Souza");
    driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("2.782");
    driver.findElement(By.xpath("(//input[@type='text'])[14]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("08140-000");
    driver.findElement(By.xpath("(//input[@type='text'])[15]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[15]")).sendKeys("Itaim Paulista");
    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[18]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[18]")).sendKeys("sao pau");
    driver.findElement(By.cssSelector("#selectCidadeOptions > span.ui-select-highlight")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[14]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("");
    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
    assertEquals("Fornecedor cadastrado com sucesso", driver.findElement(By.cssSelector("div.toast-item.toast-type-success")).getText());
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
