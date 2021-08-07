package FastSlowPointers;

public class HappyNumber {
    public static boolean find(int num) {
        // Split 23 into 2 and 3, num % 10
        // Add their squares, sum += digit * digit
        // Divide by 10, num /= 10
        // Return that sum
        int slow = num, fast = num;

        do{
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while(slow != fast); 
        // slow and fast will eventually run into each other. Either at 1 when they stop looping or at when the cycle resets

        return slow == 1;
    };

    private static int findSquareSum(int num){
        int sum = 0, digit;

        while(num > 0){
            digit = num % 10; // Fetch single digit
            sum += digit * digit; // Add the square of the single digit
            num /= 10; // Divide by 10
        };

        return sum;
    };

    public static boolean find2(int num) {
        int fast = num;
        int slow = num;

        do{
            fast = findSquareSum2(fast);
            fast = findSquareSum2(fast);
            slow = findSquareSum2(slow);
        } while(fast != slow);

        return slow == 1;
    };

    private static int findSquareSum2(int num){
        int sum = 0;
        int digit;

        while(num > 0){
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        };

        return sum;
    };
};

// System.out.println(HappyNumber.find(23));
// System.out.println(HappyNumber.find(12));