package main.java.com.contactsbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ContactsFileReader implements ContactListReader{
	private static final String REGEX_OF_CONTACT = "[\\w ]*{3}";
	private Pattern readingPattern;
	private Scanner source;
	
	public ContactsFileReader(String path) throws FileNotFoundException {
		readingPattern = Pattern.compile(REGEX_OF_CONTACT);
		File file = new File(path);
		source = new Scanner(file);
	}
	
	public ContactList read(){
		ContactList contacts = new ContactList();
		try {
			contacts = readContactList();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return contacts;
	}
	
	@Override
	public void finalize() {
		source.close();
	}
	
	private ContactList readContactList() throws FileNotFoundException {
		ContactList retList = new ContactList();
		while(source.hasNext(readingPattern)) {
			try{
			Contact contact = readSingleContact(source);
			retList.addContact(contact);
			}
			catch(Exception e){
				break;
			}
		}
		return retList;
	}
	
	private Contact readSingleContact(Scanner from) {
		String name = from.next();
		String lastname = from.next();
		String number = from.next();
		return new Contact(name, lastname, number);
	}
}
