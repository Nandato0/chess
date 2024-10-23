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
        public static int wRook = 1;
        public static int bRook = 7;

        public static void rookMovementAllowed(int qRow, int qCol, int zRow, int zCol, int[][] board) {
            boolean moveAllowed = true;
            // Überprüfung, ob die Figur eine Dame oder ein Turm ist
            if (board[qRow][qCol] == wRook || board[qRow][qCol] == bRook || board[qRow][qCol] == Queen.wQueen || board[qRow][qCol] == Queen.bQueen) {
                // Überprüfung, ob die Bewegung horizontal oder vertikal ist
                if (qCol == zCol || qRow == zRow) {
                    // Überprüfung der vertikalen Bewegung
                    if (qCol == zCol && qRow != zRow) {
                        if (qRow < zRow) { // Bewegung nach unten
                            for (int row = qRow + 1; row < zRow; row++) {
                                if (board[row][qCol] != 0) {
                                    moveAllowed = false;
                                    break;
                                }
                            }
                        } else if (qRow > zRow) { // Bewegung nach oben
                            for (int row = qRow - 1; row > zRow; row--) {
                                if (board[row][qCol] != 0) {
                                    moveAllowed = false;
                                    break;
                                }
                            }
                        }
                    }
                    // Überprüfung der horizontalen Bewegung
                    else if (qRow == zRow && qCol != zCol) {
                        if (qCol < zCol) { // Bewegung nach rechts
                            for (int col = qCol + 1; col < zCol; col++) {
                                if (board[qRow][col] != 0) {
                                    moveAllowed = false;
                                    break;
                                }
                            }
                        } else if (qCol > zCol) { // Bewegung nach links
                            for (int col = qCol - 1; col > zCol; col--) {
                                if (board[qRow][col] != 0) {
                                    moveAllowed = false;
                                    break;
                                }
                            }
                        }
                    }
                    // Wenn die Bewegung erlaubt ist, bewege die Figur
                    if (moveAllowed) {
                        movement.movefigure(board, qRow, qCol, zRow, zCol);
                    }
                }
            }
        }

    }

    public static class Knight {
        static int wKnight = 2;
        static int bKnight = 8;

        public static void knightMovementAllowed(int qRow, int qCol,int zRow, int zCol, int[][] board) {
            if (board[qRow][qCol] == wKnight || board[qRow][qCol] == bKnight){
                boolean moveallowed = zRow == qRow + 2 && zCol == qCol + 1 || zRow == qRow + 2 && zCol == qCol - 1 || zRow == qRow - 2 && zCol == qCol - 1 ||
                        zRow == qRow - 2 && zCol == qCol + 1 || zRow == qRow - 1 && zCol == qCol - 2 || zRow == qRow + 1 && zCol == qCol - 2 ||
                        zRow == qRow - 1 && zCol == qCol + 2 || zRow == qRow + 1 && zCol == qCol + 2;

                if (moveallowed) {
                    if (board[qRow][qCol] == wKnight) {
                        if (board[zRow][zCol] == bKnight || board[zRow][zCol] == Queen.bQueen || board[zRow][zCol] == Rook.bRook ||
                                                            board[zRow][zCol] == Bishop.bBishop || board[zRow][zCol] == Pawn.bPawn || board[zRow][zCol] == 0) {
                            movement.movefigure(board, qRow, qCol, zRow, zCol);
                        }
                    }
                }
            }
        }
    }
    public static class Bishop {
        static int wBishop = 3;
        static int bBishop = 9;

        public static void bishopMovementAllowed(int qRow, int qCol, int zRow, int zCol, int[][] board) {
            boolean moveallowed = false;

            // Überprüfung ob die Figur ein Läufer oder eine queen ist
            if (board[qRow][qCol] == wBishop || board[qRow][qCol] == bBishop ||
                    board[qRow][qCol] == Queen.wQueen || board[qRow][qCol] == Queen.bQueen) {

                int differenceRow = zRow - qRow;
                int differenceCol = zCol - qCol;

                // Überprüfe ob die Bewegung diagonal ist
                if (Math.abs(differenceRow) == Math.abs(differenceCol)) {
                    int rowDirection = differenceRow > 0 ? 1 : -1;
                    int colDirection = differenceCol > 0 ? 1 : -1;
                    int steps = Math.abs(differenceRow);

                    // Überprüfe alle Felder zwischen Start und Ziel
                    moveallowed = true;
                    for (int i = 1; i < steps; i++) {
                        if (board[qRow + i * rowDirection][qCol + i * colDirection] != 0) {
                            moveallowed = false;  // Blockiert durch eine Figur
                            break;
                        }
                    }
                }
            }

            // Bewege die Figur, falls erlaubt
            if (moveallowed) {
                movement.movefigure(board, qRow, qCol, zRow, zCol);
            }
        }

    }
    public static class Queen {
        public static int wQueen = 4;
        public static int bQueen = 10;
        public static void queenMovementAllowed(int qRow, int qCol, int zRow, int zCol, int[][]board) {
            if (board[qRow][qCol] == wQueen || board[qRow][qCol] == bQueen) {
                Rook.rookMovementAllowed(qRow, qCol, zRow, zCol, board);
                Bishop.bishopMovementAllowed(qRow, qCol, zRow, zCol, board);
            }
        }
    }
    public static class King {
        public static int wKing = 5;
        public static int bKing = 11;

        public static void kingMovementAllowed(int qRow, int qCol, int zRow, int zCol, int[][] board) {
            boolean moveallowed = false;
            if (board[qRow][qCol] != wKing || board[qRow][qCol] != bKing) {
                moveallowed = zRow == qRow && zCol == qCol + 1 || zRow == qRow && zCol == qCol - 1 ||
                        zCol == qCol && zRow == qRow + 1 || zCol == qCol && zRow == qRow - 1 ||
                        zRow == qRow + 1 && zCol == qCol + 1 || zRow == qRow + 1 && zCol == qCol - 1 ||
                        zRow == qRow - 1 && zCol == qCol + 1 || zRow == qRow - 1 && zCol == qCol - 1;
            }
            if (moveallowed) {
                if (board[zRow][zCol] == 0) {
                    movement.movefigure(board, qRow, qCol, zRow, zCol);
                }
            }


        }
    }
    public static class Pawn {
        public static int wPawn = 6;
        public static int bPawn = 12;

        public static void wPawnMovementAllowed(int qRow, int qCol, int zRow, int zCol, int [][] board) {
            boolean moveallowed = false;
            if (board[qRow][qCol] == wPawn) {           // move nach oben +1 oder +2
                moveallowed = zRow == qRow - 1 && zCol == qCol && board[zRow][zCol] == 0 || zRow == qRow - 2 && zCol == qCol && qRow == 6 && board[zRow][zCol] == 0 ;
            }

            if (moveallowed) {
                movement.movefigure(board, qRow, qCol, zRow, zCol);
            }
        }

        public static void bPawnMovementAllowed(int qRow, int qCol, int zRow, int zCol, int [][] board) {
            boolean moveallowed = false;
            if (board[qRow][qCol] == bPawn) {           // move nach unten +1 oder +2
                moveallowed = zRow == qRow + 1 && zCol == qCol && board[zRow][zCol] == 0 || zRow == qRow + 2 && zCol == qCol && qRow == 1 && board[zRow][zCol] == 0;
            }

            if (moveallowed) {
                movement.movefigure(board, qRow, qCol, zRow, zCol);
            }
        }
    }
}
