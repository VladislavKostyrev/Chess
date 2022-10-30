package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class King extends ChessPiece{
    King (int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkCanPieceMove() {
        checkCanPieceWalkThat();
        checkThereObstacleAlongPath();
    }

    @Override
    public void checkCanPieceWalkThat() {
        isActionCorrect = false;

        searchSquareForMoveInVertical();
        searchSquareForMoveInHorizontal();

        searchSquareForMoveInForwardRight();
        searchSquareForMoveInForwardLeft();
        searchSquareForMoveInBackLeft();
        searchSquareForMoveInBackRight();

        if (!isActionCorrect)
            System.out.println("Эта фигура не может так ходить.");
    }

    private void searchSquareForMoveInVertical() {
        if ((this.col == squareForMove.col) && (this.row - squareForMove.row == 1 || this.row - squareForMove.row == -1))
            isActionCorrect = true;
    }
    private void searchSquareForMoveInHorizontal() {
        if ((this.col - squareForMove.col == 1 || this.col - squareForMove.col == -1) && (this.row == squareForMove.row))
            isActionCorrect = true;
    }
    private void searchSquareForMoveInForwardRight() {
        if (this.col - squareForMove.col == -1 && this.row - squareForMove.row == 1)
            isActionCorrect = true;
    }
    private void searchSquareForMoveInForwardLeft() {
        if (this.col - squareForMove.col == 1 && this.row - squareForMove.row == 1)
            isActionCorrect = true;
    }
    private void searchSquareForMoveInBackLeft() {
        if (this.col - squareForMove.col == 1 && this.row - squareForMove.row == -1)
            isActionCorrect = true;
    }
    private void searchSquareForMoveInBackRight() {
        if (this.col - squareForMove.col == -1 && this.row - squareForMove.row == -1)
            isActionCorrect = true;
    }

    @Override
    public void checkThereObstacleAlongPath() {
    }

    public void checkSquareForMoveUnderAttack() {  //todo доделать
        //  проверка есть ли по гор-ли и вер-ли тура или ферзь
        // проверка есть ли на диагоналях слон, ферзь, пешка или король на первой клетке поиска
        // проверка коней, что бью это поле
    }
}

//check проверяет клетку на то, не является ли эта клетка под боем
//check не попадёт ли король при ходе фигуры под бой, проверяет клетку, где стоит король на шах
//check game wim проверка всех полей вокруг короля и поле на котором он стоит
