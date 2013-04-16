package betterprogrammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolucionesBetterProgrammer {

	public static int countWords(String s) {
		int res = 0;
		int i = 0;
		while (i < s.length()) {
			if (!Character.isWhitespace(s.charAt(i))) {
				++res;
				int j = i + 1;
				while (j < s.length() && !Character.isWhitespace(s.charAt(j)))
					++j;
				i = j + 1;
			} else {
				++i;
			}
		}
		return res;
	}

	public static int[] removeDuplicates(int[] a) {
		int n = 0;
		for (int i = 0; i < a.length; ++i) {
			++n;
			for (int j = 0; j < i; ++j)
				if (a[j] == a[i]) {
					--n;
					break;
				}
		}
		int[] res = new int[n];
		n = 0;
		for (int i = 0; i < a.length; ++i) {
			boolean found = false;
			for (int j = 0; j < n; ++j)
				if (res[j] == a[i])
					found = true;
			if (!found)
				res[n++] = a[i];
		}
		return res;
	}

	public static interface Node {

		int getValue();

		List<Node> getChildren();
	}

	public static int getLevelSum(Node root, int N) {
		if (N == 1)
			return root.getValue();
		int sum = 0;
		for (Node child : root.getChildren())
			sum += getLevelSum(child, N - 1);
		return sum;
	}

	public static Change getCorrectChange(int cents) {
		int dol = cents / 100;
		cents %= 100;
		int qua = cents / 25;
		cents %= 25;
		int dim = cents / 10;
		cents %= 10;
		int nic = cents / 5;
		cents %= 5;
		return new Change(dol, qua, dim, nic, cents);
	}

	static class Change {

		private final int _dollars;
		private final int _quarters; //25 cents
		private final int _dimes; // 10 cents
		private final int _nickels; // 5 cents
		private final int _cents; // 1 cent

		public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
			_dollars = dollars;
			_quarters = quarters;
			_dimes = dimes;
			_nickels = nickels;
			_cents = cents;
		}

		public int getDollars() {
			return _dollars;
		}

		public int getQuarters() {
			return _quarters;
		}

		public int getDimes() {
			return _dimes;
		}

		public int getNickels() {
			return _nickels;
		}

		public int getCents() {
			return _cents;
		}
	}

	public static double getAverage(Node root) {
		cnt = sum = 0;
		average(root);
		return sum / cnt;
	}

	static void average(Node node) {
		++cnt;
		sum += node.getValue();
		for (Node child : node.getChildren())
			average(child);
	}

	static double cnt, sum;

	public static int countWaysToProduceGivenAmountOfMoney(int cents) {
		int[] dp = new int[cents + 1];
		dp[0] = 1;
		for (int x : new int[] { 1, 5, 10, 25, 50 })
			for (int i = 0; i + x <= cents; ++i)
				dp[i + x] += dp[i];
		return dp[cents];
	}

	public static boolean isPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; ++i, --j)
			if (s.charAt(i) != s.charAt(j))
				return false;
		return true;
	}

	public static int sumOfTwoLargestElements(int[] a) {
		if (a.length == 0)
			return 0;
		if (a.length == 1)
			return a[0];
		int x1 = Integer.MIN_VALUE, x2 = Integer.MIN_VALUE;
		for (int x : a)
			if (x > x1) {
				x2 = x1;
				x1 = x;
			} else if (x > x2) {
				x2 = x;
			}
		return x1 + x2;
	}

	public static List<Node> traverseTreeInDepth(Node root) {
		List<Node> list = new ArrayList<Node>();
		depth(root, list);
		return list;
	}

	static void depth(Node root, List<Node> list) {
		list.add(root);
		for (Node child : root.getChildren())
			depth(child, list);
	}

	public static int countWaysToJump(int N) {
		int[] res = new int[N + 1];
		res[0] = 1;
		for (int i = 1; i <= N; ++i)
			res[i] = res[i - 1] + (i - 2 >= 0 ? res[i - 2] : 0);
		return res[N];
	}

	public static Set<Object> getUniqueElements(Set<Object> a, Set<Object> b) {
		Set<Object> res = new HashSet<Object>();
		for (Object obj : a)
			if (!b.contains(obj))
				res.add(obj);
		for (Object obj : b)
			if (!a.contains(obj))
				res.add(obj);
		return res;
	}

	public static int getLargestRootToLeafSum(Node root) {
		return rec(root, 0);
	}

	static int rec(Node root, int sum) {
		sum += root.getValue();
		if (root.getChildren() == null || root.getChildren().size() == 0)
			return sum;
		int res = Integer.MIN_VALUE;
		for (Node child : root.getChildren())
			res = Math.max(res, rec(child, sum));
		return res;
	}

	public static double getProbability(int Y, int X) {
		double[] dp = new double[Y + 1];
		double p = 1.0 / 6;
		dp[0] = 1;
		for (int z = 0; z < Y; ++z)
			for (int i = Y; i >= 0; --i) {
				if (i + 1 <= Y)
					dp[i + 1] += dp[i] * p;
				dp[i] *= 1 - p;
			}
		double res = 0;
		for (int i = X; i <= Y; ++i)
			res += dp[i];
		return res;
	}

	public static String getBinaryRepresentation(int n) {
		String res = "";
		while (n > 0) {
			res = (char) ('0' + n % 2) + res;
			n /= 2;
		}
		if (res.length() == 0)
			res = "0";
		return res;
	}

	interface ListNode {

		int getItem();

		ListNode getNext();

		void setNext(ListNode next);
	}

	public static ListNode reverse(ListNode node) {
		ListNode prev = null;
		ListNode cur = node;
		while (cur != null) {
			ListNode next = node.getNext();
			node.setNext(prev);
			prev = node;
			node = next;
		}
		return prev;
	}

	public static List<String> transferFromAtoC(int n) {
		List<String> res = new ArrayList<String>();
		hanoi(n, "A", "C", "B", res);
		return res;
	}

	static void hanoi(int n, String from, String to, String using, List<String> list) {
		if (n == 0)
			return;
		hanoi(n - 1, from, using, to, list);
		list.add(from + to);
		hanoi(n - 1, using, to, from, list);
	}

	public static int getSumOfTwoClosestToZeroElements(int[] a) {
		if (a.length == 0)
			return 0;
		if (a.length == 1)
			return a[0];
		int x1 = Integer.MIN_VALUE, x2 = Integer.MIN_VALUE;
		for (int x : a)
			if (closerToZero(x, x1)) {
				x2 = x1;
				x1 = x;
			} else if (closerToZero(x, x2)) {
				x2 = x;
			}
		return x1 + x2;
	}

	static boolean closerToZero(int x, int y) {
		if (x == Integer.MIN_VALUE)
			return false;
		if (y == Integer.MIN_VALUE)
			return true;
		return Math.abs(x) < Math.abs(y) || Math.abs(x) == Math.abs(y) && x > 0;
	}

	public static int[] retainPositiveNumbers(int[] a) {
		int n = 0;
		for (int x : a)
			if (x > 0)
				++n;
		int[] res = new int[n];
		n = 0;
		for (int x : a)
			if (x > 0)
				res[n++] = x;
		Arrays.sort(res);
		return res;
	}

	public static List<Node> traverseTreeInWidth(Node root) {
		List<Node> res = new ArrayList<Node>();
		res.add(root);
		for (int i = 0; i < res.size(); ++i)
			for (Node child : res.get(i).getChildren())
				res.add(child);
		return res;
	}

	public static Object[] reverseArray(Object[] a) {
		int n = a.length;
		Object[] res = new Object[n];
		for (int i = 0; i < n; ++i)
			res[i] = a[n - 1 - i];
		return res;
	}

	public static int getClosestToZero(int[] a) {
		int res = a[0];
		for (int x : a)
			if (closerToZero(x, res))
				res = x;
		return res;
	}

	public static String capitalizeFirstLetters(String s) {
		StringBuilder res = new StringBuilder();
		char prev = ' ';
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			if (Character.isLetter(ch) && prev == ' ')
				res.append(Character.toUpperCase(ch));
			else
				res.append(ch);
			prev = ch;
		}
		return res.toString();
	}

	public static List<Integer> getPerfectNumbers(int from, int to) {
		List<Integer> res = new ArrayList<Integer>();
		for (int num = from; num <= to; ++num) {
			int sum = 0;
			for (int i = 1; i <= num / 2; ++i)
				if (num % i == 0)
					sum += i;
			if (sum == num)
				res.add(num);
		}
		return res;
	}

	public static List<Integer> getPrimeNumbers(int from, int to) {
		List<Integer> res = new ArrayList<Integer>();
		for (int num = from; num <= to; ++num) {
			boolean isPrime = true;
			for (int i = 2; i <= num / 2; ++i)
				if (num % i == 0) {
					isPrime = false;
					break;
				}
			if (isPrime)
				res.add(num);
		}
		return res;
	}

}