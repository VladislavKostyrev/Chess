package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.*;
import static io.metadevs.vkostyrev.chess.GameLogic.*;

public class Rook extends ChessPiece {
    Rook(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public void checkIsMayPieceWalkThat(ChessPiece squareForMove) {
        System.out.println("Прошёл 1");
        if ((!(this.row == squareForMove.row) && (this.col != squareForMove.col))) {
            System.out.println("Эта фигура не может так ходить.");

            movePiece(this);
        }
        if ((!(this.col == squareForMove.col) && (this.row != squareForMove.row))) {
            System.out.println("Эта фигура не может так ходить.");
            movePiece(this);
        }


        System.out.println("Прошёл 1");
    }

    @Override
    public void checkIsThereObstacleAlongPath(ChessPiece squareForMove) {
        if (this.col == squareForMove.col && this.row > squareForMove.row) {
            checkIsThereObstacleForwardPath(squareForMove);
        }
        if (this.col == squareForMove.col && this.row < squareForMove.row) {
            checkIsThereObstacleBackPath(squareForMove);
        }
        if (this.col > squareForMove.col && this.row == squareForMove.row) {
            checkIsThereObstacleLeftPath(squareForMove);
        }
        if (this.col < squareForMove.col && this.row == squareForMove.row) {
            checkIsThereObstacleRightPath(squareForMove);
        }
        System.out.println("Прошёл 2");
    }

    @Override
    public void checkIsThereObstacleForwardPath(ChessPiece squareForMove) {
        if (this.row != 0) {
            for (int i = this.row - 1; i > squareForMove.row; i--) {
                if (!(chessBoard[i][this.col] instanceof EmptySquare)) {
                    System.out.println("На пути присутствует помеха.");
                    movePiece(this);
                }
            }
        }
    }

    @Override
    public void checkIsThereObstacleBackPath(ChessPiece squareForMove) {
        if (this.row != 7) {
            for (int i = this.row + 1; i < squareForMove.row; i++) {
                if (!(chessBoard[i][this.col] instanceof EmptySquare)) {
                    System.out.println("На пути присутствует помеха.");
                    movePiece(this);
                }
            }
        }
    }

    @Override
    public void checkIsThereObstacleLeftPath(ChessPiece squareForMove) {
        if (this.col != 0) {
            for (int i = this.col - 1; i > squareForMove.col; i--) {
                if (!(chessBoard[this.row][i] instanceof EmptySquare)) {
                    System.out.println("На пути присутствует помеха.");
                    movePiece(this);
                }
            }
        }
    }

    @Override
    public void checkIsThereObstacleRightPath(ChessPiece squareForMove) {
        if (this.col != 7) {
            for (int i = this.col + 1; i < squareForMove.col; i++) {
                if (!(chessBoard[this.row][i] instanceof EmptySquare)) {
                    System.out.println("На пути присутствует помеха.");
                    movePiece(this);
                }
            }
        }
    }

    public void checkIsMayPieceCapture(ChessPiece squareForMove) {
        if (squareForMove instanceof King) {
            System.out.println("Вы не можете рубить вражеского короля!");
            movePiece(this);
        }
    }
}