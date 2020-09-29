package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().initNewContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Anastasiia", "Petrova", "testPetrova", "ooo Test", "Moscow, Tverskaya street", "+79046111111", "8495123456", "test@mail.ru", "25", "December", "1989"));
        app.getContactHelper().submitContactCreation();
    }

}
