package otros2.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {
	public static void main(String args[]) throws Exception {
//		progresion();
		primos();
	}

	private static void primos() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		System.out.println(getNumberOfPrimes(N));
	}
	
	@SuppressWarnings("unused")
	private static void progresion() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cant = Integer.valueOf(br.readLine());
		String line = br.readLine();
		String[] strNumbers = line.split(" ");
		int[] numbers = new int[strNumbers.length];
		for (int i = 0; i < cant; i++) {
			numbers[i] = Integer.valueOf(strNumbers[i]);
		}
		int diff = numbers[1] - numbers[0];
		for (int i = 0; i < cant - 1; i++) {
			if (numbers[i + 1] - numbers[i] != diff) {
				System.out.println(numbers[i] + diff);
			}
		}
	}
	
	static int getNumberOfPrimes(int N) {
		int cont = 0;
		double sqrt = Math.sqrt((double)N);
		int top = Math.round((int)sqrt);
		for (int num = 2; num <= N; ++num) {
			boolean isPrime = true;
			for (int i = 2; i <= top; ++i){
				if (num % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				cont++;
			}
		}
		return cont;
    }
}