package bp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import betterprogrammer.SolucionesBetterProgrammer.Node;

@SuppressWarnings("unused")
public class BetterProgrammerTask {

	public static Set<Object> getIntersection1(Set<Object> a, Set<Object> b) {
        /*
          Please implement this method to
          return a Set equal to the intersection of the parameter Sets
          The method should not chage the content of the parameters.
         */
		
		Set<Object> ret = new HashSet<Object>(a);
		ret.retainAll(b);
		return ret;
    }
	
	public static Set<Object> getIntersection(Set<Object> a, Set<Object> b) {
        /*
          Please implement this method to
          return a Set equal to the intersection of the parameter Sets
          The method should not chage the content of the parameters.
         */
		
		Set<Object> ret = new HashSet<Object>();
		for(Object o : a){
			if(b.contains(o)){
				ret.add(o);
			}
		}
		for(Object o : b){
			if(a.contains(o)){
				ret.add(o);
			}else if(ret.contains(o)){
				ret.remove(o);
			}
		}
		return ret;
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
	
	public static int countWords1(String s) {
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
    
	public static int countWords(String s) {
        /*
          Please implement this method to
          return the word count in a given String.
          Assume that the parameter String can only contain spaces and alphanumeric characters.
         */
    	return s.split("\\s+").length;
    }
    
    public static int countAlmostPrimeNumbers(int from, int to) {
    	int count = 0;
    	List<Integer> primes = precalculatePrimes(from,to);
    	for(int i = from; i<=to; i++){
    		byte cant = 0;
    		for(Integer prime : primes){
    			if(i!=prime.intValue() && i%prime.intValue()==0){
    				cant++;
    			}
    		}
    		if(cant==1){
    			count++;
    		}
    	}
    	return count;
        
    }
    
    
    private static List<Integer> precalculatePrimes(int from, int to) {
    	List<Integer> primes = new ArrayList<Integer>();
    	for(int i = from; i<=to;i++){
    		boolean prime = true;
    		for(int j = 2;j<=i&&prime;j++){
    			if(j!=i && i%j==0){
    				prime=false;
    			}
    		}
    		if(prime){
    			primes.add(i);
    		}
    	}
    	return primes;
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
    	ListNode index = node;
    	List<ListNode> lista = new ArrayList<BetterProgrammerTask.ListNode>();
    	lista.add(index);
    	while(index.getNext()!=null){
    		index = index.getNext();
    		lista.add(index);
    	}
    	for(int i = lista.size()-1;i>0;i--){
    		lista.get(i).setNext(lista.get(i-1));
    	}
    	lista.get(0).setNext(null);
    	return lista.get(lista.size()-1);
    }
    
	private static class Nodo implements ListNode{
    	int item;
    	private ListNode next;
    	
		@Override
		public int getItem() {
			return item;
		}

		@Override
		public ListNode getNext() {
			return next;
		}

		@Override
		public void setNext(ListNode next) {
			this.next = next;
		}
    	
		@Override
		public String toString() {
			return ""+getItem();
		}
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
    	int[] res = new int[N + 1];
		res[0] = 1;
		for (int i = 1; i <= N; ++i)
			res[i] = res[i - 1] + (i - 2 >= 0 ? res[i - 2] : 0);
		return res[N];
    }
    
    public static int getSumOfNumbers(String s) {
        /*
          Please implement this method to
          return the sum of all integers found in the parameter String. You can assume that
          integers are separated from other parts with one or more spaces (' ' symbol).
          For example, s="12 some text 3  7", result: 22 (12+3+7=22)
         */
    	String[] split = s.split("\\s+");
    	int sum = 0;
    	for(String string : split){
    		if(!Character.isLetter(string.charAt(0))){
    			sum += Integer.valueOf(string).intValue();
    		}
    	}
    	return sum;
    }
    
    public static List<Integer> getPerfectNumbers(int from, int to) {
        /*
          Please implement this method to
          return a list of all perect numbers in the given range inclusively.
          A perfect number is defined as a positive integer which is the sum of its positive divisors not including the number itself.
          For example: 6 is a perfect number because 6 = 1 + 2 + 3 (1, 2, 3 are divisors of 6)
          28 is also a perfect number: 28 = 1 + 2 + 4 + 7 + 14
         */
    	List<Integer> ret = new ArrayList<Integer>();
    	for(int i = from; i <=to;i++){
    		int divisorsSum = 0;
    		for(int j = 1; j<i;j++){
    			if(i%j==0){
    				divisorsSum+=j;
    			}
    		}
    		if(i==divisorsSum){
    			ret.add(i);
    		}
    	}
    	return ret;
    	
    }
    
    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }
    
    private static class TreeNode implements Node{
    	
    	private int value;
    	private List<Node> children;
    	
    	public TreeNode() {
    		children = new ArrayList<BetterProgrammerTask.Node>();
    	}
    	
		@Override
		public int getValue() {
			return value;
		}

		@Override
		public List<Node> getChildren() {
			return children;
		}
		
		@Override
		public String toString() {
			return ""+value;
		}
    	
    }
    
    public static List<Node> traverseTreeInWidth2(Node root) {
		return trans2(root, new ArrayList<Node>());
    }
    
    private static List<Node> trans2(Node root, ArrayList<Node> res) {
		res.add(root);
		res.addAll(root.getChildren());
		for(Node n : root.getChildren()){
			
			res.addAll(trans2(n,res));
		}
		return res;
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
	
	public static int countWaysToProduceGivenAmountOfMoney(int cents) {
		int[] dp = new int[cents + 1];
		dp[0] = 1;
		for (int x : new int[] { 1, 5, 10, 25, 50 })
			for (int i = 0; i + x <= cents; ++i)
				dp[i + x] += dp[i];
		return dp[cents];
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
	
	public static int countPowerfulNumbers(int from, int to) {
        /*
          A powerful number is a positive integer m that for every prime number p dividing m, p*p also divides m.

          (a prime number (or a prime) is a natural number that has exactly two (distinct) natural number divisors,
          which are 1 and the prime number itself, the first prime numbers are: 2, 3, 5, 7, 11, 13, ...)

          The first powerful numbers are: 1, 4, 8, 9, 16, 25, 27, 32, 36, ...

          Please implement this method to
          return the count of powerful numbers in the range [from..to] inclusively.
         */
		int count =0 ;
		for(int m = from; m<=to;m++){
			List<Integer> primeNumbers = getPrimeNumbers(2, m);
			for(Integer pI : primeNumbers){
				int p = pI.intValue();
				if(p<1){
					continue;
				}
				int pp = p * p;
				if(m%p==0 && m%pp==0){
					System.out.println(m);
					count++;
				}
			}
		}
		
		return count;
    }
	
	private static int suma=0;
	private static int cont=0;
	
	public static double getAverage(Node root) {
		cont = suma = 0;
		average(root);
		return suma / cont;
	}

	static void average(Node node) {
		++cont;
		suma += node.getValue();
		for (Node child : node.getChildren())
			average(child);
	}
	
	public static int sumOfTwoLargestElements(int[] a) {
        /*
          Please implement this method to
          return the sum of the two largest numbers in a given array.
         */
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
    
	public static void main(String[] args) {
		//System.out.println(countWords("hoa como, te va  hj aredsa es e aseas eas e e e ae aseasease         jiojiojiojio"));
		//System.out.println(countAlmostPrimeNumbers(1, 1000));
//		System.out.println(countWaysToJump(4));
//		System.out.println(getSumOfNumbers("12 some  d4        text 3  7"));
		//System.out.println(countWaysToProduceGivenAmountOfMoney(11));
		//System.out.println(countPowerfulNumbers(1, 40));
//		//root
//		TreeNode tn1 = new TreeNode();
//		tn1.value=1;
//
//		//2 nivel
//		TreeNode tn2 = new TreeNode();
//		tn2.value=22;
//
//		TreeNode tn3 = new TreeNode();
//		tn3.value=23;
//
//		TreeNode tn4 = new TreeNode();
//		tn4.value=24;
//
//		
//		//3 nivel
//		
//		TreeNode tn5 = new TreeNode();
//		tn5.value=35;
//
//		
//		TreeNode tn6 = new TreeNode();
//		tn6.value=36;
//
//		
//		TreeNode tn7 = new TreeNode();
//		tn7.value=37;
//
//		//4 nivel
//		TreeNode tn8 = new TreeNode();
//		tn8.value=38;
//
//		TreeNode tn9 = new TreeNode();
//		tn9.value=39;
//
//
//		tn7.getChildren().add(tn8);
//		tn6.getChildren().add(tn9);
//		
//		tn4.getChildren().add(tn5);
//		tn3.getChildren().add(tn6);
//		tn2.getChildren().add(tn7);
//		
//		tn1.getChildren().add(tn2);
//		tn1.getChildren().add(tn3);
//		tn1.getChildren().add(tn4);
//		
//		List<Node> transverse = traverseTreeInWidth2(tn1);
//		for(Node n : transverse){
//			System.out.println(n.getValue());
//		}
		
//		List<Integer> perfects = getPerfectNumbers(1, 10000);
//		for(Integer i : perfects){
//			System.out.println(i);
//		}
		
		
//		Set<Object> a = new HashSet<Object>();
//		a.add(1);
//		a.add(2);
//		a.add(3);
//		a.add(4);
//		
//		Set<Object> b = new HashSet<Object>();
//		b.add(4);
//		b.add(3);
//		b.add(6);
//		b.add(7);
//		
//		Set<Object> res = getIntersection1(a, b);
//		for(Object o: res){
//			System.out.println(o);
//		}
		
//		Nodo n1 = new Nodo();
//		n1.item = 1;
//		
//		Nodo n2 = new Nodo();
//		n2.item = 2;
//		Nodo n3 = new Nodo();
//		n3.item = 3;
//		Nodo n4 = new Nodo();
//		n4.item = 4;
//		Nodo n5 = new Nodo();
//		n5.item = 5;
//		Nodo n6 = new Nodo();
//		n6.item = 6;
//		n1.setNext(n2);
//		n2.setNext(n3);
//		n3.setNext(n4);
//		n4.setNext(n5);
//		n5.setNext(n6);
//		
//		ListNode reverse = reverse(n1);
//		ListNode index = reverse;
//		while(index.getNext()!=null){
//			System.out.println(index.getItem());
//			index = index.getNext();
//		}
	}
}