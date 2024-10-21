public class movement {


    public static void movefigure(int[][] board, int qRow, int qCol, int zRow, int zCol) {
        if (figure.Rook.rookMovementAllowed(qRow, qCol, zRow, zCol, board) == true) {
            board[zRow][zCol] = board[qRow][qCol];
            board[qRow][qCol] = 0;
        }
    }



}

