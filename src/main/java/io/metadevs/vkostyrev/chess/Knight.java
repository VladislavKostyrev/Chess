package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Knight extends ChessPiece {
    Knight (int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkCanPieceMove(ChessPiece squareForMove) {
        checkCanPieceWalkThat(squareForMove);
    }

    @Override
    public void checkCanPieceWalkThat(ChessPiece squareForMove) {
        isActionCorrect = false;

        if (this.col - squareForMove.col == 1 && this.row - squareForMove.row == 2)  //верх лево
            isActionCorrect = true;
        if (this.col - squareForMove.col == -1 && this.row - squareForMove.row == 2)  //верх право
            isActionCorrect = true;
        if (this.col - squareForMove.col == 1 && this.row - squareForMove.row == -2)   //низ лево
            isActionCorrect = true;
        if (this.col - squareForMove.col == -1 && this.row - squareForMove.row == -2)  //низ право
            isActionCorrect = true;
        if (this.col - squareForMove.col == -2 && this.row - squareForMove.row == -1)  //лево верх
            isActionCorrect = true;
        if (this.col - squareForMove.col == -2 && this.row - squareForMove.row == 1)  //лево низ
            isActionCorrect = true;
        if (this.col - squareForMove.col == 2 && this.row - squareForMove.row == -1)  //право верх
            isActionCorrect = true;
        if (this.col - squareForMove.col == 2 && this.row - squareForMove.row == 1)  //право низ
            isActionCorrect = true;

        if (!isActionCorrect)
            System.out.println("Эта фигура не может так ходить.");
    }

    @Override
    public void checkThereObstacleAlongPath(ChessPiece squareForMove) {
    }
}
