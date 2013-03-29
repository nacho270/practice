package problems;

public class Problem1 {

	public static void main(String[] args) {
		int MAX = 1000;
		int suma = 0;
		int i = 3;
		for (i = 3; i <= MAX; i++) {
			if ((i % 3) == 0 || (i % 5 == 0)) {
				suma += i;
			}
		}
		System.out.printf("%d\n", suma);
	}
}
