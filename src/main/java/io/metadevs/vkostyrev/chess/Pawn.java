package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.GameLogic.isActionCorrect;

public class Pawn extends ChessPiece {
    Pawn(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void isCanPieceMove(ChessPiece squareForMove) {
        checkCanPieceWalkThat(squareForMove);
    }

    @Override
    public void checkCanPieceWalkThat(ChessPiece squareForMove) {
        //TODO реализовать первый ход на две клетки
        //TODO реализовать взятие на проходе
        //TODO реализовать превращение пекши в другую фигуру (как дошла до края доски врага)
        isActionCorrect = false;

        if (this.colour == 'w') {
            if (squareForMove.row == this.row - 1 && this.col == squareForMove.col && squareForMove instanceof EmptySquare)
                isActionCorrect = true;
            if (squareForMove.row == this.row - 1 && this.col - squareForMove.col == 1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare)))
                isActionCorrect = true;
            if (squareForMove.row == this.row - 1 && this.col - squareForMove.col == -1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare)))
                isActionCorrect = true;
        }

        if (this.colour == 'b') {
            if (squareForMove.row == this.row + 1 && this.col == squareForMove.col && squareForMove instanceof EmptySquare)
                isActionCorrect = true;
            if (squareForMove.row == this.row + 1 && this.col - squareForMove.col == 1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare)))
                isActionCorrect = true;
            if (squareForMove.row == this.row + 1 && this.col - squareForMove.col == -1 && (this.col != squareForMove.colour && !(squareForMove instanceof EmptySquare)))
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