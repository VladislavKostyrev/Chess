package io.metadevs.vkostyrev.chess;

public class Bishop extends ChessPiece {
    Bishop (int row, int col, char colour, String pieceIcon) {
        super(row, col, colour, pieceIcon);
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
