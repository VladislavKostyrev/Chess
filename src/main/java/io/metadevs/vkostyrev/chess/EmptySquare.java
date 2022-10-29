package io.metadevs.vkostyrev.chess;

public class EmptySquare extends ChessPiece {

    EmptySquare (int row, int col, String pieceIcon) {
        super(row, col, pieceIcon);
    }

    @Override
    public void checkPieceNotBlocked() {
    }

    @Override
    public void checkCanPieceMove(ChessPiece squareForMove) {
    }

    @Override
    public void checkCanPieceWalkThat(ChessPiece takenPiece) {
    }

    @Override
    public void checkThereObstacleAlongPath(ChessPiece squareForMove){
    }
}