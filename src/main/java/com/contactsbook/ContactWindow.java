package main.java.com.contactsbook;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ContactWindow extends JFrame{

	private static int WIDTH = 400;
	private static int HEIGHT = 300;
	private static String TITLE = "Contacts book";
	private static int POSITION_X = 100;
	private static int POSITION_Y = 100;
	
	public ContactWindow() {
		setWindowAtribs();
	}
	
	private void setWindowAtribs() {
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);	
		setLocation(POSITION_X, POSITION_Y);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
