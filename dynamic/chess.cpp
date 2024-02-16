#include "libchess.h"

int main(int argc, char* argv[]) {
    ChessBoard chessBoard;
    chessBoard.inputCoordinates(argc,argv);
    chessBoard.printThreatStatus();

    return 0;
}
