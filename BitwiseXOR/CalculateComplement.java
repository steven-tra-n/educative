package BitwiseXOR;

public class CalculateComplement {
    public static int bitwiseComplement(int num){
        int bitCount = 0;
        int n = num;

        while(n > 0){
            bitCount++;
            n = n >> 1;
        };

        // We can get the complement of num by XORing it with a binary number that has all set bits
        // In other words, a complete power. Which is 2 ** n - 1

        int completePower = (int)Math.pow(2, bitCount) - 1;

        return num ^ completePower;
    };
};

    //   System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(8));
    //   System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));