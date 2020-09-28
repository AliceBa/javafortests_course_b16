package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage(); //по факту там contact list
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData()
              .withFirstname("Alex").withLastname("Xander").withCompany("Factory").withMobile("89991112244")
              .withEmail("xander.email").withGroup("test1"));
    }
  }

  @Test
  public void testContactDeletion(){
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(deletedContact);
      Assert.assertEquals(before, after);
  }
}
