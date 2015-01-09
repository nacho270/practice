package otros;

public class MainSpriral {
	public static void main(String[] args) {
		Matrix<Integer> m = new Matrix<Integer>(new Integer[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}});
		SpiralIteratorConState<Integer> si = new SpiralIteratorConState<Integer>(m);
		while(si.hasNext()){
			Integer next = si.next();
			System.out.println(next);
		}
	}
}
