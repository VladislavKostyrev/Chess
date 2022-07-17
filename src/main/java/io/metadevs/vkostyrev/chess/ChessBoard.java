package io.metadevs.vkostyrev.chess;

public class ChessBoard {
    static ChessPiece[][] chessBoard = new ChessPiece[8][8];

    public void assembleChessBoard() {
        chessBoard[0][0] = new Pawn();
        chessBoard[0][1] = new Pawn();
        chessBoard[0][2] = new Pawn();
        chessBoard[0][3] = new Pawn();
        chessBoard[0][4] = new Pawn();
        chessBoard[0][5] = new Pawn();
        chessBoard[0][6] = new Pawn();
        chessBoard[0][7] = new Pawn();

        chessBoard[1][0] = new Pawn();
        chessBoard[1][1] = new Pawn();
        chessBoard[1][2] = new Pawn();
        chessBoard[1][3] = new Pawn();
        chessBoard[1][4] = new Pawn();
        chessBoard[1][5] = new Pawn();
        chessBoard[1][6] = new Pawn();
        chessBoard[1][7] = new Pawn();

        chessBoard[2][0] = null;
        chessBoard[2][1] = null;
        chessBoard[2][2] = null;
        chessBoard[2][3] = null;
        chessBoard[2][4] = null;
        chessBoard[2][5] = null;
        chessBoard[2][6] = null;
        chessBoard[2][7] = null;
        chessBoard[3][0] = null;
        chessBoard[3][1] = null;
        chessBoard[3][2] = null;
        chessBoard[3][3] = null;
        chessBoard[3][4] = null;
        chessBoard[3][5] = null;
        chessBoard[3][6] = null;
        chessBoard[3][7] = null;
        chessBoard[4][0] = null;
        chessBoard[4][1] = null;
        chessBoard[4][2] = null;
        chessBoard[4][3] = null;
        chessBoard[4][4] = null;
        chessBoard[4][5] = null;
        chessBoard[4][6] = null;
        chessBoard[4][7] = null;
        chessBoard[5][0] = null;
        chessBoard[5][1] = null;
        chessBoard[5][2] = null;
        chessBoard[5][3] = null;
        chessBoard[5][4] = null;
        chessBoard[5][5] = null;
        chessBoard[5][6] = null;
        chessBoard[5][7] = null;

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

        chessBoard[7][0] = new Pawn();
        chessBoard[7][1] = new Pawn();
        chessBoard[7][2] = new Pawn();
        chessBoard[7][3] = new Pawn();
        chessBoard[7][4] = new Pawn();
        chessBoard[7][5] = new Pawn();
        chessBoard[7][6] = new Pawn();
        chessBoard[7][7] = new Pawn();
    }
}
