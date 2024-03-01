
package com.example.chess;

import org.junit.Test;
import static org.junit.Assert.*;

public class RookTest {
    @Test
    public void testCanAttack() {
        Rook rook = new Rook();
        assertTrue(rook.canAttack(1, 1, 1, 8)); 
        assertTrue(rook.canAttack(1, 1, 8, 1)); 
        assertFalse(rook.canAttack(1, 1, 2, 3)); 
    }
}
