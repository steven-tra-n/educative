package Subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateValidParentheses(int num){
        List<String> result = new ArrayList<>();

        if(num <= 0){
            return result;
        };

        recursion(0, num, new String(), 0, 0, result);

        return result;
    };

    private static void recursion(int index, int num, String currentString, int openCount, int closeCount, List<String> result){
        if(index == num){
            while(openCount > closeCount){
                currentString += ')';
                closeCount++;
            };

            result.add(currentString);
        };

        for(int i = index; i < num; i++){
            currentString += '(';
            openCount++;
            recursion(i + 1, num, currentString, openCount, closeCount, result);
            // Unnecessary call after base case is reached
            currentString += ')';
            closeCount++;
        };
    };
};

// List<String> result = GenerateParentheses.generateValidParentheses(2);
//     System.out.println("All combinations of balanced parentheses are: " + result);

//     result = GenerateParentheses.generateValidParentheses(3);
//     System.out.println("All combinations of balanced parentheses are: " + result);