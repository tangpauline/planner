package model;

import java.sql.SQLException;

/* Interface handling CRUD operations for USERS with the mySQL database. */
public interface UserDaoInterface {
    void addUser(User user) throws SQLException;
    void createUserTasksTable(User username) throws SQLException;
    User getUser(String username) throws SQLException;
    boolean userExists(String username) throws SQLException;
}
