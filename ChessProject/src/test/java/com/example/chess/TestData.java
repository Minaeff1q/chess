public class TestData {
    private int kingX;
    private int kingY;
    private int rookX;
    private int rookY;
    private int bishopX;
    private int bishopY;
    private String result;

    public TestData(int kingX, int kingY, int rookX, int rookY , int bishopX, int bishopY, String result) {
        this.kingX = kingX;
        this.kingY = kingY;
        this.rookX = rookX;
        this.rookY = rookY;
        this.bishopX = bishopX;
        this.bishopY = bishopY;
        this.result = result;
    }

//     // Геттеры, необходимые для доступа к полям из QueenTest
//     public int getX1() { return x1; }
//     public int getY1() { return y1; }
//     // ... остальные геттеры 
//     public String getExpectedResult() { return result; }
}