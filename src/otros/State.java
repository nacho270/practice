package otros;

public abstract class State<T> {
	
	protected SpiralIteratorConState<T> iterator;
	
	public State(SpiralIteratorConState<T> iterator){
		this.iterator = iterator;
	}
	
	protected abstract void changeState();

	public abstract void executeState();
}
