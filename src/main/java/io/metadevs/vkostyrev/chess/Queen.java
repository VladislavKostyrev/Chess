package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Queen extends ChessPiece {
    Queen(int row, int col, char colour, String pieceIcon) {
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

        searchSquareForMoveInVertical(squareForMove);
        searchSquareForMoveInHorizontal(squareForMove);

        searchSquareForMoveInForwardRightPath(squareForMove);
        searchSquareForMoveInForwardLeftPath(squareForMove);
        searchSquareForMoveInBackLeftPath(squareForMove);
        searchSquareForMoveInBackRightPath(squareForMove);

        if (!isActionCorrect)
            System.out.println("Эта фигура не может так ходить.");
    }

    private void searchSquareForMoveInVertical(ChessPiece squareForMove) {
        if ((this.col == squareForMove.col) && (this.row != squareForMove.row)) {
            isActionCorrect = true;
        }
    }

    private void searchSquareForMoveInHorizontal(ChessPiece squareForMove) {
        if ((this.col != squareForMove.col) && (this.row == squareForMove.row)) {
            isActionCorrect = true;
        }
    }

    private void searchSquareForMoveInForwardRightPath(ChessPiece squareForMove) {
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

    private void checkIsThereObstacleForwardRightPath(ChessPiece squareForMove) {
        for (int row = this.row - 1, col = this.col + 1; row > squareForMove.row; row--, col++) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleForwardLeftPath(ChessPiece squareForMove) {
        for (int row = this.row - 1, col = this.col - 1; row > squareForMove.row; row--, col--) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleBackLeftPath(ChessPiece squareForMove) {
        for (int row = this.row + 1, col = this.col - 1; row < squareForMove.row; row++, col--) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }

    private void checkIsThereObstacleBackRightPath(ChessPiece squareForMove) {
        for (int row = this.row + 1, col = this.col + 1; row < squareForMove.row; row++, col++) {
            if (!(chessBoard[row][col] instanceof EmptySquare)) {
                System.out.println("На пути присутствует помеха.");
                isActionCorrect = false;
            }
        }
    }
}