package com.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFile {

    public static List<String> binary;


    public static void readInput(){
        try {
            binary = Files
                    .readAllLines(Path.of("input.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
