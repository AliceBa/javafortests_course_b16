package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectAddNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Alex", "Xander", "Factory", "89991112244", "xander.email", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage(); // homepage-по факту там список контактов
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before+1);
  }

}
