package test.java.com.contactsbook;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.*;

import main.java.com.contactsbook.*;

public class ContactsFileReaderTest {

	private final static String PATH_TO_CORRECT_CONTACT_LIST = "./res/testContactListCorrect.txt";
	private final static String PATH_TO_UNCORRECT_CONTACT_LIST = "./res/testContactListUncorrect.txt";
	private final static String PROPER_READED_LIST = "Wiktor £azarski 123456789\n"
												+ "Wiktor Lazarski 987654321\n"
												+ "Wikus £azarski 666666666\n";
	
	@Test
	public void testReadingFromFileAllInputCorrect() {
		ContactList readedContacts = doReading(PATH_TO_CORRECT_CONTACT_LIST);
		assertEquals(PROPER_READED_LIST, readedContacts.toString());
	}
	
	@Test
	public void testReadingFromFileWithIndivisibleStringsNumber() {
		ContactList readedContacts = doReading(PATH_TO_UNCORRECT_CONTACT_LIST);
		assertFalse(PROPER_READED_LIST.equals(readedContacts.toString()));
	}
	
	private ContactList doReading(String file) {
		ContactList retList = new ContactList();
		ContactsFileReader reader;
		try {
			reader = new ContactsFileReader(file);
			retList = reader.read();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return retList;
	}
	
}
