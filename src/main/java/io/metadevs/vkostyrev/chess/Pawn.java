package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Pawn extends ChessPiece {
    boolean isFirstStepDone = false;              //todo доделать

    Pawn(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkCanPieceMove(ChessPiece squareForMove) {
        checkCanPieceWalkThat(squareForMove);

    }

    @Override
    public void checkCanPieceWalkThat(ChessPiece squareForMove) {
        //TODO реализовать взятие на проходе
        isActionCorrect = false;

        searchSquareForMoveInForward(squareForMove);
        searchSquareForMoveInForwardRight(squareForMove);
        searchSquareForMoveInForwardLeft(squareForMove);

        if (!isActionCorrect)
            System.out.println("Эта фигура не может так ходить.");
    }

    private void searchSquareForMoveInForward(ChessPiece squareForMove) {
        if (isMoveForwardOneSquare(squareForMove)) {
            isFirstStepDone = true;
            isActionCorrect = true;
        }
        if (isMoveForwardTwoSquare(squareForMove)) {
            isFirstStepDone = true;
            isActionCorrect = true;
        }
    }

    private boolean isMoveForwardOneSquare(ChessPiece squareForMove) {
        if (this.colour == 'w') {
            return squareForMove.row == this.row - 1 && this.col == squareForMove.col && squareForMove instanceof EmptySquare;
        }

        if (this.colour == 'b') {
            return squareForMove.row == this.row + 1 && this.col == squareForMove.col && squareForMove instanceof EmptySquare;
        }
        return false;
    }

    private boolean isMoveForwardTwoSquare(ChessPiece squareForMove) {
        if (this.colour == 'w') {
            return this.row == 6 && squareForMove.row == 4 && this.col == squareForMove.col && squareForMove instanceof EmptySquare && chessBoard[5][squareForMove.col] instanceof EmptySquare && !this.isFirstStepDone;
        }

        if (this.colour == 'b') {
            return this.row == 1 && squareForMove.row == 3 && this.col == squareForMove.col && squareForMove instanceof EmptySquare && chessBoard[2][squareForMove.col] instanceof EmptySquare && !this.isFirstStepDone;
        }
        return false;
    }

    private void searchSquareForMoveInForwardRight(ChessPiece squareForMove) {
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

    private void searchSquareForMoveInForwardLeft(ChessPiece squareForMove) {
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
    public void checkThereObstacleAlongPath(ChessPiece squareForMove) {
        //TODO этот метод вызывается только при реализации взятия на проходе
    }
}