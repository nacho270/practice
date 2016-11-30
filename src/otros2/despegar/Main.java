package otros2.despegar;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import otros2.despegar.groupby.GroupBy;
import otros2.despegar.groupby.Grouper;
import otros2.despegar.groupby.IGroupBy;
import otros2.despegar.occurrences.IOccurrences;
import otros2.despegar.occurrences.Occurrences;

public class Main {

	public static void main(String[] args) {
		ejecutarGroupBy();
		ejecutarOccurrences();
	}

	private static void ejecutarOccurrences() {
		IOccurrences ioc = new Occurrences();
		Map<Character, Integer> findOccurrences = ioc.findOccurrences("Roberto", new GroupBy());
		for(Character c : findOccurrences.keySet()){
			System.out.println(c + " => " + findOccurrences.get(c));
		}
	}

	private static void ejecutarGroupBy() {
		Collection<Integer> col = Arrays.asList(56,76,43,6,762,67,234,65);
		IGroupBy igb = new GroupBy();
		Map<Integer, Collection<Integer>> m = igb.groupBy(col, new Grouper<Integer, Integer>() {
			@Override
			public Integer assignToGroup(Integer element) {
				return element % 5;
			}
		});
		for(Integer k : m.keySet()){
			System.out.println(k);
			for(Integer i : m.get(k)){
				System.out.println("\t"+i);
			}
		}
	}
}
