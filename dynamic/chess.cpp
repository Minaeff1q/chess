#include "libchess.h"
#include <iostream>
#include <cstdlib>

using namespace std;

int main(int argc, char* argv[]) {
    if (argc < 7) {
        cout << "Usage: " << argv[0] << " <xK> <yK> <xL> <yL> <xS> <yS>" << endl;
        return 1;
    }

    int xK = atoi(argv[1]);
    int yK = atoi(argv[2]);
    int xL = atoi(argv[3]);
    int yL = atoi(argv[4]);
    int xS = atoi(argv[5]);
    int yS = atoi(argv[6]);

    ChessBoard chessBoard;
    chessBoard.setCoordinates(xK, yK, xL, yL, xS, yS);
    chessBoard.printThreatStatus();

    return 0;
}
