package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactAddtoGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage(); //по факту там contact list
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData()
              .withFirstname("Alex").withLastname("Xander").withCompany("Factory").withMobile("89991112244")
              .withEmail("xander.email"));
    }
  }

  @Test
  public void testContactAddtoGroup(){
    List<ContactData> before = app.contact().list();
    app.contact().selectContact(before.size()-1);
    app.contact().selectGroupforContact();
    app.contact().returnToHomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());
  }
}
