public class Chess {
    public static void main(String[] args) {
        int [][] chessfield = board.createStartBoard();


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(chessfield[i][j] + "      ");
            }
            System.out.println();
        }
    }

}