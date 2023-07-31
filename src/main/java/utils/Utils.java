package utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Utils {
    /* Enter details for mySQL database below. */
    private static String URL = "jdbc:mysql://localhost:3306/planner";
    private static String Username = "root";
    private static String Password = "rootpassword123";

    /* Get a connection to MySQL database. */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, Username, Password);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return connection;
    }

    /* Convert from LocalDate to SQL Date. */
    public static Date getSqlDate(LocalDate date) {
        return Date.valueOf(date);
    }

    /* Convert from SQL Date to LocalDate. */
    public static LocalDate getLocalDate(Date date) {
        return date.toLocalDate();
    }

    /* Get the starting (Sunday) and end (Saturday) date (LocalDate) for the current week,
       Returned as an array of two LocalDate values where the Date of the first value is
       the Sunday of the start of the week, and the second value is the Saturday of the end
       of the week. */
    public static LocalDate[] getDatesCurrWeek() {
        LocalDate[] dates = new LocalDate[2];
        LocalDate today = LocalDate.now();

        LocalDate date = today;
        while (date.getDayOfWeek() != DayOfWeek.MONDAY) {
            date = date.minusDays(1);
        }
        date = date.minusDays(1);
        dates[0] = date;

        date = today;
        while (date.getDayOfWeek() != DayOfWeek.SATURDAY) {
            date = date.plusDays(1);
        }
        dates[1] = date;

        return dates;
    }
}
