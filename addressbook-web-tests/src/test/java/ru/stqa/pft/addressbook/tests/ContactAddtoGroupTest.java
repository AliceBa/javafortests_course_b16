package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactAddtoGroupTest extends TestBase {

  @Test
  public void testContactAddtoGroup(){
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereContact()){
      app.getContactHelper().createContact(new ContactData("Alex", "Xander", "Factory", "89991112244", "xander.email", "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().selectGroupforContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
