#include "libchess.h"
#include <cmath>
bool lagya(int xK, int yK, int xL, int yL) {
    return xK == xL || yK == yL;
}

bool slon(int xK, int yK, int xS, int yS) {
    return abs(xK - xS) == abs(yK - yS);
}

bool vse(int xK, int yK, int xL, int yL, int xS, int yS) {
    return lagya(xK, yK, xL, yL) && slon(xK, yK, xS, yS);
}

