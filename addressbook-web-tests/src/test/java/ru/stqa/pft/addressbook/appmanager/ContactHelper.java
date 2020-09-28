package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends BaseHelper {

  private ContactData contactData;
  private boolean creation;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void selectAddNewContact() {
    click(By.linkText("add new"));
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath(".//td[8]")).get(index).click();
    //wd.findElements(By.xpath("(//img[@alt='Edit'])")).get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home")); // там находится contact list
  }

  public void selectContactDetails() {
    click(By.xpath("(//img[@alt='Details'])[2]"));
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void selectGroupforContact() {
    click(By.name("to_group"));
    selectFromList(By.name("to_group"));
    click(By.name("add"));
  }

  public void create(ContactData contact) {
    selectAddNewContact();
    fillContactForm(contact, true);
    submitContactCreation();
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
    selectContactById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    returnToHomePage();
  }

  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements){
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      contacts.add(new ContactData().withId(id).withLastname(lastname).withFirstname(firstname));
    }
    return contacts;
  }

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements){
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      contacts.add(new ContactData().withId(id).withLastname(lastname).withFirstname(firstname));
    }
    return contacts;
  }

}
