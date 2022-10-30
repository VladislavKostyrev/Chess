package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Queen extends ChessPiece {
    Queen(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkCanPieceMove() {
        checkCanPieceWalkThat();
        checkThereObstacleAlongPath();
    }

    @Override
    public void checkCanPieceWalkThat() {
        isActionCorrect = false;

        searchSquareForMoveInVertical();
        searchSquareForMoveInHorizontal();

        searchSquareForMoveInForwardRightPath();
        searchSquareForMoveInForwardLeftPath();
        searchSquareForMoveInBackLeftPath();
        searchSquareForMoveInBackRightPath();

        if (!isActionCorrect)
            System.out.println("Эта фигура не может так ходить.");
    }

    private void searchSquareForMoveInVertical() {
        if ((this.col == squareForMove.col) && (this.row != squareForMove.row)) {
            isActionCorrect = true;
        }
    }

    private void searchSquareForMoveInHorizontal() {
        if ((this.col != squareForMove.col) && (this.row == squareForMove.row)) {
            isActionCorrect = true;
        }
    }

    private void searchSquareForMoveInForwardRightPath() {
        for (int row = this.row, col = this.col; row >= 0 && col <= 7; row--, col++) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                return;
            }
        }
    }

    private void searchSquareForMoveInForwardLeftPath() {
        for (int row = this.row, col = this.col; row >= 0 && col >= 0; row--, col--) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                return;
            }
        }
    }

    private void searchSquareForMoveInBackLeftPath() {
        for (int row = this.row, col = this.col; row <= 7 && col >= 0; row++, col--) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                return;
            }
        }
    }

    private void searchSquareForMoveInBackRightPath() {
        for (int row = this.row, col = this.col; row <= 7 && col <= 7; row++, col++) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                return;
            }
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

        if (isForwardRightPath()) {
            checkIsThereObstacleForwardRightPath();
        }
        if (isForwardLeftPath()) {
            checkIsThereObstacleForwardLeftPath();
        }
        if (isBackLeftPath()) {
            checkIsThereObstacleBackLeftPath();
        }
        if (isBackRightPath()) {
            checkIsThereObstacleBackRightPath();
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

    private boolean isForwardRightPath() {
        return this.col < squareForMove.col && this.row > squareForMove.row;
    }

    private boolean isForwardLeftPath() {
        return this.col > squareForMove.col && this.row > squareForMove.row;
    }

    private boolean isBackLeftPath() {
        return this.col > squareForMove.col && this.row < squareForMove.row;
    }

    private boolean isBackRightPath() {
        return this.col < squareForMove.col && this.row < squareForMove.row;
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

    private void checkIsThereObstacleForwardRightPath() {
        for (int row = this.row - 1, col = this.col + 1; row > squareForMove.row; row--, col++) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleForwardLeftPath() {
        for (int row = this.row - 1, col = this.col - 1; row > squareForMove.row; row--, col--) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleBackLeftPath() {
        for (int row = this.row + 1, col = this.col - 1; row < squareForMove.row; row++, col--) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleBackRightPath() {
        for (int row = this.row + 1, col = this.col + 1; row < squareForMove.row; row++, col++) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }
}