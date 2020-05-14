package com.company;

import java.util.HashMap;

public class LevelPoints {
    private static HashMap<Integer, Integer> levelPoints = new HashMap<Integer, Integer>();
    

    public static HashMap<Integer, Integer> getTable(){
        levelPoints.put(2, 20);
        levelPoints.put(3, 30);
        levelPoints.put(4, 50);
        levelPoints.put(5, 80);
        levelPoints.put(6, 130);
        levelPoints.put(7, 210);
        levelPoints.put(8, 340);
        levelPoints.put(9, 550);
        return levelPoints;
    }
}
