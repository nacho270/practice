package otros2.mule;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

	public Solution3() {
		System.out.println(solution(new int[] { 10, 10, 30, 30, 40, 10 }));
	}

	public int solution(int[] A) {
		if (A == null || A.length == 0)
			return -1;
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		int maxOccurrences = -1;
		int returnValue = -1;
		for (int i : A) {
			Integer counter = countMap.get(i);
			if (counter == null) {
				countMap.put(i, 1);
				if (1 > maxOccurrences) {
					maxOccurrences = 1;
					returnValue = i;
				}
			} else {
				int newCounter = counter.intValue() + 1;
				countMap.put(i, newCounter);
				if (newCounter > maxOccurrences) {
					maxOccurrences = newCounter;
					returnValue = i;
				}
			}
		}
		return returnValue;
	}

	public static void main(String[] args) {
		new Solution3();
	}
}
