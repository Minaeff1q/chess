import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestCasesGenerator {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        List<TestData> testCases = generateTestCases();
        saveTestCasesToDatabase(testCases);
    }

    public static List<TestData> generateTestCases() {
        List<TestData> testCases = new ArrayList<>();
        int numberOfTests = 1; // Количество генерируемых тестов

        for (int i = 0; i < numberOfTests; i++) {
            ChessThreat chessThreat = new ChessThreat();
            int kingX = getRandomCoordinate();
            int kingY = getRandomCoordinate();
            int rookX = getRandomCoordinate();
            int rookY = getRandomCoordinate();
            int bishopX = getRandomCoordinate();
            int bishopY = getRandomCoordinate();
            boolean result= chessThreat.isKingUnderThreat(kingX, kingY, rookX, rookY, bishopX, bishopY);
            TestData testData = new TestData(kingX, kingY, rookX, rookY, bishopX, bishopY, result);
            testCases.add(testData);
        }

        return testCases;
    }

    private static int getRandomCoordinate() {
        return RANDOM.nextInt(17) - 8; // Генерация случайных координат от -8 до 8
    }

    public static void saveTestCasesToDatabase(List<TestData> testCases) {
        String sql = "INSERT INTO test_cases (kingX, kingY, rookX, rookY, bishopX, bishopY, result) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (TestData testData : testCases) {
                statement.setInt(1, testData.getKingX());
                statement.setInt(2, testData.getKingY());
                statement.setInt(3, testData.getRookX());
                statement.setInt(4, testData.getRookY());
                statement.setInt(5, testData.getBishopX());
                statement.setInt(6, testData.getBishopY());
                statement.setBoolean(7, testData.isExpected());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
