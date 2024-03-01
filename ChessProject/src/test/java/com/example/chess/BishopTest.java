
package com.example.chess;

import org.junit.Test;
import static org.junit.Assert.*;

public class BishopTest {
    @Test
    public void testCanAttack() {
        Bishop bishop = new Bishop();
        assertTrue(bishop.canAttack(1, 1, 8, 8)); 
        assertTrue(bishop.canAttack(8, 1, 1, 8)); 
        assertFalse(bishop.canAttack(1, 1, 2, 3)); 
    }
}
