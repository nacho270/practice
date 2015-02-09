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
	
	//****************************** MAIN *************************************************************************

	public static void main(String[] args) {
		TreeNode tn1 = createTree();
//		ejecutarGroupAnagrams();
//		System.out.println(suma(tn1));
//		System.out.println(promedioConRecursion(tn1));
//		System.out.println(promedioFor(tn1));
		System.out.println(sumaFor(tn1));
	}

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
}
