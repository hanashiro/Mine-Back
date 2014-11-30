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

public class CadastrarClienteValido {
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
  public void testCadastrarClienteValido() throws Exception {
    driver.get("http://localhost:9000/");
    driver.findElement(By.xpath("//nav[@id='dock']/ul/li[2]/a/img")).click();
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Maria do Carmo");
    driver.findElement(By.name("00F")).click();
    driver.findElement(By.id("clienteAniversario")).clear();
    driver.findElement(By.id("clienteAniversario")).sendKeys("01/01/1980");
    driver.findElement(By.cssSelector("textarea.ng-pristine.ng-valid")).click();
    driver.findElement(By.xpath("//table[@id='cliCadastro1']/tbody/tr[4]/td[2]/textarea")).clear();
    driver.findElement(By.xpath("//table[@id='cliCadastro1']/tbody/tr[4]/td[2]/textarea")).sendKeys("Cliente VIP");
    driver.findElement(By.linkText("Contato")).click();
    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.findElement(By.xpath("(//div[@id='selectTelefoneOptions'])[2]")).click();
    driver.findElement(By.xpath("//input[@type='tel']")).clear();
    driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("(12) 3568-98745");
    driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[4]/td[5]/button")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    driver.findElement(By.xpath("(//div[@id='selectEmailOptions'])[3]")).click();
    driver.findElement(By.xpath("//input[@type='email']")).clear();
    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("maria.carmo@gmail.com");
    driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[11]/td[5]/button")).click();
    assertEquals("Celular", driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[2]/td")).getText());
    assertEquals("(12) 3568-98745", driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[2]/td[2]")).getText());
    assertEquals("Pessoal", driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[10]/td")).getText());
    assertEquals("maria.carmo@gmail.com", driver.findElement(By.xpath("//table[@id='cliCadastro2']/tbody/tr[10]/td[2]")).getText());
    driver.findElement(By.xpath("//li[3]/a/tab-heading")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("rua");
    driver.findElement(By.id("selectLogradouroOptions")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("Madame Curie");
    driver.findElement(By.xpath("(//input[@type='text'])[9]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("1000");
    driver.findElement(By.xpath("(//input[@type='text'])[11]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[11]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("12606-330");
    driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("Cruz");
    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[15]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[15]")).sendKeys("loren");
    driver.findElement(By.xpath("(//div[@id='selectCidadeOptions'])[2]")).click();
    driver.findElement(By.xpath("//table[@id='cliCadastro3']/tbody/tr[7]/td[2]/textarea")).clear();
    driver.findElement(By.xpath("//table[@id='cliCadastro3']/tbody/tr[7]/td[2]/textarea")).sendKeys("Atras da loja da Sky");
    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
    assertEquals("Cliente cadastrado com sucesso", driver.findElement(By.cssSelector("p")).getText());
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
