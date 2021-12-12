package com.adventofcode;

import java.util.ArrayList;
import java.util.List;

import static com.adventofcode.ReadFile.binary;
import static com.adventofcode.ReadFile.readInput;

public class PartTwo {

    private static int oxygenGeneratorRating = 0;
    private static int co2ScrubberRating = 0;
    private static int lifeSupportRating = 0;

    public enum Rating {
        OXYGEN_GENERATOR_RATING, CO2_SCRUBBER_RATING
    }

    public static void main(String[] args) {
        readInput();
        oxygenGeneratorRating = bitCriteria(Rating.OXYGEN_GENERATOR_RATING);
        co2ScrubberRating = bitCriteria(Rating.CO2_SCRUBBER_RATING);
        lifeSupportRating = oxygenGeneratorRating * co2ScrubberRating;
        System.out.println(lifeSupportRating);

    }

    private static int bitCriteria(Rating type){
        List<String> binaryCopy = new ArrayList<>(binary);
        List<String> temp = new ArrayList<>();

        //Loop char in elements
        for(int i = 0; i < 12; i++){

            //Count 1's and 0's
            int oneCount = 0;
            int zeroCount = 0;
            for(int j = 0; j < binaryCopy.size(); j++){
                if(binaryCopy.get(j).charAt(i) == '1')
                    oneCount += 1;
                else
                    zeroCount += 1;
            }

            //OXYGEN rating calc
            if(type == Rating.OXYGEN_GENERATOR_RATING){
                //Filter current binary list
                if(oneCount > zeroCount | oneCount == zeroCount){
                    for(int k = 0; k < binaryCopy.size(); k++ ){
                        if(binaryCopy.get(k).charAt(i) == '1')
                            temp.add(binaryCopy.get(k));
                    }
                } else if(oneCount < zeroCount){
                    for(int k = 0; k < binaryCopy.size(); k++){
                        if(binaryCopy.get(k).charAt(i) == '0'){
                            temp.add(binaryCopy.get(k));
                        }
                    }
                }
                //CO2 Rating calc
            }else if(type == Rating.CO2_SCRUBBER_RATING){
                //Filter current binary list
                if(oneCount < zeroCount){
                    for(int k = 0; k < binaryCopy.size(); k++ ){
                        if(binaryCopy.get(k).charAt(i) == '1')
                            temp.add(binaryCopy.get(k));
                    }
                } else if(oneCount > zeroCount | oneCount == zeroCount){
                    for(int k = 0; k < binaryCopy.size(); k++){
                        if(binaryCopy.get(k).charAt(i) == '0'){
                            temp.add(binaryCopy.get(k));
                        }
                    }
                }

            }

            //Check if one left
            if(binaryCopy.size() == 1){
                return Integer.parseInt(binaryCopy.get(0), 2);
            }

            //Update @BinaryCopy
            binaryCopy.clear();
            binaryCopy.addAll(temp);
            temp.clear();

        }

        return Integer.parseInt(binaryCopy.get(0), 2);
    }
}
