package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.*;
import static io.metadevs.vkostyrev.chess.GameLogic.*;

public class Rook extends ChessPiece {
    Rook(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkCanPieceMove() {
        checkCanPieceWalkThat();
        checkThereObstacleAlongPath();
    }

    @Override
    public void checkCanPieceWalkThat() {
        if ((this.col != squareForMove.col) && (this.row != squareForMove.row)) {
            System.out.println("Эта фигура не может так ходить.");
            isActionCorrect = false;
        }
    }

    @Override
    public void checkThereObstacleAlongPath() {
        if (isForwardPath()) {
            checkThereObstacleForwardPath();
        }
        if (isBackPath()) {
            checkThereObstacleBackPath();
        }
        if (isLeftPath()) {
            checkThereObstacleLeftPath();
        }
        if (isRightPath()) {
            checkThereObstacleRightPath();
        }
    }

    private boolean isForwardPath() {
        return this.col == squareForMove.col && this.row > squareForMove.row;
    }

    private boolean isBackPath() {
        return this.col == squareForMove.col && this.row < squareForMove.row;
    }

    private boolean isLeftPath() {
        return this.col > squareForMove.col && this.row == squareForMove.row;
    }

    private boolean isRightPath() {
        return this.col < squareForMove.col && this.row == squareForMove.row;
    }

    private void checkThereObstacleForwardPath() {
        for (int row = this.row - 1; row > squareForMove.row; row--) {
            if (!(chessBoard[row][this.col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkThereObstacleBackPath() {
        for (int row = this.row + 1; row < squareForMove.row; row++) {
            if (!(chessBoard[row][this.col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkThereObstacleLeftPath() {
        for (int col = this.col - 1; col > squareForMove.col; col--) {
            if (!(chessBoard[this.row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkThereObstacleRightPath() {
        for (int col = this.col + 1; col < squareForMove.col; col++) {
            if (!(chessBoard[this.row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }
}