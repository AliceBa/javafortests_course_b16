package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactAddtoGroupTest extends TestBase {

  @Test
  public void testContactAddtoGroup(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().selectGroupforContact();
  }
}
