package main.java.com.contactsbook;

/**
 * Created by Konrad on 2017-09-13.
 */
public class ContactDatabaseReader implements ContactListReader {
    public ContactList read() {
        return ContactDatabase.getInstance().getContactList();
    }
}
