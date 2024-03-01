
package com.example.chess;

public class Main {
    public static void main(String[] args) {
        ChessThreat chessThreat = new ChessThreat();

        int kingX = 4, kingY = 4;
        int rookX = 4, rookY = 8;
        int bishopX = 8, bishopY = 8;

        boolean kingUnderThreat = chessThreat.isKingUnderThreat(kingX, kingY, rookX, rookY, bishopX, bishopY);
        if (kingUnderThreat) {
            System.out.println("King is under threat!");
        } else {
            System.out.println("King is not under threat.");
        }
    }
}
