package TwoPointers;

public class BackspaceCompare {
    public static boolean compare(String str1, String str2) {
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;

        while(index1 >= 0 || index2 >= 0){
            if(str1.charAt(index1) == '#'){
                index1 = index1 - 2;
            };

            if(str2.charAt(index2) == '#'){
                index2 = index2 - 2;
            };

            if(str1.charAt(index1) == str2.charAt(index2)){
                index1--;
                index2--;
            } else{
                return false;
            };
        };

        if(index1 == index2){
            return true;
        };

        return false;
    };
};