package main.java.com.contactsbook;

import java.util.*;

public class ContactList{
	private static String EMPTY = "EMPTY LIST";
	private List<Contact> contacts;
	
	public ContactList() {
		contacts = new LinkedList<>();
	}
	
	public boolean addContact(Contact toAdd) {
		return contacts.add(toAdd);
	}

	public Contact getContact(int idx) {
		return contacts.get(idx);
	}

	public int size() {
		return contacts.size();
	}

	public boolean deleteContact(Contact toDelete) {
		for(Contact contact : contacts) {
			if(contact.equals(toDelete)) {
				return contacts.remove(contact);
			}
		}	
		return false;
	}
	
	@Override
	public String toString() {
		if(contacts.isEmpty()) {
			return EMPTY;
		}
		return buildContactListString();
	}
	
	private String buildContactListString() {
		StringBuilder contactsList = new StringBuilder();
		for(Contact contact : contacts) {
			contactsList.append(contact + "\n");
		}
		return contactsList.toString();
	}
}
