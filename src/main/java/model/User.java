package model;

public class User {
    long id;
    String firstName;
    String lastName;
    String username;
    String password;
    String tableName;

    /* Initialize new user. */
    public User(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.tableName = generateTableName(username);
    }

    public String generateTableName(String username) {
        return username + "_tasks";
    }

    /********** Getter methods **********/
    public long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getTableName() {
        return this.tableName;
    }

    /********** Setter methods **********/
    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) { // already hashed
        this.password = password;
    }

    public void setTableName(String tableName) {
        this.password = tableName;
    }
}
