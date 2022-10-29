package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.*;
import static io.metadevs.vkostyrev.chess.GameLogic.*;

public class Rook extends ChessPiece {
    Rook(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkCanPieceMove(ChessPiece squareForMove) {
        checkCanPieceWalkThat(squareForMove);
        checkThereObstacleAlongPath(squareForMove);
    }

    @Override
    public void checkCanPieceWalkThat(ChessPiece squareForMove) {
        if ((this.col != squareForMove.col) && (this.row != squareForMove.row)) {
            System.out.println("Эта фигура не может так ходить.");
            isActionCorrect = false;
        }
    }

    @Override
    public void checkThereObstacleAlongPath(ChessPiece squareForMove) {
        if (this.col == squareForMove.col && this.row > squareForMove.row) {
            checkThereObstacleForwardPath(squareForMove);
        }
        if (this.col == squareForMove.col && this.row < squareForMove.row) {
            checkThereObstacleBackPath(squareForMove);
        }
        if (this.col > squareForMove.col && this.row == squareForMove.row) {
            checkThereObstacleLeftPath(squareForMove);
        }
        if (this.col < squareForMove.col && this.row == squareForMove.row) {
            checkThereObstacleRightPath(squareForMove);
        }
    }

    private void checkThereObstacleForwardPath(ChessPiece squareForMove) {
        for (int i = this.row - 1; i > squareForMove.row; i--) {
            if (!(chessBoard[i][this.col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkThereObstacleBackPath(ChessPiece squareForMove) {
        for (int i = this.row + 1; i < squareForMove.row; i++) {
            if (!(chessBoard[i][this.col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkThereObstacleLeftPath(ChessPiece squareForMove) {
        for (int i = this.col - 1; i > squareForMove.col; i--) {
            if (!(chessBoard[this.row][i] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkThereObstacleRightPath(ChessPiece squareForMove) {
        for (int i = this.col + 1; i < squareForMove.col; i++) {
            if (!(chessBoard[this.row][i] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }
}