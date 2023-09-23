package model;

import utils.Utils;

import java.sql.*;

public class UserDao implements UserDaoInterface {

    public UserDao() {}

    /* Add new user into user table. */
    @Override
    public void addUser(User user) throws SQLException {
        String add_query =
                "INSERT INTO users" +
                        " (first_name, last_name, username, password) VALUES " +
                        " (?, ?, ?, ?);";
        try (Connection connection = Utils.getConnection(); PreparedStatement statement = connection.prepareStatement(add_query)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());

            statement.executeUpdate();
            System.out.println("added user in users");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    /* Create a new tasks table specific to new user. */
    @Override
    public void createUserTasksTable(User user) throws SQLException {
        String create_query =
                "CREATE TABLE " +
                        user.getTableName() +
                        " (id INT(3) NOT NULL AUTO_INCREMENT," +
                        " task_name VARCHAR(255)," +
                        " task_description VARCHAR(1000)," +
                        " weekday VARCHAR(10)," +
                        " due_date datetime(6)," +
                        " created_at datetime(6)," +
                        " is_done BOOL," +
                        " task_status VARCHAR(20)," +
                        " PRIMARY KEY (id))";
        try (Connection connection = Utils.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(create_query);
        } catch (SQLException e) {
            System.out.println("failed creating new table");
            System.out.println(e);
        }
    }

    @Override
    public User getUser(String username) throws SQLException {
        User user = null;
        String get_query =
                "select id, first_name, last_name, password from users" +
                        " where username =?;";
        try (Connection connection = Utils.getConnection(); PreparedStatement statement = connection.prepareStatement(get_query)) {
            statement.setString(1, username);

            ResultSet res = statement.executeQuery();

            while (res.next()) {
                long id = res.getLong("id");
                String firstName = res.getString("first_name");
                String lastName = res.getString("last_name");
                String password = res.getString("password");

                user = new User(firstName, lastName, username);
                user.setPassword(password);
                user.setId(id);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public boolean userExists(String username) throws SQLException {
        boolean exists = false;
        String find_query =
                "select * from users where username = ?;";
        try (Connection connection = Utils.getConnection(); PreparedStatement statement = connection.prepareStatement(find_query)) {
            statement.setString(1, username);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            System.out.println("sql error: ");
            System.out.println(e);
        }

        return exists;
    }

}
