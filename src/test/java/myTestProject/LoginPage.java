package myTestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

  WebDriver driver;
  WebDriverWait wait;
  By username = new By.ByCssSelector("input[type='text'].form-control");
  By password = new By.ByCssSelector("input[type='password'].form-control");
  By loginButton = new By.ByCssSelector("button.btn.btn-primary");
  By logoutButton = new By.ByCssSelector(
    "li.nav-item.px-3 a[href='/apps/simple-editor/logout']"
  );

  public LoginPage(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public void login() {
    driver.findElement(username).sendKeys("demo-cloud");
    driver.findElement(password).sendKeys("demo-password");
    driver.findElement(loginButton).click();
    System.out.println("Credentials Verified");
  }

  public void logout() throws InterruptedException {
    WebElement LogoutEvent = wait.until(
      ExpectedConditions.elementToBeClickable(logoutButton)
    );
    System.out.println("Going to Logout");
    LogoutEvent.click();
    wait.until(
      ExpectedConditions.presenceOfElementLocated(
        By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/h4")
      )
    );
  }
}
