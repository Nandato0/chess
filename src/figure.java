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
                if (board[zRow][zCol] != 0) {
                    moveAllowed = false;
                }
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
                    if (board[zRow][zCol] == 0) {
                        movement.movefigure(board, qRow, qCol, zRow, zCol);
                    }
                }
            }
        }
    }
    public static class Bishop {
        static int wBishop = 3;
        static int bBishop = 9;

        public static void bishopMovementAllowed(int qRow, int qCol, int zRow, int zCol, int[][]board) {
            boolean moveallowed = false;
            if (board[qRow][qCol] == wBishop || board[qRow][qCol] == bBishop || board[qRow][qCol] == Queen.wQueen || board[qRow][qCol] == Queen.bQueen) {
                int differenceRow = Math.abs(qRow - zRow);
                int differenceCol = Math.abs(qCol - zCol);
                if (differenceRow == differenceCol) {
                    moveallowed = zRow == qRow - differenceRow && zCol == qCol - differenceRow ||
                            zRow == qRow - differenceRow && zCol == qCol + differenceCol ||
                            zRow == qRow + differenceRow && zCol == qCol - differenceRow ||
                            zRow == qRow + differenceCol && zCol == qCol + differenceCol;
                }
            }
            if (moveallowed) {
                if (board[zRow][zCol] == 0) {
                    movement.movefigure(board, qRow, qCol, zRow, zCol);
                }
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

        public static void wPawn(int qRow, int qCol, int zRow, int zCol, int [][] board) {
            boolean moveallowed = false;
            if (board[qRow][qCol] == wPawn) {
                moveallowed = zRow == qRow - 1 && zCol == 0;
            }
            if (moveallowed) {
                movement.movefigure(board, qRow, qCol, zRow, zCol);
            }
        }

        public static void bPawn(int qRow, int qCol, int zRow, int zCol, int [][] board) {

        }

    }


}
