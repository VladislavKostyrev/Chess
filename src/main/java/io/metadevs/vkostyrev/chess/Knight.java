package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Knight extends ChessPiece {
    Knight(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkCanPieceMove() {
        checkCanPieceWalkThat();
    }

    @Override
    public void checkCanPieceWalkThat() {
        isActionCorrect = false;

        searchSquareForMoveInForwardRightPath();
        searchSquareForMoveInForwardLeftPath();
        searchSquareForMoveInBackLeftPath();
        searchSquareForMoveInBackRightPath();
        searchSquareForMoveInLeftForwardPath();
        searchSquareForMoveInLeftBackPath();
        searchSquareForMoveInRightForwardPath();
        searchSquareForMoveInRightBackPath();

        if (!isActionCorrect)
            System.out.println("Эта фигура не может так ходить.");
    }

    private void searchSquareForMoveInForwardRightPath() {
        if (this.col - squareForMove.col == -1 && this.row - squareForMove.row == 2)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInForwardLeftPath() {
        if (this.col - squareForMove.col == 1 && this.row - squareForMove.row == 2)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInBackLeftPath() {
        if (this.col - squareForMove.col == 1 && this.row - squareForMove.row == -2)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInBackRightPath() {
        if (this.col - squareForMove.col == -1 && this.row - squareForMove.row == -2)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInLeftForwardPath() {
        if (this.col - squareForMove.col == -2 && this.row - squareForMove.row == -1)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInLeftBackPath() {
        if (this.col - squareForMove.col == -2 && this.row - squareForMove.row == 1)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInRightForwardPath() {
        if (this.col - squareForMove.col == 2 && this.row - squareForMove.row == -1)
            isActionCorrect = true;
    }

    private void searchSquareForMoveInRightBackPath() {
        if (this.col - squareForMove.col == 2 && this.row - squareForMove.row == 1)
            isActionCorrect = true;
    }

    @Override
    public void checkThereObstacleAlongPath() {
    }
}
