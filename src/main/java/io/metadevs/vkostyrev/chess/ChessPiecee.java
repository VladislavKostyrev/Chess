package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.*;

class ChessPiece {
    char colour;
    int row;
    int col;
    String pieceIcon;

    ChessPiece () {
    }

    ChessPiece (String pieceIcon) {
        this.pieceIcon = pieceIcon;
    }

    ChessPiece (char colour, String pieceIcon) {
        this.colour = colour;
        this.pieceIcon = pieceIcon;
    }

    //TODO правило для рубления (хождения) что нельзя рубить короля

    public void checkIsPieceHere() {
        if (this instanceof EmptySquare) {
            System.out.println("В этом поле отсутствует фигура. Повторите ввод.");
            takePiece();
        }
    }

    public void checkIsTakePieceMineColour() {
        if (this.colour != GameLogic.walkingColour) {
            System.out.println("Вы пытаетесь взять фигуру не вашего цвета. Повторите ввод.");
            takePiece();
        }
    }

    public void checkIsKingUnderAttack() {

    }

    public void checkIsPieceNotBlocked() {

    }

    public void checkIsMayPieceWalkThat(ChessPiece takenPiece) {
    }

    public void isThereObstacleAlongPath(ChessPiece squareForMove) {
    }

    public void checkIsThereObstacleAtEndPath(ChessPiece squareForMove) {
    } //TODO вероятно этот метод лишний так как предыдущий включает в себя его

    public void checkIsMayPieceCapture(ChessPiece squareForMove) {
    }

    public void captureEnemyPiece(ChessPiece squareForMove) {
    }  //TODO вероятно тоже лишний метод

    public void putPiece(ChessPiece squareForMove) {
        chessBoard[squareForMove.row][squareForMove.col] = this;
        chessBoard[this.row][this.col] = new EmptySquare(" 　 ║");  //TODO в скобках EmptySquare() должна быть иконка " 　 ║" в виде аргумента
    }
}