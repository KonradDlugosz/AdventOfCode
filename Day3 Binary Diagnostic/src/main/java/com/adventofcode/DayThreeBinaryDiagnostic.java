package com.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DayThreeBinaryDiagnostic {

    private static List<String> binary;
    private static String gammaRate = "";
    private static String epsilonRate = "";

    public static void main(String[] args) {
        readInput();
        rate(0);
        rate(1);

        int powerConsumption = Integer.parseInt(gammaRate,2) * Integer.parseInt(epsilonRate,2);
        System.out.println(powerConsumption);
    }

    public static void rate(int choice){
        int charLen = binary.get(0).length();
        for(int i = 0; i < charLen; i++){
            int numZeros = 0;
            int numOnes = 0;
            for(int j = 0; j < binary.size(); j++){
                if(binary.get(j).charAt(i) == '0'){
                    numZeros += 1;
                }else {
                    numOnes += 1;
                }

            }

            if(choice == 0){
                if(numOnes > numZeros){
                    gammaRate += "1";
                } else {
                    gammaRate += "0";
                }
            } else if(choice == 1){
                if(numOnes < numZeros){
                    epsilonRate += "1";
                } else {
                    epsilonRate += "0";
                }
            }

        }
    }



    public static void readInput(){
        try {
            binary = Files
                    .readAllLines(Path.of("input.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
