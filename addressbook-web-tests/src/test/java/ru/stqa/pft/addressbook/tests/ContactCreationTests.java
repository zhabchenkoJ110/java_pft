package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();

        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }

        app.getContactHelper().createContact(new ContactData("Anastasiia", "Petrova", "testPetrova", "ooo Test", "test1", "Moscow, Tverskaya street", "+79046111111", "8495123456", "test@mail.ru", "25", "December", "1989"));
        app.getNavigationHelper().gotoHomePage();
    }

}
