import java.util.Scanner;

public class ChessBoard {

    private int xK, yK;
    private int xL, yL;
    private int xS, yS;

    public ChessBoard() {
    }

    public void inputCoordinates() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите координаты короля (1-8): ");
            xK = scanner.nextInt();
            yK = scanner.nextInt();
        } while (xK < 1 || xK > 8 || yK < 1 || yK > 8);

        do {
            System.out.print("Введите координаты ладьи (1-8): ");
            xL = scanner.nextInt();
            yL = scanner.nextInt();
        } while (xL < 1 || xL > 8 || yL < 1 || yL > 8 || (xK != xL && yK != yL));

        do {
            System.out.print("Введите координаты слона (1-8): ");
            xS = scanner.nextInt();
            yS = scanner.nextInt();
        } while (xS < 1 || xS > 8 || yS < 1 || yS > 8 || (xK != xS && yK != yS) || (xL != xS && yL != yS));
    }

    public boolean isRookThreatening() const {
        if (xK == xL) {
            if (xK == xS) {
                if (yS > Math.min(yK, yL) && yS < Math.max(yK, yL)) {
                    return false;
                } else {
                    return true;
                }
            }
        } else if (yK == yL) {
            if (yK == yS) {
                if (xS > Math.min(xK, xL) && xS < Math.max(xK, xL)) {
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

    public boolean isBishopThreatening() const {
        if (Math.abs(xK - xS) == Math.abs(yK - yS)) {
            if (xL <= Math.min(xK, xS) || xL >= Math.max(xK, xS) || yL <= Math.min(yK, yS) || yL >= Math.max(yK, yL)) {
                return true;
            } else if (Math.abs(xK - xL) == Math.abs(yK - yL)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean isKingUnderThreat() const {
        return isRookThreatening() && isBishopThreatening();
    }

    public void printThreatStatus() const {
        if (isKingUnderThreat()) {
            System.out.println("Королю угрожают слон и ладья");
        } else if (isRookThreatening()) {
            System.out.println("Королю угрожает ладья");
        } else if (isBishopThreatening()) {
            System.out.println("Королю угрожает слон");
        } else {
            System.out.println("Король не находится под угрозой");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.inputCoordinates();
        board.printThreatStatus();
    }
}