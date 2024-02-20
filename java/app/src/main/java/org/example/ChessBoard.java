import java.util.Scanner;

public class ChessBoard {
    private int xK, yK; // Coordinates of the king
    private int xL, yL; // Coordinates of the rook
    private int xS, yS; // Coordinates of the bishop

    public ChessBoard() {
    }

    public void inputCoordinates() {
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("Enter the coordinates of the king (1-8): ");
            xK = scanner.nextInt();
            yK = scanner.nextInt();
        } while (xK < 1 || xK > 8 || yK < 1 || yK > 8);

        do {
            System.out.println("Enter the coordinates of the rook (1-8): ");
            xL = scanner.nextInt();
            yL = scanner.nextInt();
        } while (xL < 1 || xL > 8 || yL < 1 || yL > 8 || (xK != xL && yK != yL));

        do {
            System.out.println("Enter the coordinates of the bishop (1-8): ");
            xS = scanner.nextInt();
            yS = scanner.nextInt();
        } while (xS < 1 || xS > 8 || yS < 1 || yS > 8 || (xK != xS && yK != yS) || (xL != xS && yL != yS));
    }

    public boolean isRookThreatening() {
        return (xK == xL || yK == yL) && !(Math.min(xK, xL) < xS && xS < Math.max(xK, xL) && Math.min(yK, yL) < yS && yS < Math.max(yK, yL));
    }

    public boolean isBishopThreatening() {
        return Math.abs(xK - xS) == Math.abs(yK - yS) && !(xL >= Math.min(xK, xS) && xL <= Math.max(xK, xS) && yL >= Math.min(yK, yS) && yL <= Math.max(yK, yS));
    }

    public boolean isKingUnderThreat() {
        return isRookThreatening() || isBishopThreatening();
    }

    public void printThreatStatus() {
        if (isKingUnderThreat()) {
            System.out.println("Both the rook and the bishop threaten the king.");
        } else if (isRookThreatening()) {
            System.out.println("The king is threatened by the rook.");
        } else if (isBishopThreatening()) {
            System.out.println("The king is threatened by the bishop.");
        } else {
            System.out.println("The king is not under threat.");
        }
    }

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.inputCoordinates();
        chessBoard.printThreatStatus();
    }
}