import java.io.*;
import java.util.*;

public class Solution {

    interface PerformOperation {
        boolean check(int num);
    }

    public static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return n -> {
            if (n < 2) return false;

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return n -> {
            String s = String.valueOf(n);
            String reversed = new StringBuilder(s)
                    .reverse()
                    .toString();

            return s.equals(reversed);
        };
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            String[] input = br.readLine().split(" ");

            int type = Integer.parseInt(input[0]);
            int number = Integer.parseInt(input[1]);

            PerformOperation operation;

            if (type == 1) {
                operation = isOdd();
            } else if (type == 2) {
                operation = isPrime();
            } else {
                operation = isPalindrome();
            }

            if (operation.check(number)) {
                System.out.println("ODD");
            } else if (type == 2) {
                System.out.println("COMPOSITE");
            } else if (type == 3) {
                System.out.println("PALINDROME");
            }
        }
    }
}
