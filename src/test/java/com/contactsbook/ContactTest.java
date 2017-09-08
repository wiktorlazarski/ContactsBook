package test.java.com.contactsbook;

import static org.junit.Assert.*;

import org.junit.*;

import main.java.com.contactsbook.Contact;

public class ContactTest {
	
	@Test
	public void testToStringWithKnownNumber(){
		Contact tested = new Contact("Wiktor", "£azarski", "123456789");
		assertEquals("Wiktor £azarski 123456789", tested.toString());
	}
	
	@Test
	public void testEqualsWithSameContacts() {
		Contact first = new Contact("Wiktor", "£azarski", "123456789");
		Contact second = new Contact("Wiktor", "£azarski", "123456789");
		assertTrue(first.equals(second));
	}
	
	@Test
	public void testEqualsDefaultContactsNames() {
		Contact first = new Contact("Wiktor", "£azarski", "123456789");
		Contact second = new Contact("Asia", "£azarski", "123456789");
		assertFalse(first.equals(second));
	}
	
	@Test
	public void testEqualsDefaultContactsLastnames() {
		Contact first = new Contact("Wiktor", "£azarski", "123456789");
		Contact second = new Contact("Wiktor", "Lazarski", "123456789");
		assertFalse(first.equals(second));
	}
	
	@Test
	public void testEqualsDefaultContactsNumbers() {
		Contact first = new Contact("Wiktor", "£azarski", "123456789");
		Contact second = new Contact("Wiktor", "£azarski", "987654321");
		assertFalse(first.equals(second));
	}
	
	@Test 
	public void testConstructurWithLetterInNumber() {
		Contact tested = new Contact("Wiktor", "£azarski", "12e456789");
		assertEquals("Wiktor £azarski UNKNOWN", tested.toString());
	}
	
	@Test 
	public void testConstructurWithWrongNumberOfDigits() {
		Contact tested = new Contact("Wiktor", "£azarski", "12456789");
		assertEquals("Wiktor £azarski UNKNOWN", tested.toString());
	}

}
