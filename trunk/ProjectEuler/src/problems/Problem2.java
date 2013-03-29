package problems;

import java.math.BigInteger;

public class Problem2 {

	public static void main(String[] args) {
		long MAX = 4000000;
		BigInteger suma = new BigInteger("0");
		int[] fib = new int[100];
		fib[0] = fib[1] = 1;

		for (int i = 2; i < 100; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
			if (fib[i] <= MAX) {
				suma = suma.add(new BigInteger(String.valueOf(fib[i])));
			}else{
				break;
			}
		}
		System.out.printf("%d", suma);
	}
}
