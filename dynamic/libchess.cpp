#include <iostream>
#include <cmath>
#include <cstdlib>
using namespace std;

class ChessBoard {
private:
    int xK, yK; // Координаты короля
    int xL, yL; // Координаты ладьи
    int xS, yS; // Координаты слона

public:
    ChessBoard();

    void inputCoordinates();
    bool isRookThreatening() const;
    bool isBishopThreatening() const;
    bool isKingUnderThreat() const;
    void printThreatStatus() const;
};

ChessBoard::ChessBoard() {

}

void ChessBoard::inputCoordinates(int argc, char* argv[]) {
    xK = atoi(argv[1]);
    yK = atoi(argv[2]);
    xL = atoi(argv[3]);
    yL = atoi(argv[4]);
    xS = atoi(argv[5]);
    yS = atoi(argv[6]);
}

bool ChessBoard::isRookThreatening() const {
    if (xK == xL) {
	    if (xK==xS){
	        if (yS>min(yK,yL) and yS < max(yK,yL)){
	            return false;
            }
            else {return true;}
        }
    }
    else if (yK == yL) {
        if (yK==yS){
           if (xS>min(xK,xL) and xS < max(xK,xL)){
              return false;
            }
            else {return true;}
        }
    }
    else {return false;}
    return false;
}

bool ChessBoard::isBishopThreatening() const {
    if (abs(xK - xS) == abs(yK - yS)){
        if (xL <= min(xK,xS) || xL >= max(xK,xS) || yL <= min(yK,yS) || yL >= max(yK,yL)) {
            return true;
        }
        else if (abs(xK - xL) == abs(yK - yL)) {
            return false;
        }
        else { return true;}
    }
    else { return false;}
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
