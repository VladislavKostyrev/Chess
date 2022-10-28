package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Queen extends ChessPiece {
    Queen(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void isCanPieceMove(ChessPiece squareForMove) {
        checkCanPieceWalkThat(squareForMove);
        checkThereObstacleAlongPath(squareForMove);
    }

    @Override
    public void checkCanPieceWalkThat(ChessPiece squareForMove) {
        isActionCorrect = false;

        if ((this.col == squareForMove.col) && (this.row != squareForMove.row)) {
            isActionCorrect = true;
        }
        if ((this.col != squareForMove.col) && (this.row == squareForMove.row)) {
            isActionCorrect = true;
        }
        searchSquareForMoveForwardRightPath(squareForMove);
        searchSquareForMoveForwardLeftPath(squareForMove);
        searchSquareForMoveBackLeftPath(squareForMove);
        searchSquareForMoveBackRightPath(squareForMove);
        if (!isActionCorrect)
            System.out.println("Эта фигура не может так ходить.");
    }

    private void searchSquareForMoveForwardRightPath(ChessPiece squareForMove) {
        for (int row = this.row, col = this.col; row >= 0 || col <= 7; row--, col++) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                break;
            }
            if (row == 0 || col == 7)
                return;
        }
    }

    private void searchSquareForMoveForwardLeftPath(ChessPiece squareForMove) {
        for (int row = this.row, col = this.col; row >= 0 || col >= 0; row--, col--) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                break;
            }
            if (row == 0 || col == 0)
                return;
        }
    }

    private void searchSquareForMoveBackLeftPath(ChessPiece squareForMove) {
        for (int row = this.row, col = this.col; row <= 7 || col >= 0; row++, col--) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                break;
            }
            if (row == 7 || col == 0)
                return;
        }
    }

    private void searchSquareForMoveBackRightPath(ChessPiece squareForMove) {
        for (int row = this.row, col = this.col; row <= 7 || col <= 7; row++, col++) {
            if ((chessBoard[row][col].equals(squareForMove))) {
                isActionCorrect = true;
                break;
            }
            if (row == 7 || col == 7)
                return;
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

        if (this.col < squareForMove.col && this.row > squareForMove.row) {
            checkIsThereObstacleForwardRightPath(squareForMove);
        }
        if (this.col > squareForMove.col && this.row > squareForMove.row) {
            checkIsThereObstacleForwardLeftPath(squareForMove);
        }
        if (this.col > squareForMove.col && this.row < squareForMove.row) {
            checkIsThereObstacleBackLeftPath(squareForMove);
        }
        if (this.col < squareForMove.col && this.row < squareForMove.row) {
            checkIsThereObstacleBackRightPath(squareForMove);
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

    private void checkIsThereObstacleForwardRightPath(ChessPiece squareForMove) {
        for (int i = this.row - 1, j = this.col + 1; i > squareForMove.row; i--, j++) {
            if (!(chessBoard[i][j] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleForwardLeftPath(ChessPiece squareForMove) {
        for (int i = this.row - 1, j = this.col - 1; i > squareForMove.row; i--, j--) {
            if (!(chessBoard[i][j] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleBackLeftPath(ChessPiece squareForMove) {
        for (int i = this.row + 1, j = this.col - 1; i < squareForMove.row; i++, j--) {
            if (!(chessBoard[i][j] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleBackRightPath(ChessPiece squareForMove) {
        for (int i = this.row + 1, j = this.col + 1; i < squareForMove.row; i++, j++) {
            if (!(chessBoard[i][j] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }
}