package main.java.com.contactsbook;

/**
 * Created by Konrad on 2017-09-13.
 */
public class ContactDatabaseWriter implements ContactListWriter {
    public void write(ContactList list) {
        for (int i = 0; i < list.size(); ++i) {
            ContactDatabase.getInstance().insertContact(list.getContact(i));
        }
    }
}
