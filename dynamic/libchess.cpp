#include "libchess.h"
#include <iostream>
#include <cmath>
using namespace std;

ChessBoard::ChessBoard() {}

void ChessBoard::setCoordinates(int xK, int yK, int xL, int yL, int xS, int yS) {
    this->xK = xK;
    this->yK = yK;
    this->xL = xL;
    this->yL = yL;
    this->xS = xS;
    this->yS = yS;
}

bool ChessBoard::isRookThreatening() const {
    if (xK == xL) {
        if (xK == xS) {
            if (yS > min(yK, yL) && yS < max(yK, yL)) {
                return false;
            } else {
                return true;
            }
        }
    } else if (yK == yL) {
        if (yK == yS) {
            if (xS > min(xK, xL) && xS < max(xK, xL)) {
                return false;
            } else {
                return true;
            }
        }
    } else {
        return false;
    }
    return false;
}

bool ChessBoard::isBishopThreatening() const {
    if (abs(xK - xS) == abs(yK - yS)) {
        if (xL <= min(xK, xS) || xL >= max(xK, xS) || yL <= min(yK, yS) || yL >= max(yK, yL)) {
            return true;
        } else if (abs(xK - xL) == abs(yK - yL)) {
            return false;
        } else {
            return true;
        }
    } else {
        return false;
    }
}

bool ChessBoard::isKingUnderThreat() const {
    return isRookThreatening() && isBishopThreatening();
}

void ChessBoard::printThreatStatus() const {
    if (isKingUnderThreat()) {
        cout << "Королю угрожают слон и ладья" << endl;
    } else if (isRookThreatening()) {
        cout << "Королю угрожает ладья" << endl;
    } else if (isBishopThreatening()) {
        cout << "Королю угрожает слон" << endl;
    } else {
        cout << "Король не находится под угрозой" << endl;
    }
}
