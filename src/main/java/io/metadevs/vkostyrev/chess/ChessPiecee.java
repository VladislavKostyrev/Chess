package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.*;

class ChessPiece {
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

    public void checkIsThereObstacleAlongPath(ChessPiece squareForMove) {
    }

    public void checkIsThereObstacleForwardPath(ChessPiece squareForMove) {
    }

    public void checkIsThereObstacleBackPath(ChessPiece squareForMove) {
    }

    public void checkIsThereObstacleLeftPath(ChessPiece squareForMove) {
    }

    public void checkIsThereObstacleRightPath(ChessPiece squareForMove) {
    }

    public void checkIsThereObstacleForwardRightPath(ChessPiece squareForMove) {
    }

    public void checkIsThereObstacleForwardLeftPath(ChessPiece squareForMove) {
    }

    public void checkIsThereObstacleBackLeftPath(ChessPiece squareForMove) {
    }

    public void checkIsThereObstacleBackRightPath(ChessPiece squareForMove) {
    }

    public void checkIsThereObstacleAtEndPath(ChessPiece squareForMove) {
    }

    public void checkIsMayPieceCapture(ChessPiece squareForMove) {
    }

    public void captureEnemyPiece(ChessPiece squareForMove) {
    }  //TODO вероятно тоже лишний метод

    public void putPiece(ChessPiece squareForMove) {
        chessBoard[squareForMove.row][squareForMove.col] = this;

        ChessPiece link =  new EmptySquare(this.row, this.col, " 　 ║");
        chessBoard[this.row][this.col] = link;

        this.row = squareForMove.row;
        this.col = squareForMove.col;

        System.out.println(link.pieceIcon);
//        System.out.println();
    }
}