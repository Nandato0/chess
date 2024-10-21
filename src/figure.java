public class figure {
    /*public static int wRook = 1;
    public static int wKnight = 2;
    public static int wBishop = 3;
    public static int wQueen = 4;
    public static int wKing = 5;
    public static int wPawn = 6;

    public static int bRook = 7;
    public static int bKnight = 8;
    public static int bBishop = 9;
    public static int bQueen = 10;
    public static int bKing = 11;
    public static int bPawn = 12;*/

    public static class Rook {
        int wRook = 1;
        int bRook = 7;

        public static boolean rookMovementAllowed(int qRow, int qCol, int zRow, int zCol, int[][] board) {
            if (qCol != zCol && qRow != zRow) {
                return false;
            }
            if (qCol == zCol) {
                if (qRow < zRow) {                                  // nach unten
                    for (int row = qRow + 1; row < zRow + 1; row++) {
                        if (board[row][qCol] != 0) {
                            return false;
                        }
                    }
                } else if (qRow > zRow){                            //nach oben
                    for (int row = qRow - 1; row > zRow + 1; row--) {
                        if (board[row][qCol] != 0) {
                            return false;
                        }
                    }
                }
            }
            else if (qRow == zRow) {
                if (qCol < zCol) {                                  //nach rechts
                    for (int col = qCol + 1; col < zCol + 1; col++) {
                        if (board[qRow][col] != 0) {
                            return false;
                        }
                    }
                }
                else if (qCol > zCol) {                             //nach links
                    for (int col = qCol - 1; col > zCol + 1; col--) {
                        if (board[qRow][col] != 0) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    public static class Knight {
        int wKnight = 2;
        int bKnight = 8;

    }
    public static class Bishop {
        int wBishop = 3;
        int bBishop = 9;
    }
    public static class Queen {
        int wQueen = 4;
        int bQueen = 10;
    }
    public static class King {
        int wKing = 5;
        int bKing = 11;
    }
    public static class Pawn {
        int wPawn = 6;
        int bPawn = 12;
    }
}
