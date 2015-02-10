package otros2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import otros2.Recursividad.Node;
import otros2.Recursividad.TreeNode;

@SuppressWarnings("unused")
public class Problemas {
	
	public static List<Set<String>> groupAnagrams(List<String> words) {
	    List<Set<String>> listRet = new ArrayList<Set<String>>();
	    for(String w : words){
            String sortedString = sortCharacters(w);
            boolean found = false; 
            for(Set<String> s : listRet){
                String sample = sortCharacters(s.iterator().next());
                if(sample.equals(sortedString)){
                    s.add(w);
                    found=true;
                    break;
                }
            }
            if(!found){
            	Set<String> set = new HashSet<String>();
	        	set.add(w);
	            listRet.add(set);
            }    
	    }
	    return listRet;
	}

	private static String sortCharacters(String str){
	    char[] charsStr = str.toCharArray();
	    Arrays.sort(charsStr );
	    return new String(charsStr); 
	}

	//********************************** ARBOLES ********************************************************************/
	
	private static int suma(Node node){
		return node.getValue() + sumaHijos(node.getChildren(),0);
	}

	private static int sumaHijos(List<Node> children, int index) {
		if(children == null || children.isEmpty() || index >= children.size()) return 0;
		return suma(children.get(index)) + sumaHijos(children,index+1);
	}

	private static int sumaFor(Node node){
		return innerSumaFor(node,0);
	}
	
	private static int innerSumaFor(Node node, int suma) {
		suma += node.getValue();
		for(Node n : node.getChildren()){
			suma = innerSumaFor(n, suma);
		}
		return suma;
	}

	private static class DataAverageContainer{
		private int suma;
		private int cont;
		public float avg() {
			return suma*1.0f/cont*1.0f;
		}
		@Override
		public String toString() {
			return "Suma= " + suma + "\nCont= " + cont;
		}
	}

	//**************************** PROMEDIO ARBOL RECURSION ************************************************************

	private static DataAverageContainer sumaYContarConRecursion(Node node, DataAverageContainer data){
		data.cont++;
		data.suma += node.getValue();
		return sumarYContarConRecursionHijos(node.getChildren(),data,0);
	}
	
	private static DataAverageContainer sumarYContarConRecursionHijos(List<Node> children, DataAverageContainer data, int index) {
		if(children == null || children.isEmpty() || index >= children.size()) return data;
		data = sumaYContarConRecursion(children.get(index),data);
		return sumarYContarConRecursionHijos(children,data,index+1);
	}
	
	private static float promedioConRecursion(Node node) {
		DataAverageContainer data = sumaYContarConRecursion(node, new DataAverageContainer());
		System.out.println(data);
		return data.avg();
	}
	
	//**************************** PROMEDIO ARBOL FOR ************************************************************
	
	private static DataAverageContainer sumarYContarConFor(Node node, DataAverageContainer dataAverageContainer) {
		dataAverageContainer.cont++;
		dataAverageContainer.suma += node.getValue();
		for(Node n : node.getChildren()){
			dataAverageContainer = sumarYContarConFor(n, dataAverageContainer);
		}
		return dataAverageContainer;
	}

	private static float promedioFor(Node node){
		DataAverageContainer data = sumarYContarConFor(node, new DataAverageContainer());
		System.out.println(data);
		return data.avg();
	}
	
	//*********************************************************************************************************
	/*
	 					1
	 		22			23			24
	 		37			36			35
	 		38			39
	 					40
	 					41
	*/
	private static TreeNode createTree() {
		TreeNode tn1 = new TreeNode();
		tn1.value=1;

		//2 nivel
		TreeNode tn2 = new TreeNode();
		tn2.value=22;

		TreeNode tn3 = new TreeNode();
		tn3.value=23;

		TreeNode tn4 = new TreeNode();
		tn4.value=24;

		
		//3 nivel
		TreeNode tn5 = new TreeNode();
		tn5.value=35;

		
		TreeNode tn6 = new TreeNode();
		tn6.value=36;

		
		TreeNode tn7 = new TreeNode();
		tn7.value=37;

		//4 nivel
		TreeNode tn8 = new TreeNode();
		tn8.value=38;

		TreeNode tn9 = new TreeNode();
		tn9.value=39;

		//5 nivel
		TreeNode tn10 = new TreeNode();
		tn10.value=40;
		
		//6 nivel
		TreeNode tn11 = new TreeNode();
		tn11.value=41;

		tn10.getChildren().add(tn11);
		
		tn9.getChildren().add(tn10);
		
		tn7.getChildren().add(tn8);
		tn6.getChildren().add(tn9);
		
		tn4.getChildren().add(tn5);
		tn3.getChildren().add(tn6);
		tn2.getChildren().add(tn7);
		
		tn1.getChildren().add(tn2);
		tn1.getChildren().add(tn3);
		tn1.getChildren().add(tn4);
		
		return tn1;
	}

	public static void ejecutarGroupAnagrams() {
		List<Set<String>> groupAnagrams = groupAnagrams(Arrays.asList("OMAR", "ROMA", "CASA", "PERRO", "AMOR", "SAAC"));
		String out = "[";
		for(Set<String> s : groupAnagrams){
			out += "{";
			for(String str : s){
				out += str+",";
			}
			out = out.substring(0,out.length()-1);
			out += "},";
			
		}
		out = out.substring(0,out.length()-1);
		out += "]";
		System.out.println(out);
	}

