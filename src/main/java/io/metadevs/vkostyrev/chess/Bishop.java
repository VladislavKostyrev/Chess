package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Bishop extends ChessPiece {
    Bishop(int row, int col, char colour, String pieceIcon) {
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

        searchSquareForMoveInForwardRightPath();
        searchSquareForMoveInForwardLeftPath();
        searchSquareForMoveInBackLeftPath();
        searchSquareForMoveInBackRightPath();
        if (!isActionCorrect)   //isSearchSuccessful
            System.out.println("Ёта фигура не может так ходить.");
    }

    private void searchSquareForMoveInForwardRightPath() { //TODO √риши:  цикл не заканчиваетс€?
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

    private void checkIsThereObstacleForwardRightPath() { //todo убрать check или is из названи€
        for (int row = this.row - 1, col = this.col + 1; row > squareForMove.row; row--, col++) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("Ќа пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleForwardLeftPath() {
        for (int row = this.row - 1, col = this.col - 1; row > squareForMove.row; row--, col--) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("Ќа пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleBackLeftPath() {
        for (int row = this.row + 1, col = this.col - 1; row < squareForMove.row; row++, col--) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("Ќа пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleBackRightPath() {
        for (int row = this.row + 1, col = this.col + 1; row < squareForMove.row; row++, col++) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("Ќа пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }
}