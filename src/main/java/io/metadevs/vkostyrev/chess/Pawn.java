package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Pawn extends ChessPiece {
    boolean isFirstStepDone = false;              //todo доделать

    Pawn(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkCanPieceMove() {
        checkCanPieceWalkThat();

    }

    @Override
    public void checkCanPieceWalkThat() {
        //TODO реализовать взятие на проходе
        isActionCorrect = false;

        searchSquareForMoveInForward();
        searchSquareForMoveInForwardRight();
        searchSquareForMoveInForwardLeft();

        if (!isActionCorrect)
            System.out.println("Эта фигура не может так ходить.");
    }

    private void searchSquareForMoveInForward() {
        if (isMoveForwardOneSquare()) {
            isFirstStepDone = true;
            isActionCorrect = true;
        }
        if (isMoveForwardTwoSquare()) {
            isFirstStepDone = true;
            isActionCorrect = true;
        }
    }

    private boolean isMoveForwardOneSquare() {
        if (this.colour == 'w') {
            return squareForMove.row == this.row - 1 && this.col == squareForMove.col && squareForMove instanceof EmptySquare;
        }

        if (this.colour == 'b') {
            return squareForMove.row == this.row + 1 && this.col == squareForMove.col && squareForMove instanceof EmptySquare;
        }
        return false;
    }

    private boolean isMoveForwardTwoSquare() {
        if (this.colour == 'w') {
            return this.row == 6 && squareForMove.row == 4 && this.col == squareForMove.col && squareForMove instanceof EmptySquare && chessBoard[5][squareForMove.col] instanceof EmptySquare && !this.isFirstStepDone;
        }

        if (this.colour == 'b') {
            return this.row == 1 && squareForMove.row == 3 && this.col == squareForMove.col && squareForMove instanceof EmptySquare && chessBoard[2][squareForMove.col] instanceof EmptySquare && !this.isFirstStepDone;
        }
        return false;
    }

    private void searchSquareForMoveInForwardRight() {
        if (this.colour == 'w') {
            if (squareForMove.row == this.row - 1 && this.col - squareForMove.col == -1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare))) {
                isFirstStepDone = true;
                isActionCorrect = true;
            }
        }

        if (this.colour == 'b') {
            if (squareForMove.row == this.row + 1 && this.col - squareForMove.col == -1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare))) {
                isActionCorrect = true;
                isFirstStepDone = true;
            }
        }
    }

    private void searchSquareForMoveInForwardLeft() {
        if (this.colour == 'w') {
            if (squareForMove.row == this.row - 1 && this.col - squareForMove.col == 1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare))) {
                isFirstStepDone = true;
                isActionCorrect = true;
            }
        }

        if (this.colour == 'b') {
            if (squareForMove.row == this.row + 1 && this.col - squareForMove.col == 1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare))) {
                isActionCorrect = true;
                isFirstStepDone = true;
            }
        }
    }

    @Override
    public void checkThereObstacleAlongPath() {
        //TODO этот метод вызывается только при реализации взятия на проходе
    }
}