package myTestProject.tests;

import java.time.Duration;
import java.util.Properties;
import myTestProject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigUtils;

public class LoginTests {

  LoginPage loginPg;
  WebDriver driver;
  WebDriverWait wait;

  @BeforeClass
  public void openBrowser() {
    System.setProperty(
      "webdriver.chrome.driver",
      "C:\\Users\\devha\\OneDrive\\Desktop\\Chrome WebDriver\\chromedriver_win32\\chromedriver.exe"
    );
    driver = new ChromeDriver();

    Properties props = ConfigUtils.getProps("data");

    driver.get(props.getProperty("URL"));

    String seeURL = props.getProperty("URL");
    System.out.println("URL - " + seeURL);
  }

  @Test(description = "Login Test", priority = 1)
  public void login() {
    Duration timeout = Duration.ofSeconds(10);
    wait = new WebDriverWait(driver, timeout);

    loginPg = new LoginPage(driver, wait);

    loginPg.login();

    String verifyLogin = driver
      .findElement(By.xpath("//*[@id=\"app\"]/header/nav/div/a"))
      .getText();
    Assert.assertEquals(verifyLogin, "Simple Editor");
  }

  @Test(description = "Logout Test", priority = 2)
  public void logout() throws InterruptedException {
    loginPg.logout();

    String url = driver.getCurrentUrl();
    Assert.assertTrue(url.contains("/login"));
  }

  @AfterClass
  public void closeBrowser() {
    System.out.println("Closing Browser");
    driver.quit();
  }
}
