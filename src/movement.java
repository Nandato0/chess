public class movement {


    public static void movefigure(int[][] board, int qRow, int qCol, int zRow, int zCol) {
        board[zRow][zCol] = board[qRow][qCol];
        board[qRow][qCol] = 0;
    }

}
