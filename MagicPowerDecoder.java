import java.util.Scanner;

public class MagicPowerDecoder {

    // Helper method to count digits in a number
    public static int countDigits(int num) {
        if (num == 0) return 1;
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    // Method to generate the magic code
    public static int generateMagicCode(int power) {
        int result = 0;
        int multiplier = 1;

        // Count digits and prepare divisor
        int digits = countDigits(power);
        int divisor = (int)Math.pow(10, digits - 1);

        while (divisor > 0) {
            int digit = power / divisor;
            power %= divisor;
            divisor /= 10;

            int toAppend = (digit == 1) ? 1 : digit * digit;

            // Append the squared value or 1
            int tempDigits = countDigits(toAppend);
            result = result * (int)Math.pow(10, tempDigits) + toAppend;
        }

        // Reverse the result
        int reversed = 0;
        while (result > 0) {
            reversed = reversed * 10 + result % 10;
            result /= 10;
        }

        return reversed;
    }

    // Main method: ask user for input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to decode its magic power: ");
        int input = scanner.nextInt();

        int magicCode = generateMagicCode(input);
        System.out.println("Magic Power Code: " + magicCode);

        scanner.close();
    }
}
