package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.*;

abstract class ChessPiece {
    //TODO добавить геттеры и сеттеры
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

    public static boolean isPieceHere(ChessPiece takenPiece) {
        if (takenPiece instanceof EmptySquare) {
            System.out.println("В этом поле отсутствует фигура. Повторите ввод.");
            return false;
        }
        return true;
    }

    //TODO сделать boolean
    public void isTakePieceMineColour() {
        if (this.colour != GameLogic.walkingColour) {
            System.out.println("Вы пытаетесь взять фигуру не вашего цвета. Повторите ввод.");
            takePiece();
        }
    }

    //TODO сделать boolean
    public void isKingUnderAttack() {
    }

    //TODO сделать boolean
    public void isPieceNotBlocked() {
    }

    abstract public boolean isCanPieceMove(ChessPiece squareForMove, boolean isMoveChecksSuccessful);

    abstract public boolean isMayPieceWalkThat(ChessPiece takenPiece);

    abstract public boolean isThereObstacleAlongPath(ChessPiece squareForMove, boolean isMoveChecksSuccessful);


    public boolean isThereObstacleAtEndPath(ChessPiece squareForMove) {
        if (squareForMove.colour == walkingColour) {
            System.out.println("На этой клетке находится ваша фигура.");
            return false;
        }
        return true;
//        checkIsMayPieceCapture(squareForMove);   //TODO лишнее?
    }

    abstract public void checkIsMayPieceCapture(ChessPiece squareForMove);

    public void captureEnemyPiece(ChessPiece squareForMove) {
    }  //TODO вероятно лишний метод

    public void putPiece(ChessPiece squareForMove) {                          //todo важно, проверить как работает!!!
        chessBoard[squareForMove.row][squareForMove.col] = this;

        ChessPiece link = new EmptySquare(this.row, this.col, " 　 ║");
        chessBoard[this.row][this.col] = link;

        this.row = squareForMove.row;
        this.col = squareForMove.col;
    }
}