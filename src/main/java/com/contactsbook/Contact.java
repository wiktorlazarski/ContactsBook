package main.java.com.contactsbook;

public class Contact{

	private static int PROPER_NUMBER_OF_DIGIT = 9;
	private static String UNKNOWN_NUMBER = "UNKNOWN";
	
	public String name;
	public String lastname;
	public String number;
	
	public Contact(String name, String lastname, String number) {
		this.name = name;
		this.lastname = lastname;
		this.number = number;
		
		if(!isProperNumber(number))
			this.number = UNKNOWN_NUMBER;
	}

	@Override
	public String toString() {
		return buildContactString();
	}
	
	public boolean equals(Contact contact) {
		return compareContacts(contact);
	}
	
	private boolean isProperNumber(String number) {
		return hasProperNumberOfDigit(number) && hasOnlyDigit(number);
	}
	
	private boolean hasProperNumberOfDigit(String number) {
		return number.length() == PROPER_NUMBER_OF_DIGIT;
	}
	
	private boolean hasOnlyDigit(String number) {
		for(char c : number.toCharArray()) {
			if(!Character.isDigit(c))
				return false;
		}
		return true;
	}
	
	private String buildContactString() {
		return new StringBuilder()
						.append(name+ " ")
						.append(lastname + " ")
						.append(number)
						.toString();
	}
	
	private boolean compareContacts(Contact contact) {
		return compareNames(contact.name)
				&& compareLastnames(contact.lastname)
				&& compareNumbers(contact.number);
	}
	
	private boolean compareNames(String name) {
		return this.name.equals(name);
	}
	
	private boolean compareLastnames(String lastname) {
		return this.lastname.equals(lastname);
	}
	
	private boolean compareNumbers(String number) {
		return this.number.equals(number);
	}
}
