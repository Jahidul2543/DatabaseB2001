import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectMySQL {
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException {
        connectDB();
    }
    */
    public static Properties readProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("/Users/jahidul/IdeaProjects/DatabaseB2001/src/main/resources/app.properties");
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }

    public static Connection connectDB() throws ClassNotFoundException, SQLException, IOException {
        Properties properties = readProperties();
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");

        //protocol//[hosts][/database][?properties]
        //https://app.vivifyscrum.com/boards/87777/sprint-backlog/272972
        String url = properties.getProperty("url");
        // Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, userName, password);
        System.out.println("Connceted");
        return connection;
    }

    /*
    * Connect a db and get info out of that in simple way
    * */
   /* public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "root";

        //protocol//[hosts][/database][?properties]
        //https://app.vivifyscrum.com/boards/87777/sprint-backlog/272972
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        // Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, userName, password);
        System.out.println("Connceted");
        String query = "select * from t1";
        Statement statement = ConnectMySQL.connectDB().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        String id = resultSet.getString("id");
        System.out.println(id);
    }*/
}
