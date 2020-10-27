package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
//            чтение из файла csv
//            String[] split = line.split(";");
//            list.add(new Object[]{new ContactData().withName(split[0]).withLastname(split[1]).withGroup(split[2]).withAddress(split[3]).withMobilephone(split[4]).withEmail(split[5]).withBday(split[6]).withBmonth(split[7]).withByear(split[8])});
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
        }.getType()); //Означает примеерно то же самое, что List<ContactData>.class
        return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (!app.group().isThereAGroup()) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactData contact) throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/stru.png");
        //ContactData contact = new ContactData().withName("Anastasiia").withLastname("Petrova").withNickname("testPetrova").withPhoto(photo).withCompany("ooo Test").withGroup("test1").withAddress("Moscow, Tverskaya street").withHomephone("+79046111111").withWorkphone("8495123456").withEmail("test@mail.ru").withBday("25").withBmonth("December").withByear("1989");
        app.contact().create(contact);
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

//    @Test
//    public void testCurrentDir(){
//        File currentDir = new File(".");
//        File photo = new File("src/test/resources/stru.png");
//        System.out.println(currentDir.getAbsolutePath());
//        System.out.println(photo.exists());
//
//    }

}
