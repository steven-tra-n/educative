import SlidingWindow.*;

public class main {
    public static void main(String[] args){
        System.out.println("Permutation exist: " + StringPermutation.findPermutation1("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation1("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation1("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation1("aaacb", "abc"));
    };
};