package com.example.randomizerpath;
import java.util.Random;

public class PathCreator {
    private Boolean position[][];

    public PathCreator(){
        position = new Boolean[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                position[i][j] = false;
            }
        }
        randomGenerator();
    }

    public void randomGenerator(){
        Random generator = new Random();
        int start = 8;

        position[0][start] = true;
        int row = 0;
        int column = start;
        boolean checker = true;
        while(position[9][1]!= true){

            while(checker) {
                int directions = generator.nextInt(4 + 0) + 1;
                if(directions == 0){
                    if(row - 1 < 0 || position[row-1][column]){
                        continue;
                    }
                    else{
                        row -= 1;
                    }
                }
                else if(directions == 1){
                    if(column - 1 < 0 || position[row][column-1]){
                        continue;
                    }
                    else{
                        column-=1;
                    }
                }
                else if(directions == 2){
                    if(row + 1 > 9 || position[row+1][column]){
                        continue;
                    }
                    else{
                        row += 1;
                    }

                }
                else if(directions == 3){
                    if(column + 1 > 9 || position[row][column+1]){
                        continue;
                    }
                    else{
                        column+=1;
                    }
                }
                break;
            }
            position[row][column] = true;
        }
    }
    public boolean checkValid(int row, int column){
        return position[row][column];
    }
}
