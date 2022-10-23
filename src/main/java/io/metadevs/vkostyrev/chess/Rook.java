package io.metadevs.vkostyrev.chess;

import static io.metadevs.vkostyrev.chess.ChessBoard.*;
import static io.metadevs.vkostyrev.chess.GameLogic.*;

public class Rook extends ChessPiece {
    Rook(int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
    }

    @Override
    public boolean isCanPieceMove(ChessPiece squareForMove, boolean isMoveChecksSuccessful) {
        isMoveChecksSuccessful = isMayPieceWalkThat(squareForMove);
        isMoveChecksSuccessful = isThereObstacleAlongPath(squareForMove, isMoveChecksSuccessful);
        return isMoveChecksSuccessful;
    }

    @Override
    public boolean isMayPieceWalkThat(ChessPiece squareForMove) {
        if (notSameSquare(squareForMove))   {
            System.out.println("Эта фигура не ходить на ту же клетку.");
            return false;
        }
        if (notSameColumn(!(this.col == squareForMove.col) && (this.row != squareForMove.row))) {
            System.out.println("Эта фигура не может так ходить.");
            return false;
        }
        return true;
    }

    private boolean notSameSquare(ChessPiece squareForMove) {
        return isSameRow(squareForMove) && notSameColumn(this.col != squareForMove.col);
    }

    private boolean notSameColumn(boolean col) {
        return col;
    }

    /**
     *
     * @param squareForMove
     * @return
     */
    private boolean isSameRow(ChessPiece squareForMove) {
        return !notSameColumn(this.row == squareForMove.row);
    }

    @Override
    public boolean isThereObstacleAlongPath(ChessPiece squareForMove, boolean isMoveChecksSuccessful) {
        if (this.col == squareForMove.col && this.row > squareForMove.row) {
            isMoveChecksSuccessful = checkIsThereObstacleForwardPath(squareForMove);
        }
        if (this.col == squareForMove.col && this.row < squareForMove.row) {
            isMoveChecksSuccessful = checkIsThereObstacleBackPath(squareForMove);
        }
        if (this.col > squareForMove.col && this.row == squareForMove.row) {
            isMoveChecksSuccessful = checkIsThereObstacleLeftPath(squareForMove);
        }
        if (this.col < squareForMove.col && this.row == squareForMove.row) {
            isMoveChecksSuccessful = checkIsThereObstacleRightPath(squareForMove);
        }
        return isMoveChecksSuccessful;
    }

     private boolean checkIsThereObstacleForwardPath(ChessPiece squareForMove) {
        if (this.row != 0) {
            for (int i = this.row - 1; i > squareForMove.row; i--) {
                if (!notSameColumn(chessBoard[i][this.col] instanceof EmptySquare)) {
                    System.out.println("На пути присутствует помеха.");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkIsThereObstacleBackPath(ChessPiece squareForMove) {
        if (this.row != 7) {
            for (int i = this.row + 1; i < squareForMove.row; i++) {
                if (!notSameColumn(chessBoard[i][this.col] instanceof EmptySquare)) {
                    System.out.println("На пути присутствует помеха.");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkIsThereObstacleLeftPath(ChessPiece squareForMove) {
        if (this.col != 0) {
            for (int i = this.col - 1; i > squareForMove.col; i--) {
                if (!notSameColumn(chessBoard[this.row][i] instanceof EmptySquare)) {
                    System.out.println("На пути присутствует помеха.");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkIsThereObstacleRightPath(ChessPiece squareForMove) {
        if (this.col != 7) {
            for (int i = this.col + 1; i < squareForMove.col; i++) {
                if (!notSameColumn(chessBoard[this.row][i] instanceof EmptySquare)) {
                    System.out.println("На пути присутствует помеха.");
                    return false;
                }
            }
        }
        return true;
    }

    public void checkIsMayPieceCapture(ChessPiece squareForMove) {
        if (squareForMove instanceof King) {
            System.out.println("Вы не можете рубить вражеского короля!");
            movePiece(this);
        }
    }
}