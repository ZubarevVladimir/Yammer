package com.yammer.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

  private static By FIELD_LOGIN_LOCATOR = By.id("cred_userid_inputtext");
  private static By FIELD_PASSWORD_LOCATOR = By.id("passwordInput");
  private static By BUTTON_SUBMIT_LOCATOR = By.id("submitButton");
  private static By LOAD_ELEMENT_LOCATOR = By.id("credentials");

  public void setPassword(String password) {
    browser.type(FIELD_PASSWORD_LOCATOR, password);
  }

  public void setLogin(String login) {
    browser.type(FIELD_LOGIN_LOCATOR, login);
    browser.type(FIELD_LOGIN_LOCATOR, Keys.TAB);
  }

  public boolean isLoad() {
    return browser.getElement(LOAD_ELEMENT_LOCATOR).isDisplayed();
  }

  public void clickSubmit() {
    browser.click(BUTTON_SUBMIT_LOCATOR);
  }

  public void alertPopUp(String username, String password) {
    Alert alert = browser.getWebDriver().switchTo().alert();
    alert.setCredentials(new UserAndPassword(username, password));
    alert.accept();
  }
}
