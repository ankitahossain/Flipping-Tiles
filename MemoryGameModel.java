/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package memorygamemodel;

/**
 *
 * @author USER
 *
 * 
 * /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



 


import java.util.ArrayList;
import java.util.Collections;

public class MemoryGameModel {
    private final int NUM_TILES = 16;
    private final int NUM_PAIRS = NUM_TILES / 2;
    private final ArrayList<String> tileValues = new ArrayList<>();

    public MemoryGameModel() {
        initializeTileValues();
    }

    private void initializeTileValues() {
        for (int i = 0; i < NUM_PAIRS; i++) {
            tileValues.add(Character.toString((char) ('A' + i)));
            tileValues.add(Character.toString((char) ('A' + i)));
        }
        Collections.shuffle(tileValues);
    }

    public int getNumTiles() {
        return NUM_TILES;
    }

    public String getTileValue(int index) {
        return tileValues.get(index);
    }
}
