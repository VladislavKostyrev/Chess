package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Knight extends ChessPiece {
    Knight(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkCanPieceMove(ChessPiece squareForMove) {
        checkCanPieceWalkThat(squareForMove);
    }

    @Override
    public void checkCanPieceWalkThat(ChessPiece squareForMove) {
        isActionCorrect = false;

        searchSquareForMoveInForwardRightPath(squareForMove);
        searchSquareForMoveInForwardLeftPath(squareForMove);
        searchSquareForMoveInBackLeftPath(squareForMove);
        searchSquareForMoveInBackRightPath(squareForMove);
        searchSquareForMoveInLeftForwardPath(squareForMove);
        searchSquareForMoveInLeftBackPath(squareForMove);
        searchSquareForMoveInRightForwardPath(squareForMove);
        searchSquareForMoveInRightBackPath(squareForMove);

        if (!isActionCorrect)
            System.out.println("Эта фигура не может так ходить.");
    }

    private void searchSquareForMoveInForwardRightPath(ChessPiece squareForMove) {
        if (this.col - squareForMove.col == -1 && this.row - squareForMove.row == 2)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInForwardLeftPath(ChessPiece squareForMove) {
        if (this.col - squareForMove.col == 1 && this.row - squareForMove.row == 2)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInBackLeftPath(ChessPiece squareForMove) {
        if (this.col - squareForMove.col == 1 && this.row - squareForMove.row == -2)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInBackRightPath(ChessPiece squareForMove) {
        if (this.col - squareForMove.col == -1 && this.row - squareForMove.row == -2)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInLeftForwardPath(ChessPiece squareForMove) {
        if (this.col - squareForMove.col == -2 && this.row - squareForMove.row == -1)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInLeftBackPath(ChessPiece squareForMove) {
        if (this.col - squareForMove.col == -2 && this.row - squareForMove.row == 1)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInRightForwardPath(ChessPiece squareForMove) {
        if (this.col - squareForMove.col == 2 && this.row - squareForMove.row == -1)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInRightBackPath(ChessPiece squareForMove) {
        if (this.col - squareForMove.col == 2 && this.row - squareForMove.row == 1)
            isActionCorrect = true;
    }

    @Override
    public void checkThereObstacleAlongPath(ChessPiece squareForMove) {
    }
}
