package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubmarineRadar {
    public static void main(String[] args) {
        //Read file and add to list called input
        List<Integer> input = new ArrayList<>();
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                input.add(Integer.parseInt(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int largerThanPrevious = sonarSweep(input);
        System.out.println(largerThanPrevious);

    }

    public static int sonarSweep(List<Integer> input){
        int largerThanPrevious = 0;
        for(int i = 3; i < input.size(); i++){
            int windowOne = input.get(i-1) + input.get(i-2) + input.get(i - 3);
            int windowTwo = input.get(i) + input.get(i-1) + input.get(i-2);
            if(windowOne < windowTwo){
                largerThanPrevious += 1;
            }
        }

        return largerThanPrevious;
    }
}
