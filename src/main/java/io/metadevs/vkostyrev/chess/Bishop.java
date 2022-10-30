package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Bishop extends ChessPiece {
    Bishop(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkCanPieceMove(ChessPiece squareForMove) {
        checkCanPieceWalkThat(squareForMove);
        checkThereObstacleAlongPath(squareForMove);
    }

    @Override
    public void checkCanPieceWalkThat(ChessPiece squareForMove) {
        isActionCorrect = false;

        searchSquareForMoveInForwardRightPath(squareForMove);
        searchSquareForMoveInForwardLeftPath(squareForMove);
        searchSquareForMoveInBackLeftPath(squareForMove);
        searchSquareForMoveInBackRightPath(squareForMove);
        if (!isActionCorrect)   //isSearchSuccessful
            System.out.println("Ёта фигура не может так ходить.");
    }

    private void searchSquareForMoveInForwardRightPath(ChessPiece squareForMove) { //TODO √риши:  цикл не заканчиваетс€?
        for (int row = this.row, col = this.col; row >= 0 && col <= 7; row--, col++) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                return;
            }
        }
    }

    private void searchSquareForMoveInForwardLeftPath(ChessPiece squareForMove) {
        for (int row = this.row, col = this.col; row >= 0 && col >= 0; row--, col--) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                return;
            }
        }
    }

    private void searchSquareForMoveInBackLeftPath(ChessPiece squareForMove) {
        for (int row = this.row, col = this.col; row <= 7 && col >= 0; row++, col--) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                return;
            }
        }
    }

    private void searchSquareForMoveInBackRightPath(ChessPiece squareForMove) {
        for (int row = this.row, col = this.col; row <= 7 && col <= 7; row++, col++) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                return;
            }
        }
    }

    @Override
    public void checkThereObstacleAlongPath(ChessPiece squareForMove) {
        if (isForwardRightPath(squareForMove)) {
            checkIsThereObstacleForwardRightPath(squareForMove);
        }
        if (isForwardLeftPath(squareForMove)) {
            checkIsThereObstacleForwardLeftPath(squareForMove);
        }
        if (isBackLeftPath(squareForMove)) {
            checkIsThereObstacleBackLeftPath(squareForMove);
        }
        if (isBackRightPath(squareForMove)) {
            checkIsThereObstacleBackRightPath(squareForMove);
        }
    }

    private boolean isForwardRightPath(ChessPiece squareForMove) {
        return this.col < squareForMove.col && this.row > squareForMove.row;
    }

    private boolean isForwardLeftPath(ChessPiece squareForMove) {
        return this.col > squareForMove.col && this.row > squareForMove.row;
    }

    private boolean isBackLeftPath(ChessPiece squareForMove) {
        return this.col > squareForMove.col && this.row < squareForMove.row;
    }

    private boolean isBackRightPath(ChessPiece squareForMove) {
        return this.col < squareForMove.col && this.row < squareForMove.row;
    }

    private void checkIsThereObstacleForwardRightPath(ChessPiece squareForMove) { //todo убрать check или is из названи€
        for (int row = this.row - 1, col = this.col + 1; row > squareForMove.row; row--, col++) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("Ќа пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleForwardLeftPath(ChessPiece squareForMove) {
        for (int row = this.row - 1, col = this.col - 1; row > squareForMove.row; row--, col--) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("Ќа пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleBackLeftPath(ChessPiece squareForMove) {
        for (int row = this.row + 1, col = this.col - 1; row < squareForMove.row; row++, col--) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("Ќа пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleBackRightPath(ChessPiece squareForMove) {
        for (int row = this.row + 1, col = this.col + 1; row < squareForMove.row; row++, col++) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("Ќа пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }
}