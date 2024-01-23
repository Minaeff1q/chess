#include <iostream>
#include "libchess.h"
using namespace std;

int main() {
    cout << "Введите координаты короля: " << endl;
    int xK, yK;
    cin >> xK >> yK;

    cout << "Введите координаты ладьи: " << endl;
    int xL, yL;
    cin >> xL >> yL;

    cout << "Введите координаты слона: " << endl;
    int xS, yS;
    cin >> xS >> yS;

    if (vse(xK, yK, xL, yL, xS, yS)) {
        cout << "Королю угрожают слон и ладья" << endl;
    } else if (lagya(xK, yK, xL, yL)) {
        cout << "Королю угрожает ладья" << endl;
    } else if (slon(xK, yK, xS, yS)) {
        cout << "Королю угрожает слон" << endl;
    } else {
        cout << "Король не находится под угрозой" << endl;
    }

    return 0;
}
