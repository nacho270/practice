package otros2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problemas {
	public static List<Set<String>> groupAnagrams(List<String> words) {
	    List<Set<String>> listRet = new ArrayList<Set<String>>();
	    for(String w : words){
	        if(listRet.isEmpty()){
	        	Set<String> set = new HashSet<String>();
	        	set.add(w);
	            listRet.add(set);
	        }else{
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
	    }
	    return listRet;
	}

	private static String sortCharacters(String str){
	    char[] charsStr = str.toCharArray();
	    Arrays.sort(charsStr );
	    return new String(charsStr ); 
	}

	public static void main(String[] args) {
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
