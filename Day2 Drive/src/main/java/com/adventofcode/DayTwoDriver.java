package com.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DayTwoDriver {
    public static List<String> action;
    public static List<Integer> value;

    public static void main(String[] args) {

        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        int horizontalTimesDepth = 0;
        readInput();

        for(int i = 0; i < action.size(); i++){
            if(action.get(i).equals("forward")){
                horizontal += value.get(i);
                depth += value.get(i) * aim;
            } else if(action.get(i).equals("down")){
                aim += value.get(i);
            } else if(action.get(i).equals("up")){
                aim -= value.get(i);
            }
        }
        horizontalTimesDepth = horizontal * depth;
        System.out.println(horizontalTimesDepth);


    }


    public static void readInput(){
        try {
            action = Files
                    .lines(Path.of("input.txt"))
                    .map(s -> {
                        String [] split = s.split(" ");
                        return split[0];
                    })
                    .toList();

            value = Files
                    .lines(Path.of("input.txt"))
                    .map(s -> {
                        String [] split = s.split(" ");
                        return Integer.parseInt(split[1]);
                    })
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
