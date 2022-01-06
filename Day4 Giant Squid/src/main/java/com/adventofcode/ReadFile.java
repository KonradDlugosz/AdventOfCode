package com.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
    public static String drawNumbers;
    public static List<String[][]> boardList = new ArrayList<>();

    public static void readFile()  {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("input.txt"));
            //Read drawNumbers
            String lineOfText = bufferedReader.readLine();
            drawNumbers = lineOfText;

            //Read boards
            while((lineOfText = bufferedReader.readLine()) != null){
                String [] boards = lineOfText.split(" ");
                System.out.println(Arrays.toString(boards));
            }

            //Convert

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
