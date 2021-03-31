package com.gamecenter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

public class TileSlideTest {

    List<Integer> board = new ArrayList<>();
    TileSlideMovements tSM;

    @Before
    public void setUp() throws Exception {
        tSM = new TileSlideMovements(5);
    }

    @Test
    public void fillRandArr() {
        int random = (int) Math.floor(Math.random() * 9);
        board.add(random);
        while (board.size() < 9) {
            random = (int) Math.floor(Math.random() * 9);
            if (!board.contains(random)) {
                board.add(random);
            }
        }

        System.out.println(board);
    }

    @Test
    public void getValidMovesArrTest() {

        System.out.println(TileSlideMovements.validMovementArray.toString());
    }
}