#include "libchess.h"
using namespace std;

int main() {
    ChessBoard chessBoard;
    chessBoard.inputCoordinates();
    chessBoard.printThreatStatus();

    return 0;
}
