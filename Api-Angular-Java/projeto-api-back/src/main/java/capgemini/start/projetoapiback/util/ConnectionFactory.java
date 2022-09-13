package capgemini.start.projetoapiback.util;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class ConnectionFactory {

    public static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = "jdbc:postgresql://localhost:5432/angular_api";
    public static final String USER = "postgres";
    public static final String PASS = "postgres";

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("Error when connecting to database", e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error when closing the database connection" ,e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error when closing the database connection" ,e);
        }
    }


}
