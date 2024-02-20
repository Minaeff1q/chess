package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChessBoardTest {
    @Test
    public void testIsRookThreatening() {
        ChessBoard board = new ChessBoard();
        board.inputCoordinates();
        assertFalse(board.isRookThreatening());
    }

    @Test
    public void testIsBishopThreatening() {
        ChessBoard board = new ChessBoard();
        board.inputCoordinates();
        assertFalse(board.isBishopThreatening());
    }

    @Test
    public void testIsKingUnderThreat() {
        ChessBoard board = new ChessBoard();
        board.inputCoordinates();
        assertFalse(board.isKingUnderThreat());
    }
}