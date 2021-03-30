package com.gamecenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This Class is for use with the TileSlide Class. It's purpose is to dynamically generate valid and legal movements
 * board games that involve a perfect square that has one missing tile for rearrangement of order.
 */
class TileSlideMovements {

    int key;
    public static final int GRID_TILES = 9;
    public static final int GRID_WIDTH_LENGTH = 3;
    private final List<Integer> board = Arrays.asList(new Integer[GRID_TILES]);
    public static List<ArrayList<Integer>> validMovementArray = new ArrayList<>();

    // CONSTRUCTORS

    /**
     * Upon instantiation, constructor generates all of the valid movements of a given index
     */
    TileSlideMovements() {
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
    private ArrayList<Integer> setValidMovement(int index) {
        ArrayList<Integer> moves = new ArrayList<>();
        int maxIndex = GRID_WIDTH_LENGTH - 1;
        int upIndex = index - GRID_WIDTH_LENGTH;
        int downIndex = index + GRID_WIDTH_LENGTH;

        // Vertical Movement
        if (downIndex < (GRID_TILES) && downIndex >= 0) {
            moves.add(downIndex);
        }
        if (upIndex < (GRID_TILES) && upIndex >= 0) {
            moves.add(upIndex);
        }
        // Horizontal Movement
        if ((index % GRID_WIDTH_LENGTH) == 0) {
            moves.add(index + 1);
        } else if ((index % GRID_WIDTH_LENGTH) == maxIndex) {
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
    private List<ArrayList<Integer>> generateAllValidMovements() {
        List<ArrayList<Integer>> allMoves = new ArrayList<>();
        for (int index = 0; index < (GRID_TILES); index++) {
//            new TileSlideMovements(index);
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
//        return validMovementMap.containsKey(index) && validMovementMap.containsValue(emptyTile);
        return getValidMovementArray(index).contains(emptyTile);
    }

    /**
     * Searches the array for the value zero
     *
     * @return returns the index that holds the value zero
     */
    public int getBlankTile() {
        return board.indexOf(0);
    }

    // ACCESSOR METHODS
    private int getKey() {
        return key;
    }

    private void setKey(int key) {
        this.key = key;
    }

    private ArrayList<Integer> getValidMovementArray(int key) {
        return validMovementArray.get(key);
    }

    private void setValidMovementArray(List<ArrayList<Integer>> validMovementArray) {
        TileSlideMovements.validMovementArray = validMovementArray;
    }
}
