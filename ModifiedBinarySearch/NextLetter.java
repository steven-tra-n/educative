package ModifiedBinarySearch;

public class NextLetter {
    public static char searchNextLetter(char[] letters, char key){
        int start = 0;
        int end = letters.length - 1;
        int middle = start + (end - start) / 2;

        while(start <= end){
            char middleLetter = letters[middle];

            if(key < middleLetter){
                end = middle - 1;
            } else{
                start = middle + 1;
            };

            middle = start + (end - start) / 2;
        };

        // In case start is equal to the end of the array, wrap around
        return letters[start % letters.length];
    };
};

// System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
//     System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
//     System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
//     System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));