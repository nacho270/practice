package otros2.despegar.groupby;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GroupBy implements IGroupBy{

	@Override
	public <K, E> Map<K, Collection<E>> groupBy(Collection<E> col, Grouper<K,E> grouper) {
		Map<K, Collection<E>> mapRet = new HashMap<K, Collection<E>>();
		for(E el : col){
			K key = grouper.assignToGroup(el);
			if(mapRet.get(key) == null){
				mapRet.put(key, new ArrayList<E>());
			}
			mapRet.get(key).add(el);
		}
		return mapRet;
	}

}
