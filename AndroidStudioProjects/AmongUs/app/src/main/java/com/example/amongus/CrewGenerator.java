package com.example.amongus;

import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class CrewGenerator {
    Boolean crew[][];
    HashSet<Integer> checkClick;
    int ctr = 0;

    public CrewGenerator(){
        crew = new Boolean[3][3];
        for (int i = 0; i < crew.length; i++) {
            for (int j = 0; j < crew[0].length; j++) {
                crew[i][j] = false;
            }
        }
        checkClick = new HashSet<>();
    }

    public boolean yesNo(int id) {
        int chance = 3;
        int i = 0;
        if(!checkClick.contains(id)){
            Random rand = new Random();
            int randomValue = rand.nextInt(chance) % 2;
            switch(randomValue){
                case 1: chance++; checkClick.add(id); return true;
                default: return false;
            }
        }
        else{
            return true;
        }
    }
}
