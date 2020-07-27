package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

  public void initContactModification() {
    click(By.xpath("(//img[@alt='Edit'])[1]"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page")); // там находится contact list
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

  public void createContact(ContactData contact) {
    selectAddNewContact();
    fillContactForm(contact, true);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
//*[@id="maintable"]/tbody/tr[3]/td[2]

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements){
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      String firstname = element.findElement(By.xpath("//td[2]")).getText();
      String lastname = element.findElement(By.xpath("//td[3]")).getText();
      ContactData contact = new ContactData(id,lastname, firstname,null,null,null,null);
      contacts.add(contact);
    }
    return contacts;
  }
}
