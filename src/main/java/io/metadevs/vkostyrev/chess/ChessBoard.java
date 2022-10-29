package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.GameLogic.*;

public class ChessBoard {
    public static ChessPiece[][] chessBoard = new ChessPiece[8][8];

    public static void assembleChessBoard() {
        win = false;
        walkingColour = 'w';
        countGameSteps = 0;

        chessBoard[0][0] = new Rook(0, 0, 'b', " ♖ ║");
        chessBoard[0][1] = new Knight(0,1, 'b', " ▱ ║");
        chessBoard[0][2] = new Bishop(0,2,'b', " ♗ ║");
        chessBoard[0][3] = new Queen(0,3,'b', " ♕ ║");
        chessBoard[0][4] = new King(0,4,'b', " ♔ ║");
        chessBoard[0][5] = new Bishop(0,5,'b', " ♗ ║");
        chessBoard[0][6] = new Knight(0,6,'b', " ▱ ║");
//        chessBoard[0][7] = new Rook(0,7,'b', " ♖ ║");
        chessBoard[0][7] = new EmptySquare(0,7, " 　 ║");

        chessBoard[1][0] = new Pawn(1,0,'b', " ♙ ║");
        chessBoard[1][1] = new Pawn(1,1,'b', " ♙ ║");
        chessBoard[1][2] = new Pawn(1,2,'b', " ♙ ║");
        chessBoard[1][3] = new Pawn(1,3,'b', " ♙ ║");
        chessBoard[1][4] = new Pawn(1,4,'b', " ♙ ║");
        chessBoard[1][5] = new Pawn(1,5,'b', " ♙ ║");
//        chessBoard[1][6] = new Pawn(1,6,'b', " ♙ ║");

//        chessBoard[1][7] = new Pawn(1,7,'b', " ♙ ║");
        chessBoard[1][7] = new Pawn(1,7,'w', " ♟ ║");

        chessBoard[1][6] = new EmptySquare(1,6, " 　 ║");

        chessBoard[2][0] = new EmptySquare(2, 0," 　 ║");
        chessBoard[2][1] = new EmptySquare(2, 1," 　 ║");
        chessBoard[2][2] = new EmptySquare(2, 2," 　 ║");
        chessBoard[2][3] = new EmptySquare(2, 3," 　 ║");
        chessBoard[2][4] = new EmptySquare(2, 4," 　 ║");
        chessBoard[2][5] = new EmptySquare(2, 5," 　 ║");

//        chessBoard[2][6] = new EmptySquare(2, 6," 　 ║");
        chessBoard[2][6] = new Pawn(2, 6,'b'," ♙ ║");

        chessBoard[2][7] = new EmptySquare(2, 7," 　 ║");
        chessBoard[3][0] = new EmptySquare(3, 0," 　 ║");
        chessBoard[3][1] = new EmptySquare(3, 1," 　 ║");
        chessBoard[3][2] = new EmptySquare(3, 2," 　 ║");

        chessBoard[3][3] = new EmptySquare(3, 3," 　 ║");
//        chessBoard[3][3] = new Pawn(3,3,'w', " ♟ ║");

        chessBoard[3][4] = new EmptySquare(3, 4," 　 ║");
//        chessBoard[3][4] = new Pawn(3,4,'w', " ♟ ║");

//        chessBoard[3][5] = new EmptySquare(3, 5," 　 ║");
        chessBoard[3][5] = new Pawn(3, 5,'b'," ♙ ║");


        chessBoard[3][6] = new EmptySquare(3, 6," 　 ║");
        chessBoard[3][7] = new EmptySquare(3, 7," 　 ║");
        chessBoard[4][0] = new EmptySquare(4, 0," 　 ║");
        chessBoard[4][1] = new EmptySquare(4, 1," 　 ║");
        chessBoard[4][2] = new EmptySquare(4, 2," 　 ║");

//        chessBoard[4][3] = new EmptySquare(4, 3," 　 ║");
        chessBoard[4][3] = new Bishop(4, 3,'w'," ♝ ║");
//        chessBoard[4][3] = new Pawn(4,3,'w', " ♟ ║");

//        chessBoard[4][4] = new EmptySquare(4, 4," 　 ║");
        chessBoard[4][4] = new King(4,4,'w', " ♚ ║");


//        chessBoard[4][5] = new EmptySquare(4, 5," 　 ║");
        chessBoard[4][5] = new Bishop(4,5,'w', " ♝ ║");

        chessBoard[4][6] = new EmptySquare(4, 6," 　 ║");
        chessBoard[4][7] = new EmptySquare(4, 7," 　 ║");
        chessBoard[5][0] = new EmptySquare(5, 0," 　 ║");
        chessBoard[5][1] = new EmptySquare(5, 1," 　 ║");
        chessBoard[5][2] = new EmptySquare(5, 2," 　 ║");

        chessBoard[5][3] = new EmptySquare(5, 3," 　 ║");
//        chessBoard[5][3] = new Pawn(5,3,'w', " ♟ ║");

        chessBoard[5][4] = new EmptySquare(5, 4," 　 ║");

        chessBoard[5][5] = new EmptySquare(5, 5," 　 ║");
//        chessBoard[5][5] = new Pawn(5,5,'w', " ♟ ║");

        chessBoard[5][6] = new EmptySquare(5, 6," 　 ║");
        chessBoard[5][7] = new EmptySquare(5, 7," 　 ║");

        chessBoard[6][0] = new Pawn(6,0,'w', " ♟ ║");
        chessBoard[6][1] = new Pawn(6,1,'w', " ♟ ║");
        chessBoard[6][2] = new Pawn(6,2,'w', " ♟ ║");
        chessBoard[6][3] = new Pawn(6,3,'w', " ♟ ║");
        chessBoard[6][4] = new Pawn(6,4,'w', " ♟ ║");
        chessBoard[6][5] = new Pawn(6,5,'w', " ♟ ║");
        chessBoard[6][6] = new Pawn(6,6,'w', " ♟ ║");
        chessBoard[6][7] = new Pawn(6,7,'w', " ♟ ║");

        chessBoard[7][0] = new Rook(7,0,'w', " ♜ ║");
        chessBoard[7][1] = new Knight(7,1,'w', " ♞ ║");
        chessBoard[7][2] = new Bishop(7,2,'w', " ♝ ║");
        chessBoard[7][3] = new Queen(7,3,'w', " ♛ ║");
        chessBoard[7][4] = new King(7,4,'w', " ♚ ║");
        chessBoard[7][5] = new Bishop(7,5,'w', " ♝ ║");
        chessBoard[7][6] = new Knight(7,6,'w', " ♞ ║");
        chessBoard[7][7] = new Rook(7,7,'w', " ♜ ║");

    }



    public void getFirstIndexPiece(ChessPiece chessPiece) {
        //TODO что это? удалить?
    }

    public static void showChessBoard() {
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

    public static void printAllPieces() {      //TODO удалить в конце
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println(chessBoard[i][j].pieceIcon + " " + chessBoard[i][j].row + "." + chessBoard[i][j].col + " " + i + "." + j);
            }
        }
    }
}