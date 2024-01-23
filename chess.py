def lagya(xK, yK, xL, yL):
    return xK == xL or yK == yL


def slon(xK, yK, xS, yS):
    return abs(xK - xS) == abs(yK - yS)


def vse(xK, yK, xL, yL, xS, yS):
    return lagya(xK, yK, xL, yL) and slon(xK, yK, xS, yS)

print('введите кооридинаты короля: ')
xK = int(input())
yK = int(input())
print('введите кооридинаты ладьи: ')
xL = int(input())
yL = int(input())
print('введите кооридинаты слона: ')
xS = int(input())
yS = int(input())

if vse(xK, yK, xL, yL, xS, yS):
    print('королю угрожают слон и ладья')
elif lagya(xK, yK, xL, yL):
    print('королю угрожает ладья ')
elif slon(xK, yK, xS, yS):
    print('королю угрожает слон ')
else:
    print('король не находится под угрозой')