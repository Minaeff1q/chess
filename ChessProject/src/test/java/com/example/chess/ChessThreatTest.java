package com.example.chess;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChessThreatTest {

    @Test
    public void runTestsFromDatabase() throws SQLException {
        List<TestData> testDataList = DatabaseUtils.getTestData();
        for (TestData testData : testDataList) {
            if (testData.getExpectedResult()) {
                testIsKingUnderThreat_RookAttack(testData);
            } else {
                testIsKingNotUnderThreat_RookAttack(testData);
            }
        }
    }

    public void testIsKingUnderThreat_RookAttack(TestData testData) {
        ChessThreat chessThreat = new ChessThreat();
        assertTrue(chessThreat.isKingUnderThreat(testData.getKingX(), testData.getKingY(),
                                                testData.getRookX(), testData.getRookY(),
                                                testData.getBishopX(), testData.getBishopY()));
    }

    public void testIsKingNotUnderThreat_RookAttack(TestData testData) {
        ChessThreat chessThreat = new ChessThreat();
        assertFalse(chessThreat.isKingUnderThreat(testData.getKingX(), testData.getKingY(),
                                                 testData.getRookX(), testData.getRookY(),
                                                 testData.getBishopX(), testData.getBishopY()));
    }
}
