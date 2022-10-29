package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Pawn extends ChessPiece {
    boolean isFirstStepDone = false;

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

        if (this.colour == 'w') {
            if (squareForMove.row == this.row - 1 && this.col == squareForMove.col && squareForMove instanceof EmptySquare) {
                isFirstStepDone = true;
                isActionCorrect = true;
            }
            if (squareForMove.row == this.row - 1 && this.col - squareForMove.col == 1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare))) {
                isFirstStepDone = true;
                isActionCorrect = true;
            }
            if (squareForMove.row == this.row - 1 && this.col - squareForMove.col == -1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare))) {
                isFirstStepDone = true;
                isActionCorrect = true;
            }

            if (this.row == 6 && squareForMove.row == 4 && this.col == squareForMove.col && squareForMove instanceof EmptySquare && chessBoard[5][squareForMove.col] instanceof EmptySquare && !this.isFirstStepDone)
                isActionCorrect = true;

            if (this.row == 0) {
                chessBoard[this.row][this.col] = new Queen(this.row, this.col, this.colour, " ♛ ║");
            }
        }

        if (this.colour == 'b') {
            if (squareForMove.row == this.row + 1 && this.col == squareForMove.col && squareForMove instanceof EmptySquare) {
                isActionCorrect = true;
            }
            if (squareForMove.row == this.row + 1 && this.col - squareForMove.col == 1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare))) {
                isActionCorrect = true;
            }
            if (squareForMove.row == this.row + 1 && this.col - squareForMove.col == -1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare))) {
                isActionCorrect = true;
            }

            if (this.row == 1 && squareForMove.row == 3 && this.col == squareForMove.col && squareForMove instanceof EmptySquare && chessBoard[2][squareForMove.col] instanceof EmptySquare && !this.isFirstStepDone)
                isActionCorrect = true;
        }

        if (!isActionCorrect)
            System.out.println("Эта фигура не может так ходить.");
    }

    @Override
    public void checkThereObstacleAlongPath(ChessPiece squareForMove) {
        //TODO этот метод вызывается только при реализации взятия на проходе
    }
}