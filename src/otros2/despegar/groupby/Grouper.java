package otros2.despegar.groupby;

public interface Grouper<K,E> {
	public K assignToGroup(E element);
}