	private static ListNode createList() {
		NodoLista n1 = new NodoLista();
		NodoLista n2 = new NodoLista();
		NodoLista n3 = new NodoLista();
		NodoLista n4 = new NodoLista();
		NodoLista n5 = new NodoLista();
		NodoLista n6 = new NodoLista();
		
		n1.item = 1;
		n1.next = n2;
		
		n2.item = 2;
		n2.next = n3;
		
		n3.item = 3;
		n3.next = n4;
		
		n4.item = 4;
		n4.next = n5;
		
		n5.item = 5;
		n5.next = n6;
		
		n6.item = 6;
		n6.next = null;
		
		return n1;
	}
	
	//************************** BETTER PROGRAMMER ***********************************************************
	
	public static int countWords(String s) {
        /*
          Please implement this method to
          return the word count in a given String.
          Assume that the parameter String can only contain spaces and alphanumeric characters.
         */
		return s.trim().split("\\s+").length;
    }
	
	
	
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
				if (!primos.contains(i) && i % primo == 0) {
					cuenta++;
				}
			}
			if (cuenta == 1) {
				cuentaRet++;
			}
		}
		return cuentaRet;
	}
	
	// Please do not change this interface
    interface ListNode {
        int getItem();
        ListNode getNext();
        void setNext(ListNode next);
    }
    
    private static class NodoLista implements ListNode{
    	
    	private int item;
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
			return ""+item;
		}
    }

    public static ListNode reverse(ListNode node) {
    	ListNode prev = null;
    	while(node!=null){
    		ListNode next = node.getNext();//2
    		node.setNext(prev);//1 -> null
    		prev = node;//ant = 1
    		node = next;//nodo = 2
    	}
    	return prev;
    }
    
    public static Object[] reverseArray(Object[] a) {
        /*
          Please implement this method to
          return a new array where the order of elements has been reversed from the original
          array.
         */
    	Object[] newArray = new Object[a.length];
    	for(int i = a.length - 1; i>=0;i--){
    		newArray[a.length-i-1] = a[i];
    	}
    	return newArray;
    }
    
    public static String getBinaryRepresentation(int n) {
    	if(n<2) return ""+n;
    	return getBinaryRepresentation(n/2)+n%2+"";
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
	
	public static boolean isPalindrome(String s) {
        /*
          Definition: A palindrome is a string that reads the same forward and backward.
          For example, "abcba" is a palindrome, "abab" is not.
          Please implement this method to
          return true if the parameter is a palindrome and false otherwise.
         */
		if(s.length()<2) return true;
		return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1, s.length()-1));
		
    }
	
	 public static int getRequiredNumberOfBits(int N) {
        /*
          Please implement this method to
          return the number of bits which is just enough to store any integer from 0 to N-1 inclusively
          for any int N > 0
          Example: to store 5 integers from 0 to 4 you need 3 bits: 000, 001, 010, 011, 100 and 101
        */
		 if(N<2) return 1;
		 return 1 + getRequiredNumberOfBits(N/2);
	 }
	 
	private static int count = 0;

	public static int countWaysToJump(int N) {
		if (N == 0)
			count++;
		if (N > 0) {
			countWaysToJump(N - 1);
		}
		if (N > 1) {
			countWaysToJump(N - 2);
		}
		return count;
	}
	
	 public static int[] retainPositiveNumbers(int[] a) {
		 int cont = 0;
		 for(int n:a){
			 if(n>0) cont++;
		 }
		 int[] ret = new int[cont];
		 int index = 0;
		 for(int n:a){
			 if(n>0) ret[index++]=n;
		 }
		 Arrays.sort(ret);
		 return ret;
	 }
	 
	public static List<Node> traverseTreeInDepth(Node root) {
		return innerTransverseInDepth(root, new ArrayList<Node>());
	}
	

	private static List<Node> innerTransverseInDepth(Node node, List<Node> list) {
		list.add(node);
		return innerTransverseInDepthChildren(node.getChildren(),0,list);
	}

	private static List<Node> innerTransverseInDepthChildren(List<Node> children, int index, List<Node> list) {
		if(children == null || children.isEmpty() || index >= children.size()) return list;
		list = innerTransverseInDepth(children.get(index), list);
		return innerTransverseInDepthChildren(children, index+1, list);
	}

	//****************************** MAIN *******************************************************************

	public static void main(String[] args) {
		TreeNode tn1 = createTree();
		ListNode ln = createList();
//		ejecutarGroupAnagrams();
//		System.out.println(suma(tn1));
//		System.out.println(promedioConRecursion(tn1));
//		System.out.println(promedioFor(tn1));
//		System.out.println(sumaFor(tn1));
//		System.out.println(countWords(" sd sdfdjo sfdsfdsfdsfduho sfd sdsuh df sdu fsdjiofsu dfs d fsdo fsiod fs"));
//		System.out.println(countAlmostPrimeNumbers(1, 15));
//		ln = reverse(ln);
//		while(ln != null){
//			System.out.println(ln.getItem());
//			ln = ln.getNext();
//		}
//		Object[] reversed = reverseArray(new Object[]{1,2,3,4,5,6});
//		for(int i = 0; i<reversed.length;i++){
//			System.out.println(reversed[i]);
//		}
//		System.out.println(getBinaryRepresentation(8));
//		System.out.println(isPalindrome("pepe"));
//		System.out.println(getRequiredNumberOfBits(255));
//		System.out.println(countWaysToJump(4));
//		int[] positives = retainPositiveNumbers(new int[]{0,7,-3,8,-25,0,6,2,1});
//		for(int i:positives){
//			System.out.println(i);
//		}
		List<Node> traverseTreeInWidth = traverseTreeInDepth(tn1);
		for(Node n : traverseTreeInWidth){
			System.out.println(n.getValue());
		}
	}
}
