package Subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutation {
    public static List<String> findLetterCaseStringPermutations(String str){
        List<String> result = new ArrayList<>();

        if(str.length() == 0){
            return result;
        };

        result.add(str);
        recursion(str, 0, result);

        return result;
    };

    private static void recursion(String str, int index, List<String> result){
        char[] strChars = str.toCharArray();

        for(int i = index; i < str.length(); i++){
            if(Character.isAlphabetic(strChars[i])){
                if(Character.isUpperCase(strChars[i])){
                    strChars[i] = Character.toLowerCase(strChars[i]);
                    result.add(String.valueOf(strChars));
                    recursion(str, i + 1, result);
                    // No need to backtrack
                    // strChars[i] = Character.toUpperCase(strChars[i]);
                } else{
                    strChars[i] = Character.toUpperCase(strChars[i]);
                    result.add(String.valueOf(strChars));
                    recursion(str, i + 1, result);
                    // strChars[i] = Character.toLowerCase(strChars[i]);
                };
            };
        };
    };
};

// List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
//     System.out.println(" String permutations are: " + result);

//     result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
//     System.out.println(" String permutations are: " + result);