package otros2.despegar.groupby;

import java.util.Collection;
import java.util.Map;

public interface IGroupBy {
	public <K,E> Map<K, Collection<E>> groupBy(Collection<E> col, Grouper<K,E> grouper);
}
