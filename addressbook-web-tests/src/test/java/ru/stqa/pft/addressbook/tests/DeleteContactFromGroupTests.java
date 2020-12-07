package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteContactFromGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        Groups groups = app.db().groups();
        if (app.db().contacts().size() == 0) {
            ContactData newContact = new ContactData()
                    .withName("Sergey").withLastname("Petrov").withNickname("testnick")
                    .withAddress("Moscow, Tverskaya street").withMobilephone("89046111111").withEmail("test@mail.ru")
                    .withBday("15").withBmonth("May").withByear("1989").inGroup(groups.iterator().next());
            app.contact().create(newContact);
            app.goTo().homePage();
        }
    }

    @Test
    public void testDeleteAddressFromGroup() {
        Groups groups = app.db().groups();
        Contacts before = app.db().contacts();
        app.goTo().homePage();
        ContactData removedContact = before.iterator().next();
        GroupData group = groups.iterator().next();

        if (removedContact.getGroups().size() == 0) {
            app.goTo().groupPage();
            app.contact().addContactToGroup(removedContact, group);
        }

        int contactId = removedContact.getId();
        ContactData newContact = app.db().GetContactDataById(contactId);
        Groups groupsForContactsBefore = newContact.getGroups();
        app.goTo().homePage();
        GroupData groupWithDeletedContact = newContact.getGroups().iterator().next();
        app.contact().removeContactFromGroup(removedContact, groupWithDeletedContact);
        Groups groupsForContactAfter = app.db().GetContactDataById(contactId).getGroups();
        assertThat(groupsForContactsBefore.size() - 1, equalTo(groupsForContactAfter.size()));
        assertThat(groupsForContactAfter, equalTo(groupsForContactsBefore.without(groupWithDeletedContact)));
    }
}
