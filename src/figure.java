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
        public static boolean rookMovementAllowed(int qRow, int qCol, int zRow, int zCol, int [][] board) {
            int checkUp = 0;
            int checkDown = 0;
            if (qCol == zCol) {
                if (qRow < zRow){                           // wenn es nach unten geht
                    for (int i = 1; i < 8 - qRow; i++) {
                        if (board[qRow + i][qCol] == 0) {
                            checkDown++;
                        }
                    }
                    if (checkDown == zRow - qRow) {
                        return true;
                    }
                }


                if (qRow > zRow){                           // wenn es nach oben geht
                    for (int i = 1; i < qRow + 1; i++) {
                        if (board[qRow - i][qCol] == 0) {
                            checkUp++;
                        }
                    }
                    if (checkUp == qRow - zRow ) {
                        return true;
                    }
                }




            }

            else if (qRow == zRow) {
                if (qCol < zCol) {                           // wenn es nach rechts geht
                    for (int i = 1; i < 8 - qCol; i++) {
                        if (board[qRow][qCol + i] == 0) {
                            checkUp++;
                        }
                    }
                }

                if (qRow > zRow) {                           // wenn es nach links geht
                    for (int i = 1; i < qCol + 1; i++) {
                        if (board[qRow][qCol - i] == 0) {
                            checkDown++;
                        }
                    }
                }
            }
            if (checkUp == qRow - zRow ) {
                return true;
            }

            else if (checkDown == zRow - qRow) {
                return true;
            }
            else {
                return false;
            }
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
