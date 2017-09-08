package main.java.com.contactsbook;

import javax.swing.*;

@SuppressWarnings("serial")
public class ContactListPanel extends JPanel implements ContactListWriter{
	private static final int TEXTAREA_ROWS = 15;
	private static final int TEXTAREA_COLS = 30;
	private JTextArea contactsList;
	
	public ContactListPanel() {
		initContactsTextArea();
		add(new JScrollPane(contactsList));
	}
	
	public void write(ContactList contacts) {
		contactsList.setText(contacts.toString());
		repaint();
	}
	
	@Override
	public String toString() {
		return contactsList.getText();
	}
	
	private void initContactsTextArea() {
		contactsList = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLS);
		contactsList.setBackground(null);
		contactsList.setEditable(false);
	}
}
