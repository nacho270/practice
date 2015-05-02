package otros2.mule;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	public Solution2() {
		IntList in1 = new IntList();
		IntList in2 = new IntList();
		IntList in3 = new IntList();
		IntList in4 = new IntList();

		in1.value = 1;
		in1.next = in2;

		in2.value = 2;
		in2.next = in3;

		in3.value = 3;
		in3.next = in4;

		in4.value = 4;
		in4.next = null;
		System.out.println(solution(in1, 4));
	}

	class IntList {
		public int value;
		public IntList next;
	}

	public int solution(IntList L, int M) {
		if (L == null) return -1;
		if (M <= 0) return -1;
		int size = 0;
		IntList prev = null;
		List<IntList> list = new ArrayList<IntList>();
		while (L != null) {
			list.add(L);
			IntList next = L.next;
			L.next = prev;
			prev = L;
			L = next;
			size++;
		}
		if (M > size)
			return -1;
		return list.get(size - M).value;
	}

	public static void main(String[] args) {
		new Solution2();
	}
}
