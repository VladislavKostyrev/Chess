package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class King extends ChessPiece{                         //todo добавить метод что нельзя ходить под бой
    King (int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkCanPieceMove(ChessPiece squareForMove) {
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

    public void checkSquareForMoveUnderAttack(ChessPiece squareForMove) {
        //  проверка есть ли по гор-ли и вер-ли тура или ферзь
        // проверка есть ли на диагоналях слон, ферзь, пешка или король на первой клетке поиска
        // проверка коней, что бью это поле
    }
}

//check проверяет клетку на то, не является ли эта клетка под боем
//check не попадёт ли король при ходе фигуры под бой, проверяет клетку, где стоит король на шах
//check game wim проверка всех полей вокруг короля и поле на котором он стоит
