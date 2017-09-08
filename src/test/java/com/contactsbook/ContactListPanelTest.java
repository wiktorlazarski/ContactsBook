package test.java.com.contactsbook;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import main.java.com.contactsbook.*;

public class ContactListPanelTest{
	private static final int NUMBER_OF_EXAMPLE_CONTACTS = 10;
	private static final Color STANDARD_COLOR = new Color(238, 238, 238);
	
	@Test
	public void testWriteMethod() {
		ContactList exampleList = createListToTest();
		ContactListPanel tested = new ContactListPanel();
		tested.write(exampleList);
		assertEquals(exampleList.toString(), tested.toString());
	}
	
	@Test
	public void testInitTextAreaBackground() {
		ContactListPanel tested = new ContactListPanel();
		assertEquals(tested.getBackground(), STANDARD_COLOR);
	}
	
	private ContactList createListToTest() {
		Contact exampleContact = new Contact("Wiktor", "Lazarski", "123456789");
		ContactList retList = new ContactList();
		for(int i = 0; i < NUMBER_OF_EXAMPLE_CONTACTS; i++) {
			retList.addContact(exampleContact);
		}
		return retList;
	}

}
