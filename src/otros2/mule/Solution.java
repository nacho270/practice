package otros2.mule;

class Solution {

	public Solution() {
		Tree r = new Tree();
		Tree r1 = new Tree();
		Tree r2 = new Tree();
		Tree r3 = new Tree();
		Tree r4 = new Tree();
		Tree r5 = new Tree();
		r4.x = 21;
		r3.x = 20;
		r2.x = 3;
		r2.l = r3;
		r2.r = r4;
		r1.x = 10;
		r5.x = 1;
		r1.l = r5;
		r.x = 1;
		r.l = r2;
		r.r = r1;

		System.out.println(solution(r));

	}

	class Tree {
		public int x;
		public Tree l;
		public Tree r;
	}

	public int solution(Tree T) {
		return innerSolution(T, T.x);
	}

	private int innerSolution(Tree t, int max) {
		if (t == null) return 0;
		if (max <= t.x) {
			return innerSolution(t.l, t.x) + innerSolution(t.r, t.x) + 1;
		} else {
			return innerSolution(t.l, max) + innerSolution(t.r, max);
		}
	}

	public static void main(String[] args) {
		new Solution();
	}
}
