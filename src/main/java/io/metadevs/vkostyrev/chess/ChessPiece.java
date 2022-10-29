package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.*;

abstract class ChessPiece {
    //TODO добавить геттеры и сеттеры?
    char colour;
    int row;
    int col;
    String pieceIcon;

    ChessPiece(int row, int col, String pieceIcon) {
        this.row = row;
        this.col = col;
        this.pieceIcon = pieceIcon;
    }

    ChessPiece(int row, int col, char colour, String pieceIcon) {
        this.row = row;
        this.col = col;
        this.colour = colour;
        this.pieceIcon = pieceIcon;
    }

    public void checkPiecePresence() {
        if (this instanceof EmptySquare) {
            fillErrorMessage("В этом поле отсутствует фигура. Повторите ввод.");
            isActionCorrect = false;
        }
    }

    public void checkPieceColourCorrect() {
        if (this.colour != GameLogic.walkingColour) {
            fillErrorMessage("Вы пытаетесь взять фигуру не вашего цвета. Повторите ввод.");
            isActionCorrect = false;
        }
    }

    public void checkKingUnderAttack() {    //todo реализовать метод
    }

    public void checkPieceNotBlocked() {    //todo реализовать метод
    }

    abstract public void checkCanPieceMove(ChessPiece squareForMove);        //todo он точно нужен?

    abstract public void checkCanPieceWalkThat(ChessPiece squareForMove);

    abstract public void checkThereObstacleAlongPath(ChessPiece squareForMove);

    public void checkThereObstacleAtEndPath(ChessPiece squareForMove) {
        if (squareForMove.colour == walkingColour) {
            System.out.println("На этой клетке находится ваша фигура.");
            isActionCorrect = false;
        }
    }

    public void checkPieceNotBeKing(ChessPiece squareForMove) {      //todo нейминг
        if (squareForMove instanceof King) {
            System.out.println("Вы не можете рубить короля!");
            isActionCorrect = false;
        }
    }

    public void putPiece(ChessPiece squareForMove) {    //todo название бизнеса но исполнение нет? разбить на поставить/заменить/удалить
        chessBoard[squareForMove.row][squareForMove.col] = this;

        ChessPiece link = new EmptySquare(this.row, this.col, " 　 ║");     //todo нейминг линк
        chessBoard[this.row][this.col] = link;

        this.row = squareForMove.row;
        this.col = squareForMove.col;

        if (this instanceof Pawn && this.colour == 'w' && this.row == 0) {                                   //todo в отдельный метод
            chessBoard[this.row][this.col] = new Queen(this.row, this.col, this.colour, " ♛ ║");
        }
        if (this instanceof Pawn && this.colour == 'b' && this.row == 7) {                                   //todo в отдельный метод
            chessBoard[this.row][this.col] = new Queen(this.row, this.col, this.colour, " ♕ ║");
        }
    }
}