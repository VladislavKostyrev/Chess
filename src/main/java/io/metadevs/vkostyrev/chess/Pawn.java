package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.walkingColour;

public class Pawn extends ChessPiece {
    Pawn (int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkIsMayPieceWalkThat(ChessPiece squareForMove) {
        //TODO проверка если впереди есть помеха (вероятнее будет в другом методе)
        //TODO реализовать взятие на проходе
        //TODO реализовать первый ход на две клетки
        //TODO реализовать превращение пекши в другую фигуру (как дошла до края доски врага)

        if (walkingColour == 'w') {
            if ((squareForMove.row != this.row - 1) || (squareForMove.col < this.col - 1 || squareForMove.col > this.col + 1)) {
                System.out.println("Эта фигура не может так ходить.");
                GameLogic.movePiece(this);
            }
        }
        if (walkingColour == 'b') {
            if ((squareForMove.row != this.row + 1) || (squareForMove.col < this.col - 1 || squareForMove.col > this.col + 1)) {
                System.out.println("Эта фигура не может так ходить.");
                GameLogic.movePiece(this);
            }
        }

        checkIsMayPieceCapture(squareForMove);
    }

    @Override
    public void checkIsMayPieceCapture(ChessPiece squareForMove) {
        if ((squareForMove.col == this.col - 1) || (squareForMove.col == this.col + 1)) {

            if (squareForMove instanceof EmptySquare) {
                System.out.println("Вы не можете рубить так как на этом поле отсутствует фигура.");
                GameLogic.movePiece(this);
            } else if (squareForMove.colour == this.colour) {
                System.out.println("Вы не можете рубить фигуру своего цвета.");
                GameLogic.movePiece(this);
            } else if (squareForMove instanceof King) {
                System.out.println("Вы не можете рубить короля.");
                GameLogic.movePiece(this);
            }
        }
    }

//    @Override
    //TODO этот метод вызывается только при реализации взятия на проходе
//    public boolean isThereObstacleAlongPath(ChessPiece squareForMove) {
//        return false;
//    }
}