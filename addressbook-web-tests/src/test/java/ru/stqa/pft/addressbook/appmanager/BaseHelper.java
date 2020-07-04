package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseHelper {
  protected WebDriver wd;

  public BaseHelper (WebDriver wd) {
    this.wd = wd;
  }

  public void click (By locator) {
    wd.findElement(locator).click();
  }

  public void type (By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  /*
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("Petr");
  */

  public void selectFromList(By locator) {
    click(locator);
    new Select(wd.findElement(locator)).selectByVisibleText("test1");
    click(locator);
  }
  /*
    driver.findElement(By.name("to_group")).click();
    new Select(driver.findElement(By.name("to_group"))).selectByVisibleText("test4");
    driver.findElement(By.name("to_group")).click();
   */

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
