package com.gamecenter;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class is for use with the TileSlide Class. It's purpose is to dynamically generate valid and legal movements
 * board games that involve a perfect square that has one missing tile for rearrangement of order.
 */
class TileSlideMovements extends TileSlideSubMenu {
    int gridTiles;
    int gridWidthLength;
    public static List<List<Integer>> validMovementArray = new ArrayList<>();

    // CONSTRUCTORS

    /**
     * Upon instantiation, constructor generates all of the valid movements of a given index
     */
    TileSlideMovements(int gridWxL) {
        this.gridTiles = (gridWxL * gridWxL);
        this.gridWidthLength = gridWxL;
        setValidMovementArray(generateAllValidMovements());
    }

    // METHODS

    /**
     * Dynamically generates all of the valid vertical and horizontal movements for a given index in the array.
     * Implementation works for any size perfect square i.e. 3x3, 4x4, 5x5, etc....
     *
     * @param index the given index in the array for which to set the valid movements
     * @return an array list with all the valid movements
     */
    private List<Integer> setValidMovement(int index) {
        List<Integer> moves = new ArrayList<>();
        int maxIndex = gridWidthLength - 1;
        int upIndex = index - gridWidthLength;
        int downIndex = index + gridWidthLength;

        // Vertical Movement
        if (downIndex < (gridTiles) && downIndex >= 0) {
            moves.add(downIndex);
        }
        if (upIndex < (gridTiles) && upIndex >= 0) {
            moves.add(upIndex);
        }
        // Horizontal Movement
        if ((index % gridWidthLength) == 0) {
            moves.add(index + 1);
        } else if ((index % gridWidthLength) == maxIndex) {
            moves.add(index - 1);
        } else {
            moves.add(index + 1);
            moves.add(index - 1);
        }
        return moves;
    }

    /**
     * Dynamically generates all of the valid movements the entire array length.
     * Implementation works for any size perfect square i.e. 3x3, 4x4, 5x5, etc....
     *
     * @return List of ArrayList with all the valid movements for a given index
     */
    private List<List<Integer>> generateAllValidMovements() {
        List<List<Integer>> allMoves = new ArrayList<>();
        for (int index = 0; index < (gridTiles); index++) {
            allMoves.add(setValidMovement(index));
        }
        return allMoves;
    }

    /**
     * Checks if the attempted valid movement is legal. The movement must be made with an index
     * that contains the value zero.
     *
     * @param index     takes in the index of the selected tile for lookup of its valid movements
     * @param emptyTile index of the value zero
     * @return boolean confirming islegal move and to interchange or leave alone.
     */
    public boolean confirmLegalMovement(int index, int emptyTile) {
        return getValidMovementArray(index).contains(emptyTile);
    }

    // ACCESSOR METHODS
    private List<Integer> getValidMovementArray(int key) {
        return validMovementArray.get(key);
    }

    private void setValidMovementArray(List<List<Integer>> validMovementArray) {
        TileSlideMovements.validMovementArray = validMovementArray;
    }

}
