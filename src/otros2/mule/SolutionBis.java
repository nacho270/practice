package otros2.mule;

import java.util.ArrayList;
import java.util.List;

public class SolutionBis {

	class Tree {
		public int x;
		public List<Tree> children = new ArrayList<SolutionBis.Tree>();
	}

	public SolutionBis() {
		Tree r = new Tree();
		Tree r1 = new Tree();
		Tree r2 = new Tree();
		Tree r3 = new Tree();
		Tree r4 = new Tree();
		Tree r5 = new Tree();
		r4.x = 21;
		r3.x = 20;
		r2.x = 3;
		r2.children.add(r3);
		r2.children.add(r4);
		r1.x = 10;
		r5.x = 1;
		r1.children.add(r5);
		r.x = 1;
		r.children.add(r2);
		r.children.add(r1);

		System.out.println(solution(r));

	}

	public int solution(Tree T) {
		return innerSolution(T, Integer.MIN_VALUE);
	}

	private int innerSolution(Tree t, int max) {
		int target = max < t.x ? t.x : max;
		return (max < t.x ? 1 : 0) + innerSolutionChildren(t.children, target, 0);
	}

	private int innerSolutionChildren(List<Tree> children, int max, int i) {
		if (children == null || children.isEmpty() || i >= children.size()) return 0;
		return innerSolution(children.get(i), max) + innerSolutionChildren(children, max, i + 1);
	}

	public static void main(String[] args) {
		new SolutionBis();
	}
}
