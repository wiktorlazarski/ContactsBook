package main.java.com.contactsbook;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * Created by Konrad on 2017-09-13.
 */
public class Database {
    private static final String DRIVER = "org.sqlite.JDBC";
    private  String DB_URL;

    Connection connection;
    Statement statement;

    public static class ContactNotFoundException extends Exception {}

    public Database(String databaseName) {
        DB_URL = "jdbc:sqlite:" + databaseName + ".db";

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        createTables();
    }

    private static final String insertIntoStatement = "INSERT INTO";

    private void insertIntoDatabase(String tableName, String values) {
        try {
            statement.executeUpdate(insertIntoStatement + ' ' + tableName + " values" + values);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertContact(Contact contactToInsert) {
        insertIntoDatabase(Contact.class.getSimpleName(), getValuesToInsertString(contactToInsert));
    }

    private String getValuesToInsertString(Contact contact) {
        StringBuilder valuesBuilder = new StringBuilder();
        valuesBuilder.append('(');
        valuesBuilder.append("NULL, ");
        valuesBuilder.append("\'" + contact.name + "\'" + ", ");
        valuesBuilder.append("\'" + contact.lastname + "\'" + ", ");
        valuesBuilder.append("\'" + contact.number + "\'" + ")");
        return valuesBuilder.toString();
    }

    private static final String selectStatement = "SELECT * FROM";

    private ResultSet getDatabaseRecord(String tableName, int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                selectStatement + ' ' + tableName + " WHERE id = ?");
        preparedStatement.setString(1, Integer.toString(id));
        return preparedStatement.executeQuery();
    }

    private ResultSet getAllRecords(String tableName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                selectStatement + ' ' + tableName);
        return preparedStatement.executeQuery();
    }

    private Contact getContact(ResultSet result) throws SQLException {
        return new Contact(result.getString("name"), result.getString("lastname"), result.getString("number"));
    }

    public Contact getContact(int id) throws ContactNotFoundException {
        try {
            ResultSet result = getDatabaseRecord(Contact.class.getSimpleName(), id);
            result.next();

            return getContact(result);
        }
        catch (SQLException e) {
            throw new ContactNotFoundException();
        }
    }

    public ContactList getContactList() {
        try {
            ContactList contactList = new ContactList();
            ResultSet result = getAllRecords(Contact.class.getSimpleName());
            while (result.next()) {
                contactList.addContact(getContact(result));
            }

            return contactList;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String createSQLStatement = "CREATE TABLE IF NOT EXISTS";

    private String getCreateTableStatement(String tableName, String values) {
        return createSQLStatement + " " + tableName + values;
    }

    private String getContactTableValues() {
        StringBuilder valuesBuilder = new StringBuilder();
        valuesBuilder.append('(');
        valuesBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT");
        addColumnsToCreateStatement(valuesBuilder);
        valuesBuilder.append(')');

        return valuesBuilder.toString();
    }

    private void addColumnsToCreateStatement(StringBuilder statementBuilder) {
        for (Field field : Contact.class.getFields()) {
            statementBuilder.append(", ");
            statementBuilder.append(field.getName());
            statementBuilder.append(' ');
            statementBuilder.append(field.getType().getSimpleName().toUpperCase());
        }
    }

    private void createTables() {
        try {
            statement.execute(getCreateTableStatement(Contact.class.getSimpleName(), getContactTableValues()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
