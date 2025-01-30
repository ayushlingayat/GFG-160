import java.util.Scanner;

public class ImplementPowDay76 {

    double power(double base, int exp) {
        if (exp == 0) return 1; // Base case: anything raised to 0 is 1
        double result = 1.0;
        int absExp = Math.abs(exp);

        while (absExp > 0) {
            if ((absExp & 1) == 1) { // If exponent is odd, multiply by base
                result *= base;
            }
            base *= base; // Square the base
            absExp >>= 1; // Divide exponent by 2
        }

        return (exp < 0) ? 1.0 / result : result; // Handle negative exponents
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base: ");
        double base = scanner.nextDouble();
        System.out.print("Enter exponent: ");
        int exp = scanner.nextInt();

        ImplementPowDay76 obj = new ImplementPowDay76();
        double result = obj.power(base, exp);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
