package main.java.com.contactsbook;

import java.awt.EventQueue;
import java.io.FileNotFoundException;

public class Main {

	private static final String PATH_TO_CONTACT_LIST = "./res/myContactList.txt";
	
	public static void main(String[] args) {

		ContactList myContacts = readContactsFromFile(PATH_TO_CONTACT_LIST);
		
		ContactListPanel contactsBook = new ContactListPanel();
		contactsBook.write(myContacts);
		
		EventQueue.invokeLater(() -> {
			ContactWindow contactsWindow = new ContactWindow();
			contactsWindow.add(contactsBook);
		});
	}
	
	private static ContactList readContactsFromFile(String path) {
		ContactList retList = new ContactList();
		try {
			ContactsFileReader contactsReader = new ContactsFileReader(path);
			retList = contactsReader.read();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			return retList;
		}
		return retList;
	}

}
