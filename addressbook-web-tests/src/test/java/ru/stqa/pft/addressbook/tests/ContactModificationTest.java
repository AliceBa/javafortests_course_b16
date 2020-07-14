package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage(); //по факту там contact list
    if (! app.getContactHelper().isThereContact()){
      app.getContactHelper().createContact(new ContactData("Alex", "Xander", "Factory", "89991112244", "xander.email", "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Change", "Contact", "Factory", "89991112244", "xander.email", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
