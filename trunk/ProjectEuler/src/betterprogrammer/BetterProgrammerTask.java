package betterprogrammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BetterProgrammerTask {

	public static List<Integer> getPrimeNumbers(int from, int to) {
		/*
		  Please implement this method to
		  return a list of all prime numbers in the given range (inclusively).
		  A prime number is a natural number that has exactly two distinct natural number divisors, which are 1 and the prime number itself.
		  The first prime numbers are: 2, 3, 5, 7, 11, 13
		 */
		List<Integer> primos = new ArrayList<Integer>();
		from = from < 2 ? 2 : from;
		boolean primo = true;
		for (int i = from; i <= to; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					primo = false;
					break;
				}
			}
			if (primo) {
				primos.add(i);
			} else {
				primo = true;
			}
		}
		return primos;
	}

	public static int countAlmostPrimeNumbers(int from, int to) {
		/*
		  A prime number is a natural number that has exactly two distinct natural number divisors,
		  which are 1 and the prime number itself.
		  The first prime numbers are: 2, 3, 5, 7, 11, 13.

		  Almost prime numbers are the non-prime numbers
		  which are divisible by only a single prime number.

		  Please implement this method to
		  return the number of almost prime numbers within the given range (inclusively).
		 */
		List<Integer> primos = getPrimeNumbers(from, to);
		int cuenta = 0;
		int cuentaRet = 0;
		for (int i = from; i <= to; i++) {
			for (Integer primo : primos) {
				if (i % primo == 0) {
					cuenta++;
				}
			}
			if (cuenta == 1) {
				cuentaRet++;
			} else {
				cuenta = 0;
			}
		}
		return cuentaRet;
	}

	public static Change getCorrectChange(int cents) {
		/*
		  Please implement this method to
		  take cents as a parameter
		  and return an equal amount in dollars and coins using the minimum number of
		  coins possible.
		  For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
		  Return null if the parameter is negative.
		 */
		if (cents < 0) {
			return null;
		}
		if (cents == 0) {
			return new Change(0, 0, 0, 0, 0);
		}

		int dollars = 0;
		if (cents >= 100) {
			dollars = cents / 100;
		}
		int modulo100 = cents % 100;
		int modulo25 = modulo100 % 25;
		int modulo10 = modulo25 % 10;

		int quarters = modulo100 / 25;
		int dimes = modulo25 / 10;
		int nickels = modulo10 / 5;
		int centavos = modulo10 % 5;
		return new Change(dollars, quarters, dimes, nickels, centavos);
	}

	// Please do not change this class
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

		@Override
		public String toString() {
			return _dollars + " dollars " + _quarters + " quarters " + _nickels + " nickels " + _cents + " cents";
		}
	}

	// Please do not change this interface
	public static interface Node {

		int getValue();

		List<Node> getChildren();
	}

	public static double getAverage(Node root) {
		/*
		  Please implement this method to
		  return the average of all node values (Node.getValue()) in the tree.
		 */
		int suma = root.getValue() + suma(root.getChildren());
		int count = 1 + count(root.getChildren());
		return suma / count;
	}

	private static int suma(List<Node> nodes) {
		if (nodes == null || nodes.isEmpty()) {
			return 0;
		}
		int suma = 0;
		for (Node n : nodes) {
			suma += n.getValue() + suma(n.getChildren());
		}
		return suma;
	}

	private static int count(List<Node> nodes) {
		if (nodes == null || nodes.isEmpty()) {
			return 0;
		}
		int suma = 0;
		for (Node n : nodes) {
			suma += 1 + count(n.getChildren());
		}
		return suma;
	}

	public static int getClosestToZero(int[] a) {
		/*
		  Please implement this method to
		  return the number in the array that is closest to zero.
		  If there are two equally close to zero elements like 2 and -2
		  - consider the positive element to be "closer" to zero.
		 */
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				return a[i];
			}
		}
		return a[a.length - 1];
	}

	public static int[] removeDuplicates(int[] a) {
		/*
		  Please implement this method to
		  remove all duplicates from the original array. Retain the order of the elements and
		  always retain the first occurrence of the duplicate elements.
		  For example, parameter: {2,1,2,3}, result: {2,1,3}
		 */
		Map<Integer, Integer> mapa = new LinkedHashMap<Integer, Integer>();
		int[] ret = new int[a.length];
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (mapa.get(a[i]) == null) {
				mapa.put(a[i], 1);
				ret[index++] = a[i];
			}
		}
		return Arrays.copyOfRange(ret, 0, index);
	}

	public static int countWaysToJump(int N) {
		/*
		  A set of stairs has N steps.
		  You can jump either 1 or 2 steps at a time.
		  For example, if the stairs is N=4 steps, you can reach the end in 5 possible ways:
		  1-1-1-1, or 1-2-1 or 1-1-2 or 2-1-1 or 2-2
		  Please implement this method to
		  return the count of the different ways to reach the end of the stairs with N steps.
		 */
		String[] steps = getSteps(N);
		for (int i = 0; i < steps.length; i++) {
			System.out.println(steps[i]);
		}
		return steps.length;
	}

	private static String[] getSteps(int N) {
		if (N == 0)
			return new String[] {};
		if (N == 1)
			return new String[] { "1" };
		if (N == 2)
			return new String[] { "11", "2" };
		String[] concat = concat(1, getSteps(N - 1));
		String[] concat2 = concat(2, getSteps(N - 2));
		String[] arrRet = new String[concat.length + concat2.length];
		for (int i = 0; i < concat.length; i++) {
			arrRet[i] = concat[i];
		}
		for (int i = concat.length, j = 0; j < concat2.length && i < (concat.length + concat2.length); i++, j++) {
			arrRet[i] = concat2[j];
		}
		return arrRet;
	}

	private static String[] concat(int N, String[] strArr) {
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = N + "" + strArr[i];
		}
		return strArr;
	}

	public static int countWords(String s) {
		/*
		  Please implement this method to
		  return the word count in a given String.
		  Assume that the parameter String can only contain spaces and alphanumeric characters.
		 */
		String[] split = s.split("\\s+");
		int suma = 0;
		for (String st : split) {
			if (st.equals("")) {
				continue;
			}
			suma++;
		}
		return suma;
	}

	public static void sortIgnoringSpaces(String[] a) {
		/*
		  Please implement this method to
		  sort a given array of Strngs in alphabetical order
		  ignoring spaces (' ' symbols) within the strings.
		 */
		Arrays.sort(a, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.replace(" ", "").compareTo(o2.replace(" ", ""));
			}
		});
	}
	
	public static String reverseWords(String s) {
		/*
		  Assume that the parameter String can only contain spaces and alphanumeric characters.
		  Please implement this method to
		  reverse each word in the original String while maintaining the word order.
		  For example:
		  parameter: "Hello world", result: "olleH dlrow"
		 */
		String ret = "";
		String[] words = s.split(" ");
		for (String palabra : words) {
			ret += revertString(palabra) + " ";
		}
		return ret.trim();
	}

	private static String revertString(String palabra) {
		String ret = "";
		for (int i = palabra.length() - 1; i >= 0; i--) {
			ret += palabra.charAt(i);
		}
		return ret;
	}

	public static int getCountOfOnes(int n) {
		/*
		 Please implement this method to
		 return the number of '1's in the binary representation of n
		 for any integer n, where n > 0

		 Example: for n=6 the binary representation is '110' and the number of '1's in that 
		 representation is 2
		*/
		String binary = Integer.toBinaryString(n);
		int suma = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				suma++;
			}
		}
		return suma;
	}

	public static Set<Object> getUniqueElements(Set<Object> a, Set<Object> b) {
		/*
		  Please implement this method to
		  return a set of elements that can be found only in set a or set b,
		  but not in both Sets.
		  The method should not change the content of the parameters.
		 */
		Set<Object> c = new HashSet<Object>(a);
		c.removeAll(b);

		Set<Object> d = new HashSet<Object>(b);
		d.removeAll(a);

		HashSet<Object> newSet = new HashSet<Object>(c);
		newSet.addAll(d);
		return newSet;
	}

	// Please do not change this interface
	interface ListNode {

		int getItem();

		ListNode getNext();

		void setNext(ListNode next);
	}

	public static ListNode reverse(ListNode node) {
		/*
		  Please implement this method to
		  reverse a given linked list.
		 */

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

	public static boolean isPalindrome(String s) {
		/*
		  Definition: A palindrome is a string that reads the same forward and backward.
		  For example, "abcba" is a palindrome, "abab" is not.
		  Please implement this method to
		  return true if the parameter is a palindrome and false otherwise.
		 */
		int topIndex = s.length() % 2 == 0 ? s.length() / 2 : (s.length() - 1) / 2;
		for (int i = 0; i < topIndex; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static int sumOfTwoLargestElements(int[] a) {
		/*
		  Please implement this method to
		  return the sum of the two largest numbers in a given array.
		 */
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

	public static Object[] reverseArray(Object[] a) {
		/*
		  Please implement this method to
		  return a new array where the order of elements has been reversed from the original
		  array.
		 */
		Object[] ret = new Object[a.length];
		for (int i = a.length - 1; i >= 0; i--) {
			ret[a.length - i] = a[i];
		}
		return ret;
	}

	public static class WriteOnceMap<K, V> extends HashMap<K, V> {

		private static final long serialVersionUID = 6107826937414787796L;

		@Override
		public V put(K key, V value) {
			/*
			 WriteOnceMap is a map that does not allow changing value for a particular key.
			 It means that put() method should throw IllegalArgumentException if the key is already
			 assosiated with some value in the map.

			 Please implement this method to conform to the above description of WriteOnceMap.
			*/
			if (containsKey(key)){
				throw new IllegalArgumentException("");
			}
			put(key, value);
			return value;
		}

		@Override
		public void putAll(Map<? extends K, ? extends V> m) {
			/*
			 Pleaase implement this method to conform to the description of WriteOnceMap above.
			 It should either
			 (1) copy all of the mappings from the specified map to this map or
			 (2) throw IllegalArgumentException and leave this map intact
			 if the parameter already contains some keys from this map.
			*/
			for (K key : m.keySet()){
	            if (containsKey(key)){
	            	throw new IllegalArgumentException("");
	            }
			}
			putAll(m);
		}
	}

	public static int getSumOfNumbers(String s) {
		/*
		  Please implement this method to
		  return the sum of all integers found in the parameter String. You can assume that
		  integers are separated from other parts with one or more spaces (' ' symbol).
		  For example, s="12 some text 3  7", result: 22 (12+3+7=22)
		 */
		String[] toks = s.split(" ");
		int suma = 0;
		for (String tok : toks) {
			try {
				suma += Integer.valueOf(tok);
			} catch (NumberFormatException nfe) {
				continue;
			}
		}
		return suma;
	}

	public static String capitalizeFirstLetters(String s) {
		/*
		  Please implement this method to
		  capitalize all first letters of the words in the given String.
		  All other symbols shall remain intact. If a word starts not with a letter, it shall remain intact too.
		  Assume that the parameter String can only contain spaces and alphanumeric characters.

		  NOTE: please keep in mind that the words can be divided by single or multiple spaces.
		  The spaced also can be found at the beginning or the end of the parameter string,
		  and you need to preserve them.
		 */
		String[] words = s.split(" ");
		String ret = "";
		for (String tok : words) {
			if (tok.equals("")) {
				ret += " ";
			} else if (tok.indexOf(" ") != -1) {
				ret += tok;
			} else if (tok.length() == 1) {
				ret += tok.toUpperCase();
			} else {
				ret += " " + tok.substring(0, 1).toUpperCase() + tok.substring(1, tok.length());
			}
		}
		return ret;
	}

	public static List<Node> traverseTreeInWidth(Node root) {
		/*
		  Please implement this method to
		  traverse the tree in width and return a list of all passed nodes.

		  The list should start with the root node, next
		  it should contain all second-level nodes, then third-level nodes etc.

		  The method shall work optimally with large trees.
		 */
		List<Node> res = new ArrayList<Node>();
		res.add(root);
		for (int i = 0; i < res.size(); ++i)
			for (Node child : res.get(i).getChildren())
				res.add(child);
		return res;
	}

	public static void main(String[] args) {
		//    	int[] a = new int[]{-1,3,0,1,0,5};
		//    	System.out.println(getClosestToZero(a));
		//    	int[] a = new int[]{2,1,2,3};
		//    	int[] removeDuplicates = removeDuplicates(a);
		//    	for(int i = 0;i<removeDuplicates.length;i++){
		//    		System.out.println(removeDuplicates[i]);
		//    	}
		//    	System.out.println(countWords("hola nacho como estas"));
		//System.out.println(getCountOfOnes(6));
		//    	Set<Object> uniqueElements = getUniqueElements(new HashSet<Object>(Arrays.asList(1,2,3)),new HashSet<Object>(Arrays.asList(3,4,5,1)));
		//    	for(Object i : uniqueElements){
		//    		System.out.println((Integer)i);
		//    	}
		//    	System.out.println("Total: " + countWaysToJump(5));
		//    	System.out.println(isPalindrome("a"));
		//    	System.out.println(reverseWords("Hola nacho"));
		//    	System.out.println(getSumOfNumbers("12 some text 3  7"));
		//    	System.out.println(capitalizeFirstLetters(" hola   nacho como  and as "));
		//    	System.out.println(countWords(" hola   nacho como  and as "));
		//    	System.out.println(getCorrectChange(632));
		//    	System.out.println(countAlmostPrimeNumbers(0,100));

		//    	List<Integer> primos = getPrimeNumbers(0, 14);
		//    	for(Integer i : primos){
		//    		System.out.println(i);
		//    	}
	}
}
