package io.metadevs.vkostyrev.chess;

public class EmptySquare extends ChessPiece {

    EmptySquare (int row, int col, String pieceIcon) {
        super(row, col, pieceIcon);
    }

    @Override
    public void isPieceNotBlocked() {

    }

    @Override
    public boolean isCanPieceMove(ChessPiece squareForMove, boolean isMoveChecksSuccessful) {
        return false;
    }

    @Override
    public boolean isMayPieceWalkThat(ChessPiece takenPiece) {
        return false;
    }

    @Override
    public boolean isThereObstacleAlongPath(ChessPiece squareForMove, boolean isMoveChecksSuccessful) {
        return false;
    }

    @Override
    public void checkIsMayPieceCapture(ChessPiece squareForMove) {

    }

}