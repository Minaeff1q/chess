#ifndef LIBCHESS_H
#define LIBCHESS_H

class ChessBoard {
private:
    int xK, yK; // Координаты короля
    int xL, yL; // Координаты ладьи
    int xS, yS; // Координаты слона

public:
    ChessBoard();

    void setCoordinates(int xK, int yK, int xL, int yL, int xS, int yS);
    bool isRookThreatening() const;
    bool isBishopThreatening() const;
    bool isKingUnderThreat() const;
    void printThreatStatus() const;
};

#endif
