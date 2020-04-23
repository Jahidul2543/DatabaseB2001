import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Search {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        getData();
    }

        public static void getData() throws SQLException, ClassNotFoundException, IOException {

            String query = "select * from t1";
            Statement statement = ConnectMySQL.connectDB().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            String id = resultSet.getString("id");
            System.out.println(id);
        }
}
