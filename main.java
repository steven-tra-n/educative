import SlidingWindow.*;

public class main {
    public static void main(String[] args){
        System.out.println("Maximum number of fruits: " + 
        MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " + 
        MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    };
};