
package com.example.chess;

public class Rook extends ChessPiece {
    @Override
    public boolean canAttack(int x1, int y1, int x2, int y2) {
        return x1 == x2 || y1 == y2;
    }
}
