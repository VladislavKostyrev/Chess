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
        if (isForwardPath(squareForMove)) {
            checkThereObstacleForwardPath(squareForMove);
        }
        if (isBackPath(squareForMove)) {
            checkThereObstacleBackPath(squareForMove);
        }
        if (isLeftPath(squareForMove)) {
            checkThereObstacleLeftPath(squareForMove);
        }
        if (isRightPath(squareForMove)) {
            checkThereObstacleRightPath(squareForMove);
        }
    }

    private boolean isForwardPath(ChessPiece squareForMove) {
        return this.col == squareForMove.col && this.row > squareForMove.row;
    }

    private boolean isBackPath(ChessPiece squareForMove) {
        return this.col == squareForMove.col && this.row < squareForMove.row;
    }

    private boolean isLeftPath(ChessPiece squareForMove) {
        return this.col > squareForMove.col && this.row == squareForMove.row;
    }

    private boolean isRightPath(ChessPiece squareForMove) {
        return this.col < squareForMove.col && this.row == squareForMove.row;
    }

    private void checkThereObstacleForwardPath(ChessPiece squareForMove) {
        for (int row = this.row - 1; row > squareForMove.row; row--) {
            if (!(chessBoard[row][this.col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkThereObstacleBackPath(ChessPiece squareForMove) {
        for (int row = this.row + 1; row < squareForMove.row; row++) {
            if (!(chessBoard[row][this.col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkThereObstacleLeftPath(ChessPiece squareForMove) {
        for (int col = this.col - 1; col > squareForMove.col; col--) {
            if (!(chessBoard[this.row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkThereObstacleRightPath(ChessPiece squareForMove) {
        for (int col = this.col + 1; col < squareForMove.col; col++) {
            if (!(chessBoard[this.row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }
}