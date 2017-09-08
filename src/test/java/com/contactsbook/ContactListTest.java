package test.java.com.contactsbook;

import static org.junit.Assert.*;

import org.junit.*;

import main.java.com.contactsbook.*;

public class ContactListTest {

	private ContactList tested;
	
	@Before
	public void initTestedContactList() {
		tested = new ContactList();
	}
	
	@Test
	public void testAddingContact() {
		Contact toAdd = new Contact("Wiktor", "£azarski", "123456789");
		assertTrue(tested.addContact(toAdd));
	}
	
	@Test
	public void testDeletingExistingContact() {
		Contact toDelete = new Contact("Wiktor", "£azarski", "123456789");
		tested.addContact(toDelete);
		assertTrue(tested.deleteContact(toDelete));
	}
	
	@Test
	public void testDeletingUnexistingContact() {
		Contact toDelete = new Contact("Wiktor", "£azarski", "123456789");
		assertFalse(tested.deleteContact(toDelete));
	}
	
	@Test
	public void testToStringWithEmptyList() {
		assertEquals(tested.toString(), "EMPTY LIST");
	}
	
	@Test
	public void testToStringWithFilledList() {
		Contact contact = new Contact("Wiktor", "£azarski", "123456789");
		tested.addContact(contact);
		assertEquals(tested.toString(), contact.toString() + "\n");
	}

}
