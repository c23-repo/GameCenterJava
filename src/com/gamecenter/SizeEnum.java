package com.gamecenter;

enum SizeEnum {
    THREES(3), FOURS(4), FIVES(5);

    private final int squareSize;

    SizeEnum(int squareSize) {
        this.squareSize = squareSize;
    }

    public int squareWidthHeight() {
        return squareSize;
    }

    public int perfectSquareSize() {
        return (squareSize * squareSize);
    }
}