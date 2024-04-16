import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/chess";
    private static final String USER = "daniil";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static List<TestData> getTestData() throws SQLException {
        try (Connection connection = DatabaseUtils.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM test_cases");
            List<TestData> testData = new ArrayList<>();

            while (resultSet.next()) {
                TestData data = new TestData(
                        resultSet.getInt("kingX"),
                        resultSet.getInt("kingY"),
                        resultSet.getInt("rookX"),
                        resultSet.getInt("rookY"),
                        resultSet.getInt("bishopX"),
                        resultSet.getInt("bishopY"),
                        resultSet.getBoolean("result")
                );
                testData.add(data);
            }
            return testData;
        }
    }
}
