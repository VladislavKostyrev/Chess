package io.metadevs.vkostyrev.chess;

import io.metadevs.vkostyrev.chess.GameLogic.*;
import org.jetbrains.annotations.NotNull;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;
import static io.metadevs.vkostyrev.chess.GameLogic.scanner;
import static io.metadevs.vkostyrev.chess.GameLogic.takePiece;

class ChessPiece {
    char colour;
    int row;
    int col;

    public void checkIsPieceHere() {
        if (this == null) {
            System.out.println("В этом поле отсутствует фигура. Повторите ввод.");
            takePiece();
        }
    }

    public void checkIsTakePieceMineColour() {
        if (this.colour != GameLogic.walkingColour) {
            System.out.println("Вы пытаетесь взять чужую фигуру. Повторите ввод.");
            takePiece();
        }
    }

    public void isKingUnderAttack() {
    }


    public void movePiece() {
    }


    public void isMayPieceWalkThat() {
    }


    public void isThereObstacleAlongPath() {
    }

    public void isThereObstacleAtEndPath() {
    }

    public void capturePiece() {
    }

}
