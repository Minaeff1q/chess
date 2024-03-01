
package com.example.chess;

public class ChessThreat {
    private final Rook rook;
    private final Bishop bishop;

    public ChessThreat() {
        this.rook = new Rook();
        this.bishop = new Bishop();
    }

    public boolean isKingUnderThreat(int kingX, int kingY, int rookX, int rookY, int bishopX, int bishopY) {

        if (rook.canAttack(kingX, kingY, rookX, rookY)) {
            return true;
        }

        if (bishop.canAttack(kingX, kingY, bishopX, bishopY)) {
            return true;
        }

        if (rookX != bishopX && rookY != bishopY) {
            return false;
        }

        if (rookX == bishopX) {
            if (Math.abs(bishopY - kingY) < Math.abs(rookY - kingY)) {
                return true;
            }
        }

        if (rookY == bishopY) {
            if (Math.abs(bishopX - kingX) < Math.abs(rookX - kingX)) {
                return true;
            }
        }

        return false;
    }
}
