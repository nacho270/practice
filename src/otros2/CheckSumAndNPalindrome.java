package otros2;

import java.util.Arrays;

public class CheckSumAndNPalindrome {

    private static void runNPalindrome(final String word) {
        int level = 0;
        while (level < word.length() - 1) {
            final boolean palindrome = isPalindrome(word, level);
            if (palindrome) {
                System.out.println(word + " es palindrome a nivel " + level + ": " + word.substring(level));
                return;
            }
            level++;
        }
        System.out.println(word + " no es palindrome");
    }

    private static boolean isPalindrome(final String word, final int start) {
        if (word.length() < 2) {
            return true;
        }
        final int middle = start + word.length() / 2;
        int end = word.length() - 1;
        for (int i = start; i < middle; i++) {
            if (word.charAt(i) != word.charAt(end)) {
                return false;
            }
            end--;
        }
        return true;
    }

    private static void checkSum(final int[] a, final int[] b, final int num) {
        Arrays.sort(a);
        Arrays.sort(b);
        int indexA = 0;
        int indexB = b.length - 1;
        int sum;
        while (indexA < a.length && indexB >= 0) {
            sum = a[indexA] + b[indexB];
            if (sum == num) {
                System.out.println("Found it! " + num + " = " + a[indexA] + " + " + b[indexB]);
                break;
            } else if (sum > num) {
                indexB--;
            } else {
                indexA++;
            }
        }
    }

    public static void main(final String[] args) {
        runNPalindrome("pepe");
        checkSum(new int[] { 1, 2, 3, 4, 5 }, new int[] { 10, 11, 12, 13, 14 }, 13);
    }
}
