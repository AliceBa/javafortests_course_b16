package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactAddtoGroupTest extends TestBase {

  @Test
  public void testContactAddtoGroup(){
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereContact()){
      app.getContactHelper().createContact(new ContactData("Alex", "Xander", "Factory", "89991112244", "xander.email", "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().selectGroupforContact();
  }
}
