package TwoPointers;

public class BackspaceCompare {
    public static boolean compare(String str1, String str2) {
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;
        int tempIndex1;
        int tempIndex2;

        while(index1 >= 0 || index2 >= 0){
            tempIndex1 = findNextValidIndex(str1, index1);
            tempIndex2 = findNextValidIndex(str2, index2);

            if(str1.charAt(tempIndex1) == str2.charAt(tempIndex2)){
                index1 = tempIndex1 - 1; // Set indicies to newly found indicies
                index2 = tempIndex2 - 1;
            } else{
                return false;
            };
        };

        if(index1 == index2){
            return true;
        };

        return false;
    };

    private static int findNextValidIndex(String str, int index){
        int backspaceCount = 0;

        while(index >= 0){
            if(str.charAt(index) == '#'){
                backspaceCount++;
            } else if(backspaceCount > 0){
                backspaceCount--; // Decrement backspaceCount as well as index since two chars need to be skipped for each '#'
            } else{
                break; // Index is valid, return
            };

            index--;
        };

        return index;
    };
};

// System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
// System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
// System.out.println(BackspaceCompare.compare("xp#", "xyz##"));    
// System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));