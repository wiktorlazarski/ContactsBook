package test.java.com.contactsbook;

import junit.framework.TestCase;
import main.java.com.contactsbook.Contact;
import main.java.com.contactsbook.ContactList;
import main.java.com.contactsbook.Database;

import java.util.ArrayList;

/**
 * Created by Konrad on 2017-09-13.
 */
public class DatabaseTest extends TestCase {

    public void testInsertContact() throws Exception {
        Database database = new Database("test");
        Contact testContact = new Contact("Kon", "Woj", "666777888");
        database.insertContact(testContact);
        assertEquals(testContact.toString(), database.getContact(1).toString());
    }

    public void testGetContact() throws Exception {
        Database database = new Database("test1");
        Contact testContact = new Contact("Kon", "Woj", "666767888");
        database.insertContact(testContact);
        assertEquals(testContact.toString(), database.getContact(1).toString());
    }

    public void testGetContactList() throws Exception {
        Database database = new Database("test2");
        ContactList contactList = new ContactList();
        contactList.addContact(new Contact("Kla", "Bla", "555666777"));
        contactList.addContact(new Contact("Ble", "lals", "777888999"));
        for (int i = 0; i < contactList.size(); ++i) {
            database.insertContact(contactList.getContact(i));
        }

        assertEquals(contactList.toString(), database.getContactList().toString());
    }
}