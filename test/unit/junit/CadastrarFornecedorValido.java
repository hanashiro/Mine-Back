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

public class CadastrarFornecedorValido {
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
  public void testCadastrarFornecedorValido() throws Exception {
    driver.get("http://localhost:9000/");
    driver.findElement(By.xpath("//nav[@id='dock']/ul/li[8]/a/img")).click();
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Distribuidora Marquinhos");
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Marcos Oliveira Pedroso");
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("110.042.490.114");
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("110.042.490.114");
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("416162/001-1");
    driver.findElement(By.xpath("//li[2]/a/tab-heading")).click();
    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.findElement(By.xpath("(//div[@id='selectTelefoneOptions'])[3]")).click();
    driver.findElement(By.xpath("//input[@type='tel']")).clear();
    driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("(12) 3546-87654");
    driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[4]/td[5]/button")).click();
    assertEquals("Comercial", driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[2]/td")).getText());
    assertEquals("(12) 3546-87654", driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[2]/td[2]")).getText());
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    driver.findElement(By.xpath("//div[@id='selectEmail']/ul/li/div[4]/a")).click();
    driver.findElement(By.xpath("//input[@type='email']")).clear();
    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("dist.marquinhos@bol.com.br");
    driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[11]/td[5]/button")).click();
    assertEquals("Comercial", driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[10]/td")).getText());
    assertEquals("dist.marquinhos@bol.com.br", driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[10]/td[2]")).getText());
    driver.findElement(By.xpath("//li[3]/a/tab-heading")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("ave");
    driver.findElement(By.id("selectLogradouroOptions")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[11]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[11]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("Peixoto de Castro");
    driver.findElement(By.xpath("(//input[@type='text'])[12]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("1509");
    driver.findElement(By.xpath("(//input[@type='text'])[14]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[14]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("12606-300");
    driver.findElement(By.xpath("(//input[@type='text'])[15]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[15]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[15]")).sendKeys("Vila Zelia");
    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[18]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[18]")).sendKeys("lorena");
    driver.findElement(By.cssSelector("#selectCidadeOptions > span.ui-select-highlight")).click();
    driver.findElement(By.xpath("//table[@id='cliCadastro3']/tbody/tr[7]/td[2]/textarea")).clear();
    driver.findElement(By.xpath("//table[@id='cliCadastro3']/tbody/tr[7]/td[2]/textarea")).sendKeys("Em frente ao mecanico Ivan");
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
