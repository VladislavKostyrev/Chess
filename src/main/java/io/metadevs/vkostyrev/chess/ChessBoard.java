package io.metadevs.vkostyrev.chess;

public class ChessBoard {
    static ChessPiece[][] chessBoard = new ChessPiece[8][8];

    public static void assembleChessBoard() {

        //TODO зачем эти громоздкие конструкции? поменять на конструктор и ввод полей

        chessBoard[0][0] = new Rook();
        chessBoard[0][1] = new Knight();
        chessBoard[0][2] = new Bishop();
        chessBoard[0][3] = new Queen();
        chessBoard[0][4] = new King();
        chessBoard[0][5] = new Bishop();
        chessBoard[0][6] = new Knight();
        chessBoard[0][7] = new Rook();
        chessBoard[0][0].colour = 'b';
        chessBoard[0][1].colour = 'b';
        chessBoard[0][2].colour = 'b';
        chessBoard[0][3].colour = 'b';
        chessBoard[0][5].colour = 'b';
        chessBoard[0][6].colour = 'b';
        chessBoard[0][7].colour = 'b';
        chessBoard[0][0].pieceIcon = " ♖ ║";
        chessBoard[0][1].pieceIcon = " ▱ ║";
        chessBoard[0][2].pieceIcon = " ♗ ║";
        chessBoard[0][3].pieceIcon = " ♕ ║";
        chessBoard[0][4].pieceIcon = " ♔ ║";
        chessBoard[0][5].pieceIcon = " ♗ ║";
        chessBoard[0][6].pieceIcon = " ▱ ║";
        chessBoard[0][7].pieceIcon = " ♖ ║";

        chessBoard[1][0] = new Pawn();
        chessBoard[1][1] = new Pawn();
        chessBoard[1][2] = new Pawn();
        chessBoard[1][3] = new Pawn();
        chessBoard[1][4] = new Pawn();
        chessBoard[1][5] = new Pawn();
        chessBoard[1][6] = new Pawn();
        chessBoard[1][7] = new Pawn();
        chessBoard[1][0].colour = 'b';
        chessBoard[1][1].colour = 'b';
        chessBoard[1][2].colour = 'b';
        chessBoard[1][3].colour = 'b';
        chessBoard[1][4].colour = 'b';
        chessBoard[1][5].colour = 'b';
        chessBoard[1][6].colour = 'b';
        chessBoard[1][7].colour = 'b';
        chessBoard[1][0].pieceIcon = " ♙ ║";
        chessBoard[1][1].pieceIcon = " ♙ ║";
        chessBoard[1][2].pieceIcon = " ♙ ║";
        chessBoard[1][3].pieceIcon = " ♙ ║";
        chessBoard[1][4].pieceIcon = " ♙ ║";
        chessBoard[1][5].pieceIcon = " ♙ ║";
        chessBoard[1][6].pieceIcon = " ♙ ║";
        chessBoard[1][7].pieceIcon = " ♙ ║";

        //TODO можно ли сделать всего один объект и везде вставлять на него ссылку?

        chessBoard[2][0] = new EmptySquare(" 　 ║");
        chessBoard[2][1] = new EmptySquare(" 　 ║");
        chessBoard[2][2] = new EmptySquare(" 　 ║");
        chessBoard[2][3] = new EmptySquare(" 　 ║");
        chessBoard[2][4] = new EmptySquare(" 　 ║");
        chessBoard[2][5] = new EmptySquare(" 　 ║");
        chessBoard[2][6] = new EmptySquare(" 　 ║");
        chessBoard[2][7] = new EmptySquare(" 　 ║");
        chessBoard[3][0] = new EmptySquare(" 　 ║");
        chessBoard[3][1] = new EmptySquare(" 　 ║");
        chessBoard[3][2] = new EmptySquare(" 　 ║");
        chessBoard[3][3] = new EmptySquare(" 　 ║");
        chessBoard[3][4] = new EmptySquare(" 　 ║");
        chessBoard[3][5] = new EmptySquare(" 　 ║");
        chessBoard[3][6] = new EmptySquare(" 　 ║");
        chessBoard[3][7] = new EmptySquare(" 　 ║");
        chessBoard[4][0] = new EmptySquare(" 　 ║");
        chessBoard[4][1] = new EmptySquare(" 　 ║");
        chessBoard[4][2] = new EmptySquare(" 　 ║");
        chessBoard[4][3] = new EmptySquare(" 　 ║");
        chessBoard[4][4] = new EmptySquare(" 　 ║");
        chessBoard[4][5] = new EmptySquare(" 　 ║");
        chessBoard[4][6] = new EmptySquare(" 　 ║");
        chessBoard[4][7] = new EmptySquare(" 　 ║");
        chessBoard[5][0] = new EmptySquare(" 　 ║");
        chessBoard[5][1] = new EmptySquare(" 　 ║");
        chessBoard[5][2] = new EmptySquare(" 　 ║");
        chessBoard[5][3] = new EmptySquare(" 　 ║");
        chessBoard[5][4] = new EmptySquare(" 　 ║");
        chessBoard[5][5] = new EmptySquare(" 　 ║");
        chessBoard[5][6] = new EmptySquare(" 　 ║");
        chessBoard[5][7] = new EmptySquare(" 　 ║");

        chessBoard[6][0] = new Pawn();
        chessBoard[6][1] = new Pawn();
        chessBoard[6][2] = new Pawn();
        chessBoard[6][3] = new Pawn();
        chessBoard[6][4] = new Pawn();
        chessBoard[6][5] = new Pawn();
        chessBoard[6][6] = new Pawn();
        chessBoard[6][7] = new Pawn();
        chessBoard[6][0].colour = 'w';
        chessBoard[6][1].colour = 'w';
        chessBoard[6][2].colour = 'w';
        chessBoard[6][3].colour = 'w';
        chessBoard[6][4].colour = 'w';
        chessBoard[6][5].colour = 'w';
        chessBoard[6][6].colour = 'w';
        chessBoard[6][7].colour = 'w';
        chessBoard[6][0].pieceIcon = " ♟ ║";
        chessBoard[6][1].pieceIcon = " ♟ ║";
        chessBoard[6][2].pieceIcon = " ♟ ║";
        chessBoard[6][3].pieceIcon = " ♟ ║";
        chessBoard[6][4].pieceIcon = " ♟ ║";
        chessBoard[6][5].pieceIcon = " ♟ ║";
        chessBoard[6][6].pieceIcon = " ♟ ║";
        chessBoard[6][7].pieceIcon = " ♟ ║";

        chessBoard[7][0] = new Rook();
        chessBoard[7][1] = new Knight();
        chessBoard[7][2] = new Bishop();
        chessBoard[7][3] = new Queen();
        chessBoard[7][4] = new King();
        chessBoard[7][5] = new Bishop();
        chessBoard[7][6] = new Knight();
        chessBoard[7][7] = new Rook();
        chessBoard[7][0].colour = 'w';
        chessBoard[7][1].colour = 'w';
        chessBoard[7][2].colour = 'w';
        chessBoard[7][3].colour = 'w';
        chessBoard[7][4].colour = 'w';
        chessBoard[7][5].colour = 'w';
        chessBoard[7][6].colour = 'w';
        chessBoard[7][7].colour = 'w';
        chessBoard[7][0].pieceIcon = " ♜ ║";
        chessBoard[7][1].pieceIcon = " ♞ ║";
        chessBoard[7][2].pieceIcon = " ♝ ║";
        chessBoard[7][3].pieceIcon = " ♛ ║";
        chessBoard[7][4].pieceIcon = " ♚ ║";
        chessBoard[7][5].pieceIcon = " ♝ ║";
        chessBoard[7][6].pieceIcon = " ♞ ║";
        chessBoard[7][7].pieceIcon = " ♜ ║";
    }

    public void getIndexPiece() {
        //TODO что это? удалить?
    }

    public static void printChessBoard () {
        System.out.print(" ╔════════════════════════════════════╗");

        for (int i = 0, j = 8; i < 8; i++, j--) {
            System.out.print("\n" + j + "║");
            for (int k = 0; k < 8; k++) {
                System.out.print(chessBoard[i][k].pieceIcon);
            }
            if (i < 7)
                System.out.print("\n ║════════════════════════════════════║");
        }

        System.out.println("\n ╚════════════════════════════════════╝");
        System.out.println("   A    B    C   D    E    F   G    H");
    }
}