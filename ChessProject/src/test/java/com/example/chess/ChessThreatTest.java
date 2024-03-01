package com.example.chess;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChessThreatTest {
    @Test
    public void testIsKingUnderThreat_RookAttack() {
        ChessThreat chessThreat = new ChessThreat();

        assertTrue(chessThreat.isKingUnderThreat(4, 4, 4, 8, 8, 1));
        assertTrue(chessThreat.isKingUnderThreat(4, 4, 8, 4, 1, 1));
        assertTrue(chessThreat.isKingUnderThreat(4, 4, 2, 2, 6, 6));
    }

    @Test
    public void testIsKingUnderThreat_RookBishopBlock() {
        ChessThreat chessThreat = new ChessThreat();
        assertFalse(chessThreat.isKingUnderThreat(4, 4, 5, 8, 6, 7));
    }
}