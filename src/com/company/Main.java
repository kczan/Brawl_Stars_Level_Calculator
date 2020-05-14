package com.company;


import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final short MAX_POINTS = 1410;

    public static int calculateTotalPoints(int gainedPoints, int currentLevel){
        HashMap<Integer, Integer> levelPoints = LevelPoints.getTable();
        int accumulatedPoints = 0;
        for (int i = 2; i <= currentLevel; i++){
            accumulatedPoints += levelPoints.get(i);
        }
        accumulatedPoints += gainedPoints;
        return accumulatedPoints;
    }

    public static int getMaximumAvailableLevel(int accumulatedPoints, int currentLevel) {
        int nextLevel = currentLevel + 1;
        int levelAvailable = currentLevel;
        HashMap<Integer, Integer> levelPoints = LevelPoints.getTable();
        if (accumulatedPoints < levelPoints.get(nextLevel)) {
            System.out.println("You can't upgrade your brawler yet, keep playing!");
            System.exit(0);
        }
        while (accumulatedPoints >= levelPoints.get(nextLevel)) {
            accumulatedPoints -= levelPoints.get(nextLevel);
            nextLevel++;
            levelAvailable++;
        }
        return levelAvailable;
    }

    public static int getCurrentLevel(){
        System.out.println("What is your brawlers current level?");
        Scanner currentLevel = new Scanner(System.in);
        return currentLevel.nextInt();
    }

    public static int getGainedPoints(){
        System.out.println("How many power points have you already collected?");
        Scanner gainedPoints = new Scanner(System.in);
        return gainedPoints.nextInt();
    }
    public static void main(String[] args) {
        int currentLevel = getCurrentLevel();
        int gainedPoints = getGainedPoints();
        int totalPoints = calculateTotalPoints(gainedPoints, currentLevel);
        if (totalPoints == MAX_POINTS) {
            System.out.println("You can upgrade your brawler to maximum level. Congratulations!");
            System.exit(0);
        } else if (totalPoints > MAX_POINTS) {
            System.out.println("Maximum points total exceeded, please check again.");
            System.exit(0);
        }
        System.out.println("You can upgrade your brawler up to level " + Integer.toString(getMaximumAvailableLevel(gainedPoints, currentLevel)));

    }
}
