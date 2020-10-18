package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withName("Anastasiia").withLastname("Petrova").withNickname("testPetrova").withCompany("ooo Test").withGroup("test1").withAddress("Moscow, Tverskaya street").withHomephone("+79046111111").withWorkphone("8495123456").withEmail("test@mail.ru").withBday("25").withBmonth("December").withByear("1989"));
        }
    }

    @Test
    public void testContactDeletion() {
        app.contact().returnToHomePage();
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.goTo().homePage();
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }

}
