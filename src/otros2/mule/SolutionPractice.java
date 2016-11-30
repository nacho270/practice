package otros2.mule;

public class SolutionPractice {
	public static int solution(int[] A) throws Exception {
		int equilibrio = -1;
		if (A == null || A.length == 0) {
			throw new Exception("A");
		}
		long sumLeft = 0;
		long sumRight = 0;
		for (int i = 0; i < A.length; i++) {
			sumRight += A[i];
		}
		for (int i = 0; i < A.length; i++) {
			long tempRight = sumRight - A[i];
			if (sumLeft == tempRight) {
				equilibrio = i;
				break;
			} else {
				sumLeft += A[i];
				sumRight = tempRight;
			}
		}
		return equilibrio;
	}

	public static void main(String[] args) {
		try {
			System.out.println(solution(new int[] { -7, 1, 5, 2, -4, 3, 0 }));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}