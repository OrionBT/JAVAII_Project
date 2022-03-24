package DOA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * class is called to connect to the database
 */
public class DBConnection {
    // JDBC URL parts
    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String ipAddress = "//wgudb.ucertify.com/WJ07MBi";

    // JDBC URL
    private static final String jdbcURL = protocol + vendorName + ipAddress;

    // Driver Interface reference
    private static final String MYSQLJDBCDriver = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = null;

    private static final String username = "U07MBi"; // Username
    private static final String password = "53689066267"; // Password

    /** starts the connection to the db
     * @return Connection
     */
    public static Connection startConnection()
    {
        try {
            Class.forName(MYSQLJDBCDriver);
            conn = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connection successful");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * closes the connection to the db
     */
    public static void closedConnection() {
        try {
            conn.close();
            System.out.println("Connection closed");
        }
        catch (SQLException e){
            System.out.println("Error" + e.getMessage());
        }
    }

}
