package otros2.despegar.occurrences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import otros2.despegar.groupby.Grouper;
import otros2.despegar.groupby.IGroupBy;

public class Occurrences implements IOccurrences{

	@Override
	public Map<Character, Integer> findOccurrences(String word, IGroupBy groupBy) {
		Collection<Character> col = new ArrayList<Character>();
		for(int i=0;i<word.length();i++){
			col.add(word.charAt(i));
		}
		Map<Character, Collection<Character>> mapGroupBy = groupBy.groupBy(col, new Grouper<Character, Character>() {
			@Override
			public Character assignToGroup(Character element) {
				return Character.toLowerCase(element.charValue());
			}
		});
		Map<Character, Integer> mapRet = new HashMap<Character, Integer>();
		for(Character c : mapGroupBy.keySet()){
			mapRet.put(c, mapGroupBy.get(c).size());
		}
		return mapRet;
	}
}
