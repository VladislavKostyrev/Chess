package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.ChessBoard.printChessBoard;

public class Main {
    public static void main(String[] args) {
        GameLogic.startGame();
        EmptySquare emptySquare = new EmptySquare("R");
    }
}