public class board {

    public static int[][] createStartBoard() {

        int[][] board = new int[8][8];
        for (int i = 0; i < 1; i++) {       //linke seite von schwarzeseite
            for (int j = 0; j < 5; j++) {
                board[i][j] = 7+j;
            }
        }
        for (int i = 0; i < 1; i++) {       //rechte seite von schwarzeseite
            for (int j = 5; j < 8; j++) {
                board[i][j] = 14-j;
            }
        }
        for (int i = 1; i < 2; i++) {       // schwarze bauern auf schwarze seite
            for (int j = 0; j < 8; j++) {
                board[i][j] = figure.Pawn.bPawn;
            }
        }


        for (int i = 7; i < 8; i++) {       //linke seite von weisseseite
            for (int j = 0; j < 5; j++) {
                board[i][j] = 1+j;
            }
        }
        for (int i = 7; i < 8; i++) {       //rechte seite von weisseseite
            for (int j = 5; j < 8; j++) {
                board[i][j] = 8-j;
            }
        }

        for (int i = 6; i < 7; i++) {       // weiße bauern auf weiße seite
            for (int j = 0; j < 8; j++) {
                board[i][j] = figure.Pawn.wPawn;
            }
        }

        return board;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(createStartBoard()[i][j] + " ");
            }
            System.out.println();
        }
    }

}
