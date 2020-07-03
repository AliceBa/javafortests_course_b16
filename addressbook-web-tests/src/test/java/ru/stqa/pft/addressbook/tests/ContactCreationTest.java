package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().selectAddNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Alex", "Xander", "Factory", "89991112244", "xander.email"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage(); // homepage-по сути список контактов
  }

}
