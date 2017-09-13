package main.java.com.contactsbook;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * Created by Konrad on 2017-09-13.
 */
public class ContactDatabase {
    private static final Database instance = new Database("contacts");

    public static Database getInstance() {
        return instance;
    }
}
