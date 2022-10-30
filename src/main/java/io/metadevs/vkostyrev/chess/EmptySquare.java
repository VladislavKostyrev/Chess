package io.metadevs.vkostyrev.chess;

public class EmptySquare extends ChessPiece {

    EmptySquare (int row, int col, String pieceIcon) {
        super(row, col, pieceIcon);
    }

    @Override
    public void checkPieceNotBlocked() {
    }

    @Override
    public void checkCanPieceMove() {
    }

    @Override
    public void checkCanPieceWalkThat() {
    }

    @Override
    public void checkThereObstacleAlongPath(){
    }
}