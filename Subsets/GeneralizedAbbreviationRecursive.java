package Subsets;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviationRecursive {
    public static List<String> generateGeneralizedAbbreviation(String word){
        List<String> result = new ArrayList<>(); 

        generateAbbreviationRecursive(word, new StringBuilder(), 0, 0, result);

        return result;
    };

    private static void generateAbbreviationRecursive(String word, StringBuilder abWord, int start, int count, List<String> result){
        if(start == word.length()){
            if(count != 0){
                abWord.append(count);
            };

            result.add(abWord.toString());
        } else{
            // Continue abbreviating by incrementing the current abbreviation count
            generateAbbreviationRecursive(word, new StringBuilder(abWord), start + 1, count + 1, result);

            // Restart abbreviating, append the count and the current character to the string
            if(count != 0){
                abWord.append(count);
            };

            generateAbbreviationRecursive(word, new StringBuilder(abWord).append(word.charAt(start)), start + 1, 0, result);
        };
    };
};

// List<String> result = GeneralizedAbbreviationRecursive.generateGeneralizedAbbreviation("BAT");
//     System.out.println("Generalized abbreviation are: " + result);

//     result = GeneralizedAbbreviationRecursive.generateGeneralizedAbbreviation("code");
//     System.out.println("Generalized abbreviation are: " + result);