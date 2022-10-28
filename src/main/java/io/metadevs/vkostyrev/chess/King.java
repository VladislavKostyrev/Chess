package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class King extends ChessPiece{                         //todo добавить метод что нельзя ходить под бой
    King (int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void isCanPieceMove(ChessPiece squareForMove) {
        checkCanPieceWalkThat(squareForMove);
        checkThereObstacleAlongPath(squareForMove);
    }

    @Override
    public void checkCanPieceWalkThat(ChessPiece squareForMove) {               //todo вынести в отдельные методы
        isActionCorrect = false;

        if ((this.col == squareForMove.col) && (this.row - squareForMove.row == 1 || this.row - squareForMove.row == -1))
            isActionCorrect = true;
        if ((this.col - squareForMove.col == 1 || this.col - squareForMove.col == -1) && (this.row == squareForMove.row))
            isActionCorrect = true;

        if (this.col - squareForMove.col == 1 && this.row - squareForMove.row == 1)
            isActionCorrect = true;
        if (this.col - squareForMove.col == -1 && this.row - squareForMove.row == 1)
            isActionCorrect = true;
        if (this.col - squareForMove.col == -1 && this.row - squareForMove.row == -1)
            isActionCorrect = true;
        if (this.col - squareForMove.col == 1 && this.row - squareForMove.row == -1)
            isActionCorrect = true;

        if (!isActionCorrect)
            System.out.println("Эта фигура не может так ходить.");
    }

    @Override
    public void checkThereObstacleAlongPath(ChessPiece squareForMove) {
    }
}
