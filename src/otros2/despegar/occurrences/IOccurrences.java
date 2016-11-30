package otros2.despegar.occurrences;

import java.util.Map;

import otros2.despegar.groupby.IGroupBy;

public interface IOccurrences {
	public Map<Character, Integer> findOccurrences(String word, IGroupBy groupBy);
}
