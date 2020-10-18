package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withName("Anastasiia").withLastname("Petrova").withNickname("testPetrova").withCompany("ooo Test").withGroup("test1").withAddress("Moscow, Tverskaya street").withHomephone("+79046111111").withWorkphone("8495123456").withEmail("test@mail.ru").withBday("25").withBmonth("December").withByear("1989"));
        }
    }

    @Test
    public void testContactModification() {
        app.contact().returnToHomePage();
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData()
                .withId(before.get(index).getId()).withName("Anastasiia").withLastname("Petrova")
                .withNickname("testPetrova").withCompany("ooo Test").withGroup("test1").withAddress("Moscow, Tverskaya street")
                .withHomephone("+79046111111").withWorkphone("8495123456").withEmail("test@mail.ru")
                .withBday("25").withBmonth("December").withByear("1989");
        app.goTo().homePage();
        app.contact().modify(index, contact);
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
