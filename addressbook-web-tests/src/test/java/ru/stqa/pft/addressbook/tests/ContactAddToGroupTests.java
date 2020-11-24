package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditionsContact() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
            Groups groups = app.db().groups();
            Contacts contacts = app.db().contacts();
            if (app.db().contacts().size() == 0) {
                app.goTo().addNewContactPage();
                app.contact().create(new ContactData()
                        .withName("Sergey").withLastname("Petrov").withNickname("testnick")
                        .withAddress("Moscow, Tverskaya street").withMobilephone("89046111111").withEmail("test@mail.ru")
                        .withBday("15").withBmonth("May").withByear("1989").inGroup(groups.iterator().next()));
                app.goTo().homePage();
            }
        }
    }

    @Test
    public void testContactAddToGroup() {
        Groups groups = app.db().groups();
        Contacts before = app.db().contacts();
        app.goTo().homePage();
        ContactData addedContact = before.iterator().next();
        if (addedContact.getGroups().size() == groups.size()) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
        Groups groupsOfContactBefore = addedContact.getGroups();
        GroupData groupWithAddedContact = new GroupData();
        for (GroupData group : app.db().groups()) {
            if (!group.hasContact(addedContact)) {
                app.goTo().homePage();
                app.contact().addContactToGroup(addedContact, group);
                groupWithAddedContact = group;
            } else if (group.hasContact(addedContact)) {
            }
        }

        ContactData newContact = app.db().GetContactDataById(addedContact.getId());
        Groups groupsOfContactAfter = newContact.getGroups();
        assertThat(groupsOfContactBefore.size() + 1, equalTo(groupsOfContactAfter.size()));
        assertThat(groupsOfContactAfter, equalTo(groupsOfContactBefore.withAdded(groupWithAddedContact)));
    }
}
