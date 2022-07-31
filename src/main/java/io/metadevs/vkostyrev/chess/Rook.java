package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.*;
import static io.metadevs.vkostyrev.chess.GameLogic.movePiece;
import static io.metadevs.vkostyrev.chess.GameLogic.walkingColour;

public class Rook extends ChessPiece {

    public void checkIsMayPieceWalkThat(ChessPiece squareForMove) {
        if ((!(this.row == squareForMove.row) && (this.col != squareForMove.col))) {
            System.out.println("Эта фигура не может так ходить.");
            movePiece(this);
        }
        if ((!(this.col == squareForMove.col) && (this.row != squareForMove.row))) {
            System.out.println("Эта фигура не может так ходить.");
            movePiece(this);
        }

//        checkIsMayPieceCapture(squareForMove); //&&&&&&&&77777////????
    }



    @Override
    public void isThereObstacleAlongPath(ChessPiece squareForMove) {

    }

    public static void main(String[] args) {
        assembleChessBoard();
        printChessBoard();
    }
}
