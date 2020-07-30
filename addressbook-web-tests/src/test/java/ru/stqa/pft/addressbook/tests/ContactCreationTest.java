package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Name+", "LastName+", "Factory", "89991112244", "smbd.email", "test1");
    app.getContactHelper().selectAddNewContact();
    app.getContactHelper().fillContactForm((contact), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage(); // homepage-по факту там список контактов
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()+1);

    /*int max = 0;
    for (ContactData c : after){
      if(c.getId()>max){
        max = c.getId();
      }
    }*/

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }

}
