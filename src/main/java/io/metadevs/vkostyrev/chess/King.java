package io.metadevs.vkostyrev.chess;

public class King extends ChessPiece{
    //TODO написать логику для
    King (int row, int col, char colour, String pieceIcon) {
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
}
