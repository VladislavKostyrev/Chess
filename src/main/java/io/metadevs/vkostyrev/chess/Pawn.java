package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.GameLogic.movePiece;
import static io.metadevs.vkostyrev.chess.GameLogic.walkingColour;

public class Pawn extends ChessPiece {
    Pawn (int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void isPieceNotBlocked() {

    }

    @Override
    public boolean isCanPieceMove(ChessPiece squareForMove, boolean isMoveChecksSuccessful) {
        isMoveChecksSuccessful = isMayPieceWalkThat(squareForMove);
        return isMoveChecksSuccessful;
    }

    @Override
    public boolean isMayPieceWalkThat(ChessPiece squareForMove) {
        //TODO проверка если впереди есть помеха (вероятнее будет в другом методе)
        //TODO реализовать взятие на проходе
        //TODO реализовать первый ход на две клетки
        //TODO реализовать превращение пекши в другую фигуру (как дошла до края доски врага)

        if (walkingColour == 'w') {
            if ((squareForMove.row != this.row - 1) || (squareForMove.col < this.col - 1 || squareForMove.col > this.col + 1)) {
                System.out.println("Эта фигура не может так ходить.");
                return false;
            }
            return true;
        }
        if (walkingColour == 'b') {
            if ((squareForMove.row != this.row + 1) || (squareForMove.col < this.col - 1 || squareForMove.col > this.col + 1)) {
                System.out.println("Эта фигура не может так ходить.");
                return false;
            }
            return true;
        }

//        checkIsMayPieceCapture(squareForMove);
        return true;
    }

    @Override
    public boolean isThereObstacleAlongPath(ChessPiece squareForMove, boolean isMoveChecksSuccessful) {
        //TODO этот метод вызывается только при реализации взятия на проходе
        return true;
    }


    @Override
    public void checkIsMayPieceCapture(ChessPiece squareForMove) {
        if ((squareForMove.col == this.col - 1) || (squareForMove.col == this.col + 1)) {
            if (squareForMove instanceof EmptySquare) {
                System.out.println("Вы не можете рубить так как на этом поле отсутствует фигура.");
                movePiece(this);                                                                            //TODO лишнее?
            } else if (squareForMove.colour == this.colour) {
                System.out.println("Вы не можете рубить фигуру своего цвета.");
                movePiece(this);
            } else if (squareForMove instanceof King) {                                    //TODO заменить проверкой
                System.out.println("Вы не можете рубить короля.");
                movePiece(this);
            }
        }
    }

}